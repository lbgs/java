package com.坦克;
import java.util.*;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

import java.io.*;
//播放声音的类
class AePlayWave extends Thread {
	private String filename;
	public AePlayWave(String wavfile) {
		filename = wavfile;

	}

	public void run() {
		File soundFile = new File(filename);
		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (Exception e1) {
			e1.printStackTrace();
			return;
		}

		AudioFormat format = audioInputStream.getFormat();
		SourceDataLine auline = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

		try {
			auline = (SourceDataLine) AudioSystem.getLine(info);
			auline.open(format);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		auline.start();
		int nBytesRead = 0;
		//这是缓冲
		byte[] abData = new byte[2048];

		try {
			while (nBytesRead != -1) {
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
				if (nBytesRead >= 0)
					auline.write(abData, 0, nBytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} finally {
			auline.drain();
			auline.close();
		}

	}
}
//继续存盘的游戏（坐标和方向）
class DuquDitk{
	int x;
	int y;
	int f;
	public DuquDitk(int x,int y,int f){
		this.x=x;
		this.y=y;
		this.f=f;
	}
}
//记录类，同时记录设置
class Jilv{
	private static int Ditksun=20;
	private static int Imtksun=3;
	private static int Ditksi=0;
	private static FileWriter fw=null;
	private static BufferedWriter bw=null;
	private static FileReader fr=null;
	private static BufferedReader br=null;
	private static Vector<Ditk> ets=new Vector<Ditk>(); 
	private static Vector<DuquDitk> ddk=new Vector<DuquDitk>();
	//读取存盘的游戏
	public static Vector<DuquDitk> DuquyouxiDitk(){
		try {
			fr=new FileReader("f:/坦克大战/存盘.txt");
			br=new BufferedReader(fr);
			//先读取一行
			String s="";
			s=br.readLine();
			//读取坦克坐标
			while((s=br.readLine())!=null){
				String xyf[]=s.split("\t");
				DuquDitk dq=new DuquDitk(Integer.parseInt(xyf[0]),
						Integer.parseInt(xyf[1]),Integer.parseInt(xyf[2]));
				ddk.add(dq);
			}	
		} catch (Exception e) {
			// TODO: handle exceptione
			e.printStackTrace();
		}finally{
			try {
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return ddk;
	}
	//存盘后敌人坦克的坐标和方向
	public static void Ditzbf(){
		try {
			fw=new FileWriter("f:/坦克大战/存盘.txt");
			bw=new BufferedWriter(fw);
			String b="x\t"+"y\t"+"方向";
			bw.write(b+"\r\n");
			for(int i=0;i<ets.size();i++){
				//取出坦克
				Ditk et=ets.get(i);
				if(et.ws){
					String s=et.x+"\t"+et.y+"\t"+et.f;
					bw.write(s+"\r\n");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				bw.close();
				fw.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	//退出后保存玩家的战绩
	public static void Jilvwanjiachengji(){
		try {
			//输出流
			fw=new FileWriter("f:/坦克大战/总成绩.txt");
			bw=new BufferedWriter(fw);
			String s=Ditksi+"";
			bw.write(s);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				bw.close();
				fw.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	//读取保存的战绩
	public static void Duquwanjiachengji(){
		try {
			//输入流
			fr=new FileReader("f:/坦克大战/总成绩.txt");
			br=new BufferedReader(fr);
			String s=br.readLine();
			Ditksi=Integer.parseInt(s);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				br.close();
				fr.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	public static void Ditksun(){
		Ditksun--;
	}
	public static void Imtksun(){
		Imtksun--;
	}
	public static void Ditksi(){
		Ditksi++;
	}
	public static int getDitksun() {
		return Ditksun;
	}
	public static void setDitksun(int ditksun) {
		Ditksun = ditksun;
	}
	public static int getImtksun() {
		return Imtksun;
	}
	public static void setImtksun(int imtksun) {
		Imtksun = imtksun;
	}
	public static int getDitksi() {
		return Ditksi;
	}
	public static void setDitksi(int ditksi) {
		Ditksi = ditksi;
	}
	public static Vector<Ditk> getEts() {
		return ets;
	}
	public static void setEts(Vector<Ditk> ets) {
		Jilv.ets = ets;
	}
}
//爆炸类
class Bomb{
	int x;
	int y;
	int zhi=9;
	boolean ws=true;
	public Bomb(int x,int y){
		this.x=x;
		this.y=y;
	}
	public void Mingzhi(){
		if(zhi>0){
			zhi--;
		}else{
			this.ws=false;
		}
	}
}
//子弹类
class Shot implements Runnable{
	int x;
	int y;
	int f;
	int sudu=2;
	boolean ws=true;
	public Shot(int x,int y,int f){
		this.x=x-1;
		this.y=y-1;
		this.f=f;
	}
	public void run(){
		while(true){
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			switch(f){
			case 0:
				y-=sudu;
				break;
			case 1:
				y+=sudu;
			    break;
			case 2:
				x-=sudu;
				break;
			case 3:
				x+=sudu;
				break;
			}
			if(x<0||x>530||y<0||y>460){
				ws=false;
				break;
			}
		}
	}
}
//坦克类
class Tk{
	//横坐标
    int x=0;
	//纵坐标
    int y=0;
	//速度
	int sudu=1;
	//颜色
	int color;
	//方向
	int f;
	//判断是否死亡
	boolean ws=true;
	public Tk(int x,int y){
		this.x=x;
		this.y=y;
	}
	public int getF() {
		return f;
	}
	public void setF(int f) {
		this.f = f;
	}
	public int getSudu() {
		return sudu;
	}
	public void setSudu(int sudu) {
		this.sudu = sudu;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
//我的坦克
class Imtk extends Tk{
	Vector<Shot> vv=new Vector<Shot>();
	Shot s;
	public Imtk(int x,int y){
		super(x, y);
		this.color=0;
		this.f=0;
		this.sudu=1;
	}
	public void zidan(){
		switch(f){
		case 0:
			s=new Shot(x+10,y,0);
			vv.add(s);
			break;
		case 1:
			s=new Shot(x+10,y+30,1);
			vv.add(s);
		    break;
		case 2:
			s=new Shot(x-5,y+15,2);
			vv.add(s);
			break;
		case 3:
			s=new Shot(x+25,y+15,3);
			vv.add(s);
			break;
		}
		Thread ta=new Thread(s);
		ta.start();
 	} 
	// 我的坦克方向
	public void Up(){
		if(y>=0){
			y-=sudu;
		}
	}
	public void Down(){
		if(y<=430){
			y+=sudu;
		}
	}
	public void Left(){
		if(x>=5){
			x-=sudu;
		}
	}
	public void Ringht(){
		if(x<=507){
			x+=sudu;
		}
	}
}
//敌人坦克
class Ditk extends Tk implements Runnable {
	Vector<Shot> vv=new Vector<Shot>();
	Shot s;
	Vector<Ditk> et=new Vector<Ditk>();
	int cd=30;
	public Ditk(int x,int y){
		super(x, y);
		this.color=1;
		this.f=(int)(Math.random()*4);
		this.sudu=1;
	}
	public void setDitk(Vector<Ditk> ets){
		this.et=ets;
	}
	//判断坦克是否碰撞
	public boolean Tkpengzhuang(){
		boolean b=false;
		switch(this.f){
		//坦克往上
		case 0:
			//取出其他敌人坦克
			for(int i=0;i<et.size();i++){
				//取出坦克
				Ditk ee=et.get(i);
				//不等于自己坦克坐标
				if(ee!=this){
					//其他坦克的上下方向
					if(ee.f==0||ee.f==1){
						//this坦克的第一个点
						if(this.x>=ee.x&&this.x<=ee.x+20&&this.y>=ee.y&&this.y<=ee.y+30){
							return true;
						}
						//第二个点
						if(this.x+20>=ee.x&&this.x+20<=ee.x+20&&this.y>=ee.y&&this.y<=ee.y+30){					
							return true;
						}
					}
					//其他坦克的左右方向
					if(ee.f==2||ee.f==3){
						//this坦克的第一点
						if(this.x>=ee.x-5&&this.x<=ee.x+25&&this.y>=ee.y+5&&this.y<=ee.y+25){
							b=true;
						}
						//第二点
						if(this.x+20>=ee.x-5&&this.x+20<=ee.x+25&&this.y>=ee.y+5&&this.y<=ee.y+25){
							b=true;
						}
					}
				}
			}
			break;
		//坦克往下
		case 1:
			//取出其他敌人坦克
			for(int i=0;i<et.size();i++){
				//取出坦克
				Ditk ee=et.get(i);
				//不等于自己坦克坐标
				if(ee!=this){
					//其他坦克的上下方向
					if(ee.f==0||ee.f==1){
						//this坦克的第一个点
						if(this.x>=ee.x&&this.x<=ee.x+20&&this.y+30>=ee.y&&this.y+30<=ee.y+30){
							return true;
						}
						//第二个点
						if(this.x+20>=ee.x&&this.x+20<=ee.x+20&&this.y+30>=ee.y&&this.y+30<=ee.y+30){
							return true;
						}
					}
					//其他坦克的左右方向
					if(ee.f==2||ee.f==3){
						//this坦克的第一点
						if(this.x>=ee.x-5&&this.x<=ee.x+25&&this.y+30>=ee.y+5&&this.y+30<=ee.y+25){
							return true;
						}
						//第二点
						if(this.x+20>=ee.x-5&&this.x+20<=ee.x+25&&this.y+30>=ee.y+5&&this.y+30<=ee.y+25){
							return true;
						}
					}
				}
			}
			break;
		//坦克往左
		case 2:
			//取出其他敌人坦克
			for(int i=0;i<et.size();i++){
				//取出坦克
				Ditk ee=et.get(i);
				//不等于自己坦克坐标
				if(ee!=this){
					//其他坦克的上下方向
					if(ee.f==0||ee.f==1){
						//this坦克的第一个点
						if(this.x-5>=ee.x&&this.x-5<=ee.x+20&&this.y+5>=ee.y&&this.y+5<=ee.y+30){
							return true;
						}
						//第二个点
						if(this.x-5>=ee.x&&this.x-5<=ee.x+20&&this.y+25>=ee.y&&this.y+25<=ee.y+30){
							return true;
						}
					}
					//其他坦克的左右方向
					if(ee.f==2||ee.f==3){
						//this坦克的第一点
						if(this.x-5>=ee.x-5&&this.x-5<=ee.x+25&&this.y+5>=ee.y+5&&this.y+5<=ee.y+25){
							return true;
						}
						//第二点
						if(this.x-5+20>=ee.x-5&&this.x-5<=ee.x+25&&this.y+25>=ee.y+5&&this.y+25<=ee.y+25){
							return true;
						}
					}
				}
			}
			break;
		//坦克往右
		case 3:
			//取出其他敌人坦克
			for(int i=0;i<et.size();i++){
				//取出坦克
				Ditk ee=et.get(i);
				//不等于自己坦克坐标
				if(ee!=this){
					//其他坦克的上下方向
					if(ee.f==0||ee.f==1){
						//this坦克的第一个点
						if(this.x+25>=ee.x&&this.x+25<=ee.x+20&&this.y+5>=ee.y&&this.y+5<=ee.y+30){
							return true;
						}
						//第二个点
						if(this.x+25>=ee.x&&this.x+25<=ee.x+20&&this.y+25>=ee.y&&this.y+25<=ee.y+30){
							return true;
						}
					}
					//其他坦克的左右方向
					if(ee.f==2||ee.f==3){
						//this坦克的第一点
						if(this.x+25>=ee.x-5&&this.x+25<=ee.x+25&&this.y+5>=ee.y+5&&this.y+5<=ee.y+25){
							return true;
						}
						//第二点
						if(this.x-5+20>=ee.x-5&&this.x-5<=ee.x+25&&this.y+25>=ee.y+5&&this.y+25<=ee.y+25){
							return true;
						}
					}
				}
			}
			break;
		}
		
		return b;
	}
    public void run(){
    	while(true){
	    	try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    	//给敌人添加子弹
	    	if(vv.size()<3){
	    	switch(f){
			case 0:
				s=new Shot(x+10,y,0);
				vv.add(s);
				break;
			case 1:
				s=new Shot(x+10,y+30,1);
				vv.add(s);
			    break;
			case 2:
				s=new Shot(x-5,y+15,2);
				vv.add(s);
				break;
			case 3:
				s=new Shot(x+25,y+15,3);
				vv.add(s);
				break;
			}
			Thread ta=new Thread(s);
			ta.start();
	    	}
	    	//判断敌人的方向
	    	switch(this.f){
	    	case 0:
	    		for(int i=0;i<cd;i++){
	    			if(y>=0&&!this.Tkpengzhuang()){
	    				y-=sudu;
	    			}
	    			try {
	    				Thread.sleep(100);
	    			} catch (Exception e) {
	    				// TODO: handle exception
	    				e.printStackTrace();
	    			}
	    		}
				break;
			case 1:
				for(int i=0;i<cd;i++){
					if(y<=430&&!this.Tkpengzhuang()){
						y+=sudu;
					}
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			    break;
			case 2:
				for(int i=0;i<cd;i++){
					if(x>=5&&!this.Tkpengzhuang()){
						x-=sudu;
					}
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				break;
			case 3:
				for(int i=0;i<cd;i++){
					if(x<=507&&!this.Tkpengzhuang()){
						x+=sudu;
					}
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				break;
	    	}
	    	//给一个随机方向
	    	this.f=(int)(Math.random()*4);
	    	//给一个随机长度
	    	this.cd=(int)(Math.random()*50);
    	}
    }
}
package com.̹��;
import java.util.*;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

import java.io.*;
//������������
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
		//���ǻ���
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
//�������̵���Ϸ������ͷ���
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
//��¼�࣬ͬʱ��¼����
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
	//��ȡ���̵���Ϸ
	public static Vector<DuquDitk> DuquyouxiDitk(){
		try {
			fr=new FileReader("f:/̹�˴�ս/����.txt");
			br=new BufferedReader(fr);
			//�ȶ�ȡһ��
			String s="";
			s=br.readLine();
			//��ȡ̹������
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
	//���̺����̹�˵�����ͷ���
	public static void Ditzbf(){
		try {
			fw=new FileWriter("f:/̹�˴�ս/����.txt");
			bw=new BufferedWriter(fw);
			String b="x\t"+"y\t"+"����";
			bw.write(b+"\r\n");
			for(int i=0;i<ets.size();i++){
				//ȡ��̹��
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
	//�˳��󱣴���ҵ�ս��
	public static void Jilvwanjiachengji(){
		try {
			//�����
			fw=new FileWriter("f:/̹�˴�ս/�ܳɼ�.txt");
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
	//��ȡ�����ս��
	public static void Duquwanjiachengji(){
		try {
			//������
			fr=new FileReader("f:/̹�˴�ս/�ܳɼ�.txt");
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
//��ը��
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
//�ӵ���
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
//̹����
class Tk{
	//������
    int x=0;
	//������
    int y=0;
	//�ٶ�
	int sudu=1;
	//��ɫ
	int color;
	//����
	int f;
	//�ж��Ƿ�����
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
//�ҵ�̹��
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
	// �ҵ�̹�˷���
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
//����̹��
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
	//�ж�̹���Ƿ���ײ
	public boolean Tkpengzhuang(){
		boolean b=false;
		switch(this.f){
		//̹������
		case 0:
			//ȡ����������̹��
			for(int i=0;i<et.size();i++){
				//ȡ��̹��
				Ditk ee=et.get(i);
				//�������Լ�̹������
				if(ee!=this){
					//����̹�˵����·���
					if(ee.f==0||ee.f==1){
						//this̹�˵ĵ�һ����
						if(this.x>=ee.x&&this.x<=ee.x+20&&this.y>=ee.y&&this.y<=ee.y+30){
							return true;
						}
						//�ڶ�����
						if(this.x+20>=ee.x&&this.x+20<=ee.x+20&&this.y>=ee.y&&this.y<=ee.y+30){					
							return true;
						}
					}
					//����̹�˵����ҷ���
					if(ee.f==2||ee.f==3){
						//this̹�˵ĵ�һ��
						if(this.x>=ee.x-5&&this.x<=ee.x+25&&this.y>=ee.y+5&&this.y<=ee.y+25){
							b=true;
						}
						//�ڶ���
						if(this.x+20>=ee.x-5&&this.x+20<=ee.x+25&&this.y>=ee.y+5&&this.y<=ee.y+25){
							b=true;
						}
					}
				}
			}
			break;
		//̹������
		case 1:
			//ȡ����������̹��
			for(int i=0;i<et.size();i++){
				//ȡ��̹��
				Ditk ee=et.get(i);
				//�������Լ�̹������
				if(ee!=this){
					//����̹�˵����·���
					if(ee.f==0||ee.f==1){
						//this̹�˵ĵ�һ����
						if(this.x>=ee.x&&this.x<=ee.x+20&&this.y+30>=ee.y&&this.y+30<=ee.y+30){
							return true;
						}
						//�ڶ�����
						if(this.x+20>=ee.x&&this.x+20<=ee.x+20&&this.y+30>=ee.y&&this.y+30<=ee.y+30){
							return true;
						}
					}
					//����̹�˵����ҷ���
					if(ee.f==2||ee.f==3){
						//this̹�˵ĵ�һ��
						if(this.x>=ee.x-5&&this.x<=ee.x+25&&this.y+30>=ee.y+5&&this.y+30<=ee.y+25){
							return true;
						}
						//�ڶ���
						if(this.x+20>=ee.x-5&&this.x+20<=ee.x+25&&this.y+30>=ee.y+5&&this.y+30<=ee.y+25){
							return true;
						}
					}
				}
			}
			break;
		//̹������
		case 2:
			//ȡ����������̹��
			for(int i=0;i<et.size();i++){
				//ȡ��̹��
				Ditk ee=et.get(i);
				//�������Լ�̹������
				if(ee!=this){
					//����̹�˵����·���
					if(ee.f==0||ee.f==1){
						//this̹�˵ĵ�һ����
						if(this.x-5>=ee.x&&this.x-5<=ee.x+20&&this.y+5>=ee.y&&this.y+5<=ee.y+30){
							return true;
						}
						//�ڶ�����
						if(this.x-5>=ee.x&&this.x-5<=ee.x+20&&this.y+25>=ee.y&&this.y+25<=ee.y+30){
							return true;
						}
					}
					//����̹�˵����ҷ���
					if(ee.f==2||ee.f==3){
						//this̹�˵ĵ�һ��
						if(this.x-5>=ee.x-5&&this.x-5<=ee.x+25&&this.y+5>=ee.y+5&&this.y+5<=ee.y+25){
							return true;
						}
						//�ڶ���
						if(this.x-5+20>=ee.x-5&&this.x-5<=ee.x+25&&this.y+25>=ee.y+5&&this.y+25<=ee.y+25){
							return true;
						}
					}
				}
			}
			break;
		//̹������
		case 3:
			//ȡ����������̹��
			for(int i=0;i<et.size();i++){
				//ȡ��̹��
				Ditk ee=et.get(i);
				//�������Լ�̹������
				if(ee!=this){
					//����̹�˵����·���
					if(ee.f==0||ee.f==1){
						//this̹�˵ĵ�һ����
						if(this.x+25>=ee.x&&this.x+25<=ee.x+20&&this.y+5>=ee.y&&this.y+5<=ee.y+30){
							return true;
						}
						//�ڶ�����
						if(this.x+25>=ee.x&&this.x+25<=ee.x+20&&this.y+25>=ee.y&&this.y+25<=ee.y+30){
							return true;
						}
					}
					//����̹�˵����ҷ���
					if(ee.f==2||ee.f==3){
						//this̹�˵ĵ�һ��
						if(this.x+25>=ee.x-5&&this.x+25<=ee.x+25&&this.y+5>=ee.y+5&&this.y+5<=ee.y+25){
							return true;
						}
						//�ڶ���
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
	    	//����������ӵ�
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
	    	//�жϵ��˵ķ���
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
	    	//��һ���������
	    	this.f=(int)(Math.random()*4);
	    	//��һ���������
	    	this.cd=(int)(Math.random()*50);
    	}
    }
}
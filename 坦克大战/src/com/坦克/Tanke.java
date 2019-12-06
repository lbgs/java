package com.坦克;
/**
 * 
 * @author 作者：王荣华
 * @date 日期：2017年7月28日上午12:02:31
 * 功能：坦克大战
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.imageio.ImageIO;
public class Tanke extends JFrame implements ActionListener{
    //战场面板
	MyPanel ml=null;
    //关卡面板
	MygkPanel mk=null;
	//菜单栏
	JMenuBar jmb=null;
	//主菜单
	JMenu jm1,jm2;
	//新游戏
	JMenuItem jmt1;
	//退出
	JMenuItem jmt2;
	//存盘退出
	JMenuItem jmt3;
	//继续游戏
	JMenuItem jmt4;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tanke tk=new Tanke();
	}
	public Tanke(){
		//创建面板
		mk=new MygkPanel();
		//创建菜单
		jmb=new JMenuBar();
		jm1=new JMenu("文件(F)");
		jm1.setMnemonic('F');
		jmt1=new JMenuItem("新游戏(N)");
		jmt1.setMnemonic('N');
		jmt2=new JMenuItem("退出(X)");
		jmt2.setMnemonic('X');
		jmt3=new JMenuItem("存盘退出(S)");
		jmt3.setMnemonic('S');
		jmt4=new JMenuItem("继续游戏(R)");
		jmt4.setMnemonic('R');
		//存放
		jmb.add(jm1);
		jm1.add(jmt1);
		jm1.add(jmt4);
		jm1.add(jmt3);
		jm1.add(jmt2);
		//注册监听
		jmt1.addActionListener(this);
		jmt1.setActionCommand("新游戏");
		jmt2.addActionListener(this);
		jmt2.setActionCommand("退出");
		jmt3.addActionListener(this);
		jmt3.setActionCommand("存盘退出");
		jmt4.addActionListener(this);
		jmt4.setActionCommand("继续游戏");
		//启动线程
		Thread ta=new Thread(mk);
		ta.start();
		//添加当窗体
		this.setJMenuBar(jmb);
		this.add(mk);
		this.setTitle("坦克大战");
		this.setSize(650,600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("新游戏")){
			ml=new MyPanel("newGame");
			//读取战绩
			Jilv.Duquwanjiachengji();
			//删除旧的面板
			this.remove(mk);
			//添加新的面板
			this.add(ml);
			//注册监听
			this.addKeyListener(ml);
			Thread ta=new Thread(ml);
			ta.start();
			//显示新的面板
			this.setVisible(true);
		}else if(e.getActionCommand().equals("退出")){
			//记录成绩
			Jilv.Jilvwanjiachengji();
			//退出
			System.exit(0);
		}else if(e.getActionCommand().equals("存盘退出")){
			Jilv.setEts(ml.dk);
			Jilv.Ditzbf();
			//退出
			System.exit(0);
		}else if(e.getActionCommand().equals("继续游戏")){
			System.out.println("继续游戏");
			ml=new MyPanel("conGame");
			//读取战绩
			Jilv.Duquwanjiachengji();
			//删除旧的面板
			this.remove(mk);
			//添加新的面板
			this.add(ml);
			//注册监听
			this.addKeyListener(ml);
			Thread ta=new Thread(ml);
			ta.start();
			//显示新的面板
			this.setVisible(true);
		}
	}

}
//关卡类
class MygkPanel extends JPanel implements Runnable{
	int i=0;
	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(0, 0, 532, 460);
		if(i%2==0){
			g.setColor(Color.yellow);
			g.setFont(new Font("华为楷体",Font.BOLD,30));
			g.drawString("关卡：1", 200, 185);
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			i++;
			this.repaint();
		}
	}
}
class MyPanel extends JPanel implements KeyListener,Runnable{
	//我的坦克
	Imtk ik=null;
	//敌人坦克
	Vector<Ditk> dk=new Vector<Ditk>();
	//保存的敌人坦克
	Vector<DuquDitk> ddk=new Vector<DuquDitk>();
	//爆炸
	Image img[]=null;
	Vector<Bomb> bombs=new Vector<Bomb>();
	public MyPanel(String file){
		//初始化我的坦克
		ik=new Imtk(220,430);
		//判断是新游戏还是继续游戏
		if(file.equals("newGame")){
			//初始化敌人坦克
			for(int i=0;i<4;i++){
				//添加敌人坦克
				Ditk ditk=new Ditk((i+1)*105,0);
			    //把敌人坦克放进Vector
				dk.add(ditk);
			    //敌人坦克上下左右移动
			    Thread ti=new Thread(ditk);
			    ti.start();
			    //将MyPanel敌人坦克交给该敌人坦克
			    ditk.setDitk(dk);
			}
		}else{
			ddk=new Jilv().DuquyouxiDitk();
			//初始化敌人坦克
			for(int i=0;i<ddk.size();i++){
				//取出保存的坦克（坐标和方向）
				DuquDitk dq=ddk.get(i);
				//添加敌人坦克
				Ditk ditk=new Ditk(dq.x,dq.y);
				//方向
				ditk.f=dq.f;
			    //把敌人坦克放进Vector
				dk.add(ditk);
			    //敌人坦克上下左右移动
			    Thread ti=new Thread(ditk);
			    ti.start();
			    //将MyPanel敌人坦克交给该敌人坦克
			    ditk.setDitk(dk);
			}
		}
		//播放音频
		AePlayWave apw=new AePlayWave("D:/Users/WRH/Workspaces/MyEclipse 2017 CI/坦克大战/src/com/image/111.wav");
	//	apw.start();
		//爆炸
		img=new Image[3];
		try {
			img[0]=ImageIO.read(new File("D:/Users/WRH/Workspaces/MyEclipse 2017 CI/坦克大战/src/com/image/bomb1.gif"));
			img[1]=ImageIO.read(new File("D:/Users/WRH/Workspaces/MyEclipse 2017 CI/坦克大战/src/com/image/bomb2.gif"));
			img[2]=ImageIO.read(new File("D:/Users/WRH/Workspaces/MyEclipse 2017 CI/坦克大战/src/com/image/bomb3.gif"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		img[0]=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/com/image/bomb1.gif"));
//		img[1]=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/com/image/bomb2.gif"));
//		img[2]=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/com/image/bomb3.gif"));
		
	}
	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(0, 0, 532, 460);
		this.showInfo(g);
		//判断我的坦克是否有效
		if(ik.ws){
		//画我的坦克
			this.Tkls(ik.getX(), ik.getY(),ik.getColor(),ik.getF(), g);
		}else if(Jilv.getImtksun()>0){
			ik=new Imtk(220,400);
		}
		//画我的子弹
		if(ik.ws){
			for(int i=0;i<ik.vv.size();i++){
				//取出一颗子弹
				Shot zd=ik.vv.get(i);
				if(ik.s!=null&&ik.s.ws==true){
					g.setColor(new Color(255,255,255));
					g.fillOval(zd.x,zd.y, 2, 2);
				}
				if(zd.ws==false){
					ik.vv.remove(zd);
				}
			}
		}	
		//画敌人坦克
		for(int i=0;i<dk.size();i++){
			Ditk dtk=dk.get(i);
			if(dtk.ws){
				this.Tkls(dtk.getX(), dtk.getY(), dtk.getColor(), dtk.getF(), g);
				//画子弹
				for(int j=0;j<dtk.vv.size();j++){
					//取子弹
					Shot zd=dtk.vv.get(j);
					if(zd.ws){
						g.setColor(new Color(255,255,255));
						g.fillOval(zd.x,zd.y, 2, 2);
					}else
					if(zd.ws==false){
						dtk.vv.remove(zd);
					}
				}
			}else if(dtk.ws==false){
				dk.remove(dtk);
				Ditk ditk=new Ditk((i+1)*105,0);
				System.out.println("死亡"+(i+1));
			}
		}
		//画爆炸
		for(int i=0;i<bombs.size();i++){
			//取出一颗炸弹
			Bomb b=bombs.get(i);
			if(b.zhi>6){
				g.drawImage(img[0], b.x, b.y, 30, 30, this);
			}else if(b.zhi>3){
				g.drawImage(img[1], b.x, b.y, 30, 30, this);
			}else{
				g.drawImage(img[2], b.x, b.y, 30, 30, this);
			}
			//让爆炸生命减少
			b.Mingzhi();
			if(b.zhi==0){
				bombs.remove(b);
			}
		}
	}
	//子弹线程
	public void run(){
		while(true){
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			//敌人坦克被击中
			this.Imjz();
			//我的坦克被击中
			this.Ditkjz();
			this.repaint();
		}
	}
	//记录函数
	public void showInfo(Graphics g){
		//玩家坦克的数量
		this.Tkls(540, 30, 0, 0, g);
		g.setColor(Color.black);
		g.setFont(new Font("宋体",Font.BOLD,20));
		g.drawString("剩"+Jilv.getImtksun()+"辆", 570, 50);
		//敌人坦克的数量
		this.Tkls(540, 70, 1, 0, g);
		g.setColor(Color.black);
		g.setFont(new Font("宋体",Font.BOLD,20));
		g.drawString("剩"+Jilv.getDitksun()+"辆", 570, 90);
		//成绩
		this.Tkls(90, 480, 1, 0, g);
		g.setColor(Color.black);
		g.setFont(new Font("宋体",Font.BOLD,20));
		g.drawString("总成绩：", 10, 500);
		g.drawString("消灭"+Jilv.getDitksi()+"辆", 120, 500);
	}
	//我的子弹击中敌人坦克
	public void Imjz(){
		//遍历我的子弹
		for(int i=0;i<ik.vv.size();i++){
			//取出子弹
			Shot sot=ik.vv.get(i);
			//判断子弹是否有效
			if(sot.ws){
				//遍历敌人坦克
				for(int j=0;j<dk.size();j++){
					//取出敌人坦克
					Ditk di=dk.get(j);
					//判断坦克是否有效
					if(di.ws){
						this.Jizhong(sot, di);
					}
				}
				
				
			}
			
		}
	}
	//敌人的子弹击中我的坦克
	public void Ditkjz(){
		//取出敌人一辆坦克
		for(int i=0;i<dk.size();i++){
			//取出敌人坦克
			Ditk et=dk.get(i);
			//取出一颗子弹
			for(int j=0;j<et.vv.size();j++){
				//取出子弹
				Shot sot=et.vv.get(j);
				if(ik.ws){
					this.Jizhong(sot, ik);
				}
			}
		} 
	}
	//判断坦克是否被居中
	public void Jizhong(Shot ss,Tk tk){
		//判断敌人坦克方向
	    switch(tk.f){
		//上下居中了
	    case 0:
	    case 1:
			if(ss.x>tk.x&&ss.x<tk.x+20&&ss.y>tk.y&&ss.y<tk.y+30){
				//子弹和坦克死亡
				ss.ws=false;
				//坦克死亡
				tk.ws=false;
				if(tk.color==1){
					//坦克减少
					Jilv.Ditksun();
					//玩家总成绩
					Jilv.Ditksi();
				}else if(tk.color==0){
					Jilv.Imtksun();
				}
				//创建爆炸对象
				Bomb b=new Bomb(tk.x-5,tk.y);
				//把爆炸放进Vectors
				bombs.add(b);
			}
			break;
		//左右居中
	    case 2:
	    case 3:
			if(ss.x>tk.x-5&&ss.x<tk.x+25&&ss.y>tk.y+5&&ss.y<tk.y+25){
				//子弹和坦克死亡
				ss.ws=false;
				//敌人坦克死亡
				tk.ws=false;
				//判断是玩家坦克还是敌人坦克
				if(tk.color==1){
					//坦克减少
					Jilv.Ditksun();
					//玩家总成绩
					Jilv.Ditksi();
				}else if(tk.color==0){
					Jilv.Imtksun();
				}
				
				//创建爆炸对象
				Bomb b=new Bomb(tk.x,tk.y);
				//把爆炸放进Vector
				bombs.add(b);
			}
			break;
		}
	    
	}
	//判断颜色和方向
	public void Tkls(int x,int y,int color,int fx,Graphics g){
		switch(color){
		//我的坦克
		case 0:
			g.setColor(new Color(255,255,0));
			break;
		//敌人坦克
		case 1:
			g.setColor(new Color(0,255,255));
			break;
		//强敌人坦克	
		case 2:
			g.setColor(new Color(255,0,0));
			break;
		}
		switch(fx){
		//往上
		case 0:
			//左边
			g.fill3DRect(x, y, 5, 30, false);
			//右边
			g.fill3DRect(x+15, y, 5, 30, false);
			//中间
			g.fill3DRect(x+3, y+5, 14, 20, false);
			//圆
			g.fillOval(x+5, y+10, 10, 10);
			//炮筒
			g.drawLine(x+10, y+15, x+10, y);
			break;
		//往下
		case 1:
			//左边
			g.fill3DRect(x, y, 5, 30, false);
			//右边
			g.fill3DRect(x+15, y, 5, 30, false);
			//中间
			g.fill3DRect(x+3, y+5, 14, 20, false);
			//圆
			g.fillOval(x+5, y+10, 10, 10);
			//炮筒
			g.drawLine(x+10, y+15, x+10, y+30);
			break;
		//往左
		case 2:
			//左边
			g.fill3DRect(x-5, y+20, 30, 5, false);
			//右边
			g.fill3DRect(x-5, y+5, 30, 5, false);
			//中间
			g.fill3DRect(x, y+8, 20, 14, false);
			//圆
			g.fillOval(x+5, y+10, 10, 10);
			//炮筒
			g.drawLine(x+5, y+15, x-5, y+15);
			break;
		//往右
		case 3:
			//左边
			g.fill3DRect(x-5, y+20, 30, 5, false);
			//右边
			g.fill3DRect(x-5, y+5, 30, 5, false);
			//中间
			g.fill3DRect(x, y+8, 20, 14, false);
			//圆
			g.fillOval(x+5, y+10, 10, 10);
			//炮筒
			g.drawLine(x+5, y+15, x+25, y+15);
			break;
		} 
	}
	public void keyPressed(KeyEvent e){
		this.repaint();
		//往上移动
		if(e.getKeyCode()==KeyEvent.VK_W){
			this.ik.Up();
			this.ik.setF(0);
		//往下移动
		}else if(e.getKeyCode()==KeyEvent.VK_S){
            this.ik.Down();
            this.ik.setF(1);
	    //往左移动
		}else if(e.getKeyCode()==KeyEvent.VK_A){
			this.ik.Left();
			this.ik.setF(2);
		//往右移动
		}else if(e.getKeyCode()==KeyEvent.VK_D){
			this.ik.Ringht();
			this.ik.setF(3);
		}
		//按j开火
		if(e.getKeyCode()==KeyEvent.VK_J){
			if(ik.vv.size()<5){
	    	    this.ik.zidan();
			}
		}
	}	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
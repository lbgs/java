package com.坦克;
/**
 * 
 * @author 作者：王荣华
 * @date 日期：2017年7月28日上午12:02:31
 * 功能：坦克大战
 */
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.*;
public class Demo1 extends JFrame {
    My ml=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo1  tk=new Demo1 ();
	}
	public Demo1(){
		ml=new My();
		//设置窗体
		this.add(ml);
		this.addKeyListener(ml);
		Thread ta=new Thread(ml);
		ta.start();
		this.setTitle("坦克");
		this.setSize(532,460);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class My extends JPanel implements KeyListener,Runnable{
	//我的坦克
	Imtk ik=null;
	//敌人坦克
	Vector<Ditk> dk=new Vector<Ditk>();
	//爆炸
	Image img[]=null;
	Vector<Bomb> bombs=new Vector<Bomb>();
	//击中
	public My(){
		//初始化我的坦克
		ik=new Imtk(220,400);
		//初始化敌人坦克
		for(int i=0;i<4;i++){
			//添加敌人坦克
			Ditk ditk=new Ditk((i+1)*105,0);
		    //把敌人坦克放进Vector
			dk.add(ditk);
		    //敌人坦克上下左右移动
		    Thread ti=new Thread(ditk);
		    ti.start();
		}
		//爆炸
		img=new Image[3];
		img[0]=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/com/image/bomb1.gif"));
		img[1]=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/com/image/bomb2.gif"));
		img[2]=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/com/image/bomb3.gif"));
		
	}
	public void paint(Graphics g){
		super.paint(g);
		//背景颜色
		g.fillRect(0, 0, 532, 460);
		//我的坦克
		this.Tkls(ik.getX(), ik.getY(),ik.getColor(),ik.getF(), g);
		//敌人坦克
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
		//我的子弹
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
	//子弹线程
	public void run(){
		while(true){
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
			//遍历我的子弹
			for(int i=0;i<ik.vv.size();i++){
				//取出子弹
				Shot sot=ik.vv.get(i);
				//判断我的子弹是否有效
				if(sot.ws){
					//遍历敌人坦克
					for(int j=0;j<dk.size();j++){
						//取出敌人坦克
						Ditk di=dk.get(j);
						//判断坦克是否有效
						if(di.ws){
							this.DkJizhong(sot, di);
						}
					}
					
				}
				
			}
			this.repaint();
		}
	}
	//判断敌人是否被居中
	public void DkJizhong(Shot ss,Ditk di){
		//判断敌人坦克方向
	    switch(di.f){
		//上下居中了
	    case 0:
	    case 1:
			if(ss.x>di.x&&ss.x<di.x+20&&ss.y>di.y&&ss.y<di.y+30){
				//子弹和坦克死亡
				ss.ws=false;
				//敌人坦克死亡
				di.ws=false;
				//创建爆炸对象
				Bomb b=new Bomb(di.x-5,di.y);
				//把爆炸放进Vectors
				bombs.add(b);
			}
			break;
		//左右居中
	    case 2:
	    case 3:
			if(ss.x>di.x-5&&ss.x<di.x+25&&ss.y>di.y+5&&ss.y<di.y+25){
				//子弹和坦克死亡
				ss.ws=false;
				//敌人坦克死亡
				di.ws=false;
				//创建爆炸对象
				Bomb b=new Bomb(di.x,di.y);
				//把爆炸放进Vector
				bombs.add(b);
			}
			break;
		}
	    
	}
	//判断我的坦克是否被击中
	public void IkJizhong(Shot ss,Imtk im){
		//判断我的坦克方向
	    switch(im.f){
	    case 0:
	    case 1:
	    	if(ss.x>im.x&&ss.x<im.x+20&&ss.y>im.y&&ss.y<im.y+30){
	    		//子弹死亡
	    		ss.ws=false;
	    		//我的坦克死亡
	    		ik.ws=false;
	    		//创建爆炸
	    		Bomb b=new Bomb(ik.x-5,ik.y);
	    		//爆炸放进Vector
	    		bombs.add(b);
	    		System.out.println(ik.ws);
	    	}
	    case 2:
	    case 3:
	    	if(ss.x>im.x-5&&ss.x<im.x+25&&ss.y>im.y+5&&ss.y<im.y+25){
	    		ss.ws=false;
	    		//我的坦克死亡
	    		ik.ws=false;
	    		//创建爆炸
	    		Bomb b=new Bomb(ik.x,ik.y);
	    		//爆炸放进Vector
	    		bombs.add(b);
	    	}
	    }
	}
	//判断颜色和方向
	public void Tkls(int x,int y,int co,int fx,Graphics g){
		switch(co){
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
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
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
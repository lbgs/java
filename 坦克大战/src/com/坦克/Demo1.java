package com.̹��;
/**
 * 
 * @author ���ߣ����ٻ�
 * @date ���ڣ�2017��7��28������12:02:31
 * ���ܣ�̹�˴�ս
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
		//���ô���
		this.add(ml);
		this.addKeyListener(ml);
		Thread ta=new Thread(ml);
		ta.start();
		this.setTitle("̹��");
		this.setSize(532,460);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class My extends JPanel implements KeyListener,Runnable{
	//�ҵ�̹��
	Imtk ik=null;
	//����̹��
	Vector<Ditk> dk=new Vector<Ditk>();
	//��ը
	Image img[]=null;
	Vector<Bomb> bombs=new Vector<Bomb>();
	//����
	public My(){
		//��ʼ���ҵ�̹��
		ik=new Imtk(220,400);
		//��ʼ������̹��
		for(int i=0;i<4;i++){
			//��ӵ���̹��
			Ditk ditk=new Ditk((i+1)*105,0);
		    //�ѵ���̹�˷Ž�Vector
			dk.add(ditk);
		    //����̹�����������ƶ�
		    Thread ti=new Thread(ditk);
		    ti.start();
		}
		//��ը
		img=new Image[3];
		img[0]=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/com/image/bomb1.gif"));
		img[1]=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/com/image/bomb2.gif"));
		img[2]=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/com/image/bomb3.gif"));
		
	}
	public void paint(Graphics g){
		super.paint(g);
		//������ɫ
		g.fillRect(0, 0, 532, 460);
		//�ҵ�̹��
		this.Tkls(ik.getX(), ik.getY(),ik.getColor(),ik.getF(), g);
		//����̹��
		for(int i=0;i<dk.size();i++){
			Ditk dtk=dk.get(i);
			if(dtk.ws){
				this.Tkls(dtk.getX(), dtk.getY(), dtk.getColor(), dtk.getF(), g);
			//���ӵ�
			for(int j=0;j<dtk.vv.size();j++){
				//ȡ�ӵ�
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
		//����ը
		for(int i=0;i<bombs.size();i++){
			//ȡ��һ��ը��
			Bomb b=bombs.get(i);
			if(b.zhi>6){
				g.drawImage(img[0], b.x, b.y, 30, 30, this);
			}else if(b.zhi>3){
				g.drawImage(img[1], b.x, b.y, 30, 30, this);
			}else{
				g.drawImage(img[2], b.x, b.y, 30, 30, this);
			}
			//�ñ�ը��������
			b.Mingzhi();
			if(b.zhi==0){
				bombs.remove(b);
			}
		}
		//�ҵ��ӵ�
		for(int i=0;i<ik.vv.size();i++){
			//ȡ��һ���ӵ�
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
	//�ӵ��߳�
	public void run(){
		while(true){
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
			//�����ҵ��ӵ�
			for(int i=0;i<ik.vv.size();i++){
				//ȡ���ӵ�
				Shot sot=ik.vv.get(i);
				//�ж��ҵ��ӵ��Ƿ���Ч
				if(sot.ws){
					//��������̹��
					for(int j=0;j<dk.size();j++){
						//ȡ������̹��
						Ditk di=dk.get(j);
						//�ж�̹���Ƿ���Ч
						if(di.ws){
							this.DkJizhong(sot, di);
						}
					}
					
				}
				
			}
			this.repaint();
		}
	}
	//�жϵ����Ƿ񱻾���
	public void DkJizhong(Shot ss,Ditk di){
		//�жϵ���̹�˷���
	    switch(di.f){
		//���¾�����
	    case 0:
	    case 1:
			if(ss.x>di.x&&ss.x<di.x+20&&ss.y>di.y&&ss.y<di.y+30){
				//�ӵ���̹������
				ss.ws=false;
				//����̹������
				di.ws=false;
				//������ը����
				Bomb b=new Bomb(di.x-5,di.y);
				//�ѱ�ը�Ž�Vectors
				bombs.add(b);
			}
			break;
		//���Ҿ���
	    case 2:
	    case 3:
			if(ss.x>di.x-5&&ss.x<di.x+25&&ss.y>di.y+5&&ss.y<di.y+25){
				//�ӵ���̹������
				ss.ws=false;
				//����̹������
				di.ws=false;
				//������ը����
				Bomb b=new Bomb(di.x,di.y);
				//�ѱ�ը�Ž�Vector
				bombs.add(b);
			}
			break;
		}
	    
	}
	//�ж��ҵ�̹���Ƿ񱻻���
	public void IkJizhong(Shot ss,Imtk im){
		//�ж��ҵ�̹�˷���
	    switch(im.f){
	    case 0:
	    case 1:
	    	if(ss.x>im.x&&ss.x<im.x+20&&ss.y>im.y&&ss.y<im.y+30){
	    		//�ӵ�����
	    		ss.ws=false;
	    		//�ҵ�̹������
	    		ik.ws=false;
	    		//������ը
	    		Bomb b=new Bomb(ik.x-5,ik.y);
	    		//��ը�Ž�Vector
	    		bombs.add(b);
	    		System.out.println(ik.ws);
	    	}
	    case 2:
	    case 3:
	    	if(ss.x>im.x-5&&ss.x<im.x+25&&ss.y>im.y+5&&ss.y<im.y+25){
	    		ss.ws=false;
	    		//�ҵ�̹������
	    		ik.ws=false;
	    		//������ը
	    		Bomb b=new Bomb(ik.x,ik.y);
	    		//��ը�Ž�Vector
	    		bombs.add(b);
	    	}
	    }
	}
	//�ж���ɫ�ͷ���
	public void Tkls(int x,int y,int co,int fx,Graphics g){
		switch(co){
		//�ҵ�̹��
		case 0:
			g.setColor(new Color(255,255,0));
			break;
		//����̹��
		case 1:
			g.setColor(new Color(0,255,255));
			break;
		//ǿ����̹��	
		case 2:
			g.setColor(new Color(255,0,0));
			break;
		}
		switch(fx){
		//����
		case 0:
			//���
			g.fill3DRect(x, y, 5, 30, false);
			//�ұ�
			g.fill3DRect(x+15, y, 5, 30, false);
			//�м�
			g.fill3DRect(x+3, y+5, 14, 20, false);
			//Բ
			g.fillOval(x+5, y+10, 10, 10);
			//��Ͳ
			g.drawLine(x+10, y+15, x+10, y);
			break;
		//����
		case 1:
			//���
			g.fill3DRect(x, y, 5, 30, false);
			//�ұ�
			g.fill3DRect(x+15, y, 5, 30, false);
			//�м�
			g.fill3DRect(x+3, y+5, 14, 20, false);
			//Բ
			g.fillOval(x+5, y+10, 10, 10);
			//��Ͳ
			g.drawLine(x+10, y+15, x+10, y+30);
			break;
		//����
		case 2:
			//���
			g.fill3DRect(x-5, y+20, 30, 5, false);
			//�ұ�
			g.fill3DRect(x-5, y+5, 30, 5, false);
			//�м�
			g.fill3DRect(x, y+8, 20, 14, false);
			//Բ
			g.fillOval(x+5, y+10, 10, 10);
			//��Ͳ
			g.drawLine(x+5, y+15, x-5, y+15);
			break;
		//����
		case 3:
			//���
			g.fill3DRect(x-5, y+20, 30, 5, false);
			//�ұ�
			g.fill3DRect(x-5, y+5, 30, 5, false);
			//�м�
			g.fill3DRect(x, y+8, 20, 14, false);
			//Բ
			g.fillOval(x+5, y+10, 10, 10);
			//��Ͳ
			g.drawLine(x+5, y+15, x+25, y+15);
			break;
		} 
	}
	public void keyPressed(KeyEvent e){
		this.repaint();
		//�����ƶ�
		if(e.getKeyCode()==KeyEvent.VK_W){
			this.ik.Up();
			this.ik.setF(0);
		//�����ƶ�
		}else if(e.getKeyCode()==KeyEvent.VK_S){
            this.ik.Down();
            this.ik.setF(1);
	    //�����ƶ�
		}else if(e.getKeyCode()==KeyEvent.VK_A){
			this.ik.Left();
			this.ik.setF(2);
		//�����ƶ�
		}else if(e.getKeyCode()==KeyEvent.VK_D){
			this.ik.Ringht();
			this.ik.setF(3);
		}
		//��j����
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
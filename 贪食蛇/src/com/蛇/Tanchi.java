package com.��;
/**
 * 
 * @author ���ߣ����ٻ�
 * @date ���ڣ�2017��7��30������10:06:34
 * ���ܣ�̰����
 */
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
public class Tanchi extends JFrame{
    ShePanel sp=null; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tanchi tc=new Tanchi();
	}
	public Tanchi(){
		//�������
		sp=new ShePanel();
		//ע�����
		this.addKeyListener(sp);
		//�߳�
		Thread ts=new Thread(sp);
		ts.start();
		//������
		this.add(sp);
		//���ô���
		this.setTitle("̰����");
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class ShePanel extends JPanel implements KeyListener,Runnable{
	Imshe ss=null;
	Image img=null;
	public ShePanel(){
		ss=new Imshe(60,100);
		Thread ta=new Thread(ss);
		ta.start();
		try {
			img=ImageIO.read(new File("D:/Users/Administrator/Desktop/С��/lle.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(0, 0, 500, 400);
		g.setColor(new Color(255,255,255));
		g.fillOval(ss.getX(),ss.getY(), 10, 10);
	//	g.drawImage(img,ss.getX(),ss.getY(),50,40,this );
		this.Fang(g);
	}
	//�жϷ���
	public void Fang(Graphics g){
		g.setColor(new Color(0,0,255));
		switch(ss.getFx()){
		case 8:
			g.fillOval(ss.getX(),ss.getY()+10, 10, 10);
			break;
		case 2:
			g.fillOval(ss.getX(),ss.getY()-10, 10, 10);
			break;
		case 4:
			g.fillOval(ss.getX()+10,ss.getY(), 10, 10);
			break;
		case 6:
			g.fillOval(ss.getX()-10,ss.getY(), 10, 10);
			break;
		}
	}
	public void run(){
		while(true){
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			this.repaint();
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		this.repaint();
		if(e.getKeyCode()==KeyEvent.VK_W){
			this.ss.setFx(8);
		}else if(e.getKeyCode()==KeyEvent.VK_S){
			this.ss.setFx(2);
		}else if(e.getKeyCode()==KeyEvent.VK_A){
			this.ss.setFx(4);
		}else if(e.getKeyCode()==KeyEvent.VK_D){
			this.ss.setFx(6);
		}
		if(e.getKeyCode()==KeyEvent.VK_J){
	//	this.ss.Px();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
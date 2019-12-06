package com.练习;
/**
 * 
 * @author 作者：王荣华
 * @date 日期：2017年7月29日下午10:35:10
 * java中英文翻译
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Fanyi extends JFrame{
    china fy=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fanyi fi=new Fanyi();
		Thread ta=new Thread(new china());
		ta.start();
	}
	public Fanyi(){
		fy=new china();
		//注册监听
        this.addKeyListener(fy);
		this.add(fy);
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class china extends JPanel implements KeyListener,Runnable{
	int x=50;
	int y=100;
	public china(){
		
	}
	public void paint(Graphics g){
		super.paint(g);
        g.fillRect(0, 0, 500, 400);
        g.setColor(new Color(255,255,255));
		g.fillOval(x, y, 10, 10);
	}
	public void run(){
		while(true){
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			x+=10;
			System.out.println(x);
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
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			x++;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
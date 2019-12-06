package com.¡∑œ∞;
import java.awt.*;
import javax.swing.*;
import java.util.*;
public class Timer extends JWindow{
	MyPanel mp=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer t=new Timer();
//		t.RunTime(20);
	}
	public Timer(){
		mp=new MyPanel(10);
		this.add(mp);
		this.setSize(500,400);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
class MyPanel extends JPanel{
	int time;
	public MyPanel(int time){
		this.time=time;
	}
	public void paint(Graphics g){
		super.paint(g);
		g.setFont(new Font("ÀŒÃÂ",Font.BOLD,100));
		
		while(time>0){
			System.out.println(time);
			g.drawString("00:"+time, 150, 200);
			try {
				Thread.sleep(1000);
				time--;
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		if(time==0){
			System.out.println("÷¥––√¸¡Ó");
		}
	}
}
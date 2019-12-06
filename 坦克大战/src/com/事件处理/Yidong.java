package com.事件处理;
/**
 * 
 * @author 作者：王荣华
 * @date 日期：2017年7月28日下午4:59:01
 * 功能：上下左右移动
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Yidong extends JFrame{
	Mypanel mp=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Yidong yd=new Yidong();
	}
	public Yidong(){
		System.out.println("窗体");
		mp=new Mypanel();
		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class Mypanel extends JPanel implements KeyListener{
	int x=30;
	int y=30;
	public void paint(Graphics g){
		 super.paint(g);
		 g.fillOval(x, y, 10, 10);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		this.repaint();
		if(e.getKeyCode()==KeyEvent.VK_UP){
			y--;
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			y++;
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			x--;
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			this.x++;
		}else if(e.getKeyCode()==KeyEvent.VK_S){
			y++;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}

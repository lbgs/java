package com.Á·Ï°;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Demo1_4 extends JFrame{
    Yd d=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo1_4 demo4=new Demo1_4();
	}
	public Demo1_4(){
		d=new Yd();
		this.addMouseListener(d);
		this.addMouseMotionListener(d);
		this.add(d);
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class Yd extends JPanel implements MouseListener,MouseMotionListener{
    int x;
    int y;
    int a;
    int b;
	public void paint(Graphics g){
    	super.paint(g);
    	g.fillOval(x-12, y-35, 10, 10);
    	g.setColor(Color.red);
    	g.fillOval(a-12, b-35, 10, 10);
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		this.repaint();
		if(e.getX()>x){
			x=e.getX();
			y=e.getY();
			a=x-10;
			b=y;
		}else if(e.getX()<x){
			x=e.getX();
			y=e.getY();
			a=x+10;
			b=y;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		this.repaint();
		System.out.println(e.getX()+"  "+e.getY());
	/*	if(e.getX()>x&&e.getY()>y){
			a=x;
			b=y;
			x=e.getX();
			y=e.getY();
		}else if(e.getX()<x&&e.getY()<y){
			a=x;
			b=y;
			x=e.getX();
			y=e.getY();
		} else */ if(e.getX()>x){
			System.out.println(x+"  "+y);
			a=x-10;
			b=y;
			x=e.getX();
			y=e.getY();
		}else if(e.getX()<x){
			a=x+10;
			b=y;
			x=e.getX();
			y=e.getY();
		}else if(e.getY()>y){
			a=x;
			b=y-10;
			x=e.getX();
			y=e.getY();
		}else if(e.getY()<y){
			a=x;
			b=y+10;
			x=e.getX();
			y=e.getY();
		}
	}
	
}

package com.��ϰ;
/**
 * 
 * @author ���ߣ����ٻ�
 * @date ���ڣ�2017��7��29������12:29:27
 *
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Demo1_3 extends JFrame{
    MyPane mp=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Demo1_3 demo3=new Demo1_3();
	}
	public Demo1_3(){
		mp=new MyPane();
		this.addMouseListener(mp);
		this.addMouseMotionListener(mp);
		this.add(mp);
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class MyPane extends JPanel implements KeyListener,MouseListener,MouseMotionListener{
    int x;
    int y;
    int width;
    int height;
	public void paint(Graphics g){
		super.paint(g);
		g.drawRect(x-7, y-30, width, height);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("�����");
		width+=50;
		height++;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("��갴��");
		this.repaint();
		System.out.println("��갴��x="+e.getX()+"  y="+e.getY());
		x=e.getX();
		y=e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("����ɿ�");
		System.out.println("����ɿ�x="+e.getX()+"  y="+e.getY());
		this.repaint();
			width=e.getX()-x;
			height=e.getY()-y;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("������");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("����뿪");
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		

	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
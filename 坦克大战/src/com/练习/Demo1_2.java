package com.��ϰ;
/**
 * 
 * @author ���ߣ����ٻ�
 * @date ���ڣ�2017��7��28������4:35:43
 * ���ܣ��¼�������ƣ���ť��
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Demo1_2 extends JFrame implements ActionListener{
    JPanel mp=null;
    JButton bt1,bt2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo1_2 demo2=new Demo1_2();
	}
	public Demo1_2(){
		mp=new JPanel();
		mp.setBackground(new Color(0,0,0));
		bt1=new JButton("��ɫ");
		bt2=new JButton("��ɫ");
		this.add(mp);
		this.add(bt1,BorderLayout.NORTH);
		this.add(bt2,BorderLayout.SOUTH);
		//ע���¼�
		bt1.setActionCommand("��ɫ");
		bt2.setActionCommand("��ɫ");
		//��ӵ�����
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		this.setTitle("��ɫ�л�");
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("��ɫ")){
			mp.setBackground(new Color(0,0,255));
		}else if(e.getActionCommand().equals("��ɫ")){
			mp.setBackground(new Color(255,0,0));
		}
	}


}

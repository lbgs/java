package com.swing;

/**
 * @author ���ߣ����ٻ�
 * @date ���ڣ�2017��7��25������11:44:27
 * ���ܣ���ʽ���ֹ���
 */
import java.awt.*;
import javax.swing.*;
public class Demo1_5 extends JFrame {
	int size=5;
	//�������
	JButton jb[]=new JButton[size];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo1_5 demo5=new Demo1_5();
	}
	public Demo1_5(){
		//�������
		jb[0]=new JButton("����");
	//	jb[0].setSize(100, 80);
	//	jb[0].setLocation(30, 40);
		jb[1]=new JButton("��С��");
	//	jb[1].setSize(50,60);
		jb[2]=new JButton("������");
		jb[3]=new JButton("���");
		jb[4]=new JButton("����");
		this.add(jb[0]);
		this.add(jb[1]);
		this.add(jb[2]);
		this.add(jb[3]);
		this.add(jb[4]);
		//���ֹ���
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
	//	this.setLayout(null);
		//���ô���
		this.setTitle("��ʽ����");
		this.setSize(300,200);
		this.setLocation(450,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

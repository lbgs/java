package com.swing;
/**
 * 
 * @author ���ߣ����ٻ�
 * @date ���ڣ�2017��7��26������12:16:35
 * ���ܣ����񲼾ֹ���
 */
import java.awt.*;
import javax.swing.*;
public class Demo1_4 extends JFrame{
    int size=9;
    JButton jb[]=new JButton[size];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo1_4 demo4=new Demo1_4();
	}
	public Demo1_4(){
		//�������
		for(int i=0;i<size;i++){
			jb[i]=new JButton(String.valueOf(i+1));
		}
		//���ֹ���
		this.setLayout(new GridLayout(3,3,10,10));
		//������
		for(int i=0;i<size;i++){
			this.add(jb[i]);
		}
		//���ô���
		this.setTitle("�������");
		this.setSize(300,200);
		this.setLocation(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//��ֹ�ı䴰���С
		this.setResizable(false);
	}

}

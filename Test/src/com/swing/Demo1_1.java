package com.swing;
import javax.swing.JButton;
import javax.swing.JFrame;
public class Demo1_1 extends JFrame { 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Demo1_1 demo=new Demo1_1();
	}
	JButton jb=null;
    public Demo1_1(){
    	//����JButtn���
    	jb=new JButton("����һ����ť");
    	//����һ������
    	this.setTitle("hello");
    	//���ô����С
    	this.setSize(200,200);
    	//��JButton�Ž�JFrame
    	this.add(jb);
    	//���ô���λ��
    	this.setLocation(400,300);
    	//��ʾ����
    	this.setVisible(true);
    	//�����ڹر�ʱ������̨Ҳ�ر�
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

package com.swing;
import java.awt.*;
import javax.swing.*;
/**
 * @author ���ٻ�
 * @date ���ڣ�2017��7��25������11:21:38
 * ���ܣ��߽粼��
 */
public class Demo1_2 extends JFrame {
    int size=5;
    //�������
    JButton jb[]=new JButton[size];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Demo1_2 deom1=new Demo1_2();
	}
	public Demo1_2(){
		//�������
	    jb[0]=new JButton("�в�");
	    jb[1]=new JButton("����");
	    jb[2]=new JButton("�ϲ�");
	    jb[3]=new JButton("����");
	    jb[4]=new JButton("����");
	    //���λ��
	    this.add(jb[0],BorderLayout.CENTER);//��
	    this.add(jb[1],BorderLayout.WEST);//��
	    this.add(jb[2],BorderLayout.SOUTH);//��
	    this.add(jb[3],BorderLayout.EAST);//��
	    this.add(jb[4],BorderLayout.NORTH);//��
	    //���ô���
	    this.setTitle("�߽粼��");
	    this.setSize(500,400);
	    this.setLocation(300, 200);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	}

}

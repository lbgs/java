package com.��ϰ;
import java.awt.*;
import javax.swing.JFrame;
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����һ�����췽�������ô��ڱ���
       Frame f=new Frame("С��Ϸ"); 
       //���ô���λ�úʹ�С��λ�ÿ�20����30����С��200����100
       f.setBounds(20,30,200,100);
       f.setSize(500,400);//���ô���λ�ã����500���߶�400
       f.setLocation(300, 200);//���ô��ڴ�С�����300���߶�200
       f.setVisible(true);//������ʾ
       JFrame a=new JFrame();    
       a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  //     a.setDefaultColoseOperation(JFrame.EXIT_ON_CLOSE);
       Button b=new Button();
       b.add(null);

	}
}


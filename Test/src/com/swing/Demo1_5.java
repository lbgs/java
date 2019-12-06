package com.swing;

/**
 * @author 作者：王荣华
 * @date 日期：2017年7月25日下午11:44:27
 * 功能：流式布局管理
 */
import java.awt.*;
import javax.swing.*;
public class Demo1_5 extends JFrame {
	int size=5;
	//定义组件
	JButton jb[]=new JButton[size];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo1_5 demo5=new Demo1_5();
	}
	public Demo1_5(){
		//创建组件
		jb[0]=new JButton("成龙");
	//	jb[0].setSize(100, 80);
	//	jb[0].setLocation(30, 40);
		jb[1]=new JButton("李小龙");
	//	jb[1].setSize(50,60);
		jb[2]=new JButton("李连杰");
		jb[3]=new JButton("洪金宝");
		jb[4]=new JButton("周润发");
		this.add(jb[0]);
		this.add(jb[1]);
		this.add(jb[2]);
		this.add(jb[3]);
		this.add(jb[4]);
		//布局管理
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
	//	this.setLayout(null);
		//设置窗体
		this.setTitle("流式布局");
		this.setSize(300,200);
		this.setLocation(450,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

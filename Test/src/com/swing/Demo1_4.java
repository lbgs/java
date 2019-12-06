package com.swing;
/**
 * 
 * @author 作者：王荣华
 * @date 日期：2017年7月26日上午12:16:35
 * 功能：网格布局管理
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
		//创建组件
		for(int i=0;i<size;i++){
			jb[i]=new JButton(String.valueOf(i+1));
		}
		//布局管理
		this.setLayout(new GridLayout(3,3,10,10));
		//添加组件
		for(int i=0;i<size;i++){
			this.add(jb[i]);
		}
		//设置窗体
		this.setTitle("网格管理");
		this.setSize(300,200);
		this.setLocation(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//禁止改变窗体大小
		this.setResizable(false);
	}

}

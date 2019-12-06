package com.练习;
/**
 * 
 * @author 作者：王荣华
 * @date 日期：2017年7月28日下午4:35:43
 * 功能：事件处理机制（按钮）
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
		bt1=new JButton("蓝色");
		bt2=new JButton("红色");
		this.add(mp);
		this.add(bt1,BorderLayout.NORTH);
		this.add(bt2,BorderLayout.SOUTH);
		//注册事件
		bt1.setActionCommand("蓝色");
		bt2.setActionCommand("红色");
		//添加到监听
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		this.setTitle("颜色切换");
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("蓝色")){
			mp.setBackground(new Color(0,0,255));
		}else if(e.getActionCommand().equals("红色")){
			mp.setBackground(new Color(255,0,0));
		}
	}


}

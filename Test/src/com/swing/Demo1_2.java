package com.swing;
import java.awt.*;
import javax.swing.*;
/**
 * @author 王荣华
 * @date 日期：2017年7月25日下午11:21:38
 * 功能：边界布局
 */
public class Demo1_2 extends JFrame {
    int size=5;
    //定义组件
    JButton jb[]=new JButton[size];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Demo1_2 deom1=new Demo1_2();
	}
	public Demo1_2(){
		//创建组件
	    jb[0]=new JButton("中部");
	    jb[1]=new JButton("东部");
	    jb[2]=new JButton("南部");
	    jb[3]=new JButton("西部");
	    jb[4]=new JButton("北部");
	    //组件位置
	    this.add(jb[0],BorderLayout.CENTER);//中
	    this.add(jb[1],BorderLayout.WEST);//东
	    this.add(jb[2],BorderLayout.SOUTH);//南
	    this.add(jb[3],BorderLayout.EAST);//西
	    this.add(jb[4],BorderLayout.NORTH);//北
	    //设置窗体
	    this.setTitle("边界布局");
	    this.setSize(500,400);
	    this.setLocation(300, 200);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	}

}

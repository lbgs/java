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
    	//创建JButtn组件
    	jb=new JButton("我是一个按钮");
    	//创建一个标题
    	this.setTitle("hello");
    	//设置窗体大小
    	this.setSize(200,200);
    	//把JButton放进JFrame
    	this.add(jb);
    	//设置窗口位置
    	this.setLocation(400,300);
    	//显示窗口
    	this.setVisible(true);
    	//当窗口关闭时，控制台也关闭
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

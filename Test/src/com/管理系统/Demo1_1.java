package com.管理系统;
/**
 * 
 * @author 作者：王荣华
 * @date 日期：2017年7月26日下午4:19:52
 * 功能：登陆界面
 */
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
public class Demo1_1 extends JFrame {
    JPanel jpl1,jpl2,jpl3;
    JLabel jl1,jl2;
	JTextField jtf1;
    JPasswordField jpf1;
    JButton jb1,jb2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo1_1 demo1=new Demo1_1();
	}
	public Demo1_1(){
		//设置窗体图标
		//创建组件
        jpl1=new JPanel();
        jpl2=new JPanel();
        jpl3=new JPanel();
        jl1=new JLabel("用户名：");
        jl2=new JLabel("密    码：");
        jtf1=new JTextField(10);
        jpf1=new JPasswordField(10);
        jb1=new JButton("登陆");
        jb2=new JButton("取消");
        
        //布局管理
        this.setLayout(new GridLayout(3,1));
         
        //添加组件
        jpl1.add(jl1);
        jpl1.add(jtf1);
        jpl2.add(jl2);
        jpl2.add(jpf1);
        jpl3.add(jb1);
        jpl3.add(jb2);
        
        this.add(jpl1);
        this.add(jpl2);
        this.add(jpl3);
        
        this.setTitle("会员登陆");
        this.setSize(220,150);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}

}

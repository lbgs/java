package com.管理系统;
/**
 * 
 * @author 作者：王荣华
 * @date 日期：2017年7月26日下午11:17:36
 * 功能：QQ聊天功能
 */
import java.awt.*;
import javax.swing.*;
public class Liaotian extends JFrame {
    JTextArea jta=null;
    JScrollPane jcp=null;
    JPanel jp=null;
    JComboBox jcb=null;
    JTextField jtf=null;
    JButton jb=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Liaotian qq=new Liaotian();
	}
	public Liaotian(){
		//创建窗体
		jta=new JTextArea();
		jcp=new JScrollPane(jta);
		jp=new JPanel();
		String as[]={"木港","小乐","俊洪","锡树"};
		jcb=new JComboBox(as);
		jtf=new JTextField(10);
		jb=new JButton("发送");
		//布局管理
		//面板
		jp.add(jcb);
		jp.add(jtf);
		jp.add(jb);
		//添加组件
		this.add(jcp);
		this.add(jp,BorderLayout.SOUTH);
		//设置窗体
		this.setTitle("QQ聊天");
		this.setIconImage((new ImageIcon("image/mm.jpg")).getImage());
		this.setSize(300,200);
		this.setLocation(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}

}

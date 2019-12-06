package 学生管理系统1;
/**
 * 
 * @author 王荣华
 *	添加数据
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
public class Sutadd extends JDialog implements ActionListener {
	JLabel jl1,jl2,jl3,jl4;
	JTextField jtf1,jtf2,jtf3,jtf4;
	JButton jb1,jb2;
	JPanel jp1,jp2;
	Connection ct=null;
	PreparedStatement ps=null;
	//owner：this的父窗体
	//title：窗体名
	//modal：指定是模式窗口，还是非模式窗口
	public Sutadd(Frame owner,String title,boolean modal){
		super(owner,title,modal);
		//定义组件
		jl1=new JLabel("编号");
		jl2=new JLabel("姓名");
		jl3=new JLabel("性别");
		jl4=new JLabel("年龄");
		
		jtf1=new JTextField(20);
		jtf2=new JTextField(20);
		jtf3=new JTextField(20);
		jtf4=new JTextField(20);
		
		jb1=new JButton("添加");
		jb1.addActionListener(this);
		jb2=new JButton("取消");
		jb2.addActionListener(this);
		
		jp1=new JPanel();
		jp1.add(jl1);
		jp1.add(jtf1);
		jp1.add(jl2);
		jp1.add(jtf2);
		jp1.add(jl3);
		jp1.add(jtf3);
		jp1.add(jl4);
		jp1.add(jtf4);
		
		jp2=new JPanel();
		jp2.add(jb1);
		jp2.add(jb2);
		//添加组件
		this.add(jp1,BorderLayout.CENTER);
		this.add(jp2,BorderLayout.SOUTH);
		//设置窗体
		this.setSize(300,200);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){	
			String sql="insert into pengyoubiao values(?,?,?,?)";
			String[] paras={jtf1.getText(),jtf2.getText(),jtf3.getText(),jtf4.getText()};
			Sutmodel sm=new Sutmodel();
			String add="";
			if(sm.Sutupdate(sql, paras)){
				add="添加成功";
			}else{
				add="添加失败";
			}
			JOptionPane.showMessageDialog(this, add);
			this.dispose();
		}
	}
}

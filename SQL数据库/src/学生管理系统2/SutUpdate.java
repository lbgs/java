package 学生管理系统2;
/**
 * 
 * @author 王荣华
 *	修改数据
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
public class SutUpdate extends JDialog implements ActionListener {
	JLabel jl1,jl2,jl3,jl4;
	JTextField jtf1,jtf2,jtf3,jtf4;
	JButton jb1,jb2;
	JPanel jp1,jp2;
	Connection ct=null;
	PreparedStatement ps=null;
	//owner：this的父窗体
	//title：窗体名
	//modal：指定是模式窗口，还是非模式窗口
	public SutUpdate(Frame owner,String title,boolean modal,Sutmodel sqlsut,int row){
		super(owner,title,modal);
		//定义组件
		jl1=new JLabel("编号");
		jl2=new JLabel("姓名");
		jl3=new JLabel("性别");
		jl4=new JLabel("年龄");
		
		jtf1=new JTextField(20);
		jtf1.setText(sqlsut.getValueAt(row, 0).toString());
		//禁止用户修改
		jtf1.setEditable(false);
		jtf2=new JTextField(20);
		jtf2.setText((String)sqlsut.getValueAt(row, 1));
		jtf3=new JTextField(20);
		jtf3.setText((String)sqlsut.getValueAt(row, 2));
		jtf4=new JTextField(20);
		jtf4.setText(sqlsut.getValueAt(row, 3).toString());
		
		jb1=new JButton("修改");
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
			String sql="update pengyoubiao set Pname=?,sve=?,age=? where PID=?";
			String[] paras={jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf1.getText(),};
			Sutmodel sm=new Sutmodel();
			String add="";
			if(sm.Sutupdate(sql, paras)){
				add="修改成功";
			}else{
				add="修改失败";
			}
			JOptionPane.showMessageDialog(this, add);
			this.dispose();
		}else if(e.getSource()==jb2){
			int a=JOptionPane.showConfirmDialog(this, "确定取消");
			if(a==0){
				this.dispose();
			}
		}
	}
}


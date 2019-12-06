/**
 * 人事管理表的界面
 */
package mhl.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import mhl.Model.*;
import mhl.Tools.MyTools;
public class Rsgl extends JPanel implements ActionListener{
	JTable jt=null;
	JLabel jl1,jl2;
	JTextField jtf=null;
	JPanel jp1,jp2,jp3,jp3_1,jp3_2;
	JButton jb1,jb2,jb3,jb4,jb5;
	RsglModel rm=null;
	JScrollPane jsp=null;
//	public static void main(String args[]){
//		Rsgl rm=new Rsgl();
//	}
	public Rsgl(){
		//北部
		jp1=new JPanel();
		jl1=new JLabel("请输入姓名（员工号或者职位）：");
		jl1.setFont(MyTools.font14);
		jp1.add(jl1);
		jtf=new JTextField(20);
		jp1.add(jtf);
		jb1=new JButton("查询");
		jb1.addActionListener(this);
		jb1.setFont(MyTools.font14);
		jp1.add(jb1);
		//中间
		jp2=new JPanel(new BorderLayout());
		String sql="select empid,empname,sex,address from rszl where 1=?";
		String[] paras={"1"};
		rm=new RsglModel();
		rm.inischaxu(sql, paras);
		jt=new JTable(rm);
		jsp=new JScrollPane(jt);
		jp2.add(jsp);
		
		//南部
		jp3=new JPanel(new BorderLayout());
		jp3_1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		int coutn=rm.getRowCount();
		jl2=new JLabel("总共有 "+coutn+" 条记录");
		jl2.setFont(MyTools.font14);
		jp3_1.add(jl2);
		jp3_2=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jb2=new JButton("详细信息");
		jb2.addActionListener(this);
		jb2.setFont(MyTools.font14);
		jp3_2.add(jb2);
		jb3=new JButton("添加");
		jb3.addActionListener(this);
		jb3.setFont(MyTools.font14);
		jp3_2.add(jb3);
		jb4=new JButton("修改");
		jb4.addActionListener(this);
		jb4.setFont(MyTools.font14);
		jp3_2.add(jb4);
		jb5=new JButton("删除");
		jb5.setEnabled(false);
		jb5.addActionListener(this);
		jb5.setFont(MyTools.font14);
		jp3_2.add(jb5);
		jp3.add(jp3_1,"West");
		jp3.add(jp3_2,"East");
		//设置为BorderLayout
		this.setLayout(new BorderLayout());
		//把组件添加到窗体
		this.add(jp1,"North");
		this.add(jp2,"Center");
		this.add(jp3,"South");
		//设置窗体
		this.setSize(500,400);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){
			if(jtf.getText().equals("")){
				String sql="select empid,empname,sex,address from rszl where 1=?";
				String[] paras={"1"};
				rm=new RsglModel();
				rm.inischaxu(sql, paras);
			}else{
				String name=jtf.getText().trim();
				String sql="select empid,empname,sex,address from rszl where empname=?";
				String[] paras={name};
				//更新数据模型
				rm=new RsglModel();
				rm.inischaxu(sql, paras);
			}
			//更新JTabel
			this.jt.setModel(rm);
		}else if(e.getSource()==jb3){
			
			Rsadd rsadd=new Rsadd(null, "添加信息", true);
		}else if(e.getSource()==jb5){
			int row=this.jt.getSelectedRow();
			String empid=(String)this.rm.getValueAt(row, 0);
			String sql="delete from rszl where empid=?";
			String[] paras={empid};
			rm=new RsglModel();
			rm.iniscud(sql, paras);
			//更新数据模型
			rm=new RsglModel();
			String sql1="select empid,empname,sex,address from rszl where 1=?";
			String[] paras1={"1"};
			rm.inischaxu(sql1, paras1);
			jt.setModel(rm);
		}
	}
}

package 学生管理系统1;
/**
 * 
 * @author 王荣华
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Test1 extends JFrame implements ActionListener {
	JPanel jp1,jp2;
	JTable jt=null;
	JButton jb1,jb2,jb3,jb4;
	JLabel jl=null;
	JTextField jtf=null;
	JScrollPane jsp=null;
	Sutmodel sutsql=null;
	//连接数据库
	Connection ct=null;
	PreparedStatement ps=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test1 test=new Test1();
	}
	//构造函数
	public Test1(){
		//北部
		jp1=new JPanel();
		jl=new JLabel("请输入姓名：");
		jtf=new JTextField(10);
		jb1=new JButton("查询");
		jb1.addActionListener(this);
		jp1.add(jl);
		jp1.add(jtf);
		jp1.add(jb1);
		//南部
		jp2=new JPanel();
		jb2=new JButton("添加");
		jb2.addActionListener(this);
		jb3=new JButton("修改");
		jb3.addActionListener(this);
		jb4=new JButton("删除");
		jb4.addActionListener(this);
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		//中间
		//创建数据模型对象
		sutsql=new Sutmodel();
		//初始化jt
		jt=new JTable(sutsql);
		jsp=new JScrollPane(jt);
		//添加到窗体
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.SOUTH);
		this.add(jsp);
		//设置窗体
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//查询信息
		if(e.getSource()==jb1){
			//读取用户输入的内容
			String name=this.jtf.getText().trim();
			String sql="";
			if(name.equals("")){
				sql="select * from pengyoubiao";
			}else{
				sql="select * from pengyoubiao where Pname='"+name+"'";
			}
			//创建新的数据模型，并更新
			sutsql=new Sutmodel(sql);
			//更新JTable
			jt.setModel(sutsql);
		//添加信息	
		}else if(e.getSource()==jb2){
			Sutadd scud=new Sutadd(this, "添加信息", true);
			//创建新的数据模型，并更新
			sutsql=new Sutmodel();
			//更新JTable
			jt.setModel(sutsql);
		}else if(e.getSource()==jb3){
			int row=this.jt.getSelectedRow();
			if(row==-1){
				JOptionPane.showMessageDialog(this, "请选择一行！");
			}else{
				sutsql=new Sutmodel();
				SutUpdate sup=new SutUpdate(this, "修改信息", true, sutsql, row);
				System.out.println(row);
				//创建新的数据模型，并更新
				sutsql=new Sutmodel();
				//更新JTable
				jt.setModel(sutsql);
			}
		}else if(e.getSource()==jb4){
			//删除数据
			//getSelectedRow会放回用户选择的行，没选择返回-1
			int rowname=this.jt.getSelectedRow();
			if(rowname==-1){
				//提示
				JOptionPane.showMessageDialog(this, "请选一行！");
			}else{
			//得到编号
				String sutid=sutsql.getValueAt(rowname, 0).toString();
				String sql="delete from pengyoubiao where PID=?";
				String paras[]={sutid};
				Sutmodel sm=new Sutmodel();
				String add="";
				if(sm.Sutupdate(sql, paras)){
					add="添加成功";
				}else{
					add="添加失败";
				}
				//提示对话框
				JOptionPane.showMessageDialog(this, add);
			}
			//创建新的数据模型，并更新
			sutsql=new Sutmodel();
			//更新JTable
			jt.setModel(sutsql);
		}
	}
}

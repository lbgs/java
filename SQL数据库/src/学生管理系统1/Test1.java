package ѧ������ϵͳ1;
/**
 * 
 * @author ���ٻ�
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
	//�������ݿ�
	Connection ct=null;
	PreparedStatement ps=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test1 test=new Test1();
	}
	//���캯��
	public Test1(){
		//����
		jp1=new JPanel();
		jl=new JLabel("������������");
		jtf=new JTextField(10);
		jb1=new JButton("��ѯ");
		jb1.addActionListener(this);
		jp1.add(jl);
		jp1.add(jtf);
		jp1.add(jb1);
		//�ϲ�
		jp2=new JPanel();
		jb2=new JButton("���");
		jb2.addActionListener(this);
		jb3=new JButton("�޸�");
		jb3.addActionListener(this);
		jb4=new JButton("ɾ��");
		jb4.addActionListener(this);
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		//�м�
		//��������ģ�Ͷ���
		sutsql=new Sutmodel();
		//��ʼ��jt
		jt=new JTable(sutsql);
		jsp=new JScrollPane(jt);
		//��ӵ�����
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.SOUTH);
		this.add(jsp);
		//���ô���
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//��ѯ��Ϣ
		if(e.getSource()==jb1){
			//��ȡ�û����������
			String name=this.jtf.getText().trim();
			String sql="";
			if(name.equals("")){
				sql="select * from pengyoubiao";
			}else{
				sql="select * from pengyoubiao where Pname='"+name+"'";
			}
			//�����µ�����ģ�ͣ�������
			sutsql=new Sutmodel(sql);
			//����JTable
			jt.setModel(sutsql);
		//�����Ϣ	
		}else if(e.getSource()==jb2){
			Sutadd scud=new Sutadd(this, "�����Ϣ", true);
			//�����µ�����ģ�ͣ�������
			sutsql=new Sutmodel();
			//����JTable
			jt.setModel(sutsql);
		}else if(e.getSource()==jb3){
			int row=this.jt.getSelectedRow();
			if(row==-1){
				JOptionPane.showMessageDialog(this, "��ѡ��һ�У�");
			}else{
				sutsql=new Sutmodel();
				SutUpdate sup=new SutUpdate(this, "�޸���Ϣ", true, sutsql, row);
				System.out.println(row);
				//�����µ�����ģ�ͣ�������
				sutsql=new Sutmodel();
				//����JTable
				jt.setModel(sutsql);
			}
		}else if(e.getSource()==jb4){
			//ɾ������
			//getSelectedRow��Ż��û�ѡ����У�ûѡ�񷵻�-1
			int rowname=this.jt.getSelectedRow();
			if(rowname==-1){
				//��ʾ
				JOptionPane.showMessageDialog(this, "��ѡһ�У�");
			}else{
			//�õ����
				String sutid=sutsql.getValueAt(rowname, 0).toString();
				String sql="delete from pengyoubiao where PID=?";
				String paras[]={sutid};
				Sutmodel sm=new Sutmodel();
				String add="";
				if(sm.Sutupdate(sql, paras)){
					add="��ӳɹ�";
				}else{
					add="���ʧ��";
				}
				//��ʾ�Ի���
				JOptionPane.showMessageDialog(this, add);
			}
			//�����µ�����ģ�ͣ�������
			sutsql=new Sutmodel();
			//����JTable
			jt.setModel(sutsql);
		}
	}
}

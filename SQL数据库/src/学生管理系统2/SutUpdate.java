package ѧ������ϵͳ2;
/**
 * 
 * @author ���ٻ�
 *	�޸�����
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
	//owner��this�ĸ�����
	//title��������
	//modal��ָ����ģʽ���ڣ����Ƿ�ģʽ����
	public SutUpdate(Frame owner,String title,boolean modal,Sutmodel sqlsut,int row){
		super(owner,title,modal);
		//�������
		jl1=new JLabel("���");
		jl2=new JLabel("����");
		jl3=new JLabel("�Ա�");
		jl4=new JLabel("����");
		
		jtf1=new JTextField(20);
		jtf1.setText(sqlsut.getValueAt(row, 0).toString());
		//��ֹ�û��޸�
		jtf1.setEditable(false);
		jtf2=new JTextField(20);
		jtf2.setText((String)sqlsut.getValueAt(row, 1));
		jtf3=new JTextField(20);
		jtf3.setText((String)sqlsut.getValueAt(row, 2));
		jtf4=new JTextField(20);
		jtf4.setText(sqlsut.getValueAt(row, 3).toString());
		
		jb1=new JButton("�޸�");
		jb1.addActionListener(this);
		jb2=new JButton("ȡ��");
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
		//������
		this.add(jp1,BorderLayout.CENTER);
		this.add(jp2,BorderLayout.SOUTH);
		//���ô���
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
				add="�޸ĳɹ�";
			}else{
				add="�޸�ʧ��";
			}
			JOptionPane.showMessageDialog(this, add);
			this.dispose();
		}else if(e.getSource()==jb2){
			int a=JOptionPane.showConfirmDialog(this, "ȷ��ȡ��");
			if(a==0){
				this.dispose();
			}
		}
	}
}


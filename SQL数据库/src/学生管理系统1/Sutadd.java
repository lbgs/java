package ѧ������ϵͳ1;
/**
 * 
 * @author ���ٻ�
 *	�������
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
	//owner��this�ĸ�����
	//title��������
	//modal��ָ����ģʽ���ڣ����Ƿ�ģʽ����
	public Sutadd(Frame owner,String title,boolean modal){
		super(owner,title,modal);
		//�������
		jl1=new JLabel("���");
		jl2=new JLabel("����");
		jl3=new JLabel("�Ա�");
		jl4=new JLabel("����");
		
		jtf1=new JTextField(20);
		jtf2=new JTextField(20);
		jtf3=new JTextField(20);
		jtf4=new JTextField(20);
		
		jb1=new JButton("���");
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
			String sql="insert into pengyoubiao values(?,?,?,?)";
			String[] paras={jtf1.getText(),jtf2.getText(),jtf3.getText(),jtf4.getText()};
			Sutmodel sm=new Sutmodel();
			String add="";
			if(sm.Sutupdate(sql, paras)){
				add="��ӳɹ�";
			}else{
				add="���ʧ��";
			}
			JOptionPane.showMessageDialog(this, add);
			this.dispose();
		}
	}
}

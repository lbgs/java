package com.mhl.view;
import java.awt.*;
import javax.swing.*;
import com.mhl.tools.*;
import com.mhl.model.*;
public class EmpInfo extends JPanel {
	JPanel jp1,jp2,jp3,jp4,jp5;
	JLabel p1_jl1,p3_jl1;
	JTextField p1_jtf1;
	JButton p1_jb1,p4_jb1,p4_jb2,p4_jb3,p4_jb4;
	JTable jt1;
	JScrollPane jsp1;
	String sql = "select empid Ա����,empname ����,sex �Ա�,zhiwei ְλ from rszl where 1=?";
	String[] paras = {"1"};
	public EmpInfo() {
		//����
		jp1 = new JPanel();
		p1_jl1 = new JLabel("������������Ա���Ż�����)");
		p1_jl1.setFont(ToolFont.f2);
		p1_jtf1 = new JTextField(20);
		p1_jtf1.setFont(ToolFont.f2);
		p1_jb1 = new JButton("��ѯ");
		jp1.add(p1_jl1);
		jp1.add(p1_jtf1);
		jp1.add(p1_jb1);
		
		//�в�JTable
		EmpModel em = new EmpModel();
		em.empQuery(sql, paras);
		jt1 = new JTable(em);
		jsp1 = new JScrollPane(jt1);
		jp2 = new JPanel(new BorderLayout());
		jp2.add(jsp1);
		
		//�²� jp3,jp4������jp5��
		jp3 = new JPanel();
		jp3.setLayout(new FlowLayout(FlowLayout.LEFT));
		p3_jl1 = new JLabel("          �ܼ�¼����***��");
		p3_jl1.setFont(ToolFont.f2);
		jp3.add(p3_jl1);
		jp4 = new JPanel();
		jp4.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p4_jb1 = new JButton("��ϸ��Ϣ");
		p4_jb1.setFont(ToolFont.f2);
		p4_jb2 = new JButton("���");
		p4_jb2.setFont(ToolFont.f2);
		p4_jb3 = new JButton("�޸�");
		p4_jb3.setFont(ToolFont.f2);
		p4_jb4 = new JButton("ɾ��");
		p4_jb4.setFont(ToolFont.f2);
		jp4.add(p4_jb1);
		jp4.add(p4_jb2);
		jp4.add(p4_jb3);
		jp4.add(p4_jb4);
		jp5 = new JPanel(new BorderLayout());
		jp5.add(jp3,"West");
		jp5.add(jp4,"East");
		
		this.setLayout(new BorderLayout());
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp5,BorderLayout.SOUTH);
		this.setVisible(true);
	}
}

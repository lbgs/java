package com.����ϵͳ;
/**
 * 
 * @author ���ߣ����ٻ�
 * @date ���ڣ�2017��7��26������11:17:36
 * ���ܣ�QQ���칦��
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
		//��������
		jta=new JTextArea();
		jcp=new JScrollPane(jta);
		jp=new JPanel();
		String as[]={"ľ��","С��","����","����"};
		jcb=new JComboBox(as);
		jtf=new JTextField(10);
		jb=new JButton("����");
		//���ֹ���
		//���
		jp.add(jcb);
		jp.add(jtf);
		jp.add(jb);
		//������
		this.add(jcp);
		this.add(jp,BorderLayout.SOUTH);
		//���ô���
		this.setTitle("QQ����");
		this.setIconImage((new ImageIcon("image/mm.jpg")).getImage());
		this.setSize(300,200);
		this.setLocation(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}

}

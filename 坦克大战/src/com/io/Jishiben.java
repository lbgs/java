package com.io;
/**
 * 
 * @author ���ٻ�
 * ���ܣ����±����Դ򿪡����棡
 */
import java.io.*;
import java.awt.*;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Jishiben extends JFrame implements ActionListener{
    //������
	JTextArea jta=null;
	//�˵���
	JMenuBar jmb=null;
	//�˵�
	JMenu jm=null;
	//�ֲ˵�
	JMenuItem jmt1,jmt2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jishiben jsb=new Jishiben();
	}
	public Jishiben(){
		//�������
		jta=new JTextArea();
		jmb=new JMenuBar();
		jm=new JMenu("�ļ�");
		jmt1=new JMenuItem("��");
		jmt2=new JMenuItem("����");
		//ע�����
		jmt1.addActionListener(this);
		jmt1.setActionCommand("��");
		jmt2.addActionListener(this);
		jmt2.setActionCommand("����");
		//��Ӳ˵�
		jmb.add(jm);
		//����Ӳ˵�
		jm.add(jmt1);
		jm.add(jmt2);
		//��������JFrame
		this.setJMenuBar(jmb);
		this.add(jta);
		//��������
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("��")){
			//�ļ�ѡ�����
			JFileChooser jfc=new JFileChooser();
			//���ñ���
			jfc.setDialogTitle("��ѡ���ļ�......");
			//Ĭ�Ϸ�ʽ
			jfc.showOpenDialog(null);
			//��ʾ����
			jfc.setVisible(true);
			//�û�ѡ��ľ���·��
			String dakai=jfc.getSelectedFile().getAbsolutePath();
			//
			FileReader fr=null;
			BufferedReader br=null;
			try {
				fr=new FileReader(dakai);
				br=new BufferedReader(fr);
				String s="";
				String sun="";//��β������
				//��ȡ�ļ�
				while((s=br.readLine())!=null){
					//��ȡ���ļ���ʾ��jta
					sun+=s+"\r\n";
				}
				jta.setText(sun);
			} catch (Exception e2) {
				// TODO: handle exception
			}finally{
				try {
					fr.close();
					br.close();
				} catch (Exception e3) {
					// TODO: handle exception
					e3.printStackTrace();
				}
			}
		}else if(e.getActionCommand().equals("����")){
			//�ļ�ѡ�����
			JFileChooser jfc=new JFileChooser();
			//��������
			jfc.setDialogTitle("���Ϊ......");
			//Ĭ�Ϸ�ʽ
			jfc.showSaveDialog(null);
			//��ʾ����
			jfc.setVisible(true);
			//�õ��û�ѡ���ȫ·��
			String save=jfc.getSelectedFile().getAbsolutePath();
			//д�뵽ָ���ļ�
			FileWriter fw=null;
			BufferedWriter bw=null;
			try {
				fw=new FileWriter(save);
				bw=new BufferedWriter(fw);
				int s=0;
				bw.write(this.jta.getText());
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}finally{
				try {
					fw.close();
					bw.close();
				} catch (Exception e3) {
					// TODO: handle exception
					e3.printStackTrace();
				}
			}
		}
	}

}

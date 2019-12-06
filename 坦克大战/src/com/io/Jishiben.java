package com.io;
/**
 * 
 * @author 王荣华
 * 功能：记事本可以打开、保存！
 */
import java.io.*;
import java.awt.*;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Jishiben extends JFrame implements ActionListener{
    //添加组件
	JTextArea jta=null;
	//菜单条
	JMenuBar jmb=null;
	//菜单
	JMenu jm=null;
	//字菜单
	JMenuItem jmt1,jmt2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jishiben jsb=new Jishiben();
	}
	public Jishiben(){
		//创建组件
		jta=new JTextArea();
		jmb=new JMenuBar();
		jm=new JMenu("文件");
		jmt1=new JMenuItem("打开");
		jmt2=new JMenuItem("保存");
		//注册监听
		jmt1.addActionListener(this);
		jmt1.setActionCommand("打开");
		jmt2.addActionListener(this);
		jmt2.setActionCommand("保存");
		//添加菜单
		jmb.add(jm);
		//添加子菜单
		jm.add(jmt1);
		jm.add(jmt2);
		//添加组件到JFrame
		this.setJMenuBar(jmb);
		this.add(jta);
		//窗体设置
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("打开")){
			//文件选择组件
			JFileChooser jfc=new JFileChooser();
			//设置标题
			jfc.setDialogTitle("请选择文件......");
			//默认方式
			jfc.showOpenDialog(null);
			//显示窗体
			jfc.setVisible(true);
			//用户选择的绝对路径
			String dakai=jfc.getSelectedFile().getAbsolutePath();
			//
			FileReader fr=null;
			BufferedReader br=null;
			try {
				fr=new FileReader(dakai);
				br=new BufferedReader(fr);
				String s="";
				String sun="";//到尾流换行
				//读取文件
				while((s=br.readLine())!=null){
					//读取的文件显示到jta
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
		}else if(e.getActionCommand().equals("保存")){
			//文件选择组件
			JFileChooser jfc=new JFileChooser();
			//窗体名称
			jfc.setDialogTitle("另存为......");
			//默认方式
			jfc.showSaveDialog(null);
			//显示窗体
			jfc.setVisible(true);
			//得到用户选择的全路径
			String save=jfc.getSelectedFile().getAbsolutePath();
			//写入到指定文件
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

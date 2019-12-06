package com.作业;
/**
 * 
 * @author 作者：王荣华
 * @date 日期：2017年7月27日下午2:36:49
 * 功能：记事本
 */
import java.awt.*;
import javax.swing.*;
public class Jishiben extends JFrame {
    JTextArea jta=null;
    //菜单组件
    JMenuBar cd=null;
    JMenu me[]=null;
    JMenuItem mi[]=null;
    //二级菜单
    JMenu erji=null;
    JMenuItem jm1,jm2;
    //工具栏
    JToolBar gj=null;
    JButton jb[]=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jishiben ji=new Jishiben();
	}
	public Jishiben(){
		me=new JMenu[5];
		mi=new JMenuItem[7];
		jb=new JButton[5];
		//创建组件
		jta=new JTextArea();//中部
		//菜单栏
		me[0]=new JMenu("文件(F)");
		me[0].setMnemonic('F');
		me[1]=new JMenu("编辑(E)");
		me[1].setMnemonic('E');
		me[2]=new JMenu("格式(O)");
		me[2].setMnemonic('O');
		me[3]=new JMenu("查看(V)");
		me[3].setMnemonic('V');
		me[4]=new JMenu("帮助(H)");
		me[4].setMnemonic('H');
		//一级菜单
		erji=new JMenu("新建");
		mi[1]=new JMenuItem("打开");
		mi[2]=new JMenuItem("保存(S)");
		mi[2].setMnemonic('S');
		mi[3]=new JMenuItem("另存为");
		mi[4]=new JMenuItem("页面设置");
		mi[5]=new JMenuItem("打印");
		mi[6]=new JMenuItem("退出");
		//
		jm1=new JMenuItem("文件");
		jm2=new JMenuItem("工程");
		//添加菜单
		cd=new JMenuBar();
		cd.add(me[0]);
		cd.add(me[1]);
		cd.add(me[2]);
		cd.add(me[3]);
		cd.add(me[4]);
		//添加一级菜单
		me[0].add(erji);
		me[0].add(mi[1]);
		me[0].add(mi[2]);
		me[0].add(mi[3]);
		me[0].addSeparator();
		me[0].add(mi[4]);
		me[0].add(mi[5]);
		me[0].addSeparator();
		me[0].add(mi[6]);
		//添加二级菜单
		erji.add(jm1);
		erji.add(jm2);
		//工具栏
		jb[0]=new JButton("新建");
		jb[0].setToolTipText("新建");
		jb[1]=new JButton("打开");
		jb[1].setToolTipText("打开");
		jb[2]=new JButton("保存");
		jb[2].setToolTipText("保存");
		jb[3]=new JButton("aa");
		jb[3].setToolTipText("aa");
		jb[4]=new JButton("剪切");
		jb[4].setToolTipText("剪切");
		//添加工具栏
		gj=new JToolBar();
		gj.add(jb[0]);
		gj.add(jb[1]);
		gj.add(jb[2]);
		gj.add(jb[3]);
		gj.add(jb[4]);
		
		//添加组件
		this.add(cd);
		this.add(gj,BorderLayout.NORTH);
		this.add(jta);
		//将菜单添加到窗体上
		this.setJMenuBar(cd);
		//设置窗体
		this.setTitle("记事本");
		this.setSize(400,300);
		this.setLocation(400,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

/**
 * 管理员界面
 */
package mhl.view;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import mhl.Tools.*;
import java.io.*;
import java.util.Calendar;
public class Windows1 extends JFrame implements ActionListener,MouseListener{
	//图片
	Image login,zhuangtailan,p1_bj,p2_bj;
	//背景图片
	ImagePanel imgp;
	//菜单栏
	JMenuBar jmb=null;
	//一级菜单
	JMenu jm1,jm2,jm3,jm4,jm5,jm6;
	//二级菜单
	JMenuItem jmi[]=null;
	//工具栏
	JToolBar jtool=null;
	//工具栏按钮
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10;
	//定义五个JPanel
	JPanel p1, p2, p2_1, p2_2, p3;
	//p1的label
	JLabel p1_lab1,p1_lab2,p1_lab3,p1_lab4,p1_lab5,p1_lab6,p1_lab7,p1_lab8;
	//p2_1
	JLabel p2_1_lab1,p2_1_lab2;
	//卡片布局
	CardLayout cl=null;
	//拆分窗口
	JSplitPane jsp=null;
	//鼠标光标
	Cursor mouse=null;
	//状态栏
	JLabel jtimeNew;
	//定时器触发事件Action
	Timer time=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Windows1 windows=new Windows1();
	}
	//初始化菜单栏
	public void inisMenu(){
		//菜单栏
		jmb=new JMenuBar();
		//定义二级菜单数量
		jmi=new JMenuItem[12];			
		//创建一级菜单
		jm1=new JMenu("系统管理");
		jm1.setFont(MyTools.font16);
		jmb.add(jm1);
		//创建二级菜单
		jmi[0]=new JMenuItem("切换用户",new ImageIcon("image/qhyh.jpg"));
		jmi[0].setFont(MyTools.font14);
		jm1.add(jmi[0]);
		jmi[1]=new JMenuItem("切换到收款界面",new ImageIcon("image/qhsy.jpg"));
		jmi[1].setFont(MyTools.font14);
		jm1.add(jmi[1]);
		jmi[2]=new JMenuItem("登陆管理",new ImageIcon("image/login.jpg"));
		jmi[2].setFont(MyTools.font14);
		jm1.add(jmi[2]);
		jmi[3]=new JMenuItem("万年历",new ImageIcon("image/wnl.jpg"));
		jmi[3].setFont(MyTools.font14);
		jm1.add(jmi[3]);
		jmi[4]=new JMenuItem("退出",new ImageIcon("image/exit.jpg"));
		jmi[4].setFont(MyTools.font14);
		jm1.add(jmi[4]);
		//一级菜单
		jm2=new JMenu("人事管理");
		jm2.setFont(MyTools.font16);
		jmb.add(jm2);
		jmi[5]=new JMenuItem("人事管理",new ImageIcon("image/p1_rsgl.jpg"));
		jmi[5].setFont(MyTools.font14);
		jm2.add(jmi[5]);
		
		jm3=new JMenu("菜单服务");
		jm3.setFont(MyTools.font16);
		jmb.add(jm3);
		jmi[6]=new JMenuItem("菜谱价格",new ImageIcon("image/p1_cpjg.jpg"));
		jmi[6].setFont(MyTools.font14);
		jm3.add(jmi[6]);
		
		jm4=new JMenu("报表统计");
		jm4.setFont(MyTools.font16);
		jmb.add(jm4);
		jmi[7]=new JMenuItem("报表统计",new ImageIcon("image/p1_bbtj.jpg"));
		jmi[7].setFont(MyTools.font14);
		jm4.add(jmi[7]);
		
		jm5=new JMenu("成本及库房");
		jm5.setFont(MyTools.font16);
		jmb.add(jm5);
		jmi[8]=new JMenuItem("成本及库房",new ImageIcon("image/p1_cb.jpg"));
		jmi[8].setFont(MyTools.font14);
		jm5.add(jmi[8]);
		
		jm6=new JMenu("帮助");
		jm6.setFont(MyTools.font16);
		jmb.add(jm6);
		jmi[9]=new JMenuItem("动画帮助",new ImageIcon("image/p1_dhbz.jpg"));
		jmi[9].setFont(MyTools.font14);
		jm6.add(jmi[9]);
		//JMenuBar添加到JFrame
		this.setJMenuBar(jmb);	
	}
	//初始化工具栏
	public void inisToolBar(){
		//工具栏
		jtool=new JToolBar();
		//不可以浮动
		jtool.setFloatable(false);
		jb1=new JButton(new ImageIcon("image/jt1.jpg"));
		jb1.setToolTipText("切换到收款界面");
		jb2=new JButton(new ImageIcon("image/jt2.jpg"));
		jb2.setToolTipText("切换用户");
		jb3=new JButton(new ImageIcon("image/jt3.jpg"));
		jb3.setToolTipText("登陆管理");
		jb4=new JButton(new ImageIcon("image/jt4.jpg"));
		jb4.setToolTipText("人事管理");
		jb5=new JButton(new ImageIcon("image/jt5.jpg"));
		jb5.setToolTipText("报表统计");
		jb6=new JButton(new ImageIcon("image/jt6.jpg"));
		jb6.setToolTipText("菜谱价格");
		jb7=new JButton(new ImageIcon("image/jt7.jpg"));
		jb7.setToolTipText("成本及库房");
		jb8=new JButton(new ImageIcon("image/jt8.jpg"));
		jb8.setToolTipText("");
		jb9=new JButton(new ImageIcon("image/jt9.jpg"));
		jb9.setToolTipText("动画帮助");
		jb10=new JButton(new ImageIcon("image/jt10.jpg"));
		jb10.setToolTipText("退出系统");
		jtool.add(jb1);
		jtool.add(jb2);
		jtool.add(jb3);
		jtool.add(jb4);
		jtool.add(jb5);
		jtool.add(jb6);
		jtool.add(jb7);
		jtool.add(jb8);
		jtool.add(jb9);
		jtool.add(jb10);			
	}
	//中间JPanel
	public void inisAllPanels(){
		//初始化鼠标光标为手状类型
		mouse=new Cursor(Cursor.HAND_CURSOR);
		p1=new JPanel(new BorderLayout());
		//背景图
		try {
			p1_bj=ImageIO.read(new File("image/p1.jpg"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		imgp=new ImagePanel(p1_bj);
		imgp.setLayout(new GridLayout(8,1));
		p1.add(imgp);
		p1_lab1=new JLabel(new ImageIcon("image/p1_mhl.jpg"),0);
		imgp.add(p1_lab1);
		p1_lab2=new JLabel("人 事 管 理",new ImageIcon("image/p1_rsgl.jpg"),0);
		p1_lab2.setFont(MyTools.font14);
		p1_lab2.addMouseListener(this);
		p1_lab2.setEnabled(false);
		p1_lab2.setCursor(mouse);
		imgp.add(p1_lab2);
		p1_lab3=new JLabel("登 陆 管 理",new ImageIcon("image/p1_dlgl.jpg"),0);
		p1_lab3.setFont(MyTools.font14);
		p1_lab3.addMouseListener(this);
		p1_lab3.setEnabled(false);
		p1_lab3.setCursor(mouse);
		imgp.add(p1_lab3);
		p1_lab4=new JLabel("菜 谱 价 格",new ImageIcon("image/p1_cpjg.jpg"),0);
		p1_lab4.setFont(MyTools.font14);
		p1_lab4.addMouseListener(this);
		p1_lab4.setEnabled(false);
		p1_lab4.setCursor(mouse);
		imgp.add(p1_lab4);
		p1_lab5=new JLabel("报 表 统 计",new ImageIcon("image/p1_bbtj.jpg"),0);
		p1_lab5.setFont(MyTools.font14);
		p1_lab5.addMouseListener(this);
		p1_lab5.setEnabled(false);
		p1_lab5.setCursor(mouse);
		imgp.add(p1_lab5);
		p1_lab6=new JLabel("成本及库房",new ImageIcon("image/p1_cb.jpg"),0);
		p1_lab6.setFont(MyTools.font14);
		p1_lab6.addMouseListener(this);
		p1_lab6.setEnabled(false);
		p1_lab6.setCursor(mouse);
		imgp.add(p1_lab6);
		p1_lab7=new JLabel("系 统 设 置",new ImageIcon("image/p1_xtsz.jpg"),0);
		p1_lab7.setFont(MyTools.font14);
		p1_lab7.addMouseListener(this);
		p1_lab7.setEnabled(false);
		p1_lab7.setCursor(mouse);
		imgp.add(p1_lab7);
		p1_lab8=new JLabel("动 画 帮 助",new ImageIcon("image/p1_dhbz.jpg"),0);
		p1_lab8.setFont(MyTools.font14);
		p1_lab8.addMouseListener(this);
		p1_lab8.setEnabled(false);
		p1_lab8.setCursor(mouse);
		imgp.add(p1_lab8);
		//处理p2
		p2=new JPanel(new BorderLayout());
		p2_1=new JPanel(cl);
		p2_1_lab1=new JLabel(new ImageIcon("image/p2_zuo.jpg"));
		p2_1_lab2=new JLabel(new ImageIcon("image/p2_you.jpg"));
		p2_1.add(p2_1_lab1,"左");
		p2_1.add(p2_1_lab2,"右");
		p2_2=new JPanel(cl);
		try {
			p2_bj=ImageIO.read(new File("image/p3_bj.jpg"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
//		JLabel rs=new JLabel(new ImageIcon("image/rsgl.jpg"));
		Rsgl rs=new Rsgl();
		
		JLabel dl=new JLabel(new ImageIcon("image/dlgl.jpg"));
		imgp=new ImagePanel(p2_bj);
		p2_2.add(imgp,"bj");
		p2_2.add(rs,"rsgl");
		p2_2.add(dl,"dlgl");
		p2.add(p2_1,"West");
		p2.add(p2_2,"Center");
		//拆分窗口，把p1和p2放进去
		jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,p1,p2);
		//知道左边面板占多大
		jsp.setDividerLocation(150);
		//把边界线设置为0
		jsp.setDividerSize(0);
	}
	public void inisStatusBar(){
		//状态栏
		p3=new JPanel(new BorderLayout());
		time=new Timer(1000, this);
		time.start();
		jtimeNew=new JLabel("当前时间："+Calendar.getInstance().getTime().toLocaleString()+"   ");
		jtimeNew.setFont(MyTools.font14);
		//背景图片
		try {
			zhuangtailan=ImageIO.read(new File("image/bj.jpg"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		imgp=new ImagePanel(zhuangtailan);
		imgp.setLayout(new BorderLayout());
		imgp.add(jtimeNew,"East");		
	}
	public Windows1(){
		//初始化卡片布局
		cl=new CardLayout();
		//调用菜单函数
		this.inisMenu();
		//调用工具栏函数
		this.inisToolBar();
		//调用状态栏函数
		this.inisStatusBar();
		//中间
		this.inisAllPanels();
		//把面板放进容器
		Container ct=this.getContentPane();
		ct.add(jtool,"North");
		ct.add(jsp,"Center");
		ct.add(p3,"South");
		//设置窗体
		try {
			login=ImageIO.read((new File("image/jb.jpg")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setIconImage(login);
		this.setTitle("满汉楼餐饮管理系统");
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(width,height-27);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.jtimeNew.setText("当前时间："+Calendar.getInstance().getTime().toLocaleString()+"   ");
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.p1_lab2){
			this.cl.show(p2_2, "rsgl");
		}else if(e.getSource()==this.p1_lab3){
			this.cl.show(p2_2,"dlgl");
		}else if(e.getSource()==this.p1_lab4){
			
		}else if(e.getSource()==this.p1_lab5){
			
		}else if(e.getSource()==this.p1_lab6){
			
		}else if(e.getSource()==this.p1_lab7){
			
		}else if(e.getSource()==this.p1_lab8){
			
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.p1_lab2){
			p1_lab2.setEnabled(true);
		}else if(e.getSource()==this.p1_lab3){
			p1_lab3.setEnabled(true);
		}else if(e.getSource()==this.p1_lab4){
			p1_lab4.setEnabled(true);
		}else if(e.getSource()==this.p1_lab5){
			p1_lab5.setEnabled(true);
		}else if(e.getSource()==this.p1_lab6){
			p1_lab6.setEnabled(true);
		}else if(e.getSource()==this.p1_lab7){
			p1_lab7.setEnabled(true);
		}else if(e.getSource()==this.p1_lab8){
			p1_lab8.setEnabled(true);
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.p1_lab2){
			p1_lab2.setEnabled(false);
		}else if(e.getSource()==this.p1_lab3){
			p1_lab3.setEnabled(false);
		}else if(e.getSource()==this.p1_lab4){
			p1_lab4.setEnabled(false);
		}else if(e.getSource()==this.p1_lab5){
			p1_lab5.setEnabled(false);
		}else if(e.getSource()==this.p1_lab6){
			p1_lab6.setEnabled(false);
		}else if(e.getSource()==this.p1_lab7){
			p1_lab7.setEnabled(false);
		}else if(e.getSource()==this.p1_lab8){
			p1_lab8.setEnabled(false);
		}
	}

}

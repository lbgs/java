/**
 * ����Ա����
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
	//ͼƬ
	Image login,zhuangtailan,p1_bj,p2_bj;
	//����ͼƬ
	ImagePanel imgp;
	//�˵���
	JMenuBar jmb=null;
	//һ���˵�
	JMenu jm1,jm2,jm3,jm4,jm5,jm6;
	//�����˵�
	JMenuItem jmi[]=null;
	//������
	JToolBar jtool=null;
	//��������ť
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10;
	//�������JPanel
	JPanel p1, p2, p2_1, p2_2, p3;
	//p1��label
	JLabel p1_lab1,p1_lab2,p1_lab3,p1_lab4,p1_lab5,p1_lab6,p1_lab7,p1_lab8;
	//p2_1
	JLabel p2_1_lab1,p2_1_lab2;
	//��Ƭ����
	CardLayout cl=null;
	//��ִ���
	JSplitPane jsp=null;
	//�����
	Cursor mouse=null;
	//״̬��
	JLabel jtimeNew;
	//��ʱ�������¼�Action
	Timer time=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Windows1 windows=new Windows1();
	}
	//��ʼ���˵���
	public void inisMenu(){
		//�˵���
		jmb=new JMenuBar();
		//��������˵�����
		jmi=new JMenuItem[12];			
		//����һ���˵�
		jm1=new JMenu("ϵͳ����");
		jm1.setFont(MyTools.font16);
		jmb.add(jm1);
		//���������˵�
		jmi[0]=new JMenuItem("�л��û�",new ImageIcon("image/qhyh.jpg"));
		jmi[0].setFont(MyTools.font14);
		jm1.add(jmi[0]);
		jmi[1]=new JMenuItem("�л����տ����",new ImageIcon("image/qhsy.jpg"));
		jmi[1].setFont(MyTools.font14);
		jm1.add(jmi[1]);
		jmi[2]=new JMenuItem("��½����",new ImageIcon("image/login.jpg"));
		jmi[2].setFont(MyTools.font14);
		jm1.add(jmi[2]);
		jmi[3]=new JMenuItem("������",new ImageIcon("image/wnl.jpg"));
		jmi[3].setFont(MyTools.font14);
		jm1.add(jmi[3]);
		jmi[4]=new JMenuItem("�˳�",new ImageIcon("image/exit.jpg"));
		jmi[4].setFont(MyTools.font14);
		jm1.add(jmi[4]);
		//һ���˵�
		jm2=new JMenu("���¹���");
		jm2.setFont(MyTools.font16);
		jmb.add(jm2);
		jmi[5]=new JMenuItem("���¹���",new ImageIcon("image/p1_rsgl.jpg"));
		jmi[5].setFont(MyTools.font14);
		jm2.add(jmi[5]);
		
		jm3=new JMenu("�˵�����");
		jm3.setFont(MyTools.font16);
		jmb.add(jm3);
		jmi[6]=new JMenuItem("���׼۸�",new ImageIcon("image/p1_cpjg.jpg"));
		jmi[6].setFont(MyTools.font14);
		jm3.add(jmi[6]);
		
		jm4=new JMenu("����ͳ��");
		jm4.setFont(MyTools.font16);
		jmb.add(jm4);
		jmi[7]=new JMenuItem("����ͳ��",new ImageIcon("image/p1_bbtj.jpg"));
		jmi[7].setFont(MyTools.font14);
		jm4.add(jmi[7]);
		
		jm5=new JMenu("�ɱ����ⷿ");
		jm5.setFont(MyTools.font16);
		jmb.add(jm5);
		jmi[8]=new JMenuItem("�ɱ����ⷿ",new ImageIcon("image/p1_cb.jpg"));
		jmi[8].setFont(MyTools.font14);
		jm5.add(jmi[8]);
		
		jm6=new JMenu("����");
		jm6.setFont(MyTools.font16);
		jmb.add(jm6);
		jmi[9]=new JMenuItem("��������",new ImageIcon("image/p1_dhbz.jpg"));
		jmi[9].setFont(MyTools.font14);
		jm6.add(jmi[9]);
		//JMenuBar��ӵ�JFrame
		this.setJMenuBar(jmb);	
	}
	//��ʼ��������
	public void inisToolBar(){
		//������
		jtool=new JToolBar();
		//�����Ը���
		jtool.setFloatable(false);
		jb1=new JButton(new ImageIcon("image/jt1.jpg"));
		jb1.setToolTipText("�л����տ����");
		jb2=new JButton(new ImageIcon("image/jt2.jpg"));
		jb2.setToolTipText("�л��û�");
		jb3=new JButton(new ImageIcon("image/jt3.jpg"));
		jb3.setToolTipText("��½����");
		jb4=new JButton(new ImageIcon("image/jt4.jpg"));
		jb4.setToolTipText("���¹���");
		jb5=new JButton(new ImageIcon("image/jt5.jpg"));
		jb5.setToolTipText("����ͳ��");
		jb6=new JButton(new ImageIcon("image/jt6.jpg"));
		jb6.setToolTipText("���׼۸�");
		jb7=new JButton(new ImageIcon("image/jt7.jpg"));
		jb7.setToolTipText("�ɱ����ⷿ");
		jb8=new JButton(new ImageIcon("image/jt8.jpg"));
		jb8.setToolTipText("");
		jb9=new JButton(new ImageIcon("image/jt9.jpg"));
		jb9.setToolTipText("��������");
		jb10=new JButton(new ImageIcon("image/jt10.jpg"));
		jb10.setToolTipText("�˳�ϵͳ");
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
	//�м�JPanel
	public void inisAllPanels(){
		//��ʼ�������Ϊ��״����
		mouse=new Cursor(Cursor.HAND_CURSOR);
		p1=new JPanel(new BorderLayout());
		//����ͼ
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
		p1_lab2=new JLabel("�� �� �� ��",new ImageIcon("image/p1_rsgl.jpg"),0);
		p1_lab2.setFont(MyTools.font14);
		p1_lab2.addMouseListener(this);
		p1_lab2.setEnabled(false);
		p1_lab2.setCursor(mouse);
		imgp.add(p1_lab2);
		p1_lab3=new JLabel("�� ½ �� ��",new ImageIcon("image/p1_dlgl.jpg"),0);
		p1_lab3.setFont(MyTools.font14);
		p1_lab3.addMouseListener(this);
		p1_lab3.setEnabled(false);
		p1_lab3.setCursor(mouse);
		imgp.add(p1_lab3);
		p1_lab4=new JLabel("�� �� �� ��",new ImageIcon("image/p1_cpjg.jpg"),0);
		p1_lab4.setFont(MyTools.font14);
		p1_lab4.addMouseListener(this);
		p1_lab4.setEnabled(false);
		p1_lab4.setCursor(mouse);
		imgp.add(p1_lab4);
		p1_lab5=new JLabel("�� �� ͳ ��",new ImageIcon("image/p1_bbtj.jpg"),0);
		p1_lab5.setFont(MyTools.font14);
		p1_lab5.addMouseListener(this);
		p1_lab5.setEnabled(false);
		p1_lab5.setCursor(mouse);
		imgp.add(p1_lab5);
		p1_lab6=new JLabel("�ɱ����ⷿ",new ImageIcon("image/p1_cb.jpg"),0);
		p1_lab6.setFont(MyTools.font14);
		p1_lab6.addMouseListener(this);
		p1_lab6.setEnabled(false);
		p1_lab6.setCursor(mouse);
		imgp.add(p1_lab6);
		p1_lab7=new JLabel("ϵ ͳ �� ��",new ImageIcon("image/p1_xtsz.jpg"),0);
		p1_lab7.setFont(MyTools.font14);
		p1_lab7.addMouseListener(this);
		p1_lab7.setEnabled(false);
		p1_lab7.setCursor(mouse);
		imgp.add(p1_lab7);
		p1_lab8=new JLabel("�� �� �� ��",new ImageIcon("image/p1_dhbz.jpg"),0);
		p1_lab8.setFont(MyTools.font14);
		p1_lab8.addMouseListener(this);
		p1_lab8.setEnabled(false);
		p1_lab8.setCursor(mouse);
		imgp.add(p1_lab8);
		//����p2
		p2=new JPanel(new BorderLayout());
		p2_1=new JPanel(cl);
		p2_1_lab1=new JLabel(new ImageIcon("image/p2_zuo.jpg"));
		p2_1_lab2=new JLabel(new ImageIcon("image/p2_you.jpg"));
		p2_1.add(p2_1_lab1,"��");
		p2_1.add(p2_1_lab2,"��");
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
		//��ִ��ڣ���p1��p2�Ž�ȥ
		jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,p1,p2);
		//֪��������ռ���
		jsp.setDividerLocation(150);
		//�ѱ߽�������Ϊ0
		jsp.setDividerSize(0);
	}
	public void inisStatusBar(){
		//״̬��
		p3=new JPanel(new BorderLayout());
		time=new Timer(1000, this);
		time.start();
		jtimeNew=new JLabel("��ǰʱ�䣺"+Calendar.getInstance().getTime().toLocaleString()+"   ");
		jtimeNew.setFont(MyTools.font14);
		//����ͼƬ
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
		//��ʼ����Ƭ����
		cl=new CardLayout();
		//���ò˵�����
		this.inisMenu();
		//���ù���������
		this.inisToolBar();
		//����״̬������
		this.inisStatusBar();
		//�м�
		this.inisAllPanels();
		//�����Ž�����
		Container ct=this.getContentPane();
		ct.add(jtool,"North");
		ct.add(jsp,"Center");
		ct.add(p3,"South");
		//���ô���
		try {
			login=ImageIO.read((new File("image/jb.jpg")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setIconImage(login);
		this.setTitle("����¥��������ϵͳ");
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(width,height-27);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.jtimeNew.setText("��ǰʱ�䣺"+Calendar.getInstance().getTime().toLocaleString()+"   ");
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

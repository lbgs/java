package com.mhl.view;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.util.*;
import com.mhl.tools.*;

public class Windows1 extends JFrame implements ActionListener,MouseListener {
	JMenuBar jmb;
	JMenu jm1,jm2,jm3,jm4,jm5,jm6;
	JMenuItem jm11,jm12,jm13,jm14,jm15;
	JToolBar jtb1;
	JButton jbt1,jbt2,jbt3,jbt4,jbt5,jbt6,jbt7,jbt8,jbt9,jbt10;
	
	JPanel jp1,jp2,jp3,jp4,jp5;
	//showtime
	JLabel showtime;
	Timer t;//javax.swing.Timer
	Image showtime2;
	//JP1 p1_label�м䲿��
	Image p1image;
	JLabel p1_label1,p1_label2,p1_label3,p1_label4,p1_label5,p1_label6,p1_label7,p1_label8;
	//JP2,
	JLabel p2_zuo,p2_you;
	//Image p2image;
	//JP3
	Image p3image; 
	ToolImage p3_image;
	CardLayout p3card;
	//JSplitPane��P1��P4����JSplitPane��
	JSplitPane jsp1;
	//����
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Windows1();
	}
	
	public Windows1() {
		Container ct = this.getContentPane();
		
		
		jmb = new JMenuBar();
		
		jm1 = new JMenu("ϵͳ����");
		jm1.setFont(ToolFont.f1);
		jm11 = new JMenuItem("�л��û�");
		jm11.setFont(ToolFont.f2);
		jm11.setIcon(new ImageIcon("image/qhyh.jpg"));
		jm12 = new JMenuItem("�л����տ����");
		jm12.setFont(ToolFont.f2);
		jm12.setIcon(new ImageIcon("image/qhsy.jpg"));
		jm13 = new JMenuItem("��½����");
		jm13.setFont(ToolFont.f2);
		jm13.setIcon(new ImageIcon("image/login.jpg"));
		jm14 = new JMenuItem("������");
		jm14.setFont(ToolFont.f2);
		jm14.setIcon(new ImageIcon("image/wnl.jpg"));
		jm15 = new JMenuItem("�˳�");
		jm15.setFont(ToolFont.f2);
		jm15.setIcon(new ImageIcon("image/exit.jpg"));
		jm1.add(jm11);
		jm1.add(jm12);
		jm1.add(jm13);
		jm1.add(jm14);
		jm1.add(jm15);
		
		
		jm2 = new JMenu("���¹���");
		jm2.setFont(ToolFont.f1);
		jm3 = new JMenu("�˵�����");
		jm3.setFont(ToolFont.f1);
		jm4 = new JMenu("����ͳ��");
		jm4.setFont(ToolFont.f1);
		jm5 = new JMenu("�ɱ����ⷿ");
		jm5.setFont(ToolFont.f1);
		jm6 = new JMenu("����");
		jm6.setFont(ToolFont.f1);
		
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmb.add(jm5);
		jmb.add(jm6);
		
		jtb1 = new JToolBar();
		jtb1.setFloatable(false);
		jbt1 = new JButton(new ImageIcon("image/jt1.jpg"));
		jbt2 = new JButton(new ImageIcon("image/jt2.jpg"));
		jbt3 = new JButton(new ImageIcon("image/jt3.jpg"));
		jbt4 = new JButton(new ImageIcon("image/jt4.jpg"));
		jbt5 = new JButton(new ImageIcon("image/jt5.jpg"));
		jbt6 = new JButton(new ImageIcon("image/jt6.jpg"));
		jbt7 = new JButton(new ImageIcon("image/jt7.jpg"));
		jbt8 = new JButton(new ImageIcon("image/jt8.jpg"));
		jbt9 = new JButton(new ImageIcon("image/jt9.jpg"));
		jbt10 = new JButton(new ImageIcon("image/jt10.jpg"));
		jtb1.add(jbt1);
		jtb1.add(jbt2);
		jtb1.add(jbt3);
		jtb1.add(jbt4);
		jtb1.add(jbt5);
		jtb1.add(jbt6);
		jtb1.add(jbt7);
		jtb1.add(jbt8);
		jtb1.add(jbt9);
		jtb1.add(jbt10);
		
		
		//״̬��showtime
		t = new Timer(1000, this);//ÿªһ���ⷢ����
		t.start();
		jp5 = new JPanel();
		jp5.setLayout(new BorderLayout());
		showtime = new JLabel("��ǰʱ�䣺" + Calendar.getInstance().getTime().toLocaleString() + "  ");
		showtime.setFont(ToolFont.f1);
		try {
			showtime2 = ImageIO.read(new File("image/bj.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ToolImage showpanel = new ToolImage(showtime2);
		showpanel.setLayout(new BorderLayout());
		showpanel.add(showtime,"East");
		jp5.add(showpanel);
		
		//�м䲿��JP1
		try {
			p1image = ImageIO.read(new File("image/p1.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ToolImage p1_image = new ToolImage(p1image);
		p1_image.setLayout(new GridLayout(8,1));
		p1_label1 = new JLabel(new ImageIcon("image/p1_mhl.jpg"));
		p1_image.add(p1_label1);
		p1_label2 = new JLabel("�� �� �� ��", new ImageIcon("image/p1_rsgl_h.jpg"), 0);
		p1_label2.setFont(ToolFont.f2);
		p1_label2.setForeground(Color.GRAY);
		p1_label2.addMouseListener(this);
		p1_image.add(p1_label2);
		p1_label3 = new JLabel("�� ½ �� ��", new ImageIcon("image/p1_dlgl_h.jpg"), 0);
		p1_label3.setFont(ToolFont.f2);
		p1_label3.setForeground(Color.GRAY);
		p1_label3.addMouseListener(this);
		p1_image.add(p1_label3);
		p1_label4 = new JLabel("�� �� �� ��", new ImageIcon("image/p1_cpjg_h.jpg"), 0);
		p1_label4.setFont(ToolFont.f2);
		p1_label4.setForeground(Color.GRAY);
		p1_label4.addMouseListener(this);
		p1_image.add(p1_label4);
		p1_label5 = new JLabel("�� �� ͳ ��", new ImageIcon("image/p1_bbtj_h.jpg"), 0);
		p1_label5.setFont(ToolFont.f2);
		p1_label5.setForeground(Color.GRAY);
		p1_label5.addMouseListener(this);
		p1_image.add(p1_label5);
		p1_label6 = new JLabel("�ɱ����ⷿ", new ImageIcon("image/p1_cb_h.jpg"), 0);
		p1_label6.setFont(ToolFont.f2);
		p1_label6.setForeground(Color.GRAY);
		p1_label6.addMouseListener(this);
		p1_image.add(p1_label6);
		p1_label7 = new JLabel("ϵ ͳ �� ��", new ImageIcon("image/p1_xtsz_h.jpg"), 0);
		p1_label7.setFont(ToolFont.f2);
		p1_label7.setForeground(Color.GRAY);
		p1_label7.addMouseListener(this);
		p1_image.add(p1_label7);
		p1_label8 = new JLabel("�� �� �� ��", new ImageIcon("image/p1_dhbz_h.jpg"), 0);
		p1_label8.setFont(ToolFont.f2);
		p1_label8.setForeground(Color.GRAY);
		p1_label8.addMouseListener(this);
		p1_image.add(p1_label8);
		jp1 = new JPanel();
		jp1.setLayout(new BorderLayout());
		jp1.add(p1_image);
		//����P2��P3��P4 P2��P3������P4���棬P2��P3��CardLayout,P4��BorderLayou
		//p2
		jp2 = new JPanel(new CardLayout());
		p2_zuo = new JLabel(new ImageIcon("image/p2_zuo.jpg"));
		p2_you = new JLabel(new ImageIcon("image/p2_you.jpg"));
		jp2.add(p2_zuo,"0");
		jp2.add(p2_you, "1");
	    //p3
		p3card = new CardLayout();
		jp3 = new JPanel(p3card);
		try {
			p3image = ImageIO.read(new File("image/p3_bj.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p3_image = new ToolImage(p3image);
		jp3.add(p3_image,"0");
		EmpInfo emp = new EmpInfo();
		jp3.add(emp,"1");
		
		//p4
		jp4 = new JPanel(new BorderLayout());
		jp4.add(jp2,"West");
		jp4.add(jp3,"Center");
		//����JSplitPane����P1��P4���뵽JSplitPane��
		jsp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jp1, jp4);
		jsp1.setDividerSize(0);
		//ָ�����ռ��������
		jsp1.setDividerLocation(150);
		
		
		
		
		
		//��JP��ӵ�Container
		ct.add(jtb1,"North");
		ct.add(jsp1,"Center");
		ct.add(jp5,"South");
		
		
		this.setJMenuBar(jmb);
	    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	    this.setSize(width,height-30);
	    this.setIconImage(new ImageIcon("image/jb.jpg").getImage());
	    this.setTitle("����¥��������ϵͳ");
	    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	    this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.showtime.setText("��ǰʱ�䣺" + Calendar.getInstance().getTime().toLocaleString() + "  ");
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == p1_label2) {
			p1_label2.setIcon( new ImageIcon("image/p1_rsgl.jpg"));
			p1_label2.setForeground(null);
		} else if(e.getSource() == p1_label3) {
			p1_label3.setIcon( new ImageIcon("image/p1_dlgl.jpg"));
			p1_label3.setForeground(null);
		} else if(e.getSource() == p1_label4) {
			p1_label4.setIcon( new ImageIcon("image/p1_cpjg.jpg"));
			p1_label4.setForeground(null);
		} else if(e.getSource() == p1_label5) {
			p1_label5.setIcon( new ImageIcon("image/p1_bbtj.jpg"));
			p1_label5.setForeground(null);
		} else if(e.getSource() == p1_label6) {
			p1_label6.setIcon( new ImageIcon("image/p1_cb.jpg"));
			p1_label6.setForeground(null);
		} else if(e.getSource() == p1_label7) {
			p1_label7.setIcon( new ImageIcon("image/p1_xtsz.jpg"));
			p1_label7.setForeground(null);
		}  else if(e.getSource() == p1_label8) {
			p1_label8.setIcon( new ImageIcon("image/p1_dhbz.jpg"));
			p1_label8.setForeground(null);
		} 
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == p1_label2) {
			p1_label2.setIcon( new ImageIcon("image/p1_rsgl_h.jpg"));
			p1_label2.setForeground(Color.GRAY);
		} else if(e.getSource() == p1_label3) {
			p1_label3.setIcon( new ImageIcon("image/p1_dlgl_h.jpg"));
			p1_label3.setForeground(Color.GRAY);
		} else if(e.getSource() == p1_label4) {
			p1_label4.setIcon( new ImageIcon("image/p1_cpjg_h.jpg"));
			p1_label4.setForeground(Color.GRAY);
		} else if(e.getSource() == p1_label5) {
			p1_label5.setIcon( new ImageIcon("image/p1_bbtj_h.jpg"));
			p1_label5.setForeground(Color.GRAY);
		} else if(e.getSource() == p1_label6) {
			p1_label6.setIcon( new ImageIcon("image/p1_cb_h.jpg"));
			p1_label6.setForeground(Color.GRAY);
		} else if(e.getSource() == p1_label7) {
			p1_label7.setIcon( new ImageIcon("image/p1_xtsz_h.jpg"));
			p1_label7.setForeground(Color.GRAY);
		} else if(e.getSource() == p1_label8) {
			p1_label8.setIcon( new ImageIcon("image/p1_dhbz_h.jpg"));
			p1_label8.setForeground(Color.GRAY);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == p1_label2) {
			p3card.show(jp3, "1");
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}

package com.��ҵ;
/**
 * 
 * @author ���ߣ����ٻ�
 * @date ���ڣ�2017��7��27������2:36:49
 * ���ܣ����±�
 */
import java.awt.*;
import javax.swing.*;
public class Jishiben extends JFrame {
    JTextArea jta=null;
    //�˵����
    JMenuBar cd=null;
    JMenu me[]=null;
    JMenuItem mi[]=null;
    //�����˵�
    JMenu erji=null;
    JMenuItem jm1,jm2;
    //������
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
		//�������
		jta=new JTextArea();//�в�
		//�˵���
		me[0]=new JMenu("�ļ�(F)");
		me[0].setMnemonic('F');
		me[1]=new JMenu("�༭(E)");
		me[1].setMnemonic('E');
		me[2]=new JMenu("��ʽ(O)");
		me[2].setMnemonic('O');
		me[3]=new JMenu("�鿴(V)");
		me[3].setMnemonic('V');
		me[4]=new JMenu("����(H)");
		me[4].setMnemonic('H');
		//һ���˵�
		erji=new JMenu("�½�");
		mi[1]=new JMenuItem("��");
		mi[2]=new JMenuItem("����(S)");
		mi[2].setMnemonic('S');
		mi[3]=new JMenuItem("���Ϊ");
		mi[4]=new JMenuItem("ҳ������");
		mi[5]=new JMenuItem("��ӡ");
		mi[6]=new JMenuItem("�˳�");
		//
		jm1=new JMenuItem("�ļ�");
		jm2=new JMenuItem("����");
		//��Ӳ˵�
		cd=new JMenuBar();
		cd.add(me[0]);
		cd.add(me[1]);
		cd.add(me[2]);
		cd.add(me[3]);
		cd.add(me[4]);
		//���һ���˵�
		me[0].add(erji);
		me[0].add(mi[1]);
		me[0].add(mi[2]);
		me[0].add(mi[3]);
		me[0].addSeparator();
		me[0].add(mi[4]);
		me[0].add(mi[5]);
		me[0].addSeparator();
		me[0].add(mi[6]);
		//��Ӷ����˵�
		erji.add(jm1);
		erji.add(jm2);
		//������
		jb[0]=new JButton("�½�");
		jb[0].setToolTipText("�½�");
		jb[1]=new JButton("��");
		jb[1].setToolTipText("��");
		jb[2]=new JButton("����");
		jb[2].setToolTipText("����");
		jb[3]=new JButton("aa");
		jb[3].setToolTipText("aa");
		jb[4]=new JButton("����");
		jb[4].setToolTipText("����");
		//��ӹ�����
		gj=new JToolBar();
		gj.add(jb[0]);
		gj.add(jb[1]);
		gj.add(jb[2]);
		gj.add(jb[3]);
		gj.add(jb[4]);
		
		//������
		this.add(cd);
		this.add(gj,BorderLayout.NORTH);
		this.add(jta);
		//���˵���ӵ�������
		this.setJMenuBar(cd);
		//���ô���
		this.setTitle("���±�");
		this.setSize(400,300);
		this.setLocation(400,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

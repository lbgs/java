package com.����ϵͳ;
/**
 * 
 * @author ���ߣ����ٻ�
 * @date ���ڣ�2017��7��26������4:45:36
 *
 */
import java.awt.*;
import javax.swing.*;
public class zhuce extends JFrame {
	JPanel jp[]=new JPanel[7];//������
	JLabel jl[]=new JLabel[7];//��ǩ���
	JTextField jtf1,jtf2,jtf3;//�ı������
	JButton jb1,jb2;//��ť
	JRadioButton jrb1,jrb2;//��ѡ�����
	ButtonGroup jbg;//��ѡ��ť�����
	JCheckBox jcb[]=new JCheckBox[4];//��ѡ�����
	JList l;//�б�����
	JComboBox jc;//���������
	JScrollPane jfp1;//�����������
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        zhuce zh=new zhuce();
	}
	public zhuce(){
		//�������
		for(int i=0;i<7;i++){
			jp[i]=new JPanel();
		}
		jl[0]=new JLabel(" �û�����");
		jl[1]=new JLabel("��ʵ������");
		jl[2]=new JLabel("�Ա�");
		jl[3]=new JLabel("���᣺");
		jl[4]=new JLabel("�ֻ����룺");
		jl[5]=new JLabel("��ϲ�����˶���");
		jl[6]=new JLabel("��ϲ�������εص㣺");
		
		jtf1=new JTextField(10);
		jtf2=new JTextField(10);
		jtf3=new JTextField(10);
		
		jrb1=new JRadioButton("��");
		jrb2=new JRadioButton("Ů");
		jbg=new ButtonGroup();
		jbg.add(jrb1);
		jbg.add(jrb2);
		
		String cb[]={"����","����","��ݸ","��ɽ","��ɽ"};
		jc=new JComboBox(cb);
		
		jcb[0]=new JCheckBox("����");
		jcb[1]=new JCheckBox("��ë��");
		jcb[2]=new JCheckBox("����");
		jcb[3]=new JCheckBox("��ɽ");
		
		String[] ls={"������","��¡��������","���ֹ�","����֮��","����ɽ",};
		l=new JList(ls);
		l.setVisibleRowCount(3);
		jfp1=new JScrollPane(l);
		
		jb1=new JButton("ע���û�");
		jb2=new JButton("ȡ��ע��");
		
		//���ò���
		this.setLayout(new GridLayout(7,1));
		
		jp[0].add(jl[0]);
		jp[0].add(jtf1);
		jp[1].add(jl[1]);
		jp[1].add(jtf2);
		jp[2].add(jl[2]);
		jp[2].add(jrb1);
		jp[2].add(jrb2);
		jp[2].add(jl[3]);
		jp[2].add(jc);
		jp[3].add(jl[4]);
		jp[3].add(jtf3);
		jp[4].add(jl[5]);
		jp[4].add(jcb[0]);
		jp[4].add(jcb[1]);
		jp[4].add(jcb[2]);
		jp[4].add(jcb[3]);
		jp[5].add(jl[6]);
		jp[5].add(jfp1);
		jp[6].add(jb1);
		jp[6].add(jb2);
		
		this.add(jp[0]);
		this.add(jp[1]);
		this.add(jp[2]);
		this.add(jp[3]);
		this.add(jp[4]);
		this.add(jp[5]);
		this.add(jp[6]);
		
		this.setTitle("ע��");
		this.setSize(350,500);
		this.setLocation(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//this.setResizable(false);
	}

}

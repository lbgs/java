package qq;
/**
 * 
 * @author ���ߣ����ٻ�
 * @date ���ڣ�2017��7��27������12:26:10
 * QQ��½����
 */
import java.awt.*;
import javax.swing.*;
public class Denglu extends JFrame {
    JPanel jp1,jp2,jp3,jp4;
	//����
	JLabel jb=null;
	//�ϲ�
	JButton jb1,jb2,jb3;
	//�в�
	JTabbedPane jtp1;
	JLabel jl[];
	JTextField jtf1,jtf2,jtf3;
	JPasswordField jpf1,jpf2,jpf3;
	JButton bu1,bu2,bu3;
	JCheckBox jcb[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Denglu bl=new Denglu();
	}
	public Denglu(){
		//�������
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();
		
		//����
		jb=new JLabel(new ImageIcon("image/tou.gif"));
		//�ϲ�
		jb1=new JButton(new ImageIcon("image/denglu.gif"));
		jb2=new JButton(new ImageIcon("image/quxiao.gif"));
		jb3=new JButton(new ImageIcon("image/xiangdao.gif"));
		//�в�
		//ѡ�񿨴���
		jtp1=new JTabbedPane();
		jcb=new JCheckBox[6];
		jtp1.add("qq��½",jp2);
		jtp1.add("�����½",jp3);
		jtp1.add("�����½",jp4);
		//�м䲼��qq��½
		jl=new JLabel[12];
		jl[0]=new JLabel("QQ���룺",JLabel.RIGHT);
		jtf1=new JTextField(10);
		jl[1]=new JLabel("��     �룺",JLabel.RIGHT);
		jpf1=new JPasswordField(10);
		jl[2]=new JLabel("��������",JLabel.CENTER);
		jl[2].setForeground(new Color(0,0,255));
		jl[2].setFont(new Font("����",Font.PLAIN,16));
	    bu1=new JButton(new ImageIcon("image/qingchu.gif"));
	    jcb[0]=new JCheckBox("�����½");
	    jcb[1]=new JCheckBox("��ס����");
	    jl[3]=new JLabel("<html> <a href='www.qq.com'>�������뱣��</a><html>");
        jl[3].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //�����½
		jl[4]=new JLabel("�ֻ����룺",JLabel.RIGHT);
		jtf2=new JTextField(10);
		jl[5]=new JLabel("��     �룺",JLabel.RIGHT);
		jpf2=new JPasswordField(10);
		jl[6]=new JLabel("��������",JLabel.CENTER);
		jl[6].setForeground(new Color(0,0,255));
		jl[6].setFont(new Font("����",Font.PLAIN,16));
	    bu2=new JButton(new ImageIcon("image/qingchu.gif"));
	    jcb[2]=new JCheckBox("�����½");
	    jcb[3]=new JCheckBox("��ס����");
	    jl[7]=new JLabel("<html> <a href='www.qq.com'>�������뱣��</a><html>");
        jl[7].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//�����½
        jl[8]=new JLabel("������룺",JLabel.RIGHT);
		jtf3=new JTextField(10);
		jl[9]=new JLabel("��     �룺",JLabel.RIGHT);
		jpf3=new JPasswordField(10);
		jl[10]=new JLabel("��������",JLabel.CENTER);
		jl[10].setForeground(new Color(0,0,255));
		jl[10].setFont(new Font("����",Font.PLAIN,16));
	    bu3=new JButton(new ImageIcon("image/qingchu.gif"));
	    jcb[4]=new JCheckBox("�����½");
	    jcb[5]=new JCheckBox("��ס����");
	    jl[11]=new JLabel("<html> <a href='www.qq.com'>�������뱣��</a><html>");
        jl[11].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //���ò���
		jp2.setLayout(new GridLayout(3,3));
		jp3.setLayout(new GridLayout(3,3));
		jp4.setLayout(new GridLayout(3,3));
		//���qq��½���
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp2.add(jl[0]);
		jp2.add(jtf1);
		jp2.add(bu1);
		jp2.add(jl[1]);
		jp2.add(jpf1);
		jp2.add(jl[2]);
		jp2.add(jcb[0]);
		jp2.add(jcb[1]);
		jp2.add(jl[3]);
		//��Ӻ����½���
		jp3.add(jl[4]);
		jp3.add(jtf2);
		jp3.add(bu2);
		jp3.add(jl[5]);
		jp3.add(jpf2);
		jp3.add(jl[6]);
		jp3.add(jcb[2]);
		jp3.add(jcb[3]);
		jp3.add(jl[7]);
		//��������½���
		jp4.add(jl[8]);
		jp4.add(jtf3);
		jp4.add(bu3);
		jp4.add(jl[9]);
		jp4.add(jpf3);
		jp4.add(jl[10]);
		jp4.add(jcb[4]);
		jp4.add(jcb[5]);
		jp4.add(jl[11]);
        
		//������
		this.add(jtp1,BorderLayout.CENTER);
		this.add(jb,BorderLayout.NORTH);
		this.add(jp1,BorderLayout.SOUTH);
		//���ô���
		this.setTitle("��Ѷqq");
		this.setIconImage((new ImageIcon("image/qq.gif")).getImage());
		this.setSize(348,230);
		this.setLocation(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}

}

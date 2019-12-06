package qq;
/**
 * 
 * @author 作者：王荣华
 * @date 日期：2017年7月27日上午12:26:10
 * QQ登陆界面
 */
import java.awt.*;
import javax.swing.*;
public class Denglu extends JFrame {
    JPanel jp1,jp2,jp3,jp4;
	//北部
	JLabel jb=null;
	//南部
	JButton jb1,jb2,jb3;
	//中部
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
		//创建组件
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();
		
		//北部
		jb=new JLabel(new ImageIcon("image/tou.gif"));
		//南部
		jb1=new JButton(new ImageIcon("image/denglu.gif"));
		jb2=new JButton(new ImageIcon("image/quxiao.gif"));
		jb3=new JButton(new ImageIcon("image/xiangdao.gif"));
		//中部
		//选择卡窗体
		jtp1=new JTabbedPane();
		jcb=new JCheckBox[6];
		jtp1.add("qq登陆",jp2);
		jtp1.add("号码登陆",jp3);
		jtp1.add("邮箱登陆",jp4);
		//中间布局qq登陆
		jl=new JLabel[12];
		jl[0]=new JLabel("QQ号码：",JLabel.RIGHT);
		jtf1=new JTextField(10);
		jl[1]=new JLabel("密     码：",JLabel.RIGHT);
		jpf1=new JPasswordField(10);
		jl[2]=new JLabel("忘记密码",JLabel.CENTER);
		jl[2].setForeground(new Color(0,0,255));
		jl[2].setFont(new Font("黑体",Font.PLAIN,16));
	    bu1=new JButton(new ImageIcon("image/qingchu.gif"));
	    jcb[0]=new JCheckBox("隐身登陆");
	    jcb[1]=new JCheckBox("记住密码");
	    jl[3]=new JLabel("<html> <a href='www.qq.com'>申请密码保护</a><html>");
        jl[3].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //号码登陆
		jl[4]=new JLabel("手机号码：",JLabel.RIGHT);
		jtf2=new JTextField(10);
		jl[5]=new JLabel("密     码：",JLabel.RIGHT);
		jpf2=new JPasswordField(10);
		jl[6]=new JLabel("忘记密码",JLabel.CENTER);
		jl[6].setForeground(new Color(0,0,255));
		jl[6].setFont(new Font("黑体",Font.PLAIN,16));
	    bu2=new JButton(new ImageIcon("image/qingchu.gif"));
	    jcb[2]=new JCheckBox("隐身登陆");
	    jcb[3]=new JCheckBox("记住密码");
	    jl[7]=new JLabel("<html> <a href='www.qq.com'>申请密码保护</a><html>");
        jl[7].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//邮箱登陆
        jl[8]=new JLabel("邮箱号码：",JLabel.RIGHT);
		jtf3=new JTextField(10);
		jl[9]=new JLabel("密     码：",JLabel.RIGHT);
		jpf3=new JPasswordField(10);
		jl[10]=new JLabel("忘记密码",JLabel.CENTER);
		jl[10].setForeground(new Color(0,0,255));
		jl[10].setFont(new Font("黑体",Font.PLAIN,16));
	    bu3=new JButton(new ImageIcon("image/qingchu.gif"));
	    jcb[4]=new JCheckBox("隐身登陆");
	    jcb[5]=new JCheckBox("记住密码");
	    jl[11]=new JLabel("<html> <a href='www.qq.com'>申请密码保护</a><html>");
        jl[11].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //设置布局
		jp2.setLayout(new GridLayout(3,3));
		jp3.setLayout(new GridLayout(3,3));
		jp4.setLayout(new GridLayout(3,3));
		//添加qq登陆组件
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
		//添加号码登陆组件
		jp3.add(jl[4]);
		jp3.add(jtf2);
		jp3.add(bu2);
		jp3.add(jl[5]);
		jp3.add(jpf2);
		jp3.add(jl[6]);
		jp3.add(jcb[2]);
		jp3.add(jcb[3]);
		jp3.add(jl[7]);
		//添加邮箱登陆组件
		jp4.add(jl[8]);
		jp4.add(jtf3);
		jp4.add(bu3);
		jp4.add(jl[9]);
		jp4.add(jpf3);
		jp4.add(jl[10]);
		jp4.add(jcb[4]);
		jp4.add(jcb[5]);
		jp4.add(jl[11]);
        
		//添加组件
		this.add(jtp1,BorderLayout.CENTER);
		this.add(jb,BorderLayout.NORTH);
		this.add(jp1,BorderLayout.SOUTH);
		//设置窗体
		this.setTitle("腾讯qq");
		this.setIconImage((new ImageIcon("image/qq.gif")).getImage());
		this.setSize(348,230);
		this.setLocation(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}

}

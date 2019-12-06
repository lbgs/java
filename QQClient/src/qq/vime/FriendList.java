/**
 * QQ好友列表
 */
package qq.vime;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class FriendList extends JFrame implements ActionListener,MouseListener{
	//卡片布局
	CardLayout cl=null;
	//第一个卡片
	JButton jp1_jb1,jp1_jb2,jp1_jb3;
	JPanel jp1,jp1_1,jp1_2;
	JScrollPane jsp1;
	JLabel[] jl1;
	//第二个卡片
	JButton jp2_jb1,jp2_jb2,jp2_jb3;
	JPanel jp2,jp2_1,jp2_2;
	JScrollPane jsp2;
	JLabel[] jl2;
	//第三个卡片
	JButton jp3_jb1,jp3_jb2,jp3_jb3;
	JPanel jp3,jp3_1,jp3_2;
	JScrollPane jsp3;
	JLabel[] jl3;
	
	//编号
	String ownerid;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FriendList friend=new FriendList();
	}
	public FriendList(String ownerid){
		this.ownerid=ownerid;
		//第一个卡片
		this.OneCard();
		//第二个卡片
		this.TwoCard();
		//第三个卡片
		this.ThreeCaed();
		//初始化卡片布局
		cl=new CardLayout();
		this.setLayout(cl);
		this.add(jp1,"我的好友");
		this.add(jp2,"陌生人");
		this.add(jp3,"黑名单");
		//设置窗体
		this.setIconImage((new ImageIcon("image/qq.gif")).getImage());
		this.setTitle(ownerid);
		this.setSize(200,400);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void OneCard(){
		jp1=new JPanel(new BorderLayout());
		//北部
		jp1_jb1=new JButton("我的好友");
		jp1_jb1.addActionListener(this);
		jp1_jb1.setActionCommand("我的好友");
		//中间
		jp1_1=new JPanel(new GridLayout(50,1,5,5));
		jl1=new JLabel[50];
		for(int i=0;i<jl1.length;i++){
			jl1[i]=new JLabel(i+1+"",new ImageIcon("image/mm.jpg"),JLabel.LEFT);
			jl1[i].addMouseListener(this);
			jp1_1.add(jl1[i]);
		}
		
		jsp1=new JScrollPane(jp1_1);
		//南部
		jp1_2=new JPanel(new GridLayout(2,1));
		jp1_jb2=new JButton("陌生人");
		jp1_jb2.addActionListener(this);
		jp1_jb3=new JButton("黑名单");
		jp1_jb3.addActionListener(this);
		jp1_2.add(jp1_jb2);
		jp1_2.add(jp1_jb3);
		
		jp1.add(jp1_jb1,"North");
		jp1.add(jsp1,"Center");
		jp1.add(jp1_2,"South");
		
	}
	public void TwoCard(){
		jp2=new JPanel(new BorderLayout());
		//北部
		jp2_1=new JPanel(new GridLayout(2,1));
		jp2_jb1=new JButton("我的好友");
		jp2_jb1.addActionListener(this);
		jp2_jb1.setActionCommand("我的好友");
		jp2_jb2=new JButton("陌生人");
		jp2_jb2.addActionListener(this);
		jp2_jb2.setActionCommand("陌生人");
		jp2_1.add(jp2_jb1);
		jp2_1.add(jp2_jb2);
		//中间
		jp2_2=new JPanel(new GridLayout(20,1,5,5));
		jl2=new JLabel[20];
		for(int i=0;i<jl2.length;i++){		
			jl2[i]=new JLabel(i+1+"",new ImageIcon("image/mm.jpg"),JLabel.LEFT);
			jl2[i].addMouseListener(this);
			jp2_2.add(jl2[i]);
		}
		jsp2=new JScrollPane(jp2_2);
		//南部
		jp2_jb3=new JButton("黑名单");
		jp2_jb3.addActionListener(this);
		jp2_jb3.setActionCommand("黑名单");
		
		//整体
		jp2.add(jp2_1,"North");
		jp2.add(jsp2,"Center");
		jp2.add(jp2_jb3,"South");
			
	}
	public void ThreeCaed(){
		jp3=new JPanel(new BorderLayout());
		//处理北部
		jp3_1=new JPanel(new GridLayout(3,1));
		jp3_jb1=new JButton("我的好友");
		jp3_jb1.addActionListener(this);
		jp3_jb2=new JButton("陌生人");
		jp3_jb2.addActionListener(this);
		jp3_jb3=new JButton("黑名单");
		jp3_1.add(jp3_jb1);
		jp3_1.add(jp3_jb2);
		jp3_1.add(jp3_jb3);
		//处理中间
		jp3_2=new JPanel(new GridLayout(15,1,5,5));
		jl3=new JLabel[15];
		for(int i=0;i<jl3.length;i++){
			jl3[i]=new JLabel(i+1+"",new ImageIcon("image/mm.jpg"),JLabel.LEFT);
			jl3[i].setEnabled(false);
			jl3[i].addMouseListener(this);
			jp3_2.add(jl3[i]);
		}
		jsp3=new JScrollPane(jp3_2);
		//处理整体
		jp3.add(jp3_1,"North");
		jp3.add(jsp3,"Center");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("我的好友")){
			cl.show(this.getContentPane(), "我的好友");
		}else if(e.getActionCommand().equals("陌生人")){
			cl.show(this.getContentPane(), "陌生人");
		}else if(e.getActionCommand().equals("黑名单")){
			cl.show(this.getContentPane(), "黑名单");
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount()==2){
			String No=((JLabel)e.getSource()).getText();
			new ChatFrame(this.ownerid,No);
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
		JLabel jl=(JLabel)e.getSource();
		jl.setForeground(Color.red);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jl=(JLabel)e.getSource();
		jl.setForeground(Color.black);
	}

}

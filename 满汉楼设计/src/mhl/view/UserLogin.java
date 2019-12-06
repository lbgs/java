/**
 * 登陆界面
 * JDialog是自定义窗体
 */
package mhl.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import mhl.Tools.*;
import mhl.Model.*;
public class UserLogin extends JDialog implements ActionListener{
	JLabel jl1,jl2,jl3;
	JTextField juser=null;
	JPasswordField jpassword=null;
	JButton jb1,jb2;
	public static void main(String args[]){
		UserLogin user=new UserLogin();
	}
	public UserLogin(){
		//创建容器
		Container ct=this.getContentPane();
		//取消布局
		this.setLayout(null);
		//定义标签
		jl1=new JLabel("请输入用户名：");
		jl1.setFont(MyTools.font16);
		jl1.setBounds(60, 190, 150, 30);
		ct.add(jl1);
		jl2=new JLabel("（或员工号）");
		jl2.setFont(MyTools.font14);
		//设置前景色
		jl2.setForeground(Color.red);
		jl2.setBounds(80,210,150,30);
		ct.add(jl2);
		jl3=new JLabel("请输入密码：");
		jl3.setFont(MyTools.font16);
		jl3.setBounds(75,240,150,30);
		ct.add(jl3);
		//文本框
		juser=new JTextField();
		juser.setBounds(170,190,120,30);
		//设置下凹
		juser.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(juser);
		//密码框
		jpassword=new JPasswordField();
		jpassword.setBounds(170,240,120,30);
		//设置下凹
		jpassword.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jpassword);
		//按钮
		jb1=new JButton("确定");
		jb1.setFont(MyTools.font16);
		jb1.setBounds(90,290,70,30);
		jb1.addActionListener(this);
		ct.add(jb1);
		jb2=new JButton("取消");
		jb2.setFont(MyTools.font16);
		jb2.setBounds(190,290,70,30);
		jb2.addActionListener(this);
		ct.add(jb2);
		//创建背景
		BackImage img=new BackImage();
		//确定位置
		img.setBounds(0, 0, 360, 360);
		//放入容器
		ct.add(img);
		//不适用Windows框
		this.setUndecorated(true);
		//设置窗体
		this.setSize(360,360);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((width-360)/2,(height-360)/2);
		this.setVisible(true);
	}
	//内部类
	class BackImage extends JPanel{
		Image img=null;
		public BackImage(){
			try {
				img=ImageIO.read(new File("image/UserLogin.jpg"));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		public void paint(Graphics g){
			super.paint(g);
			g.drawImage(img, 0,0,360,360,this);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){
			String user=juser.getText();
			String password=new String(jpassword.getPassword());
			UserModel um=new UserModel();
			String zhiwei=um.checkUser(user, password);
			if(zhiwei.contentEquals("")){
				JOptionPane.showMessageDialog(this,"请输入正确的用户名或者密码");
			}else if(zhiwei.equals("经理")||zhiwei.equals("管理员")){
				new Windows1();
			}
		}else if(e.getSource()==jb2){
			System.exit(0);
		}
	}
}

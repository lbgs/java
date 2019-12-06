/**
 * ��½����
 * JDialog���Զ��崰��
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
		//��������
		Container ct=this.getContentPane();
		//ȡ������
		this.setLayout(null);
		//�����ǩ
		jl1=new JLabel("�������û�����");
		jl1.setFont(MyTools.font16);
		jl1.setBounds(60, 190, 150, 30);
		ct.add(jl1);
		jl2=new JLabel("����Ա���ţ�");
		jl2.setFont(MyTools.font14);
		//����ǰ��ɫ
		jl2.setForeground(Color.red);
		jl2.setBounds(80,210,150,30);
		ct.add(jl2);
		jl3=new JLabel("���������룺");
		jl3.setFont(MyTools.font16);
		jl3.setBounds(75,240,150,30);
		ct.add(jl3);
		//�ı���
		juser=new JTextField();
		juser.setBounds(170,190,120,30);
		//�����°�
		juser.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(juser);
		//�����
		jpassword=new JPasswordField();
		jpassword.setBounds(170,240,120,30);
		//�����°�
		jpassword.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jpassword);
		//��ť
		jb1=new JButton("ȷ��");
		jb1.setFont(MyTools.font16);
		jb1.setBounds(90,290,70,30);
		jb1.addActionListener(this);
		ct.add(jb1);
		jb2=new JButton("ȡ��");
		jb2.setFont(MyTools.font16);
		jb2.setBounds(190,290,70,30);
		jb2.addActionListener(this);
		ct.add(jb2);
		//��������
		BackImage img=new BackImage();
		//ȷ��λ��
		img.setBounds(0, 0, 360, 360);
		//��������
		ct.add(img);
		//������Windows��
		this.setUndecorated(true);
		//���ô���
		this.setSize(360,360);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((width-360)/2,(height-360)/2);
		this.setVisible(true);
	}
	//�ڲ���
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
				JOptionPane.showMessageDialog(this,"��������ȷ���û�����������");
			}else if(zhiwei.equals("����")||zhiwei.equals("����Ա")){
				new Windows1();
			}
		}else if(e.getSource()==jb2){
			System.exit(0);
		}
	}
}

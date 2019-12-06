package qq.viow;
/**
 * 功能：服务器管理界面
 * @author 王荣华
 * 2017年9月3日 下午4:58:24
 */
import javax.swing.*;
import qq.model.*;
import java.awt.*;
import java.awt.event.*;
public class qqServer extends JFrame implements ActionListener{
	JButton jb1,jb2;
	JPanel jp1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		qqServer server=new qqServer();
		
	}
	public qqServer(){
		jp1=new JPanel();
		jb1=new JButton("启动服务器");
		jb1.addActionListener(this);
		jb2=new JButton("关闭服务器");
		jb2.addActionListener(this);
		jp1.add(jb1);
		jp1.add(jb2);
		
		this.add(jp1,"North");
		this.setIconImage(new ImageIcon("image/qq.gif").getImage());
		this.setTitle("QQ服务器");
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){
			new Server();
		}else if(e.getSource()==jb2){
			System.out.println("关闭服务器");
		}
	}

}

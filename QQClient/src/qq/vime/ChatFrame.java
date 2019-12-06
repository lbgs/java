/**
 * 聊天框
 */
package qq.vime;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import qq.common.*;
import java.io.*;
import qq.conServer.*;
public class ChatFrame extends JFrame implements ActionListener{
	JTextArea jta1,jta2;
	JScrollPane jsp1,jsp2;
	JLabel jl1;
	JButton jb1;
	JPanel jp1,jp2,jp2_1;
	//信息内容
	String ownerid;
	String ta;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ChatFrame cf=new ChatFrame("");
	}
	public ChatFrame(String ownerid,String ta){
		
		this.ownerid=ownerid;
		this.ta=ta;
		//中间
		jp1=new JPanel(new GridLayout(1,1,10,20));
		jta1=new JTextArea();
		jsp1=new JScrollPane(jta1);
		jp1.add(jsp1);
		//下面
		jp2=new JPanel(new GridLayout(2,1));
		jta2=new JTextArea();
		jsp2=new JScrollPane(jta2);
		jp2_1=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jb1=new JButton("发送");
		jb1.addActionListener(this);
		jp2_1.add(jb1);
		
		jp2.add(jsp2);
		jp2.add(jp2_1);
		//添加组件
		this.add(jp1,"Center");
		this.add(jp2,"South");
		
		this.setTitle(ownerid+" 与 "+ta+" 聊天");
		this.setIconImage((new ImageIcon("image/qq.gif")).getImage());
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){

			Message m=new Message();
			m.setOwer(ownerid);
			m.setTa(ta);
			m.setInfo(jta2.getText());
			try {
				ObjectOutputStream oos=new ObjectOutputStream(ServerHelper.s.getOutputStream());
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

}

/**
 * �����
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
	//��Ϣ����
	String ownerid;
	String ta;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ChatFrame cf=new ChatFrame("");
	}
	public ChatFrame(String ownerid,String ta){
		
		this.ownerid=ownerid;
		this.ta=ta;
		//�м�
		jp1=new JPanel(new GridLayout(1,1,10,20));
		jta1=new JTextArea();
		jsp1=new JScrollPane(jta1);
		jp1.add(jsp1);
		//����
		jp2=new JPanel(new GridLayout(2,1));
		jta2=new JTextArea();
		jsp2=new JScrollPane(jta2);
		jp2_1=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jb1=new JButton("����");
		jb1.addActionListener(this);
		jp2_1.add(jb1);
		
		jp2.add(jsp2);
		jp2.add(jp2_1);
		//������
		this.add(jp1,"Center");
		this.add(jp2,"South");
		
		this.setTitle(ownerid+" �� "+ta+" ����");
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

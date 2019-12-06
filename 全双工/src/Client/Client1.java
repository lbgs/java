/**
 * 客户端
 */
package Client;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.awt.event.*;
public class Client1 extends JFrame implements ActionListener,KeyListener{
	JTextArea jta=null;
	JScrollPane jsp=null;
	JTextField jtf=null;
	JButton jb=null;
	JPanel jp=null;
	PrintWriter pw=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client1 server1=new Client1();
	}
	public Client1(){
		//中间
		jta=new JTextArea();
		jsp=new JScrollPane(jta);
		//南部
		jtf=new JTextField(15);
		jb=new JButton("发送");
		jb.addActionListener(this);
		jb.addKeyListener(this);
		jp=new JPanel();
		jp.add(jtf);
		jp.add(jb);
		
		this.add(jsp,"Center");
		this.add(jp,"South");
		this.setTitle("QQ聊天（客户端）");
		this.setSize(400,300);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			//连接服务器
			Socket s=new Socket("127.0.0.1",5200);
			pw=new PrintWriter(s.getOutputStream(),true);
			//读取数据
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			while(true){
				String info=br.readLine();
				jta.append("服务器对客户端说： "+info+"\r\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb){
			String info=jtf.getText();
			if(info.equals("")){
				JOptionPane.showMessageDialog(this, "不能发送空信息");
			}else{
				jta.append("客户端对服务器说： "+info+"\r\n");
				pw.println(info);
				jtf.setText("");
			}
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		this.repaint();
		if(e.getKeyLocation()==KeyEvent.VK_ENTER){
			System.out.println("回车");
			String info=jtf.getText();
			if(info.equals("")){
				JOptionPane.showMessageDialog(this, "不能发送空信息");
			}else{
				jta.append("客户端对服务器说： "+info+"\r\n");
				pw.println(info);
				jtf.setText("");
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

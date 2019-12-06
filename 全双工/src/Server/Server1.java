/**
 * 服务器端
 */
package Server;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.awt.event.*;
public class Server1 extends JFrame implements ActionListener{
	JTextArea jta=null;
	JScrollPane jsp=null;
	JTextField jtf=null;
	JButton jb=null;
	JPanel jp=null;
	PrintWriter pw=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server1 server1=new Server1();
	}
	public Server1(){
		//中间
		jta=new JTextArea();
		jsp=new JScrollPane(jta);
		//南部
		jtf=new JTextField(15);
		jb=new JButton("发送");
		jb.addActionListener(this);
		jp=new JPanel();
		jp.add(jtf);
		jp.add(jb);
		
		this.add(jsp,"Center");
		this.add(jp,"South");
		this.setTitle("QQ聊天（服务器）");
		this.setSize(400,300);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			//服务器在5200端口监听
			ServerSocket ss=new ServerSocket(5200);
			//等待某个客户端连接，
			Socket s=ss.accept();
			System.out.println("连接成功");
			pw=new PrintWriter(s.getOutputStream(),true);
			//读取数据
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			while(true){
				String info=br.readLine();
				jta.append("客户端对服务器说：  "+info+"\r\n");
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
				JOptionPane.showMessageDialog(this,"不能发送空信息" );
			}else{
				pw.println(info);
				jta.append("服务器对客户端说： "+info+"\r\n");
				jtf.setText("");
			}
		}
	}

}

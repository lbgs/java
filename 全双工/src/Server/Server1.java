/**
 * ��������
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
		//�м�
		jta=new JTextArea();
		jsp=new JScrollPane(jta);
		//�ϲ�
		jtf=new JTextField(15);
		jb=new JButton("����");
		jb.addActionListener(this);
		jp=new JPanel();
		jp.add(jtf);
		jp.add(jb);
		
		this.add(jsp,"Center");
		this.add(jp,"South");
		this.setTitle("QQ���죨��������");
		this.setSize(400,300);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			//��������5200�˿ڼ���
			ServerSocket ss=new ServerSocket(5200);
			//�ȴ�ĳ���ͻ������ӣ�
			Socket s=ss.accept();
			System.out.println("���ӳɹ�");
			pw=new PrintWriter(s.getOutputStream(),true);
			//��ȡ����
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			while(true){
				String info=br.readLine();
				jta.append("�ͻ��˶Է�����˵��  "+info+"\r\n");
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
				JOptionPane.showMessageDialog(this,"���ܷ��Ϳ���Ϣ" );
			}else{
				pw.println(info);
				jta.append("�������Կͻ���˵�� "+info+"\r\n");
				jtf.setText("");
			}
		}
	}

}

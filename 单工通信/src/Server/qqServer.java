/**
 * ��������
 */
package Server;
import java.net.*;
import java.io.*;
public class qqServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		qqServer qq=new qqServer();
	}
	public qqServer(){
		try {
			//����������˿ں�Ϊ5200
			ServerSocket ss=new ServerSocket(5200);
			System.out.println("�������˿��Ѵ�");
			//�ȴ�ĳ���ͻ������ӣ�����ɹ��򷵻�һ��Socket
			Socket s=ss.accept();
			//��ȡ����
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			String info=br.readLine();
			System.out.println("��������"+info);
			//��ͻ��˷�������
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			pw.println("��ã����Ƿ�������");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

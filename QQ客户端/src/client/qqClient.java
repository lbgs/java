/**
 * �ͻ���
 */
package client;
import java.io.*;
import java.net.*;
public class qqClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		qqClient qq=new qqClient();
	}
	public qqClient(){
		try {
			//���ӷ�����
			Socket s=new Socket("127.0.0.1",5200);
			//��sд����
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			pw.println("��ã����ǿͻ���");
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			String aa=br.readLine();
			System.out.println("�ͻ��ˣ�"+aa);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

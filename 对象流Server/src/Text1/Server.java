package Text1;
/**
 * 
 * @author ���ٻ�
 * 2017��9��3�� ����4:03:07
 * ���ܣ���������������
 */
import java.net.*;
import java.io.*;
import common.*;
public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server=new Server();
	}
	public Server(){
		try {
			//�����������2345�˿ںż���
			ServerSocket ss=new ServerSocket(9999);
			System.out.println("��������9999�˿ڼ���......");
			//�������ȴ�����
			Socket s=ss.accept();
			System.out.println("������");
			//��ȡ���ܵĵ�����
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			Text1 t=(Text1)ois.readObject();
			System.out.println(t.getUser()+"  "+t.getPassword());
			ss.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

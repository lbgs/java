package Text1;
/**
 * 
 * @author ���ٻ�
 * 2017��9��3�� ����3:45:40
 * ���ܣ��������ͻ���
 */
import java.net.*;
import java.io.*;
import common.*;
public class Client {
	Socket s;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client clinet=new Client();
	}
	public Client(){
		try {
			s=new Socket("127.0.0.1",9999);
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			Text1 t=new Text1();
			t.setUser("admin");
			t.setPassword("123456");
			oos.writeObject(t);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				if(s!=null) s.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

}

package qq.conServer;
/**
 * ���ܣ�QQ�ͻ������ӷ�����
 * @author ���ٻ�
 * 2017��9��3�� ����10:45:27
 */
import java.net.*;
import java.io.*;
import qq.common.*;
public class ServerHelper {
	
	public static Socket s;
	public boolean ServerHelper(Object o){
		boolean b=false;
		try {
			s=new Socket("192.168.2.184",5200);
			System.out.println("��5200�˿ڷ��������ӳɹ�");
			//ʹ�ö������������ݸ�������
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			//��ȡ�����͹���������
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			Message m=(Message)ois.readObject();
			System.out.println("��֤");
			if(m.getMyType().equals("1")){
				b=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return b;
	}
}

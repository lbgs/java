package qq.model;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * ���ܣ�������
 * @author ���ٻ�
 * 2017��9��3�� ����10:32:37
 */
import java.net.*;
import qq.common.*;
public class Server {
	ServerSocket ss;
	Socket s;
	public Server(){
		try {
			ss=new ServerSocket(5200);
			System.out.println("��������5200�˿ڼ���......");
			while(true){
				//�������ȴ�����
				s=ss.accept();
				//��ȡ����
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				User u=(User)ois.readObject();
				System.out.println("���������ܵ���"+u.getName()+" ���룺"+u.getPassword());
				//д�벢����
				ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
				//��ȡ��Ϣ
				Message m=new Message();
				//��֤��¼
				if(u.getPassword().equals("123456")){
					m.setMyType("1");
					oos.writeObject(m);
					
					//����һ���߳�
					Info i=new Info(s);
					i.start();
				}else{
					m.setMyType("2");
					oos.writeObject(m);
				}
				
				
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

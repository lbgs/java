package qq.conServer;
/**
 * 功能：QQ客户端连接服务器
 * @author 王荣华
 * 2017年9月3日 下午10:45:27
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
			System.out.println("与5200端口服务器连接成功");
			//使用对象流发送数据给服务器
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			//读取服务发送过来的数据
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			Message m=(Message)ois.readObject();
			System.out.println("验证");
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

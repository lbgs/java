package Text1;
/**
 * 
 * @author 王荣华
 * 2017年9月3日 下午4:03:07
 * 功能：对象流服务器端
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
			//定义服务器在2345端口号监听
			ServerSocket ss=new ServerSocket(9999);
			System.out.println("服务器在9999端口监听......");
			//阻塞，等待连接
			Socket s=ss.accept();
			System.out.println("已连接");
			//读取接受的的内容
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

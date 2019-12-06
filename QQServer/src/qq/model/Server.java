package qq.model;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * 功能：服务器
 * @author 王荣华
 * 2017年9月3日 下午10:32:37
 */
import java.net.*;
import qq.common.*;
public class Server {
	ServerSocket ss;
	Socket s;
	public Server(){
		try {
			ss=new ServerSocket(5200);
			System.out.println("服务器在5200端口监听......");
			while(true){
				//阻塞，等待连接
				s=ss.accept();
				//读取数据
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				User u=(User)ois.readObject();
				System.out.println("服务器接受到："+u.getName()+" 密码："+u.getPassword());
				//写入并发送
				ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
				//读取信息
				Message m=new Message();
				//验证登录
				if(u.getPassword().equals("123456")){
					m.setMyType("1");
					oos.writeObject(m);
					
					//单开一个线程
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

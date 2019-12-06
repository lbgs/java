/**
 * 服务器端
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
			//定义服务器端口号为5200
			ServerSocket ss=new ServerSocket(5200);
			System.out.println("服务器端口已打开");
			//等待某个客户端连接，如果成功则返回一个Socket
			Socket s=ss.accept();
			//读取数据
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			String info=br.readLine();
			System.out.println("服务器："+info);
			//向客户端发送数据
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			pw.println("你好，我是服务器端");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

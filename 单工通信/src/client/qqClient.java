/**
 * 客户端
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
			//连接服务器
			Socket s=new Socket("127.0.0.1",5200);
			//向s写数据
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			pw.println("你好，我是客户端");
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			String aa=br.readLine();
			System.out.println("客户端："+aa);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

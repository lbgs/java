package qq.model;
import java.net.*;
import qq.common.*;
import java.io.*;
public class Info extends Thread{
	Socket s;
	public Info(Socket s){
		this.s=s;
	}
	public void run(){
		while(true){
			try {
				this.s=new Socket();
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message m=(Message)ois.readObject();
				System.out.println(m.getOwer()+" �� "+m.getTa()+" ˵��"+m.getInfo());
				
				//�����ÿͻ��˵���Ϣ
			
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}

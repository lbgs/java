package qq.common;
/**
 * ���ܣ�ʵ�ֶ�����
 * @author ���ٻ�
 * 2017��9��3�� ����10:48:40
 */
import java.io.*;
public class User implements Serializable{
	private String name;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
}

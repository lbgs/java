package qq.common;
/**
 * 功能：实现对象流
 * @author 王荣华
 * 2017年9月3日 下午10:48:40
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

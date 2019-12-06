package common;
import java.io.*;
public class Text1 implements Serializable //–Ú¡–ªØ
{
	private String User;
	private String password;
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

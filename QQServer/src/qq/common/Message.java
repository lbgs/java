package qq.common;
import java.io.*;
public class Message implements Serializable{
	private String MyType;
	private String ower;
	private String ta;
	private String info;
	public String getOwer() {
		return ower;
	}

	public void setOwer(String ower) {
		this.ower = ower;
	}

	public String getTa() {
		return ta;
	}

	public void setTa(String ta) {
		this.ta = ta;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getMyType() {
		return MyType;
	}

	public void setMyType(String myType) {
		MyType = myType;
	}
}

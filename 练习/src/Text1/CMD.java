package Text1;

public class CMD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//打开系统版本，winver为CMD命令
			Process pro = Runtime.getRuntime().exec("cmd /c winver"); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

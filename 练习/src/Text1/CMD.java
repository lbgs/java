package Text1;

public class CMD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//��ϵͳ�汾��winverΪCMD����
			Process pro = Runtime.getRuntime().exec("cmd /c winver"); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

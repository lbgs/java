package qq.model;
/**
 * ���ܣ���½��֤
 * @author ���ٻ�
 * 2017��9��3�� ����10:55:26
 */
import qq.conServer.*;
public class QqLogin {
	public boolean QqLogin(Object o){
		return new ServerHelper().ServerHelper(o);
	}
}

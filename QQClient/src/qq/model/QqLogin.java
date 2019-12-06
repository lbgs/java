package qq.model;
/**
 * 功能：登陆验证
 * @author 王荣华
 * 2017年9月3日 下午10:55:26
 */
import qq.conServer.*;
public class QqLogin {
	public boolean QqLogin(Object o){
		return new ServerHelper().ServerHelper(o);
	}
}

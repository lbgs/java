package mhl.Model;
import java.sql.*;
import mhl.db.*;
public class UserModel {
	SqlHelper sh=null;
	/**
	 * 
	 * @param user �û���
	 * @param password �û�����
	 * @return ����ְλ����û���򷵻�""
	 */
	public String checkUser(String user,String password){
		String zhiwei="";
		try {
			String sql="select zhiwei from login,rszl where "
					+ "login.empid=rszl.empid and login.empid=? and passwd=?";
			String[] paras={user,password};
			sh=new SqlHelper();
			ResultSet rs=sh.query(sql, paras);
			if(rs.next()){
				//��ȡ��ְλ
				zhiwei=rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
		}
		return zhiwei;
	}
}

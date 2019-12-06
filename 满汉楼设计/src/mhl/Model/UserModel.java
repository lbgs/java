package mhl.Model;
import java.sql.*;
import mhl.db.*;
public class UserModel {
	SqlHelper sh=null;
	/**
	 * 
	 * @param user 用户名
	 * @param password 用户密码
	 * @return 返回职位，若没有则返回""
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
				//则取出职位
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

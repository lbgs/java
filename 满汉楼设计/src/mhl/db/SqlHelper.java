/**
 * 对数据库操作的
 */
package mhl.db;
import java.sql.*;
public class SqlHelper {
	//定义需要的对象
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://127.0.0.1/RestaurantDB"
			+ "?useUnicode=true&characterEncoding=UTF-8";
	String user="root";
	String password="ROOT";
	//构造函数
	public SqlHelper(){
		try {
			//加载驱动
			Class.forName(driver);
			//得到连接
			ct=DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//增、修、删
	public void cud(String sql,String[] paras){
		try {
			ps=ct.prepareStatement(sql);
			for(int i=0;i<paras.length;i++){
				ps.setString(i+1, paras[i]);
			}
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.Close();
		}
	}
	//查询
	public ResultSet query(String sql,String[] paras){
		try {
			ps=ct.prepareStatement(sql);
			for(int i=0;i<paras.length;i++){
				ps.setString(i+1, paras[i]);
			}
			rs=ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rs;
	}
	//关闭资源
	public void Close(){
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(ct!=null) ct.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

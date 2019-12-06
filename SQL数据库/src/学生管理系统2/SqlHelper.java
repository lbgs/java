package 学生管理系统2;
/**
 * 
 * @author 王荣华
 * 对数据库操作
 */
import java.sql.*;
public class SqlHelper {
	//连接数据库
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String driver="com.mysql.jdbc.Driver";//驱动
	String url="jdbc:mysql://127.0.0.1/pengyou"
			+"?useUnicode=true&characterEncoding=UTF-8";//连接服务器数据库
	String user="root";//管理员
	String password="";//密码
	//连接数据库
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
	//增、删、改
	public void UpdExcute(String sql,String[] paras){
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
	public ResultSet queryExcute(String sql,String[] paras){
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
}

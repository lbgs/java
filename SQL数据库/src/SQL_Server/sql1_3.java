package SQL_Server;
/*
 * JDBC
 */
import java.sql.*;
public class sql1_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection ct=null;
		PreparedStatement ps=null;
		//结果集
		ResultSet rs=null;
		try {
			//1、加载驱动
			Class.forName("com.microsoft.jdbc.sqlserver.SQLserverDriver");
			//2、得到连接
			ct=DriverManager.getConnection
			("jdbc.microsoft.sqlserver://127.0.0.1:1433;databaseName=数据库名");
			//创建ps
			ps=ct.prepareStatement("sql语言");
			//ddl定义语言（创建数据库、创建表、备份数据库、删除数据库等等），返回boolean值
			ps.execute();
			//dml操作语言（添加、修改、删除），返回int、String等等
			ps.executeUpdate();
			//dql查询语言（查询），返回结果
			rs=ps.executeQuery();
			//字段
			rs.next();	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(ps!=null){
					ps.close();
				}
				if(ct!=null){
					ct.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

}

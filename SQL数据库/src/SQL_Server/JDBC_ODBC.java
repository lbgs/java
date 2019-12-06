package SQL_Server;
import java.sql.*;
class JDBC_ODBC{
	public static void main(String args[]){
		
		//得到连接
		Connection ct=null;
		
		Statement st=null;
		//结果集
		ResultSet rs=null;
		try{
			//1、加载驱动(作用是把需要驱动加入内存)
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//2、得到连接     jdbc:odbc:数据库名[用户民，密码]
			ct=DriverManager.getConnection("jdbc:odbc:数据库名","用户名","密码");
			//3、创建Statement或者PreparedStatement
			st=ct.createStatement();
			//4、执行(crud)
			//exectueUpdate可以执行cud(添加、修改、删除)并会返回int
			int i=st.executeUpdate("");		
			//executeQuery执行查询语句
			rs=st.executeQuery("");
			//rs.next只执行字段(标题)
			rs.next();
			rs.getInt(1);//rs.get???(i)执行一行第i列
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(st!=null){
					st.close();
				}
				if(ct!=null){
					ct.close();
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}
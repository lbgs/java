package com.练习;
import java.sql.*;
public class sql1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//定义对象
		Connection ct=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//加载驱动
			Class.forName("sun.jdbc.odbc.JdbcOdbcDeiver");
			//得到连接
			ct=DriverManager.getConnection("");
			//创建ps
			ps=ct.prepareStatement("select * from 表名  where 字段=?");
			//ps.set???(第几个问号，值)
			ps.setInt(1, 2);
			//查询语句
			rs=ps.executeQuery();
			//执行
			while(rs.next()){
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(ps!=null){
					ps.close();
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

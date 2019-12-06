package MySQL;
import java.sql.*;
public class Dome1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection ct=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2、得到连接
			ct=DriverManager.getConnection
				("jdbc:mysql://127.0.0.1:3306/pengyou","root","ROOT");
			//执行SQL语句(添加)
			ps=ct.prepareStatement("insert into pengyoubiao values(?,?,?,?)");
			ps.setInt(1, 18);
			ps.setString(2, "1a3");
			ps.setInt(3, 30);
			ps.setString(4, "女");
			ps.executeUpdate();
			//执行SQL语句（查询）
//			ps=ct.prepareStatement("select * from pengyoubiao");
//			rs=ps.executeQuery();
//			while(rs.next()){
//				int id=rs.getInt(1);
//				String name=rs.getString(2);
//				int age=rs.getInt(3);
//				System.out.println(id+"\t"+name+"\t"+age);
//			}
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
			}catch (Exception e2){
				e2.printStackTrace();
			}
		}
	}

}

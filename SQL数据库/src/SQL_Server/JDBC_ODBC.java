package SQL_Server;
import java.sql.*;
class JDBC_ODBC{
	public static void main(String args[]){
		
		//�õ�����
		Connection ct=null;
		
		Statement st=null;
		//�����
		ResultSet rs=null;
		try{
			//1����������(�����ǰ���Ҫ���������ڴ�)
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//2���õ�����     jdbc:odbc:���ݿ���[�û�������]
			ct=DriverManager.getConnection("jdbc:odbc:���ݿ���","�û���","����");
			//3������Statement����PreparedStatement
			st=ct.createStatement();
			//4��ִ��(crud)
			//exectueUpdate����ִ��cud(��ӡ��޸ġ�ɾ��)���᷵��int
			int i=st.executeUpdate("");		
			//executeQueryִ�в�ѯ���
			rs=st.executeQuery("");
			//rs.nextִֻ���ֶ�(����)
			rs.next();
			rs.getInt(1);//rs.get???(i)ִ��һ�е�i��
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
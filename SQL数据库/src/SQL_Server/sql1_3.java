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
		//�����
		ResultSet rs=null;
		try {
			//1����������
			Class.forName("com.microsoft.jdbc.sqlserver.SQLserverDriver");
			//2���õ�����
			ct=DriverManager.getConnection
			("jdbc.microsoft.sqlserver://127.0.0.1:1433;databaseName=���ݿ���");
			//����ps
			ps=ct.prepareStatement("sql����");
			//ddl�������ԣ��������ݿ⡢�������������ݿ⡢ɾ�����ݿ�ȵȣ�������booleanֵ
			ps.execute();
			//dml�������ԣ���ӡ��޸ġ�ɾ����������int��String�ȵ�
			ps.executeUpdate();
			//dql��ѯ���ԣ���ѯ�������ؽ��
			rs=ps.executeQuery();
			//�ֶ�
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

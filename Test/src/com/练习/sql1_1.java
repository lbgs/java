package com.��ϰ;
import java.sql.*;
public class sql1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�������
		Connection ct=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//��������
			Class.forName("sun.jdbc.odbc.JdbcOdbcDeiver");
			//�õ�����
			ct=DriverManager.getConnection("");
			//����ps
			ps=ct.prepareStatement("select * from ����  where �ֶ�=?");
			//ps.set???(�ڼ����ʺţ�ֵ)
			ps.setInt(1, 2);
			//��ѯ���
			rs=ps.executeQuery();
			//ִ��
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

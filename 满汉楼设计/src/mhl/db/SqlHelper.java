/**
 * �����ݿ������
 */
package mhl.db;
import java.sql.*;
public class SqlHelper {
	//������Ҫ�Ķ���
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://127.0.0.1/RestaurantDB"
			+ "?useUnicode=true&characterEncoding=UTF-8";
	String user="root";
	String password="ROOT";
	//���캯��
	public SqlHelper(){
		try {
			//��������
			Class.forName(driver);
			//�õ�����
			ct=DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//�����ޡ�ɾ
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
	//��ѯ
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
	//�ر���Դ
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

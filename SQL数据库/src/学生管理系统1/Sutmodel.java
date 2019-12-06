package ѧ������ϵͳ1;
/**
 * 
 * @author ���ٻ�
 *
 */
import javax.swing.table.*;
import java.util.*;
import java.sql.*;
public class Sutmodel extends AbstractTableModel{
	Vector row,column;
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	//��������
	String driver="com.mysql.jdbc.Driver";
	//�������ݿ�
	String url="jdbc:mysql://127.0.0.1/pengyou"
			+ "?useUnicode=true&characterEncoding=UTF-8";
	//����Ա
	String user="root";
	String password="ROOT";
	public Sutmodel(String sql){
		this.inis(sql);
	}
	//���캯������ʼ������ģ��
	public Sutmodel() {
		this.inis("select * from pengyoubiao");
	}
	//����ɾ����
	public boolean Sutupdate(String sql,String[] paras){
		boolean b=true;
		try {
			//��������
			Class.forName(driver);
			//�õ�����
			ct=DriverManager.getConnection(url,user,password);
			//ִ��SQL���
			ps=ct.prepareStatement(sql);
			for(int i=0;i<paras.length;i++){
				ps.setString(i+1, paras[i]);
			}
			if(ps.executeUpdate()!=1){
				b=false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			b=false;
			e.printStackTrace();
		}finally{
			//�ر���Դ
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(ct!=null) ct.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return b;
	}
	//��ѯ
	public void inis(String sql){
		column=new Vector();
		//�ֶ�
		column.add("���");
		column.add("����");
		column.add("�Ա�");
		column.add("����");
		
		row=new Vector();
		try {
			//��������
			Class.forName(driver);
			//�õ�����
			ct=DriverManager.getConnection(url,user,password);
			//ִ��SQL���
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Vector hang=new Vector();
				hang.add(rs.getInt(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getInt(4));
				//���뵽rowdate
				row.add(hang);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//�ر���Դ
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(ct!=null) ct.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	//�õ����ж�����
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.row.size();
	}
	//�õ����ж�����
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.column.size();
	}
	//�õ�rowIndex(��)columnIndex(��)
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)this.row.get(rowIndex)).get(columnIndex);
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)this.column.get(column);
	}

}

package ѧ������ϵͳ2;
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
	SqlHelper sqlhelper=null;
	//����ɾ����
	public boolean Sutupdate(String sql,String[] paras){
		boolean b=true;
		sqlhelper=new SqlHelper();
		sqlhelper.UpdExcute(sql, paras);
		return b;
	}
	//��ѯ
	public void inis(String sql,String[] paras){
		column=new Vector();
		//�ֶ�
		column.add("���");
		column.add("����");
		column.add("�Ա�");
		column.add("����");
		
		row=new Vector();
		try {
			sqlhelper=new SqlHelper();
			ResultSet rs=sqlhelper.queryExcute(sql, paras);
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
			this.sqlhelper.Close();
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
	//�ֶ�����column
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)this.column.get(column);
	}

}

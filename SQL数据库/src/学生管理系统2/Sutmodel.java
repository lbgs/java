package 学生管理系统2;
/**
 * 
 * @author 王荣华
 *
 */
import javax.swing.table.*;
import java.util.*;
import java.sql.*;
public class Sutmodel extends AbstractTableModel{
	Vector row,column;
	SqlHelper sqlhelper=null;
	//增、删、改
	public boolean Sutupdate(String sql,String[] paras){
		boolean b=true;
		sqlhelper=new SqlHelper();
		sqlhelper.UpdExcute(sql, paras);
		return b;
	}
	//查询
	public void inis(String sql,String[] paras){
		column=new Vector();
		//字段
		column.add("编号");
		column.add("姓名");
		column.add("性别");
		column.add("年龄");
		
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
					//加入到rowdate
					row.add(hang);
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.sqlhelper.Close();
		}
	}
	//得到共有多少行
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.row.size();
	}
	//得到共有多少列
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.column.size();
	}
	//得到rowIndex(行)columnIndex(列)
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)this.row.get(rowIndex)).get(columnIndex);
	}
	//字段名称column
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)this.column.get(column);
	}

}

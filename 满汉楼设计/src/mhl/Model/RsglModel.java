/**
 * 人事管理表的界面
 */
package mhl.Model;
import java.sql.*;
import java.util.*;
import mhl.db.*;
import javax.swing.table.*;
public class RsglModel extends AbstractTableModel {
	SqlHelper sh=null;
	Vector row,column;
	//增、修、删信息
	public boolean iniscud(String sql,String[] paras){
		boolean b=true;
		sh=new SqlHelper();
		sh.cud(sql, paras);
		return b;
	}
	//查询人事表
	public void inischaxu(String sql,String[] paras){
		column=new Vector();
		row=new Vector();
		
		try {
			sh=new SqlHelper();
			ResultSet rs=sh.query(sql,paras);
			ResultSetMetaData rstm=rs.getMetaData();
			String[] Name={"员工号","姓名","性别","职位"};
			for(int i=0;i<rstm.getColumnCount();i++){
				this.column.add(Name[i]);
			}
			while(rs.next()){
				Vector hang=new Vector();
				for(int i=0;i<rstm.getColumnCount();i++){
					hang.add(rs.getString(i+1));
				}	
				row.add(hang);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.sh.Close();
		}
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.row.size();
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.column.size();
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)row.get(rowIndex)).get(columnIndex);
	}
	public String getColumnName(int column){
		return (String)this.column.get(column);
	}
	
}

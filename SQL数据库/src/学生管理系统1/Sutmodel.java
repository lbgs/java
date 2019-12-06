package 学生管理系统1;
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
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	//加载驱动
	String driver="com.mysql.jdbc.Driver";
	//连接数据库
	String url="jdbc:mysql://127.0.0.1/pengyou"
			+ "?useUnicode=true&characterEncoding=UTF-8";
	//管理员
	String user="root";
	String password="ROOT";
	public Sutmodel(String sql){
		this.inis(sql);
	}
	//构造函数，初始化数据模型
	public Sutmodel() {
		this.inis("select * from pengyoubiao");
	}
	//增、删、改
	public boolean Sutupdate(String sql,String[] paras){
		boolean b=true;
		try {
			//加载驱动
			Class.forName(driver);
			//得到连接
			ct=DriverManager.getConnection(url,user,password);
			//执行SQL语句
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
			//关闭资源
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
	//查询
	public void inis(String sql){
		column=new Vector();
		//字段
		column.add("编号");
		column.add("姓名");
		column.add("性别");
		column.add("年龄");
		
		row=new Vector();
		try {
			//加载驱动
			Class.forName(driver);
			//得到连接
			ct=DriverManager.getConnection(url,user,password);
			//执行SQL语句
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
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
			//关闭资源
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
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)this.column.get(column);
	}

}

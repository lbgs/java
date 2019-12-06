package 练习;
/**
 * 
 * @author 王荣华
 *
 */
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
public class Xinxi extends JFrame {
	Vector ve1,ve2;
	JTable jt=null;
	JScrollPane jsp=null;
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Xinxi xx=new Xinxi();
	}
	//构造函数
	public Xinxi(){
		//初始化
		ve1=new Vector();
		ve2=new Vector();
		//字段
				ve2.add("编号");
				ve2.add("姓名");
				ve2.add("性别");
				ve2.add("部门编号");
				ve2.add("职位");
				ve2.add("薪水");
				ve2.add("入职日期");
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//得到连接
			ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1/xinxi","root","ROOT");
			//执行SQL语句
			ps=ct.prepareStatement("select * from employee");
			rs=ps.executeQuery();
			//循环
			while(rs.next()){
				//行
				Vector hang=new Vector();
				hang.add(rs.getInt(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getInt(4));
				hang.add(rs.getString(5));
				hang.add(rs.getInt(6));
				hang.add(rs.getString(7));
				//加入到rowdate
				ve1.add(hang);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(ct!=null) ct.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		jt=new JTable(ve1,ve2);
		
		jsp=new JScrollPane(jt);
		
		this.add(jsp);
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

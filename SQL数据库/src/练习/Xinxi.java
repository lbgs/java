package ��ϰ;
/**
 * 
 * @author ���ٻ�
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
	//���캯��
	public Xinxi(){
		//��ʼ��
		ve1=new Vector();
		ve2=new Vector();
		//�ֶ�
				ve2.add("���");
				ve2.add("����");
				ve2.add("�Ա�");
				ve2.add("���ű��");
				ve2.add("ְλ");
				ve2.add("нˮ");
				ve2.add("��ְ����");
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//�õ�����
			ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1/xinxi","root","ROOT");
			//ִ��SQL���
			ps=ct.prepareStatement("select * from employee");
			rs=ps.executeQuery();
			//ѭ��
			while(rs.next()){
				//��
				Vector hang=new Vector();
				hang.add(rs.getInt(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getInt(4));
				hang.add(rs.getString(5));
				hang.add(rs.getInt(6));
				hang.add(rs.getString(7));
				//���뵽rowdate
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

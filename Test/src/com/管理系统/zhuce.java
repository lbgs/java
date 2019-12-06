package com.管理系统;
/**
 * 
 * @author 作者：王荣华
 * @date 日期：2017年7月26日下午4:45:36
 *
 */
import java.awt.*;
import javax.swing.*;
public class zhuce extends JFrame {
	JPanel jp[]=new JPanel[7];//面板组件
	JLabel jl[]=new JLabel[7];//标签组件
	JTextField jtf1,jtf2,jtf3;//文本框组件
	JButton jb1,jb2;//按钮
	JRadioButton jrb1,jrb2;//单选框组件
	ButtonGroup jbg;//单选按钮组组件
	JCheckBox jcb[]=new JCheckBox[4];//多选框组件
	JList l;//列表框组件
	JComboBox jc;//下拉框组件
	JScrollPane jfp1;//滚动窗体组件
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        zhuce zh=new zhuce();
	}
	public zhuce(){
		//创建组件
		for(int i=0;i<7;i++){
			jp[i]=new JPanel();
		}
		jl[0]=new JLabel(" 用户名：");
		jl[1]=new JLabel("真实姓名：");
		jl[2]=new JLabel("性别：");
		jl[3]=new JLabel("籍贯：");
		jl[4]=new JLabel("手机号码：");
		jl[5]=new JLabel("你喜欢的运动：");
		jl[6]=new JLabel("你喜欢的旅游地点：");
		
		jtf1=new JTextField(10);
		jtf2=new JTextField(10);
		jtf3=new JTextField(10);
		
		jrb1=new JRadioButton("男");
		jrb2=new JRadioButton("女");
		jbg=new ButtonGroup();
		jbg.add(jrb1);
		jbg.add(jrb2);
		
		String cb[]={"广州","深圳","东莞","佛山","中山"};
		jc=new JComboBox(cb);
		
		jcb[0]=new JCheckBox("篮球");
		jcb[1]=new JCheckBox("羽毛球");
		jcb[2]=new JCheckBox("足球");
		jcb[3]=new JCheckBox("爬山");
		
		String[] ls={"广州塔","长隆欢乐世界","欢乐谷","世界之窗","白云山",};
		l=new JList(ls);
		l.setVisibleRowCount(3);
		jfp1=new JScrollPane(l);
		
		jb1=new JButton("注册用户");
		jb2=new JButton("取消注册");
		
		//设置布局
		this.setLayout(new GridLayout(7,1));
		
		jp[0].add(jl[0]);
		jp[0].add(jtf1);
		jp[1].add(jl[1]);
		jp[1].add(jtf2);
		jp[2].add(jl[2]);
		jp[2].add(jrb1);
		jp[2].add(jrb2);
		jp[2].add(jl[3]);
		jp[2].add(jc);
		jp[3].add(jl[4]);
		jp[3].add(jtf3);
		jp[4].add(jl[5]);
		jp[4].add(jcb[0]);
		jp[4].add(jcb[1]);
		jp[4].add(jcb[2]);
		jp[4].add(jcb[3]);
		jp[5].add(jl[6]);
		jp[5].add(jfp1);
		jp[6].add(jb1);
		jp[6].add(jb2);
		
		this.add(jp[0]);
		this.add(jp[1]);
		this.add(jp[2]);
		this.add(jp[3]);
		this.add(jp[4]);
		this.add(jp[5]);
		this.add(jp[6]);
		
		this.setTitle("注册");
		this.setSize(350,500);
		this.setLocation(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//this.setResizable(false);
	}

}

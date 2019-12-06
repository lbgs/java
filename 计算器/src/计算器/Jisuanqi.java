package 计算器;
/**
 * 
 * @author 王荣华
 * 功能：计算器
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Jisuanqi extends JFrame implements ActionListener{
	JPanel jpl[]=null;
	JButton jb[]=null;
	MyPanel mpl=null;
	Tmp tmps=new Tmp();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jisuanqi jsq=new Jisuanqi();
	}
	public Jisuanqi(){
		//创建组件
		mpl=new MyPanel(0,"");
		jpl=new JPanel[5];
		for(int i=0;i<5;i++){
			jpl[i]=new JPanel();
		}
		jb=new JButton[19];
		for(int i=1;i<=9;i++){
			jb[i]=new JButton(String.valueOf(i));
		}
		jb[0]=new JButton("0");
		jb[10]=new JButton("+");
		jb[11]=new JButton("c");
		jb[12]=new JButton("-");
		jb[13]=new JButton("±");
		jb[14]=new JButton("×");
		jb[15]=new JButton("=");
		jb[16]=new JButton(".");
		jb[17]=new JButton("÷");
		jb[18]=new JButton("=");
		//设置布局
		jpl[1].setLayout(new GridLayout(4,1,10,10));
		//添加组件
		jpl[1].add(jb[1]);
		jpl[1].add(jb[2]);
		jpl[1].add(jb[3]);
		jpl[1].add(jb[10]);
		jpl[1].add(jb[11]);
		jpl[1].add(jb[4]);
		jpl[1].add(jb[5]);
		jpl[1].add(jb[6]);
		jpl[1].add(jb[12]);
		jpl[1].add(jb[13]);
		jpl[1].add(jb[7]);
		jpl[1].add(jb[8]);
		jpl[1].add(jb[9]);
		jpl[1].add(jb[14]);
		jpl[1].add(jb[15]);
		jpl[1].add(jb[0]);
		jpl[1].add(jb[16]);
		jpl[1].add(jb[17]);
		jpl[1].add(jb[18]);
		//注册监听
		for(int i=0;i<19;i++){
			jb[i].addActionListener(this);
		}
		for(int i=0;i<=9;i++){
			jb[i].setActionCommand(i+"");
		}
		jb[10].setActionCommand("+");
		jb[11].setActionCommand("c");
		//组件添加到窗体
		this.add(mpl,BorderLayout.CENTER);
		this.add(jpl[1],BorderLayout.SOUTH);
		//设置窗体
		this.setTitle("计算器");
		this.setSize(300,250);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("0")){
			this.remove(mpl);
			mpl=new MyPanel(0,"");
			this.add(mpl);
			this.setVisible(true);
		}else if(e.getActionCommand().equals("1")){
			this.remove(mpl);
			mpl=new MyPanel(1,"");
			this.add(mpl);
			this.setVisible(true);
		}else if(e.getActionCommand().equals("2")){
			this.remove(mpl);
			mpl=new MyPanel(2,"");
			this.add(mpl);
			this.setVisible(true);
		}else if(e.getActionCommand().equals("3")){
			this.remove(mpl);
			mpl=new MyPanel(3,"");
			this.add(mpl);
			this.setVisible(true);
		}else if(e.getActionCommand().equals("4")){
			this.remove(mpl);
			mpl=new MyPanel(4,"");
			this.add(mpl);
			this.setVisible(true);
		}else if(e.getActionCommand().equals("5")){
			this.remove(mpl);
			mpl=new MyPanel(5,"");
			this.add(mpl);
			this.setVisible(true);
		}else if(e.getActionCommand().equals("6")){
			this.remove(mpl);
			mpl=new MyPanel(6,"");
			this.add(mpl);
			this.setVisible(true);
		}else if(e.getActionCommand().equals("7")){
			this.remove(mpl);
			mpl=new MyPanel(7,"");
			this.add(mpl);
			this.setVisible(true);
		}else if(e.getActionCommand().equals("8")){
			this.remove(mpl);
			mpl=new MyPanel(8,"");
			this.add(mpl);
			this.setVisible(true);
		}else if(e.getActionCommand().equals("9")){
			this.remove(mpl);
			mpl=new MyPanel(9,"");
			this.add(mpl);
			this.setVisible(true);
		}else if(e.getActionCommand().equals("c")){
			this.remove(mpl);
			mpl=new MyPanel(0,"");
			tmps.setSs(0);
			tmps.setAaa("");
			this.add(mpl);
			this.setVisible(true);
		}else if(e.getActionCommand().equals("+")){
			this.remove(mpl);
			mpl=new MyPanel(mpl.getSun(),"+");
			tmps.setSs(mpl.getSun());
			tmps.setAaa("+");
			this.add(mpl);
			this.setVisible(true);
		}else if(e.getActionCommand().equals("-")){
			this.remove(mpl);
			mpl=new MyPanel(mpl.getSun(),"-");
			tmps.setSs(mpl.getSun());
			tmps.setAaa("-");
			this.add(mpl);
			this.setVisible(true);
		}
		else if(e.getActionCommand().equals("=")){
			this.remove(mpl);
			if(tmps.getAaa().equals("+")){
				mpl=new MyPanel(mpl.getSun()+tmps.getSs(),"=");
			}else if(tmps.getAaa().equals("-")){
				System.out.println(mpl.getSun()+" "+tmps.getSs());
				mpl=new MyPanel(tmps.getSs()-mpl.getSun(),"=");
			}
			this.add(mpl);
			this.setVisible(true);
		}
	}

}
class MyPanel extends JPanel{
	int sun=0;
	String aaa="";
	public MyPanel(int sun,String aaa){
		this.sun=sun;
		this.aaa=aaa;
	}
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(new Color(255,255,255));
		g.fill3DRect(10, 10, 260, 50, false);
		g.setColor(new Color(255,255,255));
		g.setFont(new Font("华为楷体",Font.BOLD,30));
		g.drawString(sun+"", 250,55);
		g.drawString(this.aaa, 12,58);

	}
	public int getSun() {
		return sun;
	}
	public void setSun(int sun) {
		this.sun = sun;
	}
	public String getAaa() {
		return aaa;
	}
	public void setAaa(String aaa) {
		this.aaa = aaa;
	}
}
class Tmp{
	int ss=0;
	String aaa="";
	public String getAaa() {
		return aaa;
	}

	public void setAaa(String aaa) {
		this.aaa = aaa;
	}

	public int getSs() {
		return ss;
	}

	public void setSs(int ss) {
		this.ss = ss;
	}
	
}
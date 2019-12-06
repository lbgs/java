package com.练习;
/**
 * 
 * @author 王荣华
 *
 */
import java.util.*;
public class Demo1_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList aa=new ArrayList();
        Hzadmin emp=new Hzadmin();
        Scanner q=new Scanner(System.in);
        while(true){
        	System.out.println("1、添加一个猴子");
        	System.out.println("2、查找一个猴子");
        	System.out.println("0、退出");
        	String a=q.next();
        	if(a.equals("1")){
        		System.out.print("请输入猴子的名字：");
                String name=q.next();
                System.out.print("请输入猴子的身高：");
                float g=q.nextFloat();
                Hz em=new Hz(name,g);
                emp.addHz(em);
        	}else if(a.equals("2")){
        		System.out.print("请输入猴子的名字：");
        		String cha=q.next();
        		emp.setName(cha);
        	}else if(a.equals("0")){
        		System.out.println("已退出！");
        		System.exit(0);
        	}       	
        }
        
	}

}
//猴子管理
class Hzadmin{
	private ArrayList cc;
	private String name;
	public void setName(String name){ 
		this.name=name;
	}
	public Hzadmin(){
		cc=new ArrayList();
	}
	public void addHz(Hz hz){
		cc.add(hz);
	}
	public void showinfo(){
		for(int i=0;i<cc.size();i++){
			Hz ds=(Hz)cc.get(i);
			System.out.println("名字："+ds.getName()+" 身高："+ds.getG());
		}
	}
	public void chazhao(String name){
		name=this.name;
		for(int i=0;i<cc.size();i++){
			Hz ds=(Hz)cc.get(i);
	       	if((ds.getName()).equals(name)){
				System.out.println("姓名："+ds.getName()+" 身高："+ds.getG());
			}
		}
	}
}
//定义一个猴子类
class Hz{
	private String name;
	private float g;
	public Hz(String name,float g){
		this.name=name;
		this.g=g;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getG() {
		return g;
	}
	public void setG(float g) {
		this.g = g;
	}
	
	
}
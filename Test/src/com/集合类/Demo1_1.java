/**
 * 功能：java中的集合 arraylist
 */
package com.集合类;
import java.util.*;
public class Demo1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建ArrayList对象
		ArrayList array=new ArrayList();
		//创建员工对象
		Yg ys1=new Yg("c001","成龙",60,10000);
		Yg ys2=new Yg("c002","李连杰",50,9000);
		Yg ys3=new Yg("c003","李小龙",32,5000);
		//将员工加入array中
		array.add(ys1);
		array.add(ys2);
		array.add(ys3);
		array.add(ys2);
		//循环输出员工的信息
		for(int i=0;i<array.size();i++){
			Yg a1=(Yg)array.get(i);
			//显示每个员工的信息
			System.out.print("员工号"+a1.getNo()+"\t姓名："+a1.getName()+"\t年龄："+
			a1.getAvg()+"\t工资："+a1.getSal()+"\n");
		}
		//删除一个员工
		array.remove(3);
		System.out.println("更新后的数据");
		//循环输出员工的信息
		for(int i=0;i<array.size();i++){
			Yg a1=(Yg)array.get(i);
			//显示每个员工的信息
			System.out.print("员工号"+a1.getNo()+"\t姓名："+a1.getName()+"\t年龄："+
			a1.getAvg()+"\t工资："+a1.getSal()+"\n");
		}
		
	}
}
//定义一个员工类
class Yg{
	private String No;
	private String name;
	private int avg;
	private float sal;
	public  Yg(String No,String string, int i, float j) {
		// TODO Auto-generated constructor stub
		this.No=No;
		this.name=string;
		this.avg=i;
		this.sal=j;
	}
	public String getNo(){
		return No;
	}
	public void setNo(String No){
		this.No=No;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}

}

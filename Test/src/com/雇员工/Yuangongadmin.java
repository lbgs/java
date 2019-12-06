package com.雇员工;
/**
 * 
 * @author 王荣华
 *
 */
import java.util.*;
public class Yuangongadmin {
	ArrayList ll;
	public Yuangongadmin(){
		ll=new ArrayList();
	}
	//1、添加一个员工
	public void addEmp(Yuangong emp){
        ll.add(emp);
        System.out.println("添加成功");
	}
	//2、查看一个员工信息
	public void showinfo(String empNo){
		//遍历整个ArrayList
		for(int i=0;i<ll.size();i++){
			//取出Yuangong对象
			Yuangong emp=(Yuangong)ll.get(i);
			if(emp.getEmpNO().equals(empNo)){
				System.out.println("员工信息：" );
				System.out.println("员工编号："+empNo);
				System.out.println("员工姓名："+emp.getName());
				System.out.println("员工工资："+emp.getSal());			}
		}
	}
    //3、查看所有员工的信息
	public void show(){
		System.out.println("员工编号"+"\t员工姓名"+"\t员工工资");
		for(int i=0;i<ll.size();i++){
			Yuangong emp=(Yuangong)ll.get(i);
			System.out.println(emp.getEmpNO()+"\t"+emp.getName()+"\t"+emp.getSal());
		}
	}
    //4、修改指定员工工资
	public void update(String empNo,float sal){
		for(int i=0;i<ll.size();i++){
			Yuangong emp=(Yuangong)ll.get(i);
			if(emp.getEmpNO().equals(empNo)){
				emp.setSal(sal);
				System.out.println("修改成功");
			}
		}
	}
	//5、删除指定员工
	public void delEmp(String empNo){
		for(int i=0;i<ll.size();i++){
			Yuangong emp=(Yuangong)ll.get(i);
			if(emp.getEmpNO().equals(empNo)){
				ll.remove(i);
				System.out.println("删除成功");
			}
		}
	}
    //6、按工资从低到高排序
	public void srto(Yuangong arr[]){
	    int tmp;
	    for(int i=0;i<arr.length-1;i++){
	    	float min=arr[i].getSal();
	    	int w=i;
	    	for(int j=0;j<arr.length;j++){
	    		if(min<arr[j].getSal()){
	    			min=arr[j].getSal();
	    			w=j;
	    		}
	    	}
	    	System.out.println(min);
	    }
	}
	//7、统计平均工资、最低工资、最高工资
	public void avg(){
		float sun=0;
		Yuangong emp=(Yuangong)ll.get(0);
		float max=emp.getSal();
		float min=emp.getSal();
		for(int i=0;i<ll.size();i++){
			emp=(Yuangong)ll.get(i);
			sun+=emp.getSal();
			if(max>emp.getSal()){
				max=emp.getSal();
			}
			if(min<emp.getSal()){
				min=emp.getSal();
			}
		}
		System.out.println("平均工资："+(sun/ll.size()));
		System.out.println("最高工资："+max);
		System.out.println("平均工资："+min);
	}
}

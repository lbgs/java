package com.练习;
/**
 * 作者：荣华
 */
import java.util.*;
public class Demo1_1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList arr=new ArrayList();
        Ceshi ls1=new Ceshi("aa",3);
        Ceshi ls2=new Ceshi("bb",5);
        arr.add(ls1);
        arr.add(ls2);
        System.out.println("排序后");
        for(int i=0;i<arr.size();i++){
        	Ceshi emp=(Ceshi)arr.get(i);
        	System.out.println(emp.getName()+"  "+emp.getAge());
        }
	}
	
}
class Ceshi{
	private String name;
	private int age;
	public Ceshi(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

/*class Sc{
	public static void sortins(List list){
		Collections.sort(list, new Comparator);{
	public int compare(Object o1,Object o2){
		Ceshi cs1=(Ceshi)o1;
		Ceshi cs2=(Ceshi)o1;
		if(cs1.getAge()>cs2.getAge()){
			return 1;
		}else if(cs1.getAge()==cs2.getAge()){
			return 0;
		}else{
			return -1;
		}
	}
		}
	}
}*/

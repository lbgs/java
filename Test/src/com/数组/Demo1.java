/**
*���ߣ�ronghua
*���ܣ��������
*/
package com.����;
import java.util.*;
public class Demo1{
	public static void main(String args[]){
		Dog dogs[]=new Dog[5];
		Scanner q=new Scanner(System.in);
        float sun=0;
		for(int i=0;i<dogs.length;i++){
			dogs[i]=new Dog();
    		System.out.print("�������"+(i+1)+"���������֣�");
    		String name=q.next();
			dogs[i].setName(name);
			System.out.print("�������"+(i+1)+"���������أ�");
			float weight=q.nextFloat();
			dogs[i].setWeight(weight);
		}
		for(int i=0;i<dogs.length;i++){
			sun+=dogs[i].getWeight();
			System.out.println(dogs[i].getName()+"\t"+dogs[i].getWeight()+"kg");
		}
		System.out.println("�����أ�"+sun+"kg\tƽ�����أ�"+(sun/dogs.length)+"kg");	
	}
}
class Dog{
	private String name;
	private float weight;
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	public void setWeight(float weight){
		this.weight=weight;
	}
	public float getWeight(){
		return this.weight;
	}
}
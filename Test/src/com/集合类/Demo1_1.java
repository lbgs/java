/**
 * ���ܣ�java�еļ��� arraylist
 */
package com.������;
import java.util.*;
public class Demo1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����ArrayList����
		ArrayList array=new ArrayList();
		//����Ա������
		Yg ys1=new Yg("c001","����",60,10000);
		Yg ys2=new Yg("c002","������",50,9000);
		Yg ys3=new Yg("c003","��С��",32,5000);
		//��Ա������array��
		array.add(ys1);
		array.add(ys2);
		array.add(ys3);
		array.add(ys2);
		//ѭ�����Ա������Ϣ
		for(int i=0;i<array.size();i++){
			Yg a1=(Yg)array.get(i);
			//��ʾÿ��Ա������Ϣ
			System.out.print("Ա����"+a1.getNo()+"\t������"+a1.getName()+"\t���䣺"+
			a1.getAvg()+"\t���ʣ�"+a1.getSal()+"\n");
		}
		//ɾ��һ��Ա��
		array.remove(3);
		System.out.println("���º������");
		//ѭ�����Ա������Ϣ
		for(int i=0;i<array.size();i++){
			Yg a1=(Yg)array.get(i);
			//��ʾÿ��Ա������Ϣ
			System.out.print("Ա����"+a1.getNo()+"\t������"+a1.getName()+"\t���䣺"+
			a1.getAvg()+"\t���ʣ�"+a1.getSal()+"\n");
		}
		
	}
}
//����һ��Ա����
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

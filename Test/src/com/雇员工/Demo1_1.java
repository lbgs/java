/**
 * ���ܣ�Ա������
 */
package com.��Ա��;
import java.util.*;
public class Demo1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner q=new Scanner(System.in);
		Yuangongadmin admin=new Yuangongadmin();
		Yuangong emp1=new Yuangong("cs001","����",15000);
		Yuangong emp2=new Yuangong("cs002","��С��",20000);
		Yuangong emp3=new Yuangong("cs004","������",10000);
		Yuangong emp4=new Yuangong("cs005","���",18000);
		admin.addEmp(emp1);
		admin.addEmp(emp2);
		admin.addEmp(emp3);
		admin.addEmp(emp4);
		System.out.println("admin��"+admin.ll);
		while(true){
			System.out.println("����������ѡ����Ҫ���еĲ�����");
			System.out.println("1�����һ��Ա��");
			System.out.println("2���鿴һ��Ա����Ϣ");
			System.out.println("3���鿴����Ա����Ϣ");
			System.out.println("4���޸�һ��Ա���Ĺ���");
			System.out.println("5��ɾ��һ��Ա��");
			System.out.println("6������Ա����нˮ�ӵ͵�������");
			System.out.println("7���鿴Ա����ƽ�����ʡ���͹��ʡ���߹���");
			System.out.println("8���˳�Ա������ϵͳ");
			int a=q.nextInt();
			if(a==1){
				System.out.println("������Ա����ţ�");
				String v=q.next();
				System.out.println("������Ա��������");
				String name=q.next();
				System.out.println("������Ա�����ʣ�");
				float sal=q.nextFloat();
				Yuangong emp=new Yuangong(v,name,sal);
				admin.addEmp(emp);
			}else if(a==2){
				System.out.println("������Ա���ı�ţ�");
				String empNo=q.next();
				admin.showinfo(empNo);
			}else if(a==3){
				admin.show();
			}else if(a==4){
				System.out.println("������Ա����ţ�");
				String empNo=q.next();
				System.out.println("�������¹��ʣ�");
				float sal=q.nextFloat();
				admin.update(empNo, sal);
			}else if(a==5){
				System.out.println("������Ա����ţ�");
				String empNo=q.next();
				admin.delEmp(empNo);
			}else if(a==6){
				admin.srto(null);
			}else if(a==7){
				admin.avg();
			}else if(a==8){
				System.out.println("�˳�Ա������ϵͳ");
				System.exit(0);
			}else{
				System.out.println("����������������룡");
			}
		}
	}

}

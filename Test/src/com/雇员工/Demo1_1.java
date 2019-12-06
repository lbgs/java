/**
 * 功能：员工管理
 */
package com.雇员工;
import java.util.*;
public class Demo1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner q=new Scanner(System.in);
		Yuangongadmin admin=new Yuangongadmin();
		Yuangong emp1=new Yuangong("cs001","成龙",15000);
		Yuangong emp2=new Yuangong("cs002","李小龙",20000);
		Yuangong emp3=new Yuangong("cs004","李连杰",10000);
		Yuangong emp4=new Yuangong("cs005","洪金宝",18000);
		admin.addEmp(emp1);
		admin.addEmp(emp2);
		admin.addEmp(emp3);
		admin.addEmp(emp4);
		System.out.println("admin："+admin.ll);
		while(true){
			System.out.println("请输入数字选择你要进行的操作：");
			System.out.println("1、添加一个员工");
			System.out.println("2、查看一个员工信息");
			System.out.println("3、查看所以员工信息");
			System.out.println("4、修改一个员工的工资");
			System.out.println("5、删除一个员工");
			System.out.println("6、所有员工的薪水从低到高排序");
			System.out.println("7、查看员工的平均工资、最低工资、最高工资");
			System.out.println("8、退出员工管理系统");
			int a=q.nextInt();
			if(a==1){
				System.out.println("请输入员工编号：");
				String v=q.next();
				System.out.println("请输入员工姓名：");
				String name=q.next();
				System.out.println("请输入员工工资：");
				float sal=q.nextFloat();
				Yuangong emp=new Yuangong(v,name,sal);
				admin.addEmp(emp);
			}else if(a==2){
				System.out.println("请输入员工的编号：");
				String empNo=q.next();
				admin.showinfo(empNo);
			}else if(a==3){
				admin.show();
			}else if(a==4){
				System.out.println("请输入员工编号：");
				String empNo=q.next();
				System.out.println("请输入新工资：");
				float sal=q.nextFloat();
				admin.update(empNo, sal);
			}else if(a==5){
				System.out.println("请输入员工编号：");
				String empNo=q.next();
				admin.delEmp(empNo);
			}else if(a==6){
				admin.srto(null);
			}else if(a==7){
				admin.avg();
			}else if(a==8){
				System.out.println("退出员工管理系统");
				System.exit(0);
			}else{
				System.out.println("输入错误，请重新输入！");
			}
		}
	}

}

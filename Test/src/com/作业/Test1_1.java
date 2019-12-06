package com.作业;
/**
 * 
 * @author 王荣华
 *功能：学生成绩
 */
import java.util.*;
public class Test1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner q=new Scanner(System.in);
		int size=10;
        float[] arr=new float[size];
        try {
        	for(int i=0;i<arr.length;i++){
            	System.out.print("第"+(i+1)+"个学生成绩：");
            	arr[i]=q.nextFloat();
            	}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("输入错误   "+e.getMessage());
		}
        Run emp=new Run(arr);
        
	}

}
//学生成绩管理系统
class Run{
	public Run(float[] arr){
		Scanner q=new Scanner(System.in); 
		while(true){
	        	System.out.println("1、查看学生成绩");
	        	System.out.println("2、查看学生学号");
	        	System.out.println("3、统计各个分数阶段的学生人数");
	        	System.out.println("4、删除学生成绩");
	        	System.out.println("5、查看所有学生的成绩");
	        	System.out.println("6、退出学生成绩管理系统");
	        	try {
	        		System.out.print("请输入序号：");
	        		int a=q.nextInt();
	        		if(a==1){
	        			System.out.print("请输入学号：");
	        			int s=q.nextInt();
	        			for(int i=0;i<arr.length;i++){
	        				if((i+1)==s){
	        					System.out.println("成绩："+arr[i]);
	        				}
	        			}
	        		}else if(a==2){
	        			System.out.print("请输入学生成绩：");
	        			float s=q.nextFloat();
	        			for(int i=0;i<arr.length;i++){
	        				if(arr[i]==s){
	        					System.out.println("学号："+(i+1));
	        				}
	        			}
	        		}else if(a==3){
	        		    int[] array=new int[5];
	        		    for(int i=0;i<arr.length;i++){
	        			   if(arr[i]>=90){
	        				   //优的学生
	        				   array[0]++; 
	        			   }else if(arr[i]>=80){
	        				   //良的学生
	        				   array[1]++;
	        			   }else if(arr[i]>=70){
	        				   //中的学生
	        				   array[2]++;
	        			   }else if(arr[i]>=60){
	        				   //差的学生
	        				   array[3]++;
	        			   }else{
	        				   //不及格的学生
	        				   array[4]++;
	        			   }
	        		   }
	        		    System.out.println("成绩优的学生有"+array[0]+"个");
	        		    System.out.println("成绩良的学生有"+array[1]+"个");
	        		    System.out.println("成绩中的学生有"+array[2]+"个");
	        		    System.out.println("成绩差的学生有"+array[3]+"个");
	        		    System.out.println("成绩不及格的学生有"+array[4]+"个");
	        		}else if(a==4){
	        			System.out.print("请输入学号：");
	        			int s=q.nextInt();
	        			for(int i=0;i<arr.length;i++){
	        				if((i+1)==s){
	        					arr[i]=0;
	        					System.out.println("删除成功");
	        				}
	        			}
	        		}else if(a==5){
	        			for(int i=0;i<arr.length;i++){
	        				System.out.println((i+1)+"学号的成绩："+arr[i]);
	        			}
	        		}else if(a==6){
	        			System.out.println("已退出");
	        			System.exit(0);
	        		}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("输入错误     "+e.getMessage());
				}
	        }
	}
}
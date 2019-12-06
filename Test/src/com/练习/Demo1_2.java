package com.练习;
/**
 * 
 * @author 王荣华
 *
 */
import java.util.*;
public class Demo1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         
	    Scanner q=new Scanner(System.in);
	    System.out.println("中英文翻译");
	    while(true){
		    System.out.println("1、中文→英文");
		    System.out.println("2、英文→中文");
		    System.out.println("0、退出");
		    System.out.print("请选择数字：");
		    int a=q.nextInt();
		    if(a==1){
		    	System.out.print("请输入中文：");
		    	String s=q.next();
		    	System.out.print("英文是：");
		    	if(s.equals("类")){
		    		System.out.println("class");
		    	}else if(s.equals("公有的")){
		    		System.out.println("public");
		    	}else if(s.equals("私有的")){
		    		System.out.println("private");
		    	}else if(s.equals("继承")){
		    		System.out.println("extends");
		    	}
		    }else if(a==2){
		    	System.out.print("请输入英文:");
		    	String s=q.next();
		    	System.out.print("中文是：");		    	
		    	if(s.equals("int")){
		    		System.out.println("整数");
		    	}else if(s.equals("double")){
		    		System.out.println("双浮点数");
		    	}else if(s.equals("float")){
		    		System.out.println("单浮点数");
		    	}
		    }else if(a==0){
		    	System.out.println("退出翻译");
		    	System.exit(0);
		    }else{
		    	System.out.println("输入错误，请重新输入");
		    }
	    }
	}

}

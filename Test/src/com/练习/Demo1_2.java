package com.��ϰ;
/**
 * 
 * @author ���ٻ�
 *
 */
import java.util.*;
public class Demo1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         
	    Scanner q=new Scanner(System.in);
	    System.out.println("��Ӣ�ķ���");
	    while(true){
		    System.out.println("1�����ġ�Ӣ��");
		    System.out.println("2��Ӣ�ġ�����");
		    System.out.println("0���˳�");
		    System.out.print("��ѡ�����֣�");
		    int a=q.nextInt();
		    if(a==1){
		    	System.out.print("���������ģ�");
		    	String s=q.next();
		    	System.out.print("Ӣ���ǣ�");
		    	if(s.equals("��")){
		    		System.out.println("class");
		    	}else if(s.equals("���е�")){
		    		System.out.println("public");
		    	}else if(s.equals("˽�е�")){
		    		System.out.println("private");
		    	}else if(s.equals("�̳�")){
		    		System.out.println("extends");
		    	}
		    }else if(a==2){
		    	System.out.print("������Ӣ��:");
		    	String s=q.next();
		    	System.out.print("�����ǣ�");		    	
		    	if(s.equals("int")){
		    		System.out.println("����");
		    	}else if(s.equals("double")){
		    		System.out.println("˫������");
		    	}else if(s.equals("float")){
		    		System.out.println("��������");
		    	}
		    }else if(a==0){
		    	System.out.println("�˳�����");
		    	System.exit(0);
		    }else{
		    	System.out.println("�����������������");
		    }
	    }
	}

}

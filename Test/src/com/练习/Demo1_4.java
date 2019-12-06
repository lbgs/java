package com.练习;
/**
 * 
 * @author 王荣华
 *
 */
import java.io.*;
import java.util.*;
public class Demo1_4 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		//字符流输入
        InputStreamReader br=new InputStreamReader(System.in);
        BufferedReader q=new BufferedReader(br);
        Scanner s=new Scanner(System.in);
        try {
        	System.out.print("请输入：");
        	String a=q.readLine();
        	System.out.println(a);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        String f=s.next();
        System.out.println(f);
	}

}

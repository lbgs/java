package com.��ϰ;
/**
 * 
 * @author ���ٻ�
 *
 */
import java.io.*;
import java.util.*;
public class Demo1_4 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		//�ַ�������
        InputStreamReader br=new InputStreamReader(System.in);
        BufferedReader q=new BufferedReader(br);
        Scanner s=new Scanner(System.in);
        try {
        	System.out.print("�����룺");
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

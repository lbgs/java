package com.�쳣;
/**
 * 
 * @author ���ٻ�
 *
 */
import java.io.*;
public class Demo1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fe;
		try {
			fe=new FileReader("F:\\aa.txt");
		} catch (Exception e) {
			System.out.println("����Ϊ��"+e.getMessage());
			//e.printStackTrace();
		}finally {
			System.out.println("ok");
		}
	}

}

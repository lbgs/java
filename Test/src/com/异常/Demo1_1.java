package com.异常;
/**
 * 
 * @author 王荣华
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
			System.out.println("错误为："+e.getMessage());
			//e.printStackTrace();
		}finally {
			System.out.println("ok");
		}
	}

}

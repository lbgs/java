package com.io;
/**
 * 
 * @author 王荣华
 * 功能：字符拷贝文件
 */
import java.io.*;
public class Text3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//定义字符输入流
		FileReader fr=null;
		//定义字符输出流
		FileWriter fw=null;
		try {
			//创建字符输入流
			fr=new FileReader("f:/ss.txt");
			//创建字符输出流
			fw=new FileWriter("e:/China.txt");
			//定义一个字符数组
			char chars[]=new char[1024];
			//定义实际字符长度
			int n=0;
			//循环
			while((n=fr.read(chars))!=-1){
				//拷贝到指定路径（输出流）
				fw.write(chars, 0, n);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				fr.close();
				fw.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

}

package com.io;
/**
 * 
 * @author 王荣华
 * 功能：字节流拷贝文件
 */
import java.io.*;
public class Text2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建字节输入流
		FileInputStream ft=null;
		//创建字节输出流
		FileOutputStream fo=null;
		try {
			ft=new FileInputStream("f:/ss.txt");
			//拷贝文件到指定路径
			fo=new FileOutputStream("e:/中国.txt");
			//定义字节数组
			byte bytes[]=new byte[1024];
			//定义实际字节数
			int n=0;
			//循环
			while((n=ft.read(bytes))!=-1){
				//输出流
				fo.write(bytes, 0, n);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				ft.close();
				fo.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();			}
		}
	}

}

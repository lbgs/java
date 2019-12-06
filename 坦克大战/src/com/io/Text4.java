package com.io;
/**
 * 
 * @author 王荣华
 * 功能：字符缓存
 */
import java.io.*;
public class Text4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//定义
		BufferedReader br=null;
		BufferedWriter bw=null;
		try {
			//先创建FileReader
			FileReader fr=new FileReader("f:/ss.txt");
			br=new BufferedReader(fr);
			//创建FileWriter
			FileWriter fw=new FileWriter("e:/Holle.txt");
			bw=new BufferedWriter(fw);
			//定义实际字符数
			String s="";
			while((s=br.readLine())!=null){
				bw.write(s+"\r\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				br.close();
				bw.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

}

package com.io;
/**
 * 
 * @author ���ٻ�
 * ���ܣ��ַ�����
 */
import java.io.*;
public class Text4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����
		BufferedReader br=null;
		BufferedWriter bw=null;
		try {
			//�ȴ���FileReader
			FileReader fr=new FileReader("f:/ss.txt");
			br=new BufferedReader(fr);
			//����FileWriter
			FileWriter fw=new FileWriter("e:/Holle.txt");
			bw=new BufferedWriter(fw);
			//����ʵ���ַ���
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

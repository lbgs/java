package com.io;
/**
 * 
 * @author ���ٻ�
 * ���ܣ��ַ������ļ�
 */
import java.io.*;
public class Text3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�����ַ�������
		FileReader fr=null;
		//�����ַ������
		FileWriter fw=null;
		try {
			//�����ַ�������
			fr=new FileReader("f:/ss.txt");
			//�����ַ������
			fw=new FileWriter("e:/China.txt");
			//����һ���ַ�����
			char chars[]=new char[1024];
			//����ʵ���ַ�����
			int n=0;
			//ѭ��
			while((n=fr.read(chars))!=-1){
				//������ָ��·�����������
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

package com.io;
/**
 * 
 * @author ���ٻ�
 * ���ܣ��ֽ��������ļ�
 */
import java.io.*;
public class Text2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�����ֽ�������
		FileInputStream ft=null;
		//�����ֽ������
		FileOutputStream fo=null;
		try {
			ft=new FileInputStream("f:/ss.txt");
			//�����ļ���ָ��·��
			fo=new FileOutputStream("e:/�й�.txt");
			//�����ֽ�����
			byte bytes[]=new byte[1024];
			//����ʵ���ֽ���
			int n=0;
			//ѭ��
			while((n=ft.read(bytes))!=-1){
				//�����
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

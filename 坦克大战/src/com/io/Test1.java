package com.io;
import java.awt.List;
/**
 * 
 * @author ���ٻ�
 *
 */
import java.io.*;
public class Test1 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		//����һ���ļ�����
		File f=new File("f:/aa.txt");
		//�ļ�·��
		System.out.println("�ļ�·����"+f.getAbsolutePath());
		//�ļ���С
		System.out.println("�ļ���С��"+f.length());
		//�ļ�����
		System.out.println("�ļ��ɶ��ԣ�"+f.getName());
		//�ļ��ɶ���
		System.out.println(f.canRead());
		//�ж��ļ��Ƿ����
		if(!f.exists()){
			try {
				//�����ļ�
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("�ļ��Ѵ��ڣ����ܴ���");
		}
		File fi=new File("f:/aa");
		//�ж��ļ����Ƿ����
		if(!fi.isDirectory()){
			//�����ļ���
			fi.mkdir();
		}else{
			System.out.println("�ļ����Ѵ��ڣ����ܴ���");
		} 	
		File f2=new File("f:/aa");
		if(f2.isDirectory()){
			//�鿴ָ��Ŀ¼�������ļ�
			File aa[]=f2.listFiles();
			for(int i=0;i<aa.length;i++){
				//�ļ�����
				System.out.println("���ƣ�"+f2.getName());
			}
		}
		//�����ֽ�����������
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(f);
			//����һ���ֽ����飬�൱�ڻ���
			byte bytes[]=new byte[1024];
			//�õ�ʵ�ʶ�ȡ�����ֽ���
			int n=0;
			//ѭ����ȡ
			while((n=fis.read(bytes))!=-1){
				//�ֽ�ת��Ϊ�ַ���
				String s=new String(bytes,0,n);
				System.out.println("�ļ����ݣ�"+s);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				//�ļ�����ر�
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		File fie=new File("f:/ss.txt");
		//�����ֽ����������
		FileOutputStream fio=null;
		try {
			fio=new FileOutputStream(fie);
			//����:\r\n
			String s=new String("�й������ã�\r\n");
			String s1=new String("china,heoll!");
			fio.write(s.getBytes());
			fio.write(s1.getBytes());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				fio.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

}

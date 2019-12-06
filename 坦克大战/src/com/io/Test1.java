package com.io;
import java.awt.List;
/**
 * 
 * @author 王荣华
 *
 */
import java.io.*;
public class Test1 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		//创建一个文件对象
		File f=new File("f:/aa.txt");
		//文件路径
		System.out.println("文件路径："+f.getAbsolutePath());
		//文件大小
		System.out.println("文件大小："+f.length());
		//文件名称
		System.out.println("文件可读性："+f.getName());
		//文件可读性
		System.out.println(f.canRead());
		//判断文件是否存在
		if(!f.exists()){
			try {
				//创建文件
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("文件已存在，不能创建");
		}
		File fi=new File("f:/aa");
		//判断文件夹是否存在
		if(!fi.isDirectory()){
			//创建文件夹
			fi.mkdir();
		}else{
			System.out.println("文件夹已存在，不能创建");
		} 	
		File f2=new File("f:/aa");
		if(f2.isDirectory()){
			//查看指定目录的所有文件
			File aa[]=f2.listFiles();
			for(int i=0;i<aa.length;i++){
				//文件名称
				System.out.println("名称："+f2.getName());
			}
		}
		//创建字节输入流对象
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(f);
			//定义一个字节数组，相当于缓存
			byte bytes[]=new byte[1024];
			//得到实际读取到的字节数
			int n=0;
			//循环读取
			while((n=fis.read(bytes))!=-1){
				//字节转换为字符串
				String s=new String(bytes,0,n);
				System.out.println("文件内容："+s);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				//文件必须关闭
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		File fie=new File("f:/ss.txt");
		//创建字节输出流对象
		FileOutputStream fio=null;
		try {
			fio=new FileOutputStream(fie);
			//换行:\r\n
			String s=new String("中国，您好！\r\n");
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

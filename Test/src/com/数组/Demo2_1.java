/*
*���ܣ��������
*/
package com.����;
import java.util.*;
public class Demo2_1{
	public static void main(String args[]){
		int[] arr={3,5,8,12,16,17,27,56};
		System.out.print("���飺");
		for(int i=0;i<arr.length;i++){
		//	arr[i]=(int)(Math.random()*10);
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		Scanner q=new Scanner(System.in);
		System.out.println("1��˳�����"+"\n2�����ֲ���");
		int i=q.nextInt();
		if(i==1){
		    Sx sxs=new Sx();
		    sxs.finl(8,arr);
		}else if(i==2){
		    Ef es=new Ef();
			es.finl(8,0,arr.length,arr);
		}
	}
}
//˳�����
class Sx{
	//˳����ҷ���
	final public void finl(int val,int arr[]){
	    for(int i=0;i<arr.length;i++){
			if(arr[i]==val){
				int s=i;
				System.out.println("�������ҵ����±���"+s);
			}
		} 
	}
}
//���ֲ���
class Ef{
	//���ֲ��ҷ���
	final public void finl(int val,int leftarr,int ringhtarr,int arr[]){
		//��Ϊ�м����Ҫ�ҵ������±�
		int mi=(leftarr+ringhtarr)/2;
		//����Ҫ�ҵ�����
		int s=arr[mi];
		if(ringhtarr>=leftarr){
			//�����鶨�����������
			if(s>val){
				finl(val,leftarr,mi-1,arr);
			//�����鶨�������ұ���	
			}else if(s<val){
				finl(val,mi+1,ringhtarr,arr);
			}else if(s==val){
				System.out.println("�������ҵ����±���"+mi);
			}
		}else{
			System.out.println("������û���������");
		}
	}
}
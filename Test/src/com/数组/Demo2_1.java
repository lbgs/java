/*
*功能：数组查找
*/
package com.数组;
import java.util.*;
public class Demo2_1{
	public static void main(String args[]){
		int[] arr={3,5,8,12,16,17,27,56};
		System.out.print("数组：");
		for(int i=0;i<arr.length;i++){
		//	arr[i]=(int)(Math.random()*10);
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		Scanner q=new Scanner(System.in);
		System.out.println("1、顺序查找"+"\n2、二分查找");
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
//顺序查找
class Sx{
	//顺序查找方法
	final public void finl(int val,int arr[]){
	    for(int i=0;i<arr.length;i++){
			if(arr[i]==val){
				int s=i;
				System.out.println("数字已找到，下标是"+s);
			}
		} 
	}
}
//二分查找
class Ef{
	//二分查找方法
	final public void finl(int val,int leftarr,int ringhtarr,int arr[]){
		//认为中间就是要找的数字下标
		int mi=(leftarr+ringhtarr)/2;
		//定义要找的数字
		int s=arr[mi];
		if(ringhtarr>=leftarr){
			//在数组定义数的左边找
			if(s>val){
				finl(val,leftarr,mi-1,arr);
			//在数组定义数的右边找	
			}else if(s<val){
				finl(val,mi+1,ringhtarr,arr);
			}else if(s==val){
				System.out.println("数字已找到，下标是"+mi);
			}
		}else{
			System.out.println("数组中没有这个数字");
		}
	}
}
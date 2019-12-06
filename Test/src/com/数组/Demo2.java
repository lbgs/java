/*
*功能：数组排序法
*/
package com.数组;
import java.util.*;
public class Demo2{
	public static void main(String args[]){
		//定义数组的长度
		int len=17;
		//创建一个数组
		int[] arr=new int[len];
		System.out.print("调整前的数组：");
		//给数组的数值赋值
		for(int i=0;i<arr.length;i++){
			//Math.random()是产生0~1的随机数
			//产生一个随机数
			arr[i]=(int)(Math.random()*100);
			System.out.print(arr[i]+" ");
		}
		//打印系统当前时间
		Calendar ca1=Calendar.getInstance();
		System.out.println("\n排序前的时间："+ca1.getTime());
        System.out.println("1、冒泡排序法"+"\n2、选择排序法"+
		"\n3、插入排序法"+"\n4、快速排序法"); 
        Scanner q=new Scanner(System.in);
        int i=q.nextInt();
        if(i==1){
			Mp maxs=new Mp();
			maxs.show(arr);
		}else if(i==2){
			Xz xzs=new Xz();
			xzs.show(arr);
		}else if(i==3){
			Cr crs=new Cr();
			crs.show(arr);
		}else if(i==4){
			QuickSort qu=new QuickSort();
			qu.sort(0,arr.length-1,arr);
		}
		//输入最后的结果
		System.out.print("调整后的数组：");
		for(int j=0;j<arr.length;j++){
			System.out.print(arr[j]+" ");
		}
		ca1=Calendar.getInstance();
		System.out.println("\n排序后的时间："+ca1.getTime());
	}
}
//快速排序法
class QuickSort{
	public void sort(int left,int right,int arr[]){
		int l=left;
		int r=right;
		int pivot=arr[(left+right)/2];
		int temp=0;
		while(l<r){
			while(arr[l]<pivot) l++;
			while(arr[r]>pivot) r--;
			if(l>=r) break;
			temp=arr[l];
			arr[l]=arr[r];
			arr[r]=temp;
			if(arr[l]==pivot) --r;
			if(arr[r]==pivot) ++l;
		}
		if(l==r){
			l++;
			r--;
		}
		if(left<r) sort(left,r,arr);
		if(right>l) sort(l,right,arr);
	}
}
//冒泡排序
class Mp{
	//冒泡排序方法
	public void show(int arr[]){
		int tmp;
		//外部循环，一共循环多少次
		for(int i=0;i<arr.length-1;i++){
		//内部循环，开始逐个比较，如果发现前一个比后一个大就交换
		    for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					//换位
					tmp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=tmp;
				}
			}	
		}
	}
}
//选择排序法
class  Xz{
	public void show(int arr[]){
		int tmp;
		//循环第一个数到倒数第二个数
		for(int i=0;i<arr.length-1;i++){
			//把min认为是最小的
			int min=arr[i];
			//最小的下标
			int w=i;
			//循环第二个到最后一个
			for(int j=i+1;j<arr.length;j++){
				//如果min后面的数小于min就把这个值赋值给min
				if(min>arr[j]){
					min=arr[j];
					//把最新的值下标记下来
					w=j;
				}
			}
			//换位
			tmp=arr[i];
			arr[i]=arr[w];
			arr[w]=tmp;
		}
	}
}
//插入排序
class Cr{
	//插入排序方法
	public void show(int arr[]){
		for(int i=1;i<arr.length;i++){
			//定义一个数
	    	int is=arr[i];
	    	//跟前一个数对比，如果满足条件则替换
	    	for(int j=i-1;j>=0&&is<arr[j];j--){
	    		//换位
				arr[j+1]=arr[j];
			}
			
		}
	}
}
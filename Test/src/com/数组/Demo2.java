/*
*���ܣ���������
*/
package com.����;
import java.util.*;
public class Demo2{
	public static void main(String args[]){
		//��������ĳ���
		int len=17;
		//����һ������
		int[] arr=new int[len];
		System.out.print("����ǰ�����飺");
		//���������ֵ��ֵ
		for(int i=0;i<arr.length;i++){
			//Math.random()�ǲ���0~1�������
			//����һ�������
			arr[i]=(int)(Math.random()*100);
			System.out.print(arr[i]+" ");
		}
		//��ӡϵͳ��ǰʱ��
		Calendar ca1=Calendar.getInstance();
		System.out.println("\n����ǰ��ʱ�䣺"+ca1.getTime());
        System.out.println("1��ð������"+"\n2��ѡ������"+
		"\n3����������"+"\n4����������"); 
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
		//�������Ľ��
		System.out.print("����������飺");
		for(int j=0;j<arr.length;j++){
			System.out.print(arr[j]+" ");
		}
		ca1=Calendar.getInstance();
		System.out.println("\n������ʱ�䣺"+ca1.getTime());
	}
}
//��������
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
//ð������
class Mp{
	//ð�����򷽷�
	public void show(int arr[]){
		int tmp;
		//�ⲿѭ����һ��ѭ�����ٴ�
		for(int i=0;i<arr.length-1;i++){
		//�ڲ�ѭ������ʼ����Ƚϣ��������ǰһ���Ⱥ�һ����ͽ���
		    for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					//��λ
					tmp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=tmp;
				}
			}	
		}
	}
}
//ѡ������
class  Xz{
	public void show(int arr[]){
		int tmp;
		//ѭ����һ�����������ڶ�����
		for(int i=0;i<arr.length-1;i++){
			//��min��Ϊ����С��
			int min=arr[i];
			//��С���±�
			int w=i;
			//ѭ���ڶ��������һ��
			for(int j=i+1;j<arr.length;j++){
				//���min�������С��min�Ͱ����ֵ��ֵ��min
				if(min>arr[j]){
					min=arr[j];
					//�����µ�ֵ�±������
					w=j;
				}
			}
			//��λ
			tmp=arr[i];
			arr[i]=arr[w];
			arr[w]=tmp;
		}
	}
}
//��������
class Cr{
	//�������򷽷�
	public void show(int arr[]){
		for(int i=1;i<arr.length;i++){
			//����һ����
	    	int is=arr[i];
	    	//��ǰһ�����Աȣ���������������滻
	    	for(int j=i-1;j>=0&&is<arr[j];j--){
	    		//��λ
				arr[j+1]=arr[j];
			}
			
		}
	}
}
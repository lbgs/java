/**
 * ���ܣ���λ����
 */
package com.����;
import java.util.*;
public class Demo2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner q=new Scanner(System.in);
		System.out.println("����1~10��x��1~30��y��ֵ��ע�ÿո����");
		int x=q.nextInt();
		int y=q.nextInt();		
		while(x>30||y>10){
			System.out.println("����������������롣�˳�����0");
			x=q.nextInt();
			if(x==0){
				System.out.println("�˳���Ϸ");
				break;
			}
			y=q.nextInt();
		}
		if(x>0){
			Ew es=new Ew();
			es.show(x, y);
		}
	}
}
class Ew{
	//��������
	public void show(int x,int y){
		//����һ�����
		int[][] arr=new int[10][30];
		//ѭ����
		for(int i=0;i<arr.length;i++){
			//ѭ����
			for(int j=0;j<arr[i].length;j++){
				//����Զ���ֵ��λ��
				if((i+1)==y&&(j+1)==x){
					System.out.print("*");
				}else{
					System.out.print(".");
				}
			}
			System.out.println();
		}
	}
}
/**
 * 功能，二位数组
 */
package com.数组;
import java.util.*;
public class Demo2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner q=new Scanner(System.in);
		System.out.println("输入1~10的x和1~30的y数值。注用空格隔开");
		int x=q.nextInt();
		int y=q.nextInt();		
		while(x>30||y>10){
			System.out.println("输入错误，请重新输入。退出输入0");
			x=q.nextInt();
			if(x==0){
				System.out.println("退出游戏");
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
	//超级玛丽
	public void show(int x,int y){
		//定义一个框架
		int[][] arr=new int[10][30];
		//循环行
		for(int i=0;i<arr.length;i++){
			//循环列
			for(int j=0;j<arr[i].length;j++){
				//输出自定义值得位置
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
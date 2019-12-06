/**
 * 功能：骰子
 */
package com.练习;
import java.util.*;
public class Sz {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner q=new Scanner(System.in);
        System.out.println("请输入1~3数字。1、石头   2、剪刀   3、布");
		int a=0,b=0,c=0,z=0;
		while(true){
			z++;
			 int x=q.nextInt();
				int y=(int)(Math.random()*1+3);
				System.out.println("你出的是"+x);
			if(x==y){
				System.out.println("电脑出的是"+y+"\n平局");
				a++;
			}else if((x-y)==-1||(x-y)==2){
				System.out.println("电脑出的是"+y+"\n恭喜你赢了");
				b++;
			}else{
				System.out.println("电脑出的是"+y+"\n你输了");
			    c++;
			}
			System.out.println("想继续吗？ \t请输入a\n退出输入b");
			String s=q.next();
			if(s.equals("a")){
				
			}else{
				break;
			}
		}
		System.out.println("游戏已结束");
		System.out.println("一共玩了"+z+"局");
		System.out.println(a+"局平手"+"\n玩家赢了"+b+"局\n电脑赢了"+c+"局");
	}
}
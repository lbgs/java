package com.数组;
/**
 * 
 * @author 王荣华
 *功能：超级玛丽游戏
 */
import java.util.*;
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner q=new Scanner(System.in);
        System.out.println("超级玛丽游戏现在开始。注：w上、s下、a左、d右");
        System.out.println("请先定义超级玛丽的位置。");
        System.out.print("请输入1~30的x值：");
		int x=q.nextInt();
		System.out.print("请输入1~10的y值：");
		int y=q.nextInt();
		while(x>30||y>10){
			System.out.println("输入错误，请重新输入");
			System.out.print("请输入1~30的x值：");
			x=q.nextInt();
			System.out.print("请输入1~10的y值：");
			y=q.nextInt();
		}

		    Chen cs=new Chen(x,y);
		    System.out.println("当前坐标为x:"+x+"  y:"+y);
		    while(true){
			    System.out.print("请输入方向键：");
			    String c=q.next();
			    //往上
			    if(c.equals("w")||c.equals("W")){
			    	y-=1;
			    	if(y<1){
			    		y+=1;
			    		System.out.println("已没路，请重新走!");
			    		System.out.println("输入w上、s下、a左或者d右继续，输入e退出游戏！");
			    	}else{
			    		System.out.println("当前坐标为x:"+x+"  y:"+y);
			            cs=new Chen(x,y);
			            System.out.println("输入w上、s下、a左或者d右继续，输入e退出游戏！");
			    }
		        //往下
			    }else if(c.equals("s")||c.equals("S")){
		            y+=1;
		            if(y>10){
		            	y-=1;
		            	System.out.println("已没路，请重新走！");
		            	System.out.println("输入w上、s下、a左或者d右继续，输入e退出游戏！");
		            }else{
		            	System.out.println("当前坐标为x:"+x+" y:"+y);
			        	cs=new Chen(x,y);
			            System.out.println("输入w上、s下、a左或者d右继续，输入e退出游戏！");
			            }
		        //往左
			    }else if(c.equals("a")||c.equals("A")){
		        	x-=1;
		        	if(y==1&&x<1){
		        		x+=1;
		        		System.out.println("已没路，请重新走！");
		        		System.out.println("输入w上、s下、a左或者d右继续，输入e退出游戏！");
		        	}else if(x<1){
		        		x+=30;y-=1;
		        		System.out.println("当前坐标为x:"+x+" y:"+y);
		        		cs=new Chen(x,y);
		        		System.out.println("输入w上、s下、a左或者d右继续，输入e退出游戏！");
		        	}else{
		        		System.out.println("当前坐标为x:"+x+" y:"+y);
			        	cs=new Chen(x,y);
			        	System.out.println("输入w上、s下、a左或者d右继续，输入e退出游戏！");
		        	}
		        //往右
			    }else if(c.equals("d")||c.equals("D")){
		        	x+=1;
		        	if(x>30&&y==10){
		        		x-=1;
		        		System.out.println("已没路，请重新走！");
		        		System.out.println("输入w上、s下、a左或者d右继续，输入e退出游戏！");
		        	}else if(x>30){
		        		x-=30;y+=1;
		        		System.out.println("当前坐标为x:"+x+" y:"+y);
		        		cs=new Chen(x,y);
		        		System.out.println("输入w上、s下、a左或者d右继续，输入e退出游戏！");
		        	}else{
		        		System.out.println("当前坐标为x:"+x+" y:"+y);
				    	cs=new Chen(x,y);
			        	System.out.println("输入w上、s下、a左或者d右继续，输入e退出游戏！");
		        	}
		        }else if(c.equals("e")||c.equals("E")){
		        	cs=new Chen(x,y);
		        	System.out.println("最后的坐标:"+x+" y:"+y);
		        	System.out.println("游戏已结束");
		        	System.exit(0);
		        }else{
		        	System.out.println("输入错误，请重新输入");
		        }
		    }
		
    }

}
class Chen{
	//超级玛丽
	public Chen(int x,int y){
		for(int i=1;i<=10;i++){
			for(int j=1;j<=30;j++){
				if(j==x&&i==y){
					System.out.print("@");
				}else{
					System.out.print(".");
				}
			}
			System.out.println();
		}
	}
}
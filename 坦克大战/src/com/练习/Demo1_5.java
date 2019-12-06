package com.练习;
/**
 * 
 * @author 作者：王荣华
 * @date 日期：2017年7月30日上午12:10:05
 * 功能：线程
 */
public class Demo1_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog=new Dog();
		Thread ta=new Thread(dog);
		ta.start();
	}

}
class Dog implements Runnable{
	int x;
	public void run(){
		while(true){
			try {
				Thread.sleep(1000);
			} catch (Exception e) {				
				// TODO: handle exception
				e.printStackTrace();
			}
			x++;
			System.out.println(x+"、hello");
			if(x==10){
				break;
			}
		}
	}
}

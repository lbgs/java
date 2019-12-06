package com.线程;
/**
 * 
 * @author 作者：王荣华
 * @date 日期：2017年7月31日上午12:54:45
 * 功能：线程并发
 */
public class Demo1_1 {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Piao p=new Piao();
        Thread ta1=new Thread(p);
        Thread ta2=new Thread(p);
        Thread ta3=new Thread(p);
        ta1.start();
        ta2.start();
        ta3.start();
        
        
	}

}
class Piao extends Thread{
	//总数量
	private  int sun=2000;
	int s=0;
	public void run(){
		while(true){
			//对象锁
			synchronized (this) {
			if(sun>0){
				System.out.println(Thread.currentThread().getName()
						+ "正在售第"+sun+"票");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				sun--;
			}else{
				System.exit(0);
			}
			}
		}
	}
}

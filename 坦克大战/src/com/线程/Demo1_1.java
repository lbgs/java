package com.�߳�;
/**
 * 
 * @author ���ߣ����ٻ�
 * @date ���ڣ�2017��7��31������12:54:45
 * ���ܣ��̲߳���
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
	//������
	private  int sun=2000;
	int s=0;
	public void run(){
		while(true){
			//������
			synchronized (this) {
			if(sun>0){
				System.out.println(Thread.currentThread().getName()
						+ "�����۵�"+sun+"Ʊ");
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

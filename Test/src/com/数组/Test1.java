package com.����;
/**
 * 
 * @author ���ٻ�
 *���ܣ�����������Ϸ
 */
import java.util.*;
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner q=new Scanner(System.in);
        System.out.println("����������Ϸ���ڿ�ʼ��ע��w�ϡ�s�¡�a��d��");
        System.out.println("���ȶ��峬��������λ�á�");
        System.out.print("������1~30��xֵ��");
		int x=q.nextInt();
		System.out.print("������1~10��yֵ��");
		int y=q.nextInt();
		while(x>30||y>10){
			System.out.println("�����������������");
			System.out.print("������1~30��xֵ��");
			x=q.nextInt();
			System.out.print("������1~10��yֵ��");
			y=q.nextInt();
		}

		    Chen cs=new Chen(x,y);
		    System.out.println("��ǰ����Ϊx:"+x+"  y:"+y);
		    while(true){
			    System.out.print("�����뷽�����");
			    String c=q.next();
			    //����
			    if(c.equals("w")||c.equals("W")){
			    	y-=1;
			    	if(y<1){
			    		y+=1;
			    		System.out.println("��û·����������!");
			    		System.out.println("����w�ϡ�s�¡�a�����d�Ҽ���������e�˳���Ϸ��");
			    	}else{
			    		System.out.println("��ǰ����Ϊx:"+x+"  y:"+y);
			            cs=new Chen(x,y);
			            System.out.println("����w�ϡ�s�¡�a�����d�Ҽ���������e�˳���Ϸ��");
			    }
		        //����
			    }else if(c.equals("s")||c.equals("S")){
		            y+=1;
		            if(y>10){
		            	y-=1;
		            	System.out.println("��û·���������ߣ�");
		            	System.out.println("����w�ϡ�s�¡�a�����d�Ҽ���������e�˳���Ϸ��");
		            }else{
		            	System.out.println("��ǰ����Ϊx:"+x+" y:"+y);
			        	cs=new Chen(x,y);
			            System.out.println("����w�ϡ�s�¡�a�����d�Ҽ���������e�˳���Ϸ��");
			            }
		        //����
			    }else if(c.equals("a")||c.equals("A")){
		        	x-=1;
		        	if(y==1&&x<1){
		        		x+=1;
		        		System.out.println("��û·���������ߣ�");
		        		System.out.println("����w�ϡ�s�¡�a�����d�Ҽ���������e�˳���Ϸ��");
		        	}else if(x<1){
		        		x+=30;y-=1;
		        		System.out.println("��ǰ����Ϊx:"+x+" y:"+y);
		        		cs=new Chen(x,y);
		        		System.out.println("����w�ϡ�s�¡�a�����d�Ҽ���������e�˳���Ϸ��");
		        	}else{
		        		System.out.println("��ǰ����Ϊx:"+x+" y:"+y);
			        	cs=new Chen(x,y);
			        	System.out.println("����w�ϡ�s�¡�a�����d�Ҽ���������e�˳���Ϸ��");
		        	}
		        //����
			    }else if(c.equals("d")||c.equals("D")){
		        	x+=1;
		        	if(x>30&&y==10){
		        		x-=1;
		        		System.out.println("��û·���������ߣ�");
		        		System.out.println("����w�ϡ�s�¡�a�����d�Ҽ���������e�˳���Ϸ��");
		        	}else if(x>30){
		        		x-=30;y+=1;
		        		System.out.println("��ǰ����Ϊx:"+x+" y:"+y);
		        		cs=new Chen(x,y);
		        		System.out.println("����w�ϡ�s�¡�a�����d�Ҽ���������e�˳���Ϸ��");
		        	}else{
		        		System.out.println("��ǰ����Ϊx:"+x+" y:"+y);
				    	cs=new Chen(x,y);
			        	System.out.println("����w�ϡ�s�¡�a�����d�Ҽ���������e�˳���Ϸ��");
		        	}
		        }else if(c.equals("e")||c.equals("E")){
		        	cs=new Chen(x,y);
		        	System.out.println("��������:"+x+" y:"+y);
		        	System.out.println("��Ϸ�ѽ���");
		        	System.exit(0);
		        }else{
		        	System.out.println("�����������������");
		        }
		    }
		
    }

}
class Chen{
	//��������
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
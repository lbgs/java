package com.��ҵ;
/**
 * 
 * @author ���ٻ�
 *���ܣ�ѧ���ɼ�
 */
import java.util.*;
public class Test1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner q=new Scanner(System.in);
		int size=10;
        float[] arr=new float[size];
        try {
        	for(int i=0;i<arr.length;i++){
            	System.out.print("��"+(i+1)+"��ѧ���ɼ���");
            	arr[i]=q.nextFloat();
            	}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�������   "+e.getMessage());
		}
        Run emp=new Run(arr);
        
	}

}
//ѧ���ɼ�����ϵͳ
class Run{
	public Run(float[] arr){
		Scanner q=new Scanner(System.in); 
		while(true){
	        	System.out.println("1���鿴ѧ���ɼ�");
	        	System.out.println("2���鿴ѧ��ѧ��");
	        	System.out.println("3��ͳ�Ƹ��������׶ε�ѧ������");
	        	System.out.println("4��ɾ��ѧ���ɼ�");
	        	System.out.println("5���鿴����ѧ���ĳɼ�");
	        	System.out.println("6���˳�ѧ���ɼ�����ϵͳ");
	        	try {
	        		System.out.print("��������ţ�");
	        		int a=q.nextInt();
	        		if(a==1){
	        			System.out.print("������ѧ�ţ�");
	        			int s=q.nextInt();
	        			for(int i=0;i<arr.length;i++){
	        				if((i+1)==s){
	        					System.out.println("�ɼ���"+arr[i]);
	        				}
	        			}
	        		}else if(a==2){
	        			System.out.print("������ѧ���ɼ���");
	        			float s=q.nextFloat();
	        			for(int i=0;i<arr.length;i++){
	        				if(arr[i]==s){
	        					System.out.println("ѧ�ţ�"+(i+1));
	        				}
	        			}
	        		}else if(a==3){
	        		    int[] array=new int[5];
	        		    for(int i=0;i<arr.length;i++){
	        			   if(arr[i]>=90){
	        				   //�ŵ�ѧ��
	        				   array[0]++; 
	        			   }else if(arr[i]>=80){
	        				   //����ѧ��
	        				   array[1]++;
	        			   }else if(arr[i]>=70){
	        				   //�е�ѧ��
	        				   array[2]++;
	        			   }else if(arr[i]>=60){
	        				   //���ѧ��
	        				   array[3]++;
	        			   }else{
	        				   //�������ѧ��
	        				   array[4]++;
	        			   }
	        		   }
	        		    System.out.println("�ɼ��ŵ�ѧ����"+array[0]+"��");
	        		    System.out.println("�ɼ�����ѧ����"+array[1]+"��");
	        		    System.out.println("�ɼ��е�ѧ����"+array[2]+"��");
	        		    System.out.println("�ɼ����ѧ����"+array[3]+"��");
	        		    System.out.println("�ɼ��������ѧ����"+array[4]+"��");
	        		}else if(a==4){
	        			System.out.print("������ѧ�ţ�");
	        			int s=q.nextInt();
	        			for(int i=0;i<arr.length;i++){
	        				if((i+1)==s){
	        					arr[i]=0;
	        					System.out.println("ɾ���ɹ�");
	        				}
	        			}
	        		}else if(a==5){
	        			for(int i=0;i<arr.length;i++){
	        				System.out.println((i+1)+"ѧ�ŵĳɼ���"+arr[i]);
	        			}
	        		}else if(a==6){
	        			System.out.println("���˳�");
	        			System.exit(0);
	        		}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("�������     "+e.getMessage());
				}
	        }
	}
}
/**
 * ���ܣ�����
 */
package com.��ϰ;
import java.util.*;
public class Sz {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner q=new Scanner(System.in);
        System.out.println("������1~3���֡�1��ʯͷ   2������   3����");
		int a=0,b=0,c=0,z=0;
		while(true){
			z++;
			 int x=q.nextInt();
				int y=(int)(Math.random()*1+3);
				System.out.println("�������"+x);
			if(x==y){
				System.out.println("���Գ�����"+y+"\nƽ��");
				a++;
			}else if((x-y)==-1||(x-y)==2){
				System.out.println("���Գ�����"+y+"\n��ϲ��Ӯ��");
				b++;
			}else{
				System.out.println("���Գ�����"+y+"\n������");
			    c++;
			}
			System.out.println("������� \t������a\n�˳�����b");
			String s=q.next();
			if(s.equals("a")){
				
			}else{
				break;
			}
		}
		System.out.println("��Ϸ�ѽ���");
		System.out.println("һ������"+z+"��");
		System.out.println(a+"��ƽ��"+"\n���Ӯ��"+b+"��\n����Ӯ��"+c+"��");
	}
}
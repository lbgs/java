package com.������;
/**
 * 
 * @author ���ٻ�
 *
 */
import java.util.*;
public class Demo1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        HashMap hs=new HashMap();
        Yg ys1=new Yg("s001","����",49,10000);
        Yg ys2=new Yg("s002","��С��",34,124);
        hs.put("s001", ys1);
        hs.put("s002", ys2);
        Yg a1=(Yg)hs.get("s002");
        if(hs.containsKey("s002")){
        	System.out.println("���ԣ�"+a1.getName());
        }else{
        	System.out.println("�����������������");
        }
	}

}

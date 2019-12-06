package com.集合类;
/**
 * 
 * @author 王荣华
 *
 */
import java.util.*;
public class Demo1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        HashMap hs=new HashMap();
        Yg ys1=new Yg("s001","成龙",49,10000);
        Yg ys2=new Yg("s002","李小龙",34,124);
        hs.put("s001", ys1);
        hs.put("s002", ys2);
        Yg a1=(Yg)hs.get("s002");
        if(hs.containsKey("s002")){
        	System.out.println("测试："+a1.getName());
        }else{
        	System.out.println("输入错误，请重新输入");
        }
	}

}

package com.练习;
import java.awt.*;
import javax.swing.JFrame;
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//定义一个构造方法，设置窗口标题
       Frame f=new Frame("小游戏"); 
       //设置窗口位置和大小，位置宽20、高30，大小宽200、高100
       f.setBounds(20,30,200,100);
       f.setSize(500,400);//设置窗口位置，宽度500，高度400
       f.setLocation(300, 200);//设置窗口大小，宽度300，高度200
       f.setVisible(true);//窗口显示
       JFrame a=new JFrame();    
       a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  //     a.setDefaultColoseOperation(JFrame.EXIT_ON_CLOSE);
       Button b=new Button();
       b.add(null);

	}
}


/**
 * ��½��������
 * JWindow���޴��ڽ���
 */
package mhl.view;
import javax.swing.*;
import javax.tools.Tool;

import java.awt.*;
public class Index extends JWindow {
	paint p=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Index index=new Index();
	}
	public Index(){
		p=new paint();
		this.add(p);
		this.setSize(400,250);
		//�õ�����width��height�ֱ���
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-200, height/2-150);
		this.setVisible(true);
	}

}
//������
class paint extends JPanel implements Runnable{

	Thread t;
	int x=10;
	int i=0,j=40,u=10;
	String gg[]={"ϵ","ͳ","��","��","��","��","��","��","��"};
	int k=0,tt=0;
	String shi[]={"��","��","¥","��","��","��","��","��","��","��","��","��","ζ",
			"��","��","��","ʳ","��","��","��","��","��","��","��","��","¥","��","��","��",};
	Font f=new Font("����",Font.PLAIN,18);
	
	boolean ifok=true;
	int width=180,heifht=0,dian=0;
	paint(){
		t=new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if(x<=380) repaint();
			try {
				Thread.sleep(70);
				i++;
				j=j-6;
				u=u+10;
				if(tt==3) width-=20;
				if(i==4){
					tt++;
					if(ifok&&x>120+k*20) k++;
					if(k>=gg.length-1) ifok=false;
					x+=10;
					i=0;
					j=40;
					u=10;
					dian++;
					if(dian>3) dian=0;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("�߳��ж�");
			}
		}
	}
	public void paintComponent(Graphics g){
		Image image;
		image=Toolkit.getDefaultToolkit().getImage("image\\sp.gif");
		g.drawImage(image, 0,0,this.getWidth(),200,this);
		
		int r=(int)(Math.random()*255);
		int b=(int)(Math.random()*255);
		int y=(int)(Math.random()*255);
		//������
		g.setColor(new Color(253,250,250));
		g.fillRect(x, 210,390-x, 30);
		g.setColor(new Color(253,250,250));
		if(i>1) g.fillRect(x, 255-(j+20)/2, 10, j+20);
		if(j>25) g.setColor(new Color(r,b,y));
		else g.setColor(new Color(123,194,252));
		g.fillRect(x, 230-j/2, 10, j);
		//��
		g.setColor(new Color(123,194,252));
		g.drawRect(10, 210, 380, 30);
		
		if(x<120){
			//��ʾ��ϵͳ���ڼ������Ժ�
			for(int l=0;l<gg.length;l++){
				g.setColor(new Color(0,0,0));
				g.drawString(gg[l], 120+l*20, 230);
			}
			for(int l=0;l<dian;l++){
				g.setColor(new Color(0,0,0));
				g.drawString("*", 300+l*10, 235);
			}
			g.drawString("*", 300+dian*10, 235);
		}else{
			g.setColor(new Color(23,23,230));
			g.drawString(gg[k], 120+k*20, 230);
			for(int l=k+1;l<gg.length;l++){
				g.setColor(new Color(0,0,0));
				g.drawString(gg[l], 120+l*20, 230);
			}
			if(x>300+dian*10) g.setColor(new Color(23,23,230));
			for(int l=0;l<dian;l++){
				g.drawString("*", 300+l*10, 235);
			}
			g.drawString("*", 300+dian*10, 235);
		}
		//---------����дʫ
		if(tt<3){
			for(int rr=0;rr<=tt;rr++){
				g.setColor(new Color(r,b,y));
				g.drawString(shi[rr], 180, 60+tt*20);
			}
			g.drawString(shi[tt], 180, 60+tt*20);
		}
	}
}

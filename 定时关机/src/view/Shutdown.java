package view;
import java.awt.*;
import javax.swing.*;

public class Shutdown extends JWindow {
	MyPanel m=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shutdown shutdown=new Shutdown();
	}
	public Shutdown(){
		m=new MyPanel();
		Thread t=new Thread(m);
		t.start();
		this.add(m);
		this.setSize(950,90);
		this.setVisible(true);
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		int h=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((w-950)/2, (h-120)/2);
	}
}
class MyPanel extends JPanel implements Runnable{
	int i=1;
	int s=0;
	int k=0;
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(new Color(255,255,0));
		g.fillRect(0, 0, 950, 90);
		g.setColor(Color.red);
		g.setFont(new Font("楷体",Font.PLAIN,70));
		if(s<10){
			if(i<10){
				g.drawString("您的电脑即将在 0"+i+":0"+s+" 后关机！", 0, 70);
			}else{
				g.drawString("您的电脑即将在 "+i+":0"+s+" 后关机！", 0, 70);
			}
		}else{
			if(i<10){
				g.drawString("您的电脑即将在 0"+i+":"+s+" 后关机！", 0, 70);
			}else{
				g.drawString("您的电脑即将在 " +i+":"+s+" 后关机！", 0, 70);
			}
		}
		if(k==1){
			try {
				  Process pro = Runtime.getRuntime().exec("cmd /c shutdown -s"); 
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){		
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
			if(i==0 && s==0){
				k=1;
				this.repaint();
				break;
			}
			if(s==0){
				i--;
				s=59;
			}else{
				s--;
				System.out.println(s);
			}
			this.repaint();
		}
	}
	
}
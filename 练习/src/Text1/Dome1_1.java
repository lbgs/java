package Text1;
import java.awt.*;
import javax.swing.*;
public class Dome1_1 extends JWindow{
	MyPanel mp=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dome1_1 demo1=new Dome1_1();
	}

	public Dome1_1(){
		mp=new MyPanel();
		this.add(mp);
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setBackground(new Color(0,0,0,10));
		
	}

}
class MyPanel extends JPanel{
	public void paint(Graphics g){
		g.setFont(new Font("¿¬Ìå",Font.PLAIN,100));
		g.setColor(Color.red);
		g.drawString("ÖÐ", 200, 200);
		
	}
}

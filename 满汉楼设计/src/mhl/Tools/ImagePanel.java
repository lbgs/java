package mhl.Tools;
import java.awt.*;
import javax.swing.*;
public class ImagePanel extends JPanel{
	Image img;
	public ImagePanel(Image img){
		this.img=img;
		//自适应大小
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
	}
	//根据组件画的
	public void paintComponent(Graphics g){
		g.drawImage(img, 0,0,this.getWidth(),this.getHeight(),this);
	}
}

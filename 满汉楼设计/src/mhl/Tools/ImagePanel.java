package mhl.Tools;
import java.awt.*;
import javax.swing.*;
public class ImagePanel extends JPanel{
	Image img;
	public ImagePanel(Image img){
		this.img=img;
		//����Ӧ��С
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
	}
	//�����������
	public void paintComponent(Graphics g){
		g.drawImage(img, 0,0,this.getWidth(),this.getHeight(),this);
	}
}

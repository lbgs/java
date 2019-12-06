package com.̹��;
/**
 * 
 * @author ���ߣ����ٻ�
 * @date ���ڣ�2017��7��28������12:02:31
 * ���ܣ�̹�˴�ս
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.imageio.ImageIO;
public class Tanke extends JFrame implements ActionListener{
    //ս�����
	MyPanel ml=null;
    //�ؿ����
	MygkPanel mk=null;
	//�˵���
	JMenuBar jmb=null;
	//���˵�
	JMenu jm1,jm2;
	//����Ϸ
	JMenuItem jmt1;
	//�˳�
	JMenuItem jmt2;
	//�����˳�
	JMenuItem jmt3;
	//������Ϸ
	JMenuItem jmt4;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tanke tk=new Tanke();
	}
	public Tanke(){
		//�������
		mk=new MygkPanel();
		//�����˵�
		jmb=new JMenuBar();
		jm1=new JMenu("�ļ�(F)");
		jm1.setMnemonic('F');
		jmt1=new JMenuItem("����Ϸ(N)");
		jmt1.setMnemonic('N');
		jmt2=new JMenuItem("�˳�(X)");
		jmt2.setMnemonic('X');
		jmt3=new JMenuItem("�����˳�(S)");
		jmt3.setMnemonic('S');
		jmt4=new JMenuItem("������Ϸ(R)");
		jmt4.setMnemonic('R');
		//���
		jmb.add(jm1);
		jm1.add(jmt1);
		jm1.add(jmt4);
		jm1.add(jmt3);
		jm1.add(jmt2);
		//ע�����
		jmt1.addActionListener(this);
		jmt1.setActionCommand("����Ϸ");
		jmt2.addActionListener(this);
		jmt2.setActionCommand("�˳�");
		jmt3.addActionListener(this);
		jmt3.setActionCommand("�����˳�");
		jmt4.addActionListener(this);
		jmt4.setActionCommand("������Ϸ");
		//�����߳�
		Thread ta=new Thread(mk);
		ta.start();
		//��ӵ�����
		this.setJMenuBar(jmb);
		this.add(mk);
		this.setTitle("̹�˴�ս");
		this.setSize(650,600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("����Ϸ")){
			ml=new MyPanel("newGame");
			//��ȡս��
			Jilv.Duquwanjiachengji();
			//ɾ���ɵ����
			this.remove(mk);
			//����µ����
			this.add(ml);
			//ע�����
			this.addKeyListener(ml);
			Thread ta=new Thread(ml);
			ta.start();
			//��ʾ�µ����
			this.setVisible(true);
		}else if(e.getActionCommand().equals("�˳�")){
			//��¼�ɼ�
			Jilv.Jilvwanjiachengji();
			//�˳�
			System.exit(0);
		}else if(e.getActionCommand().equals("�����˳�")){
			Jilv.setEts(ml.dk);
			Jilv.Ditzbf();
			//�˳�
			System.exit(0);
		}else if(e.getActionCommand().equals("������Ϸ")){
			System.out.println("������Ϸ");
			ml=new MyPanel("conGame");
			//��ȡս��
			Jilv.Duquwanjiachengji();
			//ɾ���ɵ����
			this.remove(mk);
			//����µ����
			this.add(ml);
			//ע�����
			this.addKeyListener(ml);
			Thread ta=new Thread(ml);
			ta.start();
			//��ʾ�µ����
			this.setVisible(true);
		}
	}

}
//�ؿ���
class MygkPanel extends JPanel implements Runnable{
	int i=0;
	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(0, 0, 532, 460);
		if(i%2==0){
			g.setColor(Color.yellow);
			g.setFont(new Font("��Ϊ����",Font.BOLD,30));
			g.drawString("�ؿ���1", 200, 185);
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			i++;
			this.repaint();
		}
	}
}
class MyPanel extends JPanel implements KeyListener,Runnable{
	//�ҵ�̹��
	Imtk ik=null;
	//����̹��
	Vector<Ditk> dk=new Vector<Ditk>();
	//����ĵ���̹��
	Vector<DuquDitk> ddk=new Vector<DuquDitk>();
	//��ը
	Image img[]=null;
	Vector<Bomb> bombs=new Vector<Bomb>();
	public MyPanel(String file){
		//��ʼ���ҵ�̹��
		ik=new Imtk(220,430);
		//�ж�������Ϸ���Ǽ�����Ϸ
		if(file.equals("newGame")){
			//��ʼ������̹��
			for(int i=0;i<4;i++){
				//��ӵ���̹��
				Ditk ditk=new Ditk((i+1)*105,0);
			    //�ѵ���̹�˷Ž�Vector
				dk.add(ditk);
			    //����̹�����������ƶ�
			    Thread ti=new Thread(ditk);
			    ti.start();
			    //��MyPanel����̹�˽����õ���̹��
			    ditk.setDitk(dk);
			}
		}else{
			ddk=new Jilv().DuquyouxiDitk();
			//��ʼ������̹��
			for(int i=0;i<ddk.size();i++){
				//ȡ�������̹�ˣ�����ͷ���
				DuquDitk dq=ddk.get(i);
				//��ӵ���̹��
				Ditk ditk=new Ditk(dq.x,dq.y);
				//����
				ditk.f=dq.f;
			    //�ѵ���̹�˷Ž�Vector
				dk.add(ditk);
			    //����̹�����������ƶ�
			    Thread ti=new Thread(ditk);
			    ti.start();
			    //��MyPanel����̹�˽����õ���̹��
			    ditk.setDitk(dk);
			}
		}
		//������Ƶ
		AePlayWave apw=new AePlayWave("D:/Users/WRH/Workspaces/MyEclipse 2017 CI/̹�˴�ս/src/com/image/111.wav");
	//	apw.start();
		//��ը
		img=new Image[3];
		try {
			img[0]=ImageIO.read(new File("D:/Users/WRH/Workspaces/MyEclipse 2017 CI/̹�˴�ս/src/com/image/bomb1.gif"));
			img[1]=ImageIO.read(new File("D:/Users/WRH/Workspaces/MyEclipse 2017 CI/̹�˴�ս/src/com/image/bomb2.gif"));
			img[2]=ImageIO.read(new File("D:/Users/WRH/Workspaces/MyEclipse 2017 CI/̹�˴�ս/src/com/image/bomb3.gif"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		img[0]=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/com/image/bomb1.gif"));
//		img[1]=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/com/image/bomb2.gif"));
//		img[2]=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/com/image/bomb3.gif"));
		
	}
	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(0, 0, 532, 460);
		this.showInfo(g);
		//�ж��ҵ�̹���Ƿ���Ч
		if(ik.ws){
		//���ҵ�̹��
			this.Tkls(ik.getX(), ik.getY(),ik.getColor(),ik.getF(), g);
		}else if(Jilv.getImtksun()>0){
			ik=new Imtk(220,400);
		}
		//���ҵ��ӵ�
		if(ik.ws){
			for(int i=0;i<ik.vv.size();i++){
				//ȡ��һ���ӵ�
				Shot zd=ik.vv.get(i);
				if(ik.s!=null&&ik.s.ws==true){
					g.setColor(new Color(255,255,255));
					g.fillOval(zd.x,zd.y, 2, 2);
				}
				if(zd.ws==false){
					ik.vv.remove(zd);
				}
			}
		}	
		//������̹��
		for(int i=0;i<dk.size();i++){
			Ditk dtk=dk.get(i);
			if(dtk.ws){
				this.Tkls(dtk.getX(), dtk.getY(), dtk.getColor(), dtk.getF(), g);
				//���ӵ�
				for(int j=0;j<dtk.vv.size();j++){
					//ȡ�ӵ�
					Shot zd=dtk.vv.get(j);
					if(zd.ws){
						g.setColor(new Color(255,255,255));
						g.fillOval(zd.x,zd.y, 2, 2);
					}else
					if(zd.ws==false){
						dtk.vv.remove(zd);
					}
				}
			}else if(dtk.ws==false){
				dk.remove(dtk);
				Ditk ditk=new Ditk((i+1)*105,0);
				System.out.println("����"+(i+1));
			}
		}
		//����ը
		for(int i=0;i<bombs.size();i++){
			//ȡ��һ��ը��
			Bomb b=bombs.get(i);
			if(b.zhi>6){
				g.drawImage(img[0], b.x, b.y, 30, 30, this);
			}else if(b.zhi>3){
				g.drawImage(img[1], b.x, b.y, 30, 30, this);
			}else{
				g.drawImage(img[2], b.x, b.y, 30, 30, this);
			}
			//�ñ�ը��������
			b.Mingzhi();
			if(b.zhi==0){
				bombs.remove(b);
			}
		}
	}
	//�ӵ��߳�
	public void run(){
		while(true){
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			//����̹�˱�����
			this.Imjz();
			//�ҵ�̹�˱�����
			this.Ditkjz();
			this.repaint();
		}
	}
	//��¼����
	public void showInfo(Graphics g){
		//���̹�˵�����
		this.Tkls(540, 30, 0, 0, g);
		g.setColor(Color.black);
		g.setFont(new Font("����",Font.BOLD,20));
		g.drawString("ʣ"+Jilv.getImtksun()+"��", 570, 50);
		//����̹�˵�����
		this.Tkls(540, 70, 1, 0, g);
		g.setColor(Color.black);
		g.setFont(new Font("����",Font.BOLD,20));
		g.drawString("ʣ"+Jilv.getDitksun()+"��", 570, 90);
		//�ɼ�
		this.Tkls(90, 480, 1, 0, g);
		g.setColor(Color.black);
		g.setFont(new Font("����",Font.BOLD,20));
		g.drawString("�ܳɼ���", 10, 500);
		g.drawString("����"+Jilv.getDitksi()+"��", 120, 500);
	}
	//�ҵ��ӵ����е���̹��
	public void Imjz(){
		//�����ҵ��ӵ�
		for(int i=0;i<ik.vv.size();i++){
			//ȡ���ӵ�
			Shot sot=ik.vv.get(i);
			//�ж��ӵ��Ƿ���Ч
			if(sot.ws){
				//��������̹��
				for(int j=0;j<dk.size();j++){
					//ȡ������̹��
					Ditk di=dk.get(j);
					//�ж�̹���Ƿ���Ч
					if(di.ws){
						this.Jizhong(sot, di);
					}
				}
				
				
			}
			
		}
	}
	//���˵��ӵ������ҵ�̹��
	public void Ditkjz(){
		//ȡ������һ��̹��
		for(int i=0;i<dk.size();i++){
			//ȡ������̹��
			Ditk et=dk.get(i);
			//ȡ��һ���ӵ�
			for(int j=0;j<et.vv.size();j++){
				//ȡ���ӵ�
				Shot sot=et.vv.get(j);
				if(ik.ws){
					this.Jizhong(sot, ik);
				}
			}
		} 
	}
	//�ж�̹���Ƿ񱻾���
	public void Jizhong(Shot ss,Tk tk){
		//�жϵ���̹�˷���
	    switch(tk.f){
		//���¾�����
	    case 0:
	    case 1:
			if(ss.x>tk.x&&ss.x<tk.x+20&&ss.y>tk.y&&ss.y<tk.y+30){
				//�ӵ���̹������
				ss.ws=false;
				//̹������
				tk.ws=false;
				if(tk.color==1){
					//̹�˼���
					Jilv.Ditksun();
					//����ܳɼ�
					Jilv.Ditksi();
				}else if(tk.color==0){
					Jilv.Imtksun();
				}
				//������ը����
				Bomb b=new Bomb(tk.x-5,tk.y);
				//�ѱ�ը�Ž�Vectors
				bombs.add(b);
			}
			break;
		//���Ҿ���
	    case 2:
	    case 3:
			if(ss.x>tk.x-5&&ss.x<tk.x+25&&ss.y>tk.y+5&&ss.y<tk.y+25){
				//�ӵ���̹������
				ss.ws=false;
				//����̹������
				tk.ws=false;
				//�ж������̹�˻��ǵ���̹��
				if(tk.color==1){
					//̹�˼���
					Jilv.Ditksun();
					//����ܳɼ�
					Jilv.Ditksi();
				}else if(tk.color==0){
					Jilv.Imtksun();
				}
				
				//������ը����
				Bomb b=new Bomb(tk.x,tk.y);
				//�ѱ�ը�Ž�Vector
				bombs.add(b);
			}
			break;
		}
	    
	}
	//�ж���ɫ�ͷ���
	public void Tkls(int x,int y,int color,int fx,Graphics g){
		switch(color){
		//�ҵ�̹��
		case 0:
			g.setColor(new Color(255,255,0));
			break;
		//����̹��
		case 1:
			g.setColor(new Color(0,255,255));
			break;
		//ǿ����̹��	
		case 2:
			g.setColor(new Color(255,0,0));
			break;
		}
		switch(fx){
		//����
		case 0:
			//���
			g.fill3DRect(x, y, 5, 30, false);
			//�ұ�
			g.fill3DRect(x+15, y, 5, 30, false);
			//�м�
			g.fill3DRect(x+3, y+5, 14, 20, false);
			//Բ
			g.fillOval(x+5, y+10, 10, 10);
			//��Ͳ
			g.drawLine(x+10, y+15, x+10, y);
			break;
		//����
		case 1:
			//���
			g.fill3DRect(x, y, 5, 30, false);
			//�ұ�
			g.fill3DRect(x+15, y, 5, 30, false);
			//�м�
			g.fill3DRect(x+3, y+5, 14, 20, false);
			//Բ
			g.fillOval(x+5, y+10, 10, 10);
			//��Ͳ
			g.drawLine(x+10, y+15, x+10, y+30);
			break;
		//����
		case 2:
			//���
			g.fill3DRect(x-5, y+20, 30, 5, false);
			//�ұ�
			g.fill3DRect(x-5, y+5, 30, 5, false);
			//�м�
			g.fill3DRect(x, y+8, 20, 14, false);
			//Բ
			g.fillOval(x+5, y+10, 10, 10);
			//��Ͳ
			g.drawLine(x+5, y+15, x-5, y+15);
			break;
		//����
		case 3:
			//���
			g.fill3DRect(x-5, y+20, 30, 5, false);
			//�ұ�
			g.fill3DRect(x-5, y+5, 30, 5, false);
			//�м�
			g.fill3DRect(x, y+8, 20, 14, false);
			//Բ
			g.fillOval(x+5, y+10, 10, 10);
			//��Ͳ
			g.drawLine(x+5, y+15, x+25, y+15);
			break;
		} 
	}
	public void keyPressed(KeyEvent e){
		this.repaint();
		//�����ƶ�
		if(e.getKeyCode()==KeyEvent.VK_W){
			this.ik.Up();
			this.ik.setF(0);
		//�����ƶ�
		}else if(e.getKeyCode()==KeyEvent.VK_S){
            this.ik.Down();
            this.ik.setF(1);
	    //�����ƶ�
		}else if(e.getKeyCode()==KeyEvent.VK_A){
			this.ik.Left();
			this.ik.setF(2);
		//�����ƶ�
		}else if(e.getKeyCode()==KeyEvent.VK_D){
			this.ik.Ringht();
			this.ik.setF(3);
		}
		//��j����
		if(e.getKeyCode()==KeyEvent.VK_J){
			if(ik.vv.size()<5){
	    	    this.ik.zidan();
			}
		}
	}	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
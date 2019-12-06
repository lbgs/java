package com.Éß;

//ÎÒµÄÉß
class Imshe extends Sheshen implements Runnable{
	public Imshe(int x,int y){
		super(x,y);
		this.fx=6;
		this.sudu=5;
	}
	public void run(){
		while(true){
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			switch(this.fx){
			case 8:
				if(this.y>0){
					y-=sudu;
				}
				break;
			case 2:
				if(this.y<390){
					y+=sudu;
				}
				break;
			case 4:
				if(this.x>0){
					x-=sudu;
				}
				break;
			case 6:
				if(this.x<490){
					x+=sudu;
				}
				break;
			}
		}
	}	
}
//ÉßÀà
class Sheshen{
    int x;
	int y;
    int color=0;
    int sudu=1;
    int fx=6;
    public Sheshen(int x,int y){
    	this.x=x;
    	this.y=y;
    }
    public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public int getSudu() {
		return sudu;
	}
	public void setSudu(int sudu) {
		this.sudu = sudu;
	}
	public int getFx() {
		return fx;
	}
	public void setFx(int fx) {
		this.fx = fx;
	}
}

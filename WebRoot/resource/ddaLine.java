package Java3d;

import java.awt.*;
import java.awt.event.*;
import java.util.*;


	public class ddaLine extends Frame{
	int dif=0; 
	public static void main(String[] args){
	ddaLine ddaline=new ddaLine();
	ddaline.xrealline(30,30,500,200);
	ddaline.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
			System.exit(0);
			}
		});
	}
		
	public ddaLine(){
		this.setResizable(false);
		this.setSize(700,400);
		this.setVisible(true);
	}

	public void paintpix(int x,int y){	
		Graphics g=getGraphics();
		g.setColor(Color.RED);
		g.fillOval(x,y,1,1);
	}
		
	Graphics g=getGraphics();
	
	public void xrealline(int x1,int y1,int x2,int y2){
	double y=y1;
	double delta=(double)(y2-y1)/(x2-x1);
	if(Math.abs(delta)<=1){
		if(x1>x2){dif=-1;}
		else{dif=1;}		
		if(x1>x2){for(int i=x1;i>=x2;i+=dif){
				paintpix(i,(int)Math.round(y));
				y-=delta;}
		}else{for(int i=x1;i<=x2;i+=dif){
				paintpix(i,(int)Math.round(y));
				y+=delta;}}
	}else{
		yrealline(x1,y1,x2,y2);}
	}
		
	public void yrealline(int x1,int y1,int x2,int y2){
		if(x1>x2){dif=-1;}
		else{dif=1;}
		double y=y1;
		double delta=(double)(y2-y1)/(x2-x1);
		if(x1>x2){
			for(int i=x1;i>=x2;i+=dif){
				paintpix((int)Math.round(y),i);
				y-=delta;
			}
		}else{
			for(int i=x1;i<=x2;i+=dif){
				paintpix((int)Math.round(y),i);
				y+=delta;}
			}
		}
} 

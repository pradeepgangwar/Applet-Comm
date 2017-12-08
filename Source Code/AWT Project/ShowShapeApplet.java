import java.awt.*; 
import java.awt.event.*; 
import java.applet.*; 
import java.util.*;

public class ShowShapeApplet extends Applet { 
	boolean show = false;  //boolean variable to let know if shapes are to be shown or not
	int shape = 0;  
	Color c = Color.BLACK;
	int size = 10;
	Timer t;  
	
	//Function to start the shape transition
	public void startTransition(Color c, int size){
		show = true;
		this.c = c;
		this.size = size;
		
		t = new Timer();
		t.schedule(new showTask(),1000,1000);
	}
	
	//Function to stop the shape transition
	public void stopTransition(Color c, int size){
		show = false;
		this.c = c;
		this.size = size;
		
		if(t!=null)
			t.cancel();
		repaint();
	}
	
	public void paint(Graphics g){
		//paint shapes only if start button clicked
		if(show){
			g.setColor(c);  
			shape++;
			if(shape==3)
				shape=0;
			switch(shape){
			case 0:
				g.fillRect(10,10,size,size);		//Draws rectangle
				break;
			case 1:
				g.fillOval(10,10,size,size);		//Draws Cirle
				break;
			case 2:
				int x[] = {10,10+size,10+(size/2)};	//Draws Triangle
				int y[] = {10,10,10+size};
				g.fillPolygon(x,y,3);
				break;
			default:
			}
		}
	}
	
	class showTask extends TimerTask {
        	public void run() {
            		repaint();
        	}
    	}			
}


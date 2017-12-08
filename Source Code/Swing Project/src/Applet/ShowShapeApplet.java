package Applet;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.util.Timer;

public class ShowShapeApplet extends JPanel {
    
    JFrame f = new JFrame();
    static Color col;
    static int H, W, i;
    static boolean show = false;
    
    
    
    Timer t;
    public ShowShapeApplet(){
        
       f.setSize(400, 400);
       show  = false;
       f.add(this);
       f.setBackground(Color.white);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       f.setVisible(true);
       f.setTitle("Transition Displayer");
       f.setBounds(700, 100, 450, 300);    
    }
    
    public void draw(Color c, int h, int w){
        col = c;
        H = h;
        W = w;
        show = true;
        t = new Timer();
        t.schedule(new Display(),100,1000);
    }
    
    public void cancel(){
        t.cancel();
    }
  
    @Override
    public void paint(Graphics g) {
        
            
        if(show){
            
            g.setColor(col);
                i++;
                switch (i%3) {
                    case 0:
                        g.fillRect(155, 75, H, W);
                        break;
                    case 1:
                        g.fillOval(155, 75, H, W);
                        break;
                    case 2:
                        int x[] = {155,155+W,155+W/2};
                        int y[] = {75,75,75+H};
                        g.fillPolygon(x, y, 3);
                        break;
                    default:
                        break;
                }
        }
    }
    
    class Display extends TimerTask{
        @Override
        public void run(){
            
            f.repaint();
        }
    }   
}

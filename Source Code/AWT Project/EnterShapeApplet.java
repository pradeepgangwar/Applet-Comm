import java.awt.*; 
import java.awt.event.*; 
import java.applet.*; 
/* 
 
  <applet code="EnterShapeApplet" width="400" height="200" name="server">
    </applet>
  <applet code="ShowShapeApplet" width="400" height="400" name="client">
    </applet>
*/ 
 
public class EnterShapeApplet extends Applet { 
 
  TextField red, green, blue, size; 
  Frame main;
  ShowShapeApplet c;
  
  private Frame findParentFrame(){ 
    Container c = this; 
    while(c != null){ 
      if (c instanceof Frame) 
        return (Frame)c; 

      c = c.getParent(); 
    } 
    return (Frame)null; 
  } 
 
  public void init() { 
    GridLayout l = new GridLayout(4,1);
    setLayout(l);		//set frame layout
    
    Panel title = new Panel();
    Panel color = new Panel();	
    Panel values = new Panel();
    Panel control = new Panel();
    
    Label titleField = new Label("APPLET COMMUNICATION", Label.CENTER);
    Font myFont = new Font("Roboto",Font.BOLD,14);
    titleField.setFont(myFont);
    
    title.add(titleField);
    
    Label redp = new Label("Red: ", Label.RIGHT); 
    Label greenp = new Label("Green: ", Label.RIGHT); 
    Label bluep = new Label("Blue: ", Label.RIGHT); 
    
    red = new TextField(5); 
    green = new TextField(5); 
    blue = new TextField(5);
    
    //Add color entry fields to panel
    color.add(redp); 
    color.add(red); 
    color.add(greenp); 
    color.add(green);
    color.add(bluep);
    color.add(blue);
    
    //Add size entry fields to panel
    Label sizep = new Label("Size: ", Label.CENTER); 
    size = new TextField(7);
    
    values.add(sizep);
    values.add(size); 
    
    Button start = new Button("START");
    Button stop = new Button("STOP");
 	
    //Add control buttons to panel
    control.add(start);
    control.add(stop);
    
    //Add panels to main frame
    add(title,"title");
    add(color,"color");
    add(values,"values");
    add(control,"control");
    
    
    //IMPORTANT: Take context of second applet
    AppletContext ctx = getAppletContext();
    c = (ShowShapeApplet) ctx.getApplet("client");
    
    //click listener for 'start' button
    start.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            int valRed = Integer.parseInt(red.getText());
            int valGreen = Integer.parseInt(green.getText());
            int valBlue = Integer.parseInt(blue.getText());
            
            //Checking if RGB values are in spcified range
            if(valRed<0 || valRed >255 || valGreen<0 || valGreen >255 || valBlue<0 || valBlue >255){
            	ErrorDialog d = new ErrorDialog(findParentFrame());
            	d.setVisible(true);
            }
            
            else{
            	Color cr = new Color(valRed, valGreen, valBlue);
    	    	String size_text = size.getText();
            
            	c.startTransition(cr,Integer.parseInt(size_text));
            }
         }
    });
    
    //click listener for 'stop' button
    stop.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            Color cr = new Color(Integer.parseInt(red.getText()), Integer.parseInt(green.getText()), Integer.parseInt(blue.getText()));
    	    String size_text = size.getText();
            
            c.stopTransition(cr,Integer.parseInt(size_text));
         }
    });
  }
  
  class ErrorDialog extends Dialog {
      
      public ErrorDialog(Frame parent){
         
         super(parent, true);         
         
         setLayout(new BorderLayout());
         Panel panel = new Panel();
         Button bt = new Button("Close");
         panel.add(bt);
         
         bt.addActionListener(new ActionListener() {
         
		public void actionPerformed(ActionEvent e) {
			dispose();
         	}
    	 });
    	 
         add("South", panel);
         setSize(300,150);

         addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
               dispose();
            }
         });
      }

      public void paint(Graphics g){
         g.drawString("RGB values must be in range [0,255] !!", 25,70 );      
      }
   }
 
}


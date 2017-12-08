package Applet;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class EnterShapeApplet {

	private JFrame frame;
        static Color col;
        static ShowShapeApplet s;
        
	/**
	 * Launch the application.
     * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
                    try {
                        EnterShapeApplet window = new EnterShapeApplet();
                        window.frame.setVisible(true);
                    } catch (Exception e) {
                    }
                });
	}

	/**
	 * Create the application.
	 */
	public EnterShapeApplet() {
		initialize();
                s = new ShowShapeApplet();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
                frame.setTitle("Applet Communication");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//Color c;
		
		JLabel lblColor = new JLabel("Size :");
		lblColor.setFont(new Font("Roboto", Font.PLAIN , 20));
		lblColor.setBounds(180, 29, 86, 22);
		frame.getContentPane().add(lblColor);
		
		JSpinner height = new JSpinner();
		height.setBounds(90, 99, 51, 20);
		frame.getContentPane().add(height);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHeight.setBounds(145, 101, 68, 22);
		frame.getContentPane().add(lblHeight);
		
		JSpinner width = new JSpinner();
		width.setBounds(233,99, 51, 20);
		frame.getContentPane().add(width);
		
		JLabel lblWidth = new JLabel("Width");
		lblWidth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWidth.setBounds(287, 101, 46, 14);
		frame.getContentPane().add(lblWidth);
		
		JButton btnSelectColor = new JButton("Select Color");
		btnSelectColor.addActionListener((ActionEvent arg0) -> {
                    JColorChooser jcc = new JColorChooser();
                    Color c = JColorChooser.showDialog(null, "Please select a color!", Color.RED);
                    col = c;
                });
		btnSelectColor.setBounds(27, 196, 89, 23);
		frame.getContentPane().add(btnSelectColor);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener((ActionEvent e) -> {
                    int Height = (Integer)(height.getValue());
                    int Width = (Integer)(width.getValue());
//                  second s = new second();
//                  s.setVisible(Color.RED, Height, Width);
//                  shape s = new shape();
                    s.draw(col, Height, Width);
                });
		btnStart.setBounds(159, 196, 89, 23);
		frame.getContentPane().add(btnStart);
		
		JButton btnStop = new JButton("Stop");
                btnStop.addActionListener((ActionEvent e) -> {
                    s.cancel();
                });
		btnStop.setBounds(294, 196, 89, 23);
		frame.getContentPane().add(btnStop);
		  
	}
}


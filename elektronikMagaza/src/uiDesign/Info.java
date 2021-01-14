package uiDesign;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Info extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel versiyon,gelistirici;
	
    Info(){
    	setSize(300, 200);
		setLayout(null);
		setTitle("Bilgi");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		//label
		
		versiyon = new JLabel();
		versiyon.setText("V1.25.6");
		versiyon.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		versiyon.setForeground(Color.BLACK);
		versiyon.setBounds(95, 15, 100, 30);
		
		gelistirici = new JLabel();
		gelistirici.setText("Hodagh Software");
		gelistirici.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		gelistirici.setForeground(Color.BLACK);
		gelistirici.setBounds(45, 65, 250, 30);
		
		//add
		add(versiyon);
		add(gelistirici);
		
		setVisible(true);
   }

}

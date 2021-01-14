package uiDesign;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Models.Categories;
import sqlConnect.sqlServices;

public class ManagerCategory extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	sqlServices services = new sqlServices();
	JLabel cName,cDescription;
	JTextField cNameText;
	JTextArea cArea;
	JButton addCategory;
	
	public ManagerCategory() {
		setSize(500, 400);
		setLayout(null);
		setTitle("Kategori Ekleme");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		//label
		
		cName = new JLabel();
		cName.setText("Ad"); 
		cName.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		cName.setForeground(Color.BLACK);
		cName.setHorizontalAlignment(JLabel.CENTER);
		cName.setVerticalAlignment(JLabel.CENTER);
		cName.setBounds(0, 20, 140, 50);
		
		cDescription = new JLabel();
		cDescription.setText("Açýklama"); 
		cDescription.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		cDescription.setForeground(Color.BLACK);
		cDescription.setHorizontalAlignment(JLabel.CENTER);
		cDescription.setVerticalAlignment(JLabel.CENTER);
		cDescription.setBounds(0, 80, 140, 50);
		
		//text
		
		cNameText = new JTextField();
		cNameText.setForeground(Color.BLUE);
		cNameText.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		cNameText.setBounds(140, 28, 200, 40);
		
		//area
		
		cArea = new JTextArea();
		cArea.setForeground(Color.BLUE);
		cArea.setFont(new Font(Font.SANS_SERIF, Font.ROMAN_BASELINE, 20));
		cArea.setBounds(140, 80, 300, 100);
		cArea.setBackground(Color.white);
		cArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		cArea.setLineWrap(true);
		
		//btn
		
		addCategory = new JButton();
		addCategory.setText("Ekle"); 
		addCategory.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		addCategory.setForeground(Color.BLACK);
		addCategory.setHorizontalAlignment(JLabel.CENTER);
		addCategory.setVerticalAlignment(JLabel.CENTER);
		addCategory.setBounds(160,198, 100, 50);
		
		//add
		add(cName);
		add(cNameText);
		add(cDescription);
		add(cArea);
		add(addCategory);
		
		addCategory.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Categories category = new Categories();
					category.setName(cNameText.getText());
					category.setDescription(cArea.getText());
					services.addCategory(category);
					
					JOptionPane.showMessageDialog(ManagerCategory.this,category.getName()+" Baþarýyla Eklendi.","Alert",JOptionPane.WARNING_MESSAGE);     
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		
		
		setVisible(true);
	}
}

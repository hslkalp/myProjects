package uiDesign;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Models.Categories;
import Models.Products;
import sqlConnect.sqlServices;

public class ManagerCategory extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	sqlServices services = new sqlServices();
	JLabel cName,cDescription, discount;
	JTextField cNameText,productDiscount;
	JTextArea cArea;
	JButton addCategory,addDiscount;
	JComboBox<Categories> box;
	
	public ManagerCategory() {
		setSize(900, 900);
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
		
		discount = new JLabel();
		discount.setText("Ýndirim %"); 
		discount.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		discount.setForeground(Color.BLACK);
		discount.setHorizontalAlignment(JLabel.CENTER);
		discount.setVerticalAlignment(JLabel.CENTER);
		discount.setBounds(15, 330, 140, 50);
		
		//text
		
		cNameText = new JTextField();
		cNameText.setForeground(Color.BLUE);
		cNameText.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		cNameText.setBounds(140, 28, 200, 40);
		
		productDiscount = new JTextField();
		productDiscount.setForeground(Color.BLUE);
		productDiscount.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		productDiscount.setBounds(160, 336, 70, 40);
		
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
		
		addDiscount = new JButton();
		addDiscount.setText("uygula"); 
		addDiscount.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		addDiscount.setForeground(Color.BLACK);
		addDiscount.setHorizontalAlignment(JLabel.CENTER);
		addDiscount.setVerticalAlignment(JLabel.CENTER);
		addDiscount.setBounds(130,390, 150, 50);
		
		
		
		//JComboBox
		
		box = new JComboBox<Categories>();
		services.getCategories(box);
		box.setBounds(30, 280, 300, 40);
		
		//add
		add(cName);
		add(cNameText);
		add(cDescription);
		add(cArea);
		add(addCategory);
		add(box);
		add(discount);
		add(productDiscount);
		add(addDiscount);
		
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
		
		addDiscount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int categoryId = ((Categories)box.getSelectedItem()).getId();
					int discount = Integer.parseInt(productDiscount.getText());
					double rate = (double)(100+discount)/(double)100;
					services.setDiscount(categoryId, rate);
					JOptionPane.showMessageDialog(ManagerCategory.this," Ýndirim uygulandý.","Alert",JOptionPane.WARNING_MESSAGE); 
					productDiscount.setText("");
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("hataa");
				}
				
			}
		});
		
		
		setVisible(true);
	}
}

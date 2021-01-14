package uiDesign;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;



import Models.Employee;
import Models.Products;
import sqlConnect.sqlServices;

public class SaleProduct extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	sqlServices services = new sqlServices();
	JLabel pName,pPiece,unitPrice;
	JComboBox<Products> jComboBox;
	JTextField pPrice;
	JButton sellBtn;
	JSpinner piece;
	public SaleProduct(Employee employee) {
		setSize(720, 400);
		setLayout(null);
		setTitle("Giriþ Ekraný");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		//Label
		pName = new JLabel("Ürün: ");
		pName.setForeground(Color.BLACK);
		pName.setFont(new Font(Font.SERIF,Font.BOLD,20));
		pName.setBounds(30, 30, 100, 40);
		
		pPiece = new JLabel("Adet: ");
		pPiece.setForeground(Color.BLACK);
		pPiece.setFont(new Font(Font.SERIF,Font.BOLD,20));
		pPiece.setBounds(30, 80, 100, 40);
		
		
		unitPrice = new JLabel("Fiyat: ");
		unitPrice.setForeground(Color.BLACK);
		unitPrice.setFont(new Font(Font.SERIF,Font.BOLD,20));
		unitPrice.setBounds(30, 130, 100, 40);
		
	
		
		//JTextfield

		pPrice = new JTextField();
		pPrice.setForeground(Color.BLUE);
		pPrice.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		pPrice.setBounds(120, 130, 200, 40);
		//JComboBox
		
		jComboBox = new JComboBox<Products>();
		services.getProducts(jComboBox);
		jComboBox.setBounds(120, 30, 300, 40);
		
		//spinner
		SpinnerModel model = new SpinnerNumberModel(1,1,999,1);
		piece = new JSpinner(model);
		piece.setBounds(120,80, 80, 40);
		
		//JButton
		
		sellBtn = new JButton("satýþ");
		sellBtn.setBounds(160, 180, 100, 40);
		
		
		//add
		add(pName);
		add(pPiece);
		add(unitPrice);
		add(pPrice);
		add(jComboBox);
		add(piece);
		add(sellBtn);
		
		
	
		setVisible(true);
		
		sellBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Products selectedProducts = (Products) jComboBox.getSelectedItem();
				int stock = services.stock(selectedProducts);
				if((!"".equals(pPrice.getText())) && (selectedProducts.getStock() <= stock) &&
						((Integer)piece.getValue())<=stock) {
					services.sellProduct(selectedProducts, 
							(Integer)piece.getValue(), 
							employee, 
							Integer.parseInt(pPrice.getText()));
					JOptionPane.showMessageDialog(frame, "Satýþ Baþarýlý","Alert",JOptionPane.WARNING_MESSAGE);
				}else {
					
					JOptionPane.showMessageDialog(frame, "Satýþ Baþarýsýz deðerleri kontrol ediniz","Alert",JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		
		
	}
	
}

package uiDesign;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import sqlConnect.sqlServices;

public class ProductsTable extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	sqlServices services = new sqlServices();
	JTable productsJTable;
	JScrollPane jScrollPane;
	public ProductsTable() {
		setSize(1280, 520);
		setLayout(null);
		setTitle("Ürünler");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		//Table
		productsJTable = new JTable();
		productsJTable.setBounds(0, 0, 1280, 720);
		productsJTable.setFont(new Font(Font.MONOSPACED,Font.ROMAN_BASELINE,15));
		productsJTable.setForeground(Color.black);
		productsJTable.setEnabled(false);
		productsJTable.setBackground(Color.LIGHT_GRAY);
		productsJTable.setModel(DbUtils.resultSetToTableModel(services.getProducts()));
		
		
		
		//scroll
		jScrollPane = new JScrollPane(productsJTable);
		jScrollPane.setBounds(0, 0, 1280, 720);
		
		
		
		
		//add
		
		
		add(jScrollPane);
		
		
		
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new ProductsTable();
	}
}

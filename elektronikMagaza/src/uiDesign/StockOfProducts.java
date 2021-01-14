package uiDesign;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import sqlConnect.sqlServices;

public class StockOfProducts extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	sqlServices services = new sqlServices();
	JTable stockTable;
	JScrollPane jScrollPane;
	StockOfProducts(){
		setSize(1280, 520);
		setLayout(null);
		setTitle("Ürün Stok");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		//Table
		stockTable = new JTable();
		stockTable.setBounds(0, 0, 1280, 720);
		stockTable.setFont(new Font(Font.MONOSPACED,Font.ROMAN_BASELINE,15));
		stockTable.setForeground(Color.black);
		stockTable.setEnabled(false);
		stockTable.setBackground(Color.LIGHT_GRAY);
		stockTable.setModel(DbUtils.resultSetToTableModel(services.getStockOfProducts()));
						
		//scroll
		jScrollPane = new JScrollPane(stockTable);
		jScrollPane.setBounds(0, 0, 1280, 720);
				
		//add
				
		add(jScrollPane);
		
		
		
		
		
		
		setVisible(true);
	}
}

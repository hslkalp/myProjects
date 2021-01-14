package uiDesign;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import sqlConnect.sqlServices;

public class Catalog extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	sqlServices services = new sqlServices();
	JTable catalogTable;
	JScrollPane jScrollPane;
	public Catalog() {
		// TODO Auto-generated constructor stub
		setSize(1280, 520);
		setLayout(null);
		setTitle("Ürün Katalog");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		//Table
		catalogTable = new JTable();
		catalogTable.setBounds(0, 0, 1280, 720);
		catalogTable.setFont(new Font(Font.MONOSPACED,Font.ROMAN_BASELINE,15));
		catalogTable.setForeground(Color.black);
		catalogTable.setEnabled(false);
		catalogTable.setBackground(Color.LIGHT_GRAY);
		catalogTable.setModel(DbUtils.resultSetToTableModel(services.catalog()));
						
		//scroll
		jScrollPane = new JScrollPane(catalogTable);
		jScrollPane.setBounds(0, 0, 1280, 720);
				
		//add
				
		add(jScrollPane);
		
		
		
		
		
		
		setVisible(true);
	}
}

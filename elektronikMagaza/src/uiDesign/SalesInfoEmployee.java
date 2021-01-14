package uiDesign;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import sqlConnect.sqlServices;

public class SalesInfoEmployee extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	sqlServices services = new sqlServices();
	JTable salesTable;
	JScrollPane jScrollPane;
	public SalesInfoEmployee() {
		setSize(1280, 520);
		setLayout(null);
		setTitle("Personel Satýþlar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		//Table
		salesTable = new JTable();
		salesTable.setBounds(0, 0, 1280, 720);
		salesTable.setFont(new Font(Font.MONOSPACED,Font.ROMAN_BASELINE,15));
		salesTable.setForeground(Color.black);
		salesTable.setEnabled(false);
		salesTable.setBackground(Color.LIGHT_GRAY);
		salesTable.setModel(DbUtils.resultSetToTableModel(services.getSales()));
				
		//scroll
		jScrollPane = new JScrollPane(salesTable);
		jScrollPane.setBounds(0, 0, 1280, 720);
		
		//add
		
		add(jScrollPane);
		
		
		
		
		setVisible(true);
	}
}

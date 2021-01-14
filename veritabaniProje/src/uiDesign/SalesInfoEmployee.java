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
	JTable salesTable,salesMax;
	JScrollPane jScrollPane,jScrollPane2;
	public SalesInfoEmployee() {
		setSize(1280, 520);
		setLayout(null);
		setTitle("Personel Satýþlar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		//Table
		salesTable = new JTable();
		salesTable.setBounds(0, 0, 1280, 420);
		salesTable.setFont(new Font(Font.MONOSPACED,Font.ROMAN_BASELINE,15));
		salesTable.setForeground(Color.black);
		salesTable.setEnabled(false);
		salesTable.setBackground(Color.LIGHT_GRAY);
		salesTable.setModel(DbUtils.resultSetToTableModel(services.getSales()));
		
		//Table
		salesMax = new JTable();
		salesMax.setBounds(0, 420, 1280, 100);
		salesMax.setFont(new Font(Font.MONOSPACED,Font.ROMAN_BASELINE,15));
		salesMax.setForeground(Color.black);
		salesMax.setEnabled(false);
		salesMax.setBackground(Color.LIGHT_GRAY);
		salesMax.setModel(DbUtils.resultSetToTableModel(services.getMaxSale()));
				
		//scroll
		jScrollPane = new JScrollPane(salesTable);
		jScrollPane.setBounds(0, 0, 1280, 420);
		
		//scroll
		jScrollPane2 = new JScrollPane(salesMax);
	    jScrollPane2.setBounds(0, 420, 1280, 100);
		
		//add
		
		add(jScrollPane);
		add(jScrollPane2);
		
		
		
		setVisible(true);
	}
}

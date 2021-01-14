package uiDesign;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Models.Directors;
import net.proteanit.sql.DbUtils;
import sqlConnect.sqlServices;

public class EmployeeTable extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	sqlServices services = new sqlServices();
	JTable employeeTable;
	JScrollPane jScrollPane;
	public EmployeeTable(Directors directors) {
		setSize(1280, 520);
		setLayout(null);
		setTitle("Çalýþanlar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		//Table
		employeeTable = new JTable();
		employeeTable.setBounds(0, 0, 1280, 720);
		employeeTable.setFont(new Font(Font.MONOSPACED,Font.ROMAN_BASELINE,15));
		employeeTable.setForeground(Color.black);
		employeeTable.setEnabled(false);
		employeeTable.setBackground(Color.LIGHT_GRAY);
		employeeTable.setModel(DbUtils.resultSetToTableModel(services.getEmployeeForManager(directors)));
		
		//scroll
		jScrollPane = new JScrollPane(employeeTable);
		jScrollPane.setBounds(0, 0, 1280, 720);
		
		
		
		//add
		add(jScrollPane);
				
		
		setVisible(true);
	}
	
}

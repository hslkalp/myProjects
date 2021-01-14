package uiDesign;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import Models.Directors;
import sqlConnect.sqlServices;

public class ManagerDashBoard extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	sqlServices services = new sqlServices();
	JPanel header,main,dashboard;
	JPanel maganerEmployeePanel,mEmployeeWrap,salesInfoEmployee,salesInfoEWrap;
	JPanel catalogPanel,catalogWrap;
	
	JPanel productStock,productStockWrap;
	JLabel pStockTitle,pStockSubTitle,pStockIcon;
	
	JLabel catalogTitle,catalogSubTitle,catalogIcon;
	JLabel salesInfoTitle,salesInfoSubTitle,salesInfoIcon;
	JLabel mEmployeeTitle,mEmployeeSubTitle,mEmployeeIcon;
	JLabel managerName,managerIcon,managerDepartment;
	JScrollPane jScrollPane;
	JTabbedPane mainJTabbedPane;
	public ManagerDashBoard(Directors directors) {
		// TODO Auto-generated constructor stub
		setSize(1300, 720);
		setLayout(null);
		setTitle("Yönetici Kontrol Paneli ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		//label
		managerName = new JLabel();
		managerName.setText(directors.getName()+" "+directors.getLastName()); //Giriþ yapan kiþinin ismi alýnacak
		managerName.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		managerName.setForeground(Color.BLACK);
		managerName.setBounds(92, 2, 200, 60);
		
		managerDepartment = new JLabel();
		managerDepartment.setText(services.getDepartmentName(directors.getDepartment_id())+" Müdürü"); //Giriþ yapan kiþinin ismi alýnacak
		managerDepartment.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,15));
		managerDepartment.setForeground(Color.BLACK);
		managerDepartment.setBounds(92, 30, 200, 60);
		
		mEmployeeTitle = new JLabel();
		mEmployeeTitle.setText("Personel"); 
		mEmployeeTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		mEmployeeTitle.setForeground(Color.white);
		mEmployeeTitle.setHorizontalAlignment(JLabel.CENTER);
		mEmployeeTitle.setVerticalAlignment(JLabel.CENTER);
		mEmployeeTitle.setBounds(0, 0, 300, 50);
		
		mEmployeeSubTitle = new JLabel();
		mEmployeeSubTitle.setText("Personel Listesi"); 
		mEmployeeSubTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		mEmployeeSubTitle.setForeground(Color.BLACK);
		mEmployeeSubTitle.setHorizontalAlignment(JLabel.CENTER);
		mEmployeeSubTitle.setVerticalAlignment(JLabel.CENTER);
		mEmployeeSubTitle.setBounds(50, 230, 200, 30);
		
		salesInfoTitle = new JLabel();
		salesInfoTitle.setText("Satýþlar"); 
		salesInfoTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		salesInfoTitle.setForeground(Color.white);
		salesInfoTitle.setHorizontalAlignment(JLabel.CENTER);
		salesInfoTitle.setVerticalAlignment(JLabel.CENTER);
		salesInfoTitle.setBounds(0, 0, 300, 50);
		
		salesInfoSubTitle = new JLabel();
		salesInfoSubTitle.setText("Satýþ Listesi"); 
		salesInfoSubTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		salesInfoSubTitle.setForeground(Color.BLACK);
		salesInfoSubTitle.setHorizontalAlignment(JLabel.CENTER);
		salesInfoSubTitle.setVerticalAlignment(JLabel.CENTER);
		salesInfoSubTitle.setBounds(50, 230, 200, 30);
		
		catalogTitle = new JLabel();
		catalogTitle.setText("Katalog"); 
		catalogTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		catalogTitle.setForeground(Color.white);
		catalogTitle.setHorizontalAlignment(JLabel.CENTER);
		catalogTitle.setVerticalAlignment(JLabel.CENTER);
		catalogTitle.setBounds(0, 0, 300, 50);
		
		catalogSubTitle = new JLabel();
		catalogSubTitle.setText("Katalog Listesi"); 
		catalogSubTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		catalogSubTitle.setForeground(Color.BLACK);
		catalogSubTitle.setHorizontalAlignment(JLabel.CENTER);
		catalogSubTitle.setVerticalAlignment(JLabel.CENTER);
		catalogSubTitle.setBounds(50, 230, 200, 30);
		
		
		//
		pStockTitle = new JLabel();
		pStockTitle.setText("Stok"); 
		pStockTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		pStockTitle.setForeground(Color.white);
		pStockTitle.setHorizontalAlignment(JLabel.CENTER);
		pStockTitle.setVerticalAlignment(JLabel.CENTER);
		pStockTitle.setBounds(0, 0, 300, 50);
		
		pStockSubTitle = new JLabel();
		pStockSubTitle.setText("Stok Listesi"); 
		pStockSubTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		pStockSubTitle.setForeground(Color.BLACK);
		pStockSubTitle.setHorizontalAlignment(JLabel.CENTER);
		pStockSubTitle.setVerticalAlignment(JLabel.CENTER);
		pStockSubTitle.setBounds(50, 230, 200, 30);
		
		
		
		
		//icon
		managerIcon = new JLabel();
		managerIcon.setHorizontalAlignment(JLabel.CENTER);
		managerIcon.setVerticalAlignment(JLabel.CENTER);
		managerIcon.setIcon(new ImageIcon("images/icons8_manager_52px_1.png"));
		managerIcon.setBounds(20, 20, 52, 52);
		
		mEmployeeIcon = new JLabel();
		mEmployeeIcon.setHorizontalAlignment(JLabel.CENTER);
		mEmployeeIcon.setVerticalAlignment(JLabel.CENTER);
		mEmployeeIcon.setIcon(new ImageIcon("images/team.png"));
		mEmployeeIcon.setBounds(86, 90, 128, 128);
		
		salesInfoIcon = new JLabel();
		salesInfoIcon.setHorizontalAlignment(JLabel.CENTER);
		salesInfoIcon.setVerticalAlignment(JLabel.CENTER);
		salesInfoIcon.setIcon(new ImageIcon("images/sales2.png"));
		salesInfoIcon.setBounds(86, 90, 128, 128);
		
		catalogIcon = new JLabel();
		catalogIcon.setHorizontalAlignment(JLabel.CENTER);
		catalogIcon.setVerticalAlignment(JLabel.CENTER);
		catalogIcon.setIcon(new ImageIcon("images/catalog.png"));
		catalogIcon.setBounds(86, 90, 128, 128);
		
		
		pStockIcon = new JLabel();
		pStockIcon.setHorizontalAlignment(JLabel.CENTER);
		pStockIcon.setVerticalAlignment(JLabel.CENTER);
		pStockIcon.setIcon(new ImageIcon("images/packages.png"));
		pStockIcon.setBounds(86, 90, 128, 128);
		
		//Panel
		
		header = new JPanel();
		header.setBounds(0, 0, 1280, 150);
		header.setBackground(Color.WHITE);
		header.setLayout(null);
		
		
		main = new JPanel();
		main.setBounds(0, 150, 1280, 1020);
		main.setBackground(Color.WHITE);
		main.setLayout(null);
		
		dashboard = new JPanel();
		dashboard.setPreferredSize(new Dimension(1280, 920));
		dashboard.setBackground(new Color(83, 104, 153));
		dashboard.setLayout(null);
		
		//panel
		
		maganerEmployeePanel = new JPanel();
		maganerEmployeePanel.setBounds(50, 50, 300, 300);
		maganerEmployeePanel.setBackground(Color.WHITE);
		maganerEmployeePanel.setLayout(null);
		maganerEmployeePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		mEmployeeWrap = new JPanel();
		mEmployeeWrap.setBounds(0, 0, 300, 50);
		mEmployeeWrap.setBackground(new Color(17, 56, 84));
		mEmployeeWrap.setLayout(null);
		
		salesInfoEmployee = new JPanel();
		salesInfoEmployee.setBounds(400, 50, 300, 300);
		salesInfoEmployee.setBackground(Color.WHITE);
		salesInfoEmployee.setLayout(null);
		salesInfoEmployee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		salesInfoEmployee.setVisible(false);
		
		salesInfoEWrap = new JPanel();
		salesInfoEWrap.setBounds(0, 0, 300, 50);
		salesInfoEWrap.setBackground(new Color(17, 56, 84));
		salesInfoEWrap.setLayout(null);
		
		catalogPanel = new JPanel();
		catalogPanel.setBounds(750, 50, 300, 300);
		catalogPanel.setBackground(Color.WHITE);
		catalogPanel.setLayout(null);
		catalogPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		catalogPanel.setVisible(false);
		
		catalogWrap = new JPanel();
		catalogWrap.setBounds(0, 0, 300, 50);
		catalogWrap.setBackground(new Color(17, 56, 84));
		catalogWrap.setLayout(null);
		
		//
		
		productStock = new JPanel();
		productStock.setBounds(400, 50, 300, 300);
		productStock.setBackground(Color.WHITE);
		productStock.setLayout(null);
		productStock.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		productStock.setVisible(false);
		
		productStockWrap = new JPanel();
		productStockWrap.setBounds(0, 0, 300, 50);
		productStockWrap.setBackground(new Color(17, 56, 84));
		productStockWrap.setLayout(null);
		
		//Pane
		
		mainJTabbedPane = new JTabbedPane();
		mainJTabbedPane.setBounds(0, 0, 1280, 720);
		mainJTabbedPane.setBorder(null);
		mainJTabbedPane.setBackground(Color.WHITE);
		mainJTabbedPane.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		
		
		//scroll
		jScrollPane = new JScrollPane(dashboard,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    jScrollPane.setBounds(0, 0, 1280, 1020);
	   
	    if(directors.getDepartment_id() == 1) {
	    	salesInfoEmployee.setVisible(true);
	    	catalogPanel.setVisible(true);
	    }else {
	    	productStock.setVisible(true);
	    }
	    
	    //add
	    
	    add(header);
		add(main);
		main.add(mainJTabbedPane);
		header.add(managerName);
		header.add(managerIcon);
		header.add(managerDepartment);
	    mainJTabbedPane.add(new JScrollPane(dashboard),"Kontrol Paneli");
	    
	    dashboard.add(maganerEmployeePanel);
	    maganerEmployeePanel.add(mEmployeeWrap);
		mEmployeeWrap.add(mEmployeeTitle);
		maganerEmployeePanel.add(mEmployeeSubTitle);
		maganerEmployeePanel.add(mEmployeeIcon);
		
		dashboard.add(salesInfoEmployee);
		salesInfoEmployee.add(salesInfoEWrap);
		salesInfoEmployee.add(salesInfoIcon);
		salesInfoEWrap.add(salesInfoTitle);
		salesInfoEmployee.add(salesInfoSubTitle);
		
		dashboard.add(catalogPanel);
		catalogPanel.add(catalogWrap);
		catalogWrap.add(catalogTitle);
		catalogPanel.add(catalogSubTitle);
		catalogPanel.add(catalogIcon);
		
		
		dashboard.add(productStock);
		productStock.add(productStockWrap);
		productStockWrap.add(pStockTitle);
		productStock.add(pStockSubTitle);
		productStock.add(pStockIcon);
		
		setVisible(true);
		
		
		maganerEmployeePanel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				new EmployeeTable(directors);
			}
		});
		
		salesInfoEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				new SalesInfoEmployee();
			}
		});
		
		catalogPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				new Catalog();
			}
		});
		
		productStock.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				new StockOfProducts();
			}
		});
	}
	
	
}

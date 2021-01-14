package uiDesign;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import Models.Employee;
import sqlConnect.sqlServices;

public class EmployeeDashBoard extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	sqlServices services = new sqlServices();
	JPanel header,main,dashboard,productsPanel,productsWrap;
	JPanel sProductsPanel,sProductsWrap,saleProductPanel,saleProductWrap,saleSelfEmployee,saleSelfEmployeeWrap;
	JPanel productManager,productManagerWrap;
	
	JPanel categoryManager,categoryManagerWrap;
	JLabel cManagerTitle,cManagerSubTitle,cManagerIcon;
	
	JLabel pManagerTitle,pManagerSubTitle,pManagerIcon;
	JLabel sPPanelTitle,sPPanelSubTitle,sPPanelIcon,saleProductTitle,saleProductSubTitle,saleProductIcon;
	JLabel employeeIcon,employeeName,employeeDepartment,pPanelTitle,pPanelSubTitle,productsPanelIcon;
	JLabel saleSelfEmployeeTitle,saleSelfEmployeeSubTitle,saleSelfEmployeeIcon;
	JTabbedPane mainJTabbedPane;
	JScrollPane jScrollPane;
	
	public EmployeeDashBoard(Employee employee) {
		setSize(1300, 720);
		setLayout(null);
		setTitle("Personel Kontrol Paneli ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		//Label
		employeeName = new JLabel();
		employeeName.setText(employee.getName()+" "+employee.getLastName()); //Giriþ yapan kiþinin ismi alýnacak
		employeeName.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		employeeName.setForeground(Color.BLACK);
		employeeName.setBounds(92, 2, 200, 60);
		
		pPanelTitle = new JLabel();
		pPanelTitle.setText("ÜRÜNLER"); 
		pPanelTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		pPanelTitle.setForeground(Color.white);
		pPanelTitle.setHorizontalAlignment(JLabel.CENTER);
		pPanelTitle.setVerticalAlignment(JLabel.CENTER);
		pPanelTitle.setBounds(0, 0, 300, 50);
		
		pPanelSubTitle = new JLabel();
		pPanelSubTitle.setText("Ürünlerin Listesi"); 
		pPanelSubTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		pPanelSubTitle.setForeground(Color.BLACK);
		pPanelSubTitle.setHorizontalAlignment(JLabel.CENTER);
		pPanelSubTitle.setVerticalAlignment(JLabel.CENTER);
		pPanelSubTitle.setBounds(50, 230, 200, 30);
		
		saleSelfEmployeeTitle = new JLabel();
		saleSelfEmployeeTitle.setText("SATIÞLARIM"); 
		saleSelfEmployeeTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		saleSelfEmployeeTitle.setForeground(Color.white);
		saleSelfEmployeeTitle.setHorizontalAlignment(JLabel.CENTER);
		saleSelfEmployeeTitle.setVerticalAlignment(JLabel.CENTER);
		saleSelfEmployeeTitle.setBounds(0, 0, 300, 50);
		
		saleSelfEmployeeSubTitle = new JLabel();
		saleSelfEmployeeSubTitle.setText("Satýþ Detay"); 
		saleSelfEmployeeSubTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		saleSelfEmployeeSubTitle.setForeground(Color.BLACK);
		saleSelfEmployeeSubTitle.setHorizontalAlignment(JLabel.CENTER);
		saleSelfEmployeeSubTitle.setVerticalAlignment(JLabel.CENTER);
		saleSelfEmployeeSubTitle.setBounds(50, 230, 200, 30);
		
		sPPanelTitle = new JLabel();
		sPPanelTitle.setText("Ürün Arama"); 
		sPPanelTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		sPPanelTitle.setForeground(Color.white);
		sPPanelTitle.setHorizontalAlignment(JLabel.CENTER);
		sPPanelTitle.setVerticalAlignment(JLabel.CENTER);
		sPPanelTitle.setBounds(0, 0, 300, 50);
		
		sPPanelSubTitle = new JLabel();
		sPPanelSubTitle.setText("Geliþmiþ Arama"); 
		sPPanelSubTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		sPPanelSubTitle.setForeground(Color.BLACK);
		sPPanelSubTitle.setHorizontalAlignment(JLabel.CENTER);
		sPPanelSubTitle.setVerticalAlignment(JLabel.CENTER);
		sPPanelSubTitle.setBounds(50, 230, 200, 30);
		
		saleProductTitle = new JLabel();
		saleProductTitle.setText("Ürün Satýþ"); 
		saleProductTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		saleProductTitle.setForeground(Color.white);
		saleProductTitle.setHorizontalAlignment(JLabel.CENTER);
		saleProductTitle.setVerticalAlignment(JLabel.CENTER);
		saleProductTitle.setBounds(0, 0, 300, 50);
		
		
		saleProductSubTitle = new JLabel();
		saleProductSubTitle.setText("Satýþ Ekraný"); 
		saleProductSubTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		saleProductSubTitle.setForeground(Color.BLACK);
		saleProductSubTitle.setHorizontalAlignment(JLabel.CENTER);
		saleProductSubTitle.setVerticalAlignment(JLabel.CENTER);
		saleProductSubTitle.setBounds(50, 230, 200, 30);
		
		//
		pManagerTitle = new JLabel();
		pManagerTitle.setText("Ürün Ýþlem"); 
		pManagerTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		pManagerTitle.setForeground(Color.white);
		pManagerTitle.setHorizontalAlignment(JLabel.CENTER);
		pManagerTitle.setVerticalAlignment(JLabel.CENTER);
		pManagerTitle.setBounds(0, 0, 300, 50);
		
		
		pManagerSubTitle = new JLabel();
		pManagerSubTitle.setText("Ekle/Sil/Güncelle"); 
		pManagerSubTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		pManagerSubTitle.setForeground(Color.BLACK);
		pManagerSubTitle.setHorizontalAlignment(JLabel.CENTER);
		pManagerSubTitle.setVerticalAlignment(JLabel.CENTER);
		pManagerSubTitle.setBounds(50, 230, 200, 30);
		
		cManagerTitle = new JLabel();
		cManagerTitle.setText("Kategori Ýþlem"); 
		cManagerTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		cManagerTitle.setForeground(Color.white);
		cManagerTitle.setHorizontalAlignment(JLabel.CENTER);
		cManagerTitle.setVerticalAlignment(JLabel.CENTER);
		cManagerTitle.setBounds(0, 0, 300, 50);
		
		
		cManagerSubTitle = new JLabel();
		cManagerSubTitle.setText("Kategori Ekle"); 
		cManagerSubTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		cManagerSubTitle.setForeground(Color.BLACK);
		cManagerSubTitle.setHorizontalAlignment(JLabel.CENTER);
		cManagerSubTitle.setVerticalAlignment(JLabel.CENTER);
		cManagerSubTitle.setBounds(50, 230, 200, 30);
		
		//
		
		employeeDepartment = new JLabel();
		employeeDepartment.setText(services.getDepartmentName(employee.getDepartment_id())+" Personeli"); //Giriþ yapan kiþinin ismi alýnacak
		employeeDepartment.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,15));
		employeeDepartment.setForeground(Color.BLACK);
		employeeDepartment.setBounds(92, 30, 200, 60);
		
		//Icon
		
		
		employeeIcon = new JLabel();
		employeeIcon.setHorizontalAlignment(JLabel.CENTER);
		employeeIcon.setVerticalAlignment(JLabel.CENTER);
		employeeIcon.setIcon(new ImageIcon("images/icons8_worker_52px.png"));
		employeeIcon.setBounds(20, 20, 52, 52);
		
		productsPanelIcon = new JLabel();
		productsPanelIcon.setHorizontalAlignment(JLabel.CENTER);
		productsPanelIcon.setVerticalAlignment(JLabel.CENTER);
		productsPanelIcon.setIcon(new ImageIcon("images/box.png"));
		productsPanelIcon.setBounds(86, 90, 128, 128);
		
		sPPanelIcon = new JLabel();
		sPPanelIcon.setHorizontalAlignment(JLabel.CENTER);
		sPPanelIcon.setVerticalAlignment(JLabel.CENTER);
		sPPanelIcon.setIcon(new ImageIcon("images/product.png"));
		sPPanelIcon.setBounds(86, 90, 128, 128);
		
		
		saleProductIcon = new JLabel();
		saleProductIcon.setHorizontalAlignment(JLabel.CENTER);
		saleProductIcon.setVerticalAlignment(JLabel.CENTER);
		saleProductIcon.setIcon(new ImageIcon("images/sales.png"));
		saleProductIcon.setBounds(86, 90, 128, 128);
		
		saleSelfEmployeeIcon = new JLabel();
		saleSelfEmployeeIcon.setHorizontalAlignment(JLabel.CENTER);
		saleSelfEmployeeIcon.setVerticalAlignment(JLabel.CENTER);
		saleSelfEmployeeIcon.setIcon(new ImageIcon("images/sales2.png"));
		saleSelfEmployeeIcon.setBounds(86, 90, 128, 128);
		
		cManagerIcon = new JLabel();
		cManagerIcon.setHorizontalAlignment(JLabel.CENTER);
		cManagerIcon.setVerticalAlignment(JLabel.CENTER);
		cManagerIcon.setIcon(new ImageIcon("images/category.png"));
		cManagerIcon.setBounds(86, 90, 128, 128);
		
		
		//
		
		pManagerIcon = new JLabel();
		pManagerIcon.setHorizontalAlignment(JLabel.CENTER);
		pManagerIcon.setVerticalAlignment(JLabel.CENTER);
		pManagerIcon.setIcon(new ImageIcon("images/management.png"));
		pManagerIcon.setBounds(86, 90, 128, 128);
		
		//
		
		//JPanel
		
		header = new JPanel();
		header.setBounds(0, 0, 1280, 150);
		header.setBackground(Color.WHITE);
		header.setLayout(null);
		
		
		main = new JPanel();
		main.setBounds(0, 150, 1280, 1020);
		main.setBackground(Color.WHITE);
		main.setLayout(null);
		
		dashboard = new JPanel();
		//dashboard.setBounds(0, 0, 1280, 720);
		dashboard.setPreferredSize(new Dimension(1280, 920));
		dashboard.setBackground(new Color(83, 104, 153));
		dashboard.setLayout(null);
		
		productsPanel = new JPanel();
		productsPanel.setBounds(50, 50, 300, 300);
		productsPanel.setBackground(Color.WHITE);
		productsPanel.setLayout(null);
		productsPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		
		sProductsPanel = new JPanel();
		sProductsPanel.setBounds(400, 50, 300, 300);
		sProductsPanel.setBackground(Color.WHITE);
		sProductsPanel.setLayout(null);
		sProductsPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		saleProductPanel = new JPanel();
		saleProductPanel.setBounds(750, 50, 300, 300);
		saleProductPanel.setBackground(Color.WHITE);
		saleProductPanel.setLayout(null);
		saleProductPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		saleProductPanel.setVisible(false);
		
		saleSelfEmployee = new JPanel();
		saleSelfEmployee.setBounds(50, 400, 300, 300);
		saleSelfEmployee.setBackground(Color.WHITE);
		saleSelfEmployee.setLayout(null);
		saleSelfEmployee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		saleSelfEmployee.setVisible(false);
		
		//
		
		productManager = new JPanel();
		productManager.setBounds(750, 50, 300, 300);
		productManager.setBackground(Color.WHITE);
		productManager.setLayout(null);
		productManager.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		productManager.setVisible(false);
		
		
		//
		
		categoryManager = new JPanel();
		categoryManager.setBounds(50, 400, 300, 300);
		categoryManager.setBackground(Color.WHITE);
		categoryManager.setLayout(null);
		categoryManager.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		categoryManager.setVisible(false);
		
		
		
		productsWrap = new JPanel();
		productsWrap.setBounds(0, 0, 300, 50);
		productsWrap.setBackground(new Color(58, 70, 92));
		productsWrap.setLayout(null);
		
		sProductsWrap = new JPanel();
		sProductsWrap.setBounds(0, 0, 300, 50);
		sProductsWrap.setBackground(Color.ORANGE);
		sProductsWrap.setLayout(null);
		
		saleProductWrap = new JPanel();
		saleProductWrap.setBounds(0, 0, 300, 50);
		saleProductWrap.setBackground(new Color(83, 134, 230));
		saleProductWrap.setLayout(null);
		
		saleSelfEmployeeWrap = new JPanel();
		saleSelfEmployeeWrap.setBounds(0, 0, 300, 50);
		saleSelfEmployeeWrap.setBackground(new Color(17, 56, 84));
		saleSelfEmployeeWrap.setLayout(null);
		
		//
		
		productManagerWrap = new JPanel();
		productManagerWrap.setBounds(0, 0, 300, 50);
		productManagerWrap.setBackground(new Color(12, 18, 46));
		productManagerWrap.setLayout(null);
		
		
		//
		
		categoryManagerWrap = new JPanel();
		categoryManagerWrap.setBounds(0, 0, 300, 50);
		categoryManagerWrap.setBackground(new Color(41, 37, 77));
		categoryManagerWrap.setLayout(null);
		
		//Pane
		
		mainJTabbedPane = new JTabbedPane();
		mainJTabbedPane.setBounds(0, 0, 1280, 720);
		mainJTabbedPane.setBorder(null);
		mainJTabbedPane.setBackground(Color.WHITE);
		mainJTabbedPane.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		
		//scroll
		jScrollPane = new JScrollPane(dashboard,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setBounds(0, 0, 1280, 1020);
		
		//Görünümler
		
		if(employee.getDepartment_id() == 1) {
			saleProductPanel.setVisible(true);
			saleSelfEmployee.setVisible(true);
		}else {
			productManager.setVisible(true);
			categoryManager.setVisible(true);
		}
		
		//add
		
		add(header);
		add(main);
		main.add(mainJTabbedPane);
		header.add(employeeIcon);
		header.add(employeeName);
		header.add(employeeDepartment);
		
		
		dashboard.add(saleSelfEmployee);
		saleSelfEmployee.add(saleSelfEmployeeWrap);
		saleSelfEmployeeWrap.add(saleSelfEmployeeTitle);
		saleSelfEmployee.add(saleSelfEmployeeSubTitle);
		saleSelfEmployee.add(saleSelfEmployeeIcon);
		
		dashboard.add(saleProductPanel);
		saleProductPanel.add(saleProductWrap);
		saleProductWrap.add(saleProductTitle);
		saleProductPanel.add(saleProductIcon);
		saleProductPanel.add(saleProductSubTitle);
		
		dashboard.add(productsPanel);
		productsPanel.add(productsWrap);
		productsPanel.add(productsPanelIcon);
		productsPanel.add(pPanelSubTitle);
		productsWrap.add(pPanelTitle);
		
		dashboard.add(sProductsPanel);
		sProductsPanel.add(sProductsWrap);
		sProductsWrap.add(sPPanelTitle);
		sProductsPanel.add(sPPanelSubTitle);
		sProductsPanel.add(sPPanelIcon);
		
		
		dashboard.add(productManager);
		productManager.add(productManagerWrap);
		productManager.add(pManagerSubTitle);
		productManagerWrap.add(pManagerTitle);
		productManager.add(pManagerIcon);
		
		dashboard.add(categoryManager);
		categoryManager.add(categoryManagerWrap);
		categoryManagerWrap.add(cManagerTitle);
		categoryManager.add(cManagerSubTitle);
		categoryManager.add(cManagerIcon);
		
		//panelleri eklemeyi dene tabbed pane !!!!

		mainJTabbedPane.add(new JScrollPane(dashboard),"Kontrol Paneli");
		
		setVisible(true);
		
		//event
		
		productsPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				new ProductsTable();
			}
		});
		
		sProductsPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				new OnlySearchProducts();
			}
		});
		
		saleProductPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				new SaleProduct(employee);
			}
		});
		
		saleSelfEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				new SalesSelfEmployee(employee);
			}
		});
		
		productManager.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				new managerProducts();
			}
		});
		
		categoryManager.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				new ManagerCategory();
			}
		});
		
		
		
		
	}
	
}

package uiDesign;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



import Models.Categories;
import Models.Products;
import sqlConnect.sqlServices;

public class managerProducts extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Products products = new Products();
	sqlServices services = new sqlServices();
	JTabbedPane jTabbedPane;
	JPanel addProduct,updateDeleteProduct,selectedProduct;
	JLabel pName,pPrice,pStock,pDescription,pImageUrl,pCategory,productsTitle;
	JLabel sPName,sPPrice,sPStock,sPDescription,sPImageUrl,sPCategory;
	JLabel searchInfo;
	JTextField pNameText,pPriceText;
	JTextField sPNameText,sPPriceText,searchProductsText;
	JSpinner pPiece,sPPiece;
	JFileChooser chooser;
	JButton addImage,sPAddImage,addProductBtn,updateProduct,deleteProduct;
	JComboBox<Categories> box,box2;
	JTextArea area,sPArea ;
	JList productsList;
	JScrollPane jScrollPane;
	String sorguSýralama="";
	public managerProducts() {
		setSize(1280, 720);
		setLayout(null);
		setTitle("Ürün Yönetim");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		
		//Label
		pName = new JLabel();
		pName.setText("Ad"); 
		pName.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		pName.setForeground(Color.BLACK);
		pName.setHorizontalAlignment(JLabel.CENTER);
		pName.setVerticalAlignment(JLabel.CENTER);
		pName.setBounds(0, 20, 140, 50);
		
		pPrice = new JLabel();
		pPrice.setText("Fiyat"); 
		pPrice.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		pPrice.setForeground(Color.BLACK);
		pPrice.setHorizontalAlignment(JLabel.CENTER);
		pPrice.setVerticalAlignment(JLabel.CENTER);
		pPrice.setBounds(0, 90, 140, 50);
		
		pStock = new JLabel();
		pStock.setText("Adet"); 
		pStock.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		pStock.setForeground(Color.BLACK);
		pStock.setHorizontalAlignment(JLabel.CENTER);
		pStock.setVerticalAlignment(JLabel.CENTER);
		pStock.setBounds(0, 160, 140, 50);
		
		pImageUrl = new JLabel();
		pImageUrl.setText("Resim"); 
		pImageUrl.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		pImageUrl.setForeground(Color.BLACK);
		pImageUrl.setHorizontalAlignment(JLabel.CENTER);
		pImageUrl.setVerticalAlignment(JLabel.CENTER);
		pImageUrl.setBounds(0, 230, 140, 50);
		
		pCategory = new JLabel();
		pCategory.setText("Kategori"); 
		pCategory.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		pCategory.setForeground(Color.BLACK);
		pCategory.setHorizontalAlignment(JLabel.CENTER);
		pCategory.setVerticalAlignment(JLabel.CENTER);
		pCategory.setBounds(0, 300, 140, 50);
		
		pDescription = new JLabel();
		pDescription.setText("Açýklama"); 
		pDescription.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		pDescription.setForeground(Color.BLACK);
		pDescription.setHorizontalAlignment(JLabel.CENTER);
		pDescription.setVerticalAlignment(JLabel.CENTER);
		pDescription.setBounds(0, 370, 140, 50);
		
		//
		
		sPName = new JLabel();
		sPName.setText("Ad"); 
		sPName.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		sPName.setForeground(Color.BLACK);
		sPName.setHorizontalAlignment(JLabel.CENTER);
		sPName.setVerticalAlignment(JLabel.CENTER);
		sPName.setBounds(0, 20, 140, 50);
		
		sPPrice = new JLabel();
		sPPrice.setText("Fiyat"); 
		sPPrice.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		sPPrice.setForeground(Color.BLACK);
		sPPrice.setHorizontalAlignment(JLabel.CENTER);
		sPPrice.setVerticalAlignment(JLabel.CENTER);
		sPPrice.setBounds(0, 90, 140, 50);
		
		sPStock = new JLabel();
		sPStock.setText("Adet"); 
		sPStock.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		sPStock.setForeground(Color.BLACK);
		sPStock.setHorizontalAlignment(JLabel.CENTER);
		sPStock.setVerticalAlignment(JLabel.CENTER);
		sPStock.setBounds(0, 160, 140, 50);
		
		sPImageUrl = new JLabel();
		sPImageUrl.setText("Resim"); 
		sPImageUrl.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		sPImageUrl.setForeground(Color.BLACK);
		sPImageUrl.setHorizontalAlignment(JLabel.CENTER);
		sPImageUrl.setVerticalAlignment(JLabel.CENTER);
		sPImageUrl.setBounds(0, 230, 140, 50);
		
		sPCategory = new JLabel();
		sPCategory.setText("Kategori"); 
		sPCategory.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		sPCategory.setForeground(Color.BLACK);
		sPCategory.setHorizontalAlignment(JLabel.CENTER);
		sPCategory.setVerticalAlignment(JLabel.CENTER);
		sPCategory.setBounds(0, 300, 140, 50);
		
		sPDescription = new JLabel();
		sPDescription.setText("Açýklama"); 
		sPDescription.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		sPDescription.setForeground(Color.BLACK);
		sPDescription.setHorizontalAlignment(JLabel.CENTER);
		sPDescription.setVerticalAlignment(JLabel.CENTER);
		sPDescription.setBounds(0, 370, 140, 50);
		
		//
		productsTitle = new JLabel();
		productsTitle.setText("ÜRÜNLER"); 
		productsTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,35));
		productsTitle.setForeground(Color.RED);
		productsTitle.setHorizontalAlignment(JLabel.CENTER);
		productsTitle.setVerticalAlignment(JLabel.CENTER);
		productsTitle.setBounds(10, 0, 240, 50);
		
		//
		searchInfo = new JLabel();
		searchInfo.setText("Ürün detayýný görmek için listeden seçiniz");
		searchInfo.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
		searchInfo.setForeground(Color.red);
		searchInfo.setBounds(30, 85, 520, 32);
		
		//
		
		//area
		
		area = new JTextArea();
		area.setForeground(Color.BLUE);
		area.setFont(new Font(Font.SANS_SERIF, Font.ROMAN_BASELINE, 20));
		area.setBounds(140, 376, 300, 100);
		area.setBackground(Color.white);
		area.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		area.setLineWrap(true);
		
		sPArea = new JTextArea();
		sPArea.setForeground(Color.BLUE);
		sPArea.setFont(new Font(Font.SANS_SERIF, Font.ROMAN_BASELINE, 20));
		sPArea.setBounds(140, 376, 300, 100);
		sPArea.setBackground(Color.white);
		sPArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		sPArea.setLineWrap(true);
		
		
		//JComboBox
		
		box = new JComboBox<Categories>();
		services.getCategories(box);
		box.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
		box.setForeground(Color.BLACK);
		box.setBounds(140, 306, 200, 40);
		
		box2 = new JComboBox<Categories>();
		services.getCategories(box2);
		box2.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
		box2.setForeground(Color.BLACK);
		box2.setBounds(140, 306, 200, 40);
		
		//button
		
		
		
		addImage = new JButton();
		addImage.setText("Seç"); 
		addImage.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		addImage.setForeground(Color.BLACK);
		addImage.setHorizontalAlignment(JLabel.CENTER);
		addImage.setVerticalAlignment(JLabel.CENTER);
		addImage.setBounds(140,230, 100, 50);
		
		sPAddImage = new JButton();
		sPAddImage.setText("Seç"); 
		sPAddImage.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		sPAddImage.setForeground(Color.BLACK);
		sPAddImage.setHorizontalAlignment(JLabel.CENTER);
		sPAddImage.setVerticalAlignment(JLabel.CENTER);
		sPAddImage.setBounds(140,230, 100, 50);
		
		addProductBtn = new JButton();
		addProductBtn.setText("Ekle"); 
		addProductBtn.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		addProductBtn.setForeground(Color.BLACK);
		addProductBtn.setHorizontalAlignment(JLabel.CENTER);
		addProductBtn.setVerticalAlignment(JLabel.CENTER);
		addProductBtn.setBounds(150,498, 100, 50);
		
		
		deleteProduct = new JButton();
		deleteProduct.setText("Sil"); 
		deleteProduct.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		deleteProduct.setForeground(Color.BLACK);
		deleteProduct.setHorizontalAlignment(JLabel.CENTER);
		deleteProduct.setVerticalAlignment(JLabel.CENTER);
		deleteProduct.setBounds(90,498, 100, 50);
		
		updateProduct = new JButton();
		updateProduct.setText("Güncelle"); 
		updateProduct.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		updateProduct.setForeground(Color.BLACK);
		updateProduct.setHorizontalAlignment(JLabel.CENTER);
		updateProduct.setVerticalAlignment(JLabel.CENTER);
		updateProduct.setBounds(260,498, 150, 50);
		
		
		//Text
		pNameText = new JTextField();
		pNameText.setForeground(Color.BLUE);
		pNameText.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		pNameText.setBounds(140, 28, 200, 40);
		
		pPriceText = new JTextField();
		pPriceText.setForeground(Color.BLUE);
		pPriceText.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		pPriceText.setBounds(140, 98, 200, 40);
		
		//
		
		sPNameText = new JTextField();
		sPNameText.setForeground(Color.BLUE);
		sPNameText.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		sPNameText.setBounds(140, 28, 200, 40);
		
		sPPriceText = new JTextField();
		sPPriceText.setForeground(Color.BLUE);
		sPPriceText.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		sPPriceText.setBounds(140, 98, 200, 40);
		
		
		searchProductsText = new JTextField();
		searchProductsText.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		searchProductsText.setForeground(Color.BLACK);
		searchProductsText.setBounds(50, 50, 400, 32);
		searchProductsText.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
		
		//Panel
		
		addProduct = new JPanel();
		addProduct.setBounds(0, 0, 1280, 720);
		addProduct.setBackground(Color.WHITE);
		addProduct.setLayout(null);
		
		updateDeleteProduct = new JPanel();
		updateDeleteProduct.setBounds(0, 0, 1280, 720);
		updateDeleteProduct.setBackground(Color.WHITE);
		updateDeleteProduct.setLayout(null);
		
		selectedProduct = new JPanel();
		selectedProduct.setBounds(600, 0, 720, 620);
		selectedProduct.setBackground(Color.WHITE);
		selectedProduct.setLayout(null);
		
		//pane
		
		jTabbedPane = new JTabbedPane();
		jTabbedPane.setBounds(0, 0, 1280, 720);
		jTabbedPane.setBorder(null);
		jTabbedPane.setBorder(null);
		jTabbedPane.setBackground(Color.WHITE);
		jTabbedPane.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		
		//spinner
		SpinnerModel model = new SpinnerNumberModel(1,1,999,1);
		pPiece = new JSpinner(model);
		pPiece.setBounds(140,168, 100, 40);
		
		sPPiece = new JSpinner(model);
		sPPiece.setBounds(140,168, 100, 40);
		
		//JList
		
		productsList = new JList<Products>();
		productsList.setBounds(10, 100, 500, 500);
		productsList.setListData(services.getList(sorguSýralama).toArray()); //Ürünler listesi
		productsList.setFont(new Font(Font.SERIF,Font.BOLD,20));
		jScrollPane = new JScrollPane(productsList);
		jScrollPane.setBounds(50, 100, 500, 500);
		
		
		addImage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//chooser
				chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				chooser.setBounds(110, 230, 100, 40);
				int result = chooser.showOpenDialog(managerProducts.this);
				if(result == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					products.setImageUrl(""+file);
				}
			}
		});
		
			sPAddImage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//chooser
				chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				chooser.setBounds(110, 230, 100, 40);
				int result = chooser.showOpenDialog(managerProducts.this);
				if(result == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					products.setImageUrl(""+file);
				}
			}
		});
		
		
		
		//add
		jTabbedPane.add("Ürün Ekle",addProduct);
		jTabbedPane.add("Ürün Sil/Güncelle",updateDeleteProduct);
		add(jTabbedPane);
		addProduct.add(pName);
		addProduct.add(pNameText);
		addProduct.add(pPrice);
		addProduct.add(pPriceText);
		addProduct.add(pStock);
		addProduct.add(pPiece);
		addProduct.add(pImageUrl);
		addProduct.add(addImage);
		addProduct.add(pCategory);
		addProduct.add(pDescription);
		addProduct.add(addProductBtn);
		addProduct.add(box);
		addProduct.add(area);
		
		
		
		updateDeleteProduct.add(productsTitle);
		updateDeleteProduct.add(jScrollPane);
		updateDeleteProduct.add(selectedProduct);
		updateDeleteProduct.add(searchProductsText);
		selectedProduct.add(sPNameText);
		selectedProduct.add(sPPriceText);
		selectedProduct.add(sPPiece);
		selectedProduct.add(sPAddImage);
		selectedProduct.add(box2);
		selectedProduct.add(sPCategory);
		selectedProduct.add(sPDescription);
		selectedProduct.add(sPImageUrl);
		selectedProduct.add(sPName);
		selectedProduct.add(sPPrice);
		selectedProduct.add(sPStock);
		selectedProduct.add(sPArea);
		selectedProduct.add(updateProduct);
		selectedProduct.add(deleteProduct);
		
		setVisible(true);
		
		
		
		
		addProductBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String productName = pNameText.getText();
				int productPrice = Integer.parseInt(pPriceText.getText());
				int productStock = (Integer) pPiece.getValue();
				String productDescription = area.getText();
				
				
				
				products.setName(productName);
				products.setPurchase_price(productPrice);
				products.setStock(productStock);
				products.setDescription(productDescription);
				products.setCategoryId(((Categories)box.getSelectedItem()).getId());
				services.addProduct(products);
				
				pNameText.setText("");
				pPriceText.setText("");
				pPiece.setValue(0);
				area.setText("");
				
				JOptionPane.showMessageDialog(managerProducts.this,products.getName()+" Baþarýyla Eklendi.","Alert",JOptionPane.WARNING_MESSAGE); 
				productsList.setListData(services.getList(sorguSýralama).toArray());
			}
		});
		
            searchProductsText.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				productsList.setListData(services.searchProductList(searchProductsText.getText()).toArray());
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
            
        updateProduct.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Products selectedProducts = (Products) productsList.getSelectedValue();
				if(selectedProducts != null) {
					selectedProducts.setName(sPNameText.getText());
					selectedProducts.setPurchase_price(Integer.parseInt(sPPriceText.getText()));
					selectedProducts.setStock((Integer)(sPPiece.getValue()));
					selectedProducts.setDescription(sPArea.getText());
					selectedProducts.setImageUrl("noimage.jpg");
					selectedProducts.setCategoryId(((Categories)box2.getSelectedItem()).getId());
					services.updateProduct(selectedProducts);
					JOptionPane.showMessageDialog(managerProducts.this,selectedProducts.getName()+" Güncelleme baþarýlý.","Alert",JOptionPane.WARNING_MESSAGE); 
					productsList.setListData(services.getList(sorguSýralama).toArray());
				}
				
				
			}
		});
        
        deleteProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Products selectedProducts = (Products) productsList.getSelectedValue();
				services.deleteProduct(selectedProducts);
				JOptionPane.showMessageDialog(managerProducts.this,selectedProducts.getName()+" Silme baþarýlý.","Alert",JOptionPane.WARNING_MESSAGE); 
				productsList.setListData(services.getList(sorguSýralama).toArray());
	
			}
		});
            
        productsList.addListSelectionListener(new ListSelectionListener() {
    			@Override
    			public void valueChanged(ListSelectionEvent e) {
    				// TODO Auto-generated method stub
    				selectedProduct.setVisible(true);
    				Products selectedProducts = (Products) productsList.getSelectedValue();
    				if(selectedProducts != null) {
    					sPNameText.setText(selectedProducts.getName());
    					sPPriceText.setText(String.valueOf(selectedProducts.getPurchase_price()));
    					sPPiece.setValue(selectedProducts.getStock());
    					sPArea.setText(selectedProducts.getDescription());
    				}	
    			}
    		});
		
		
	}
	
	
}

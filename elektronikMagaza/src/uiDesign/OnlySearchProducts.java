package uiDesign;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.placeholder.PlaceHolder;

import Models.Products;
import sqlConnect.sqlServices;

public class OnlySearchProducts extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	sqlServices services = new sqlServices();
	JList productsList;
	JTextField searchProductsText;
	JLabel searchTextLabelIcon,searchInfo,imageProductIcon,productName,productDescription;
	JLabel productStock,productPrice;
	JScrollPane jScrollPane;
	JPanel searchTextWrap,listWrap,productDetail,imageProduct;
	JSpinner stockSpinner;
	JComboBox box;
	String sýralamaSorgu = "";
	public OnlySearchProducts() {
		setSize(1280, 720);
		setLayout(null);
		setTitle("Ürün Arama");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		//Label
		searchTextLabelIcon = new JLabel();
		searchTextLabelIcon.setHorizontalAlignment(JLabel.CENTER);
		searchTextLabelIcon.setVerticalAlignment(JLabel.CENTER);
		searchTextLabelIcon.setIcon(new ImageIcon("images/search.png"));
		searchTextLabelIcon.setBounds(10, 15, 32, 32);
		
		imageProductIcon = new JLabel();
		imageProductIcon.setHorizontalAlignment(JLabel.CENTER);
		imageProductIcon.setVerticalAlignment(JLabel.CENTER);
		imageProductIcon.setIcon(new ImageIcon("images/image.jpg"));
		imageProductIcon.setBounds(0, 0, 212, 212);
		imageProductIcon.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		searchInfo = new JLabel();
		searchInfo.setText("Ürün detayýný görmek için listeden seçiniz");
		searchInfo.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
		searchInfo.setForeground(Color.red);
		searchInfo.setBounds(30, 85, 520, 32);
		
		productName = new JLabel();
		productName.setText("Ürün Seçiniz");
		productName.setFont(new Font(Font.SANS_SERIF,Font.BOLD,27));
		productName.setForeground(Color.BLACK);
		productName.setBounds(242, 20, 422, 50);
		
		productDescription = new JLabel();
		productDescription.setText("Ürün Seçiniz");
		productDescription.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,17));
		productDescription.setForeground(Color.BLACK);
		productDescription.setBounds(242, 55, 422, 50);
		
		productStock = new JLabel();
		productStock.setText("Adet");
		productStock.setFont(new Font(Font.SANS_SERIF,Font.ROMAN_BASELINE,17));
		productStock.setForeground(Color.BLACK);
		productStock.setBounds(242, 115, 422, 70);
		productStock.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.black));
		
		productPrice = new JLabel();
		productPrice.setText("Ürün Seçiniz");
		productPrice.setFont(new Font(Font.SANS_SERIF,Font.BOLD,17));
		productPrice.setForeground(Color.BLACK);
		productPrice.setBounds(242, 190, 422, 50);
		
		//box 
		String sýralama [] = {"fiyat artan","fiyat azalan","Stok artan","Stok azalan","yeni ürün"};
		box = new JComboBox(sýralama);
		box.setBounds(550, 15, 200, 40);
		box.setFont(new Font(Font.SANS_SERIF,Font.BOLD,17));
		box.setForeground(Color.BLACK);
		
		
		//Spinner
		
		SpinnerModel model = new SpinnerNumberModel(0,0,999,1);
		stockSpinner = new JSpinner(model);
		stockSpinner.setBounds(310,130, 80, 40);
		stockSpinner.setEnabled(false);
		
		
		//Panel
		searchTextWrap = new JPanel();
		searchTextWrap.setBounds(30, 10, 500, 64);
		searchTextWrap.setBackground(Color.WHITE);
		searchTextWrap.setLayout(null);
		searchTextWrap.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		
		productDetail = new JPanel();
		productDetail.setBounds(550, 120, 700, 500);
		productDetail.setBackground(Color.WHITE);
		productDetail.setLayout(null);
		
		imageProduct = new JPanel();
		imageProduct.setBounds(20, 20, 212, 212);
		imageProduct.setBackground(Color.WHITE);
		imageProduct.setLayout(null);

		
		listWrap = new JPanel();
		listWrap.setBounds(30, 120, 500, 500);
		listWrap.setBackground(Color.WHITE);
		listWrap.setLayout(null);
		
		
		
		//Text
		searchProductsText = new JTextField();
		searchProductsText.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		searchProductsText.setForeground(Color.BLACK);
		searchProductsText.setBounds(50, 15, 400, 32);
		searchProductsText.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
		new PlaceHolder(searchProductsText, "Arama..");
		
		//Jlist
		
		productsList = new JList<Products>();
		productsList.setBounds(0, 0, 500, 500);
		productsList.setListData(services.getList(sýralamaSorgu).toArray()); //Ürünler listesi
		productsList.setFont(new Font(Font.SERIF,Font.BOLD,20));
		jScrollPane = new JScrollPane(productsList);
		jScrollPane.setBounds(0, 0, 500, 500);
		
		
		
		//add
		add(searchTextWrap);
		add(listWrap);
		add(productDetail);
		add(searchInfo);
		add(box);
		productDetail.add(imageProduct);
		productDetail.add(productName);
		productDetail.add(productDescription);
		productDetail.add(productStock);
		productDetail.add(stockSpinner);
		productDetail.add(productPrice);
		listWrap.add(jScrollPane);
		searchTextWrap.add(searchTextLabelIcon);
		searchTextWrap.add(searchProductsText);
		imageProduct.add(imageProductIcon);
		
		setVisible(true);
		
        box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int index = box.getSelectedIndex();
				if(index == 0) {
					sýralamaSorgu = " order by purchase_price asc";
				}else if(index == 1) {
					sýralamaSorgu = " order by purchase_price desc";
				}else if(index == 2) {
					sýralamaSorgu = " order by Stock asc";		
				}else if(index==3) {
					sýralamaSorgu = " order by Stock desc";
				}else if(index==4) {
					sýralamaSorgu = " order by purchase_date desc";
				}
				productsList.setListData(services.getList(sýralamaSorgu).toArray());
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
		
		productsList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Products product = (Products) productsList.getSelectedValue();
				if(product!=null) {
					productName.setText(product.getName());
					productDescription.setText(product.getDescription());
					stockSpinner.setValue(product.getStock());
					productPrice.setText(""+product.getPurchase_price()+" TL");
					if(product.getImageUrl() != null) {
						imageProductIcon.setIcon(new ImageIcon(product.getImageUrl()));
					}
				}
				
			}
		} );
		
		
		
		
	}
	public static void main(String[] args) {
		new OnlySearchProducts();
	}
}

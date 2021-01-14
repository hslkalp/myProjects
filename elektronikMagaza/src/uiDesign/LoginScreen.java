package uiDesign;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.placeholder.PlaceHolder;

import Models.Directors;
import Models.Employee;
import sqlConnect.sqlServices;

public class LoginScreen extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	sqlServices services = new sqlServices();
	Boolean loginEBoolean,loginMBoolean;
	Employee loginEmployee;
	Directors loginManager;
	JPanel header,main,login,manager,employee;
	JTabbedPane jTabbedPane;
	JLabel headerLabel,managerIcon,employeeIcon,idLbl,idLbl2,loginEInfo,loginEInfo2;
	JTextField managerIdText,employeeIdText;
	JButton managerLoginBtn,employeeLoginBtn;
	JMenuBar jMenuBar;
	JMenu info;
	JMenuItem version,developer;
	JLabel versiyon,gelistirici;
	PlaceHolder managerPlaceHolder, employeePlaceHolder;
	public LoginScreen() {
		setSize(720, 500);
		setLayout(null);
		setTitle("Giriþ Ekraný");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		//Label
		
		headerLabel = new JLabel();
		headerLabel.setText("Giriþ");
		headerLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,40));
		headerLabel.setForeground(Color.WHITE);
		headerLabel.setBounds(300, 10, 100, 60);
		
		
		managerIcon = new JLabel();
		managerIcon.setHorizontalAlignment(JLabel.CENTER);
		managerIcon.setVerticalAlignment(JLabel.CENTER);
		managerIcon.setIcon(new ImageIcon("images/icons8_manager_52px_1.png"));
		managerIcon.setBounds(198, 20, 52, 52);
		
		employeeIcon = new JLabel();
		employeeIcon.setHorizontalAlignment(JLabel.CENTER);
		employeeIcon.setVerticalAlignment(JLabel.CENTER);
		employeeIcon.setIcon(new ImageIcon("images/icons8_worker_52px.png"));
		employeeIcon.setBounds(198, 20, 52, 52);
		
		
		idLbl = new JLabel();
		idLbl.setHorizontalAlignment(JLabel.CENTER);
		idLbl.setVerticalAlignment(JLabel.CENTER);
		idLbl.setIcon(new ImageIcon("images/icons8_identification_documents_32px.png"));
		idLbl.setBounds(90, 100, 32, 32);
		
		
		idLbl2 = new JLabel();
		idLbl2.setHorizontalAlignment(JLabel.CENTER);
		idLbl2.setVerticalAlignment(JLabel.CENTER);
		idLbl2.setIcon(new ImageIcon("images/icons8_identification_documents_32px.png"));
		idLbl2.setBounds(90, 100, 32, 32);
		
		loginEInfo = new JLabel();
		loginEInfo.setText("Giriþ Id yanlýþ lütfen tekrar deneyiniz");
		loginEInfo.setFont(new Font(Font.SANS_SERIF,Font.BOLD,13));
		loginEInfo.setForeground(Color.RED);
		loginEInfo.setBounds(110, 210, 300, 60);
		loginEInfo.setVisible(false);
		
		loginEInfo2 = new JLabel();
		loginEInfo2.setText("Giriþ Id yanlýþ lütfen tekrar deneyiniz");
		loginEInfo2.setFont(new Font(Font.SANS_SERIF,Font.BOLD,13));
		loginEInfo2.setForeground(Color.RED);
		loginEInfo2.setBounds(110, 210, 300, 60);
		loginEInfo2.setVisible(false);
		
		//JText
		managerIdText = new JTextField();
		managerIdText.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		managerIdText.setForeground(Color.BLACK);
		managerIdText.setBounds(132, 100, 200, 32);
		managerIdText.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
		managerPlaceHolder = new PlaceHolder(managerIdText, "Müdür ID giriniz");
		
		
		employeeIdText = new JTextField();
		employeeIdText.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		employeeIdText.setForeground(Color.BLACK);
		employeeIdText.setBounds(132, 100, 200, 32);
		employeeIdText.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
		employeePlaceHolder = new PlaceHolder(employeeIdText, "Personel ID giriniz");
		
		
		
		//Panel
		header = new JPanel();
		header.setBounds(0, 0, 720, 120);
		header.setBackground(new Color(42, 55, 79));
		header.setLayout(null);
		
		main = new JPanel();
		main.setBounds(0, 120, 720, 600);
		main.setBackground(Color.WHITE);
		main.setLayout(null);
		
		
		login = new JPanel();
		login.setBounds(120, 80, 450, 300);
		login.setBackground(new Color(42, 55, 79));
		login.setLayout(null);
		login.setBorder(null);
		
		
		manager = new JPanel();
		manager.setBounds(0, 0, 450, 300);
		manager.setLayout(null);
		manager.setBackground(Color.white);
		
		employee = new JPanel();
		employee.setBounds(0, 0, 450, 300);
		employee.setLayout(null);
		employee.setBackground(Color.white);
		
		
		//Pane
		
		jTabbedPane = new JTabbedPane();
		jTabbedPane.setBounds(0, 0, 450, 300);
		jTabbedPane.setBorder(null);
		jTabbedPane.setBorder(null);
		jTabbedPane.setBackground(Color.WHITE);
		jTabbedPane.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		
		//Button
		
		managerLoginBtn = new JButton("Giriþ");
		managerLoginBtn.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		managerLoginBtn.setForeground(Color.BLACK);
		managerLoginBtn.setBounds(172, 160, 100, 40);
		
		employeeLoginBtn = new JButton("Giriþ");
		employeeLoginBtn.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		employeeLoginBtn.setForeground(Color.BLACK);
		employeeLoginBtn.setBounds(172, 160, 100, 40);
		
		
		//Menu
		jMenuBar = new JMenuBar();
		info = new JMenu("Bilgi");
		
		
		
		
		jMenuBar.add(info);
	
		
		
		
		
		add(login);
		add(header);
		add(main);
		jTabbedPane.add("Yönetici",manager);
		jTabbedPane.add("Personel",employee);
		login.add(jTabbedPane);
		header.add(headerLabel);
		manager.add(managerIcon);
		manager.add(idLbl);
		manager.add(managerIdText);
		manager.add(managerLoginBtn);
		manager.add(loginEInfo2);
		employee.add(employeeIcon);
		employee.add(idLbl2);
		employee.add(employeeIdText);
		employee.add(employeeLoginBtn);
		employee.add(loginEInfo);
		
		setJMenuBar(jMenuBar);
		
		
		
		setVisible(true);
		
		
		//Eventler
		employeeLoginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String Id = employeeIdText.getText();
				loginEBoolean = services.loginEmployee(Id);
				if(loginEBoolean==true) {
					loginEmployee = services.getEmployee();
					//Çalýþan dashboard açýlacak
					new EmployeeDashBoard(loginEmployee);
					setVisible(false); //Login Ekraný kapattýk
					loginEInfo.setVisible(false);
				}else {
					loginEInfo.setVisible(true);
				}
				
			}
		});
		
		
		managerLoginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String Id = managerIdText.getText();
				loginMBoolean = services.loginDirectors(Id);
				if(loginMBoolean==true) {
					loginManager = services.getDirectors();
					new ManagerDashBoard(loginManager);
					setVisible(false);
					loginEInfo2.setVisible(false);
				}else {
					loginEInfo2.setVisible(true);
				}
				
			}
		});
		
        info.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		// TODO Auto-generated method stub
        		new Info();
        	}
		});
		

		
	}
	

}

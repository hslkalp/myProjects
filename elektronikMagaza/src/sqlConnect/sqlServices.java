package sqlConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import Models.Categories;
import Models.Directors;
import Models.Employee;
import Models.Products;


public class sqlServices {
	Directors directors = new Directors();
	Employee employee = new Employee();
	Products searchProducts;
	//String url = "jdbc:sqlite:elektronikMagaza.db";
	String url = "jdbc:sqlserver://ALP\\SQLEXPRESS;databaseName=magazaDB;integratedSecurity=true;";
	//baðlantý
	public Directors getDirectors() {
		return this.directors;
	}
	public Employee getEmployee() {
		return this.employee;
	}
	
	
	
	public Connection getConnection() {
		Connection connection = null;
		
		try {
			//Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(url);
			System.out.println("baðlandý");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("baðlanamadý "+e.getMessage());
		}
		
		return connection;
	}
	
	public String getDepartmentName(int id) {
		String name = "";
		Connection connection = getConnection();
		ResultSet resultSet = null;
		try {
			String sorgu = "select Name from Department where Id = '"+id+"'";
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(sorgu);
			while(resultSet.next()) {
				name = resultSet.getString(1);
						
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return name;
	}
	//kategorileri getir
	public void getCategories(JComboBox<Categories> box) {
		ResultSet resultSet = null;
		Connection connection = getConnection();
		try {
			String getCategories = "select * from Categories";
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(getCategories);
			while(resultSet.next()) {
				Categories categories = new Categories();
				categories.setId(resultSet.getInt(1));
				categories.setName(resultSet.getString(2));
				categories.setDescription(resultSet.getString(3));
				box.addItem(categories);
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public ResultSet getStockOfProducts() {
		ResultSet resultSet = null;
		Connection connection = getConnection();
		
		String sorgu = "select p.Name 'Ad', p.Description 'Açýklama', c.Name 'Kategori', p.Stock 'Stok'"
				+ " from Products p inner join Categories c on p.CategoryId = c.Id";
		try {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultSet;
	}
	
	public void getProducts(JComboBox<Products> box) {
		ResultSet resultSet = null;
		Connection connection = getConnection();
		try {
			String getProducts = "select * from Products";
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(getProducts);
			while(resultSet.next()) {
				Products products = new Products();
				products.setId(resultSet.getInt(1));
				products.setName(resultSet.getString(2));
				products.setPurchase_price(resultSet.getInt(4));
				products.setStock(resultSet.getInt(5));
				products.setDescription(resultSet.getString(6));
				products.setImageUrl(resultSet.getString(7));
				products.setCategoryId(resultSet.getInt(8));
				if(products.getStock()>0) {
					box.addItem(products);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	//ürünleri getirme
	public ResultSet getProducts() {
		Connection connection = getConnection();
		ResultSet resultSet = null;
		try {
			Statement statement = connection.createStatement();
			String selectProducts = "select * from Products";
			resultSet = statement.executeQuery(selectProducts);
			/*while(resultSet.next()) {
				System.out.println(
						"Id: "+resultSet.getString(1)
						+" Name: "+resultSet.getString(2)
						+" Purchase Date: "+resultSet.getString(3)
						+" Purchase Price: "+resultSet.getString(4)
						+" Stock: "+resultSet.getString(5)
						+" Description: "+resultSet.getString(6)
						+" ImageUrl: "+resultSet.getString(7)
						+" CategoryId: "+resultSet.getString(8));
			}*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sonuç getirilemedi");
		}
		
		return resultSet;
	}
	public ResultSet getSaleEmplooyeSelf(int Id) {
		ResultSet resultSet = null;
		Connection connection = getConnection();
		try {
			String sorgu = "select s.Id 'Satýþ No', p.Name 'Ürün Adý', sd.unitPrice 'Fiyat', sd.quantity 'Adet', s.sale_date 'Tarih'"
					+ " from Sales s, Employee e, Sales_Details sd, Products p"
					+ " where s.Id = sd.Sales_Id and e.Id = s.Employee_Id "
					+ " and p.Id = sd.product_id and e.Id = '"+Id+"'";
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultSet;
		
	}
	
	public ResultSet getEmployees() {
		ResultSet resultSet = null;
		Connection connection = getConnection();
		String employees = "select * from Employee";
		try {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(employees);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getirilemedi");
		}
		
		return resultSet;
	}
	public ResultSet getEmployeeForManager(Directors directors) {
		ResultSet resultSet = null;
		Connection connection = getConnection();
		
		try {
			String employee = "select e.Name 'Ad',e.LastName 'Soyad', d.Name 'Departman', di.Name || ' ' || di.LastName 'Müdür' from Employee e INNER JOIN Department d on e.Department_Id = d.Id"
					+ " INNER JOIN Directors di on e.Director_Id = di.Id"
					+ " Where e.Department_Id = "+directors.getDepartment_id();
			
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(employee);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return resultSet;
	}
	
	public int getCategoryId(String cName) {
		int Id=0;
		ResultSet resultSet = null;
		Connection connection = getConnection();
		try {
			String category = "select Id from Categories where Name = '"+cName+"'";
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(category);
			Id = resultSet.getInt(1);
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Id;
	}
	
	//ürün ekleme
	public void addProduct(Products products) {
		Connection connection = getConnection();
		//ayný ürün ise stock arttýr
		try {
			String addProduct = "INSERT INTO Products (Name,purchase_price,Stock,[Description],"
					+ "ImgUrl,CategoryId)"+
					" VALUES ('"+products.getName()+"'"
							+ ",'"+products.getPurchase_price()+"'"
							+ ",'"+products.getStock()+"'"
							+ ",'"+products.getDescription()+"'"
							+ ",'"+products.getImageUrl()+"'"
							+ ",'"+products.getCategoryId()+"')";
			Statement statement = connection.createStatement();
			statement.executeUpdate(addProduct);
			System.out.println("eklendi");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void addCategory(Categories categories) {
		Connection connection = getConnection();
		
		try {
			String addCategory = "INSERT INTO Categories (Name,Description) "
					+ " VALUES ('"+categories.getName()+"', '"+categories.getDescription()+"')";
			Statement statement = connection.createStatement();
			statement.executeUpdate(addCategory);
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//ÜRÜN silme //listedeki elemaný seçip sileceðiz
	public void deleteProduct(Products products) {
		Connection connection = getConnection();
		try {
			String deleteProduct = "DELETE FROM Products WHERE Id = "+products.getId();
			Statement statement = connection.createStatement();
			statement.executeUpdate(deleteProduct);
			System.out.println("silindi");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// Ürün güncelleme denemek için ürün ismi alýyor ui dan direkt seçilecek
	// Ürünlerin bir listesi olacak ürüne týklandýðý zaman update ve sil gelecek
	public void updateProduct(Products products) {
		Connection connection = getConnection();
		try {
			String updateProduct = "UPDATE Products  SET Name = '"+products.getName()+"' "
					+ ", purchase_price = "+products.getPurchase_price()+","
					+ "Stock = '"+products.getStock()+"' "
					+ ",[Description] = '"+products.getDescription()+"', "
					+ "ImgUrl = '"+products.getImageUrl()+"',"
					+ "CategoryId = "+products.getCategoryId()+""
					+ " where Id = "+products.getId()+" ";
			Statement statement = connection.createStatement();
			statement.executeUpdate(updateProduct);
			System.out.println("güncellendi");
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//ürün arama
	public ResultSet searchProduct(String s) {
		Connection connection = getConnection();
		ResultSet resultSet = null;
		try {
			String searchSql = "SELECT * FROM Products WHERE Name  LIKE '%"+s+"%'";
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(searchSql);
			while(resultSet.next()) {
				searchProducts = new Products();
				System.out.println(
						"Id: "+resultSet.getString(1)
						+" Name: "+resultSet.getString(2)
						+" Purchase Date: "+resultSet.getString(3)
						+" Purchase Price: "+resultSet.getString(4)
						+" Stock: "+resultSet.getString(5)
						+" Description: "+resultSet.getString(6)
						+" ImageUrl: "+resultSet.getString(7)
						+" CategoryId: "+resultSet.getString(8));
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  resultSet;
	}
	
	public List<Products> searchProductList(String s){ 
		List<Products> products = new ArrayList<Products>();
		Connection connection = getConnection();
		try {
			ResultSet resultSet = null;
			String sqlSearch = "SELECT * FROM Products WHERE Name  LIKE '%"+s+"%'";
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlSearch);
			while(resultSet.next()) {
				Products products2 = new Products();
				products2.setId(resultSet.getInt(1));
				products2.setName(resultSet.getString(2));
				products2.setPurchase_price(resultSet.getInt(4));
				products2.setStock(resultSet.getInt(5));
				products2.setDescription(resultSet.getString(6));
				products2.setImageUrl(resultSet.getString(7));
				products2.setCategoryId(resultSet.getInt(8));
				products.add(products2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}
	
	public List<Products> getList(String sorguSýralama){
		List<Products> products = new ArrayList<>();
		ResultSet resultSet = null;
		Connection connection = getConnection();
		try {
			String sorgu = "select * from Products "+sorguSýralama;
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(sorgu);
			while(resultSet.next()) {
				Products products2 = new Products();
				products2.setId(resultSet.getInt(1));
				products2.setName(resultSet.getString(2));
				products2.setPurchase_price(resultSet.getInt(4));
				products2.setStock(resultSet.getInt(5));
				products2.setDescription(resultSet.getString(6));
				products2.setImageUrl(resultSet.getString(7));
				products2.setCategoryId(resultSet.getInt(8));
				products.add(products2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}
	
	
	// ürün satýþ
	public void sellProduct(Products products, int piece,Employee employee, int unitPrice) {
		Connection connection = getConnection();
		try {
			String sellProduct = "UPDATE Products SET Stock = Stock - "+piece+" WHERE Name = '"+products.getName()+"'";
			String salesInsert = "INSERT INTO  Sales (Employee_Id,sale_date)"
					+ "VALUES ("+employee.getId()+", datetime())";
			String salleDetails = "INSERT INTO Sales_Details (Sales_Id,product_id,unitPrice,quantity)"
					+ "select  Sales.Id , "+products.getId()+","+unitPrice+","+piece+""
					+ " from Sales order by Sales.Id desc limit 1";
						
			Statement statement = connection.createStatement();
			statement.executeUpdate(sellProduct);
			statement.executeUpdate(salesInsert);
			statement.executeUpdate(salleDetails);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int stock(Products products) {
		int stock = 0;
		Connection connection = getConnection();
		ResultSet resultSet = null;
		
		try {
			String sorgu = "select Stock from Products p where p.Id='"+products.getId()+"'";
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(sorgu);
			while(resultSet.next()) {
				stock = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return stock;
	}
	
	//fake login
	//çalýþan sale ,update,delete,add iþlemlerini login iþleminden sonra yapacak
	// login olduktan sonra jframe visible olacak
	public Boolean loginEmployee(String Id) {
		Boolean loginEmployeeBool = false;
		ResultSet resultSet = null;
		Connection connection = getConnection();
		try {
			String loginEmployee = "select * from employee e inner join User_Employee ue on e.Id = ue.Employee_Id";
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(loginEmployee);
			while(resultSet.next()) {
				if(Id.equals(resultSet.getString(7))) {
					System.out.println("sisteme giriþ yaptýnýz: "+resultSet.getString(2));
					this.employee.setId(resultSet.getInt(1));
					this.employee.setName(resultSet.getString(2));
					this.employee.setLastName(resultSet.getString(3));
					this.employee.setLoginId(resultSet.getString(7));
					this.employee.setDepartment_id(resultSet.getInt(4));
					this.employee.setDirector_id(resultSet.getInt(5));
					loginEmployeeBool = true;
					break; // sisteme giriþ yapýlan Id bulunur diðer id lere bakýlmayacak
					// çünkü baþka id de insan yok
					
				}else {
					//false olduðundan jframe açýlmayacak
					System.out.println("giriþ Id yanlýþ");
				}
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginEmployeeBool;
	}
	
	//login iþlemi müdür
	public Boolean loginDirectors(String Id) {
		ResultSet resultSet = null;
		Boolean loginDirectorBool = false;
		Connection connection = getConnection();
		try {
			String loginDrictors = "SELECT * FROM Directors";
			Statement statement = connection.createStatement();
			resultSet =  statement.executeQuery(loginDrictors);
			while(resultSet.next()) {
				if(Id.equals(resultSet.getString(5))) {
					System.out.println("sisteme giriþ yapan müdür: "+resultSet.getString(2));
					this.directors.setId((resultSet.getInt(1)));
					this.directors.setName(resultSet.getString(2));
					this.directors.setLastName(resultSet.getString(3));
					this.directors.setDepartment_id(resultSet.getInt(4));
					loginDirectorBool = true;
					break;
				}else {
					System.out.println("sisteme giriþ yapýlamadý yanlýþ id");
				}
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginDirectorBool;
	}
	
	public ResultSet getSales() {
		ResultSet resultSet = null;
		Connection connection = getConnection();
		String getSales = "select P.Name, c.Name  'kategori', s.sale_date  'satýþ tarihi', e.Name || ' ' || e.LastName  'satýcý adý',"
				+ " sd.unitPrice 'birim fiyat', sd.quantity 'adet',"
				+ " (sd.quantity*sd.unitPrice)  'tutar'"
				+ " from sales  s inner join Employee  e on e.Id = s.Employee_Id inner JOIN"
				+ " Sales_Details  sd on sd.Sales_Id = s.Id inner join Products  p on p.Id = sd.product_id inner JOIN Categories  c ON"
				+ " p.CategoryId = c.Id";
		try {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(getSales);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public ResultSet catalog() {
		ResultSet resultSet = null;
		Connection connection = getConnection();
		try {
			String sql = "select p.Name 'Ad', p.Description 'Açýklama', p.purchase_price 'Alýþ Fiyat' from Products p";
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultSet;
	}
	
}


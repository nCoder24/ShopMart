package shopmart.dao;

import shopmart.models.Product;
import java.sql.*;
import java.util.ArrayList;

public class ProductDao {
	public Product getProduct(int pid) throws Exception {
		Product product = new Product();
		Connection connection = new Connectivity().connect(); 
		String query = "SELECT * FROM product WHERE productid='" + pid + "';";
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		
		if (result.next()) {
			product.setProductID(result.getInt("productId"));
			product.setPrice(result.getInt("price"));
			product.setType(result.getString("pType"));
			product.setCatagory(result.getString("pCatagory"));
			product.setDescription(result.getString("pDescription"));
		}
		return product;
 	}
	public ArrayList<Product> getProductsByCatagory (String catagory) throws Exception {
		ArrayList<Product> products =new ArrayList<Product>();
		Connection connection = new Connectivity().connect(); 
		String query = "SELECT * FROM product WHERE pCatagory = '" +catagory + "';";
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		while(result.next())
		{
			Product product = new Product();
			if (result.next())
			{
			product.setProductID(result.getInt("productId" ));
			product.setPrice(result.getInt("price"));
			product.setType(result.getString("pType"));
			product.setCatagory(result.getString("pCatagory"));
			product.setDescription(result.getString("pDescription"));
		
			} 
			products.add(product);
		}
		return products;
	} 
}

package shopmart.dao;

import shopmart.models.Product;

public class ProductDao {
	public Product getProduct(int pid) {
		/*
		 * This is written just for testing...
		 * Overwrite this and fetch data from the database (Achyut)
		 */
		Product product = new Product(pid, 101, "Man's Fashion T-shart", "T-Shirt", "Men", "description");
		product.setDescription("Shop from wide range of Round Neck half sleeve T-Shirt from BLIVE. Pair this t -shirt with jeans or chinos, trousers and get an awesome look. It is regular machine wash. This fabric is soft in touch and it makes feel so comfort when you wear. The fabric does not pill and the color will not fade easily. Available in various color and designs for your every day fashion. Fill your wardrobe with the most wanted brand in online world and be stylish most beautiful collections from the house of BLIVE.");
		return product;
	}
}

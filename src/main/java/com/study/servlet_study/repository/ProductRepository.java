package com.study.servlet_study.repository;

import java.util.ArrayList;
import java.util.List;

import com.study.servlet_study.entity.Product;

public class ProductRepository {

	private List<Product> productList;

	private ProductRepository() {
		productList = new ArrayList<>();
	}

	private static ProductRepository instance;

	public static ProductRepository getInstance() {
		if (instance == null) {
			instance = new ProductRepository();
		}
		return instance;
	}

	public int saveProduct(Product product) {
		for (Product list : productList) {
			if (list.getProductName().equals(product.getProductName())) {
				return 0;
			}
		}
		productList.add(product);
		return 1;

	}

	public Product findProductByProductName(String productName) {
		Product findProduct = null;
		for (Product product : productList) {
			if (product.getProductName().equals(productName)) {
				findProduct = product;
				break;
			}

		}
		return findProduct;
	}
}

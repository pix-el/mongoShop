package com.retailstore.service;

import com.retailstore.model.Product;
import com.retailstore.repository.ProductRepository;
import com.retailstore.view.ProductSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pix-el on 02/02/2017.
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> searchByCriteria(ProductSearchCriteria criteria){
        System.out.println("ProductService.searchByCriteria" + criteria);
        return productRepository.searchByCriteria(criteria);
    }

    public Product getProduct(){
        return productRepository.findBySku();
    }

    public void saveProduct(Product selectedProduct){
        productRepository.save(selectedProduct);
    }

    public void deleteProduct(Product selectedProduct) {
        System.out.println("ProductService.deleteProduct"+ selectedProduct);
        productRepository.delete(selectedProduct);
    }
}

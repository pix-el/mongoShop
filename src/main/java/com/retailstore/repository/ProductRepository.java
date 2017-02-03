package com.retailstore.repository;

import com.retailstore.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

/**
 * Created by pix-el on 02/02/2017.
 */
public interface ProductRepository extends PagingAndSortingRepository<Product,String>, ProductRepositoryCustom{
    List<Product> findByType(String type);
    List<Product> findByTypeAndTitle(String type, String title);
    Product findBySku();
}

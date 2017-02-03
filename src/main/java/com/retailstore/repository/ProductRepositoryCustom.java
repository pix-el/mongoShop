package com.retailstore.repository;

import com.retailstore.model.Product;
import com.retailstore.view.ProductSearchCriteria;

import java.util.List;

/**
 * Created by pix-el on 02/02/2017.
 */
public interface ProductRepositoryCustom {
    public List<Product> searchByCriteria(ProductSearchCriteria criteria);
}

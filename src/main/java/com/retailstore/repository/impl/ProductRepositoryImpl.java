package com.retailstore.repository.impl;

import com.retailstore.model.Product;
import com.retailstore.repository.ProductRepositoryCustom;
import com.retailstore.view.ProductSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by pix-el on 02/02/2017.
 */
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Product> searchByCriteria(ProductSearchCriteria criteria) {

        Query query = new Query();
        if(StringUtils.hasText(criteria.getSku())){
            Criteria c = Criteria.where("sku").is(criteria.getSku());
            query.addCriteria(c);
        }
        if(StringUtils.hasText(criteria.getTitle())){
            Criteria c = Criteria.where("title").is(criteria.getTitle());
            query.addCriteria(c);
        }
        if(StringUtils.hasText(criteria.getDescription())){
            Criteria c = Criteria.where("description").is(criteria.getDescription());
            query.addCriteria(c);
        }
        if(StringUtils.hasText(criteria.getProductType())){
            Criteria c = Criteria.where("productType").is(criteria.getProductType());
            query.addCriteria(c);
        }
        if(StringUtils.hasText(criteria.getTrack())){
            Criteria c = Criteria.where("details.tracks").is(criteria.getTrack());
            query.addCriteria(c);
        }
        if(StringUtils.hasText(criteria.getChapter())) {
            Criteria c = Criteria.where("details.chapters").is(criteria.getChapter());
            query.addCriteria(c);
        }
        return mongoTemplate.find(query, Product.class);
    }
}

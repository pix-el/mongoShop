package com.retailstore.view;

import com.retailstore.model.Product;
import com.retailstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.util.List;

/**
 * Created by pix-el on 02/02/2017.
 */
@Component
@Scope("session")
public class ProductSearchBean {
    private Product selectedProduct;
    private ProductSearchCriteria criteria = new ProductSearchCriteria();
    private List<Product> productList;

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public ProductSearchCriteria getCriteria() {
        return criteria;
    }

    public void setCriteria(ProductSearchCriteria criteria) {
        this.criteria = criteria;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Autowired
    private ProductService productService;

    public void doSearch(ActionEvent event){
        System.out.println("ProductSearchBean.doSearch");
        System.out.println("event = [" + event + "]");
        productList = productService.searchByCriteria(criteria);
    }

    public String doEditDetail(){
        System.out.println("ProductSearchBean.doEditDetail");
        (FacesContext.getCurrentInstance().getExternalContext().getFlash()).put("selected", selectedProduct);
        return "detail.xhtml";
    }

    public void doDelete(ActionEvent event){
         try {
             productService.deleteProduct(selectedProduct);
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Deleted Successfully!"));
         }catch (DataAccessException e){
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                     "Error when deleting a product!",null));
         }
    }
}

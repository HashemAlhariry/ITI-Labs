package com.ecommerce;

 

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.ecommerce.repositories.entites.Buyer;
import com.ecommerce.repositories.entites.BuyerBidProduct;
import com.ecommerce.repositories.entites.BuyerBidProductId;
import com.ecommerce.repositories.entites.BuyerBuyProduct;
import com.ecommerce.repositories.entites.BuyerBuyProductId;
import com.ecommerce.repositories.entites.Category;
import com.ecommerce.repositories.entites.Product;
import com.ecommerce.repositories.entites.Seller;
import com.ecommerce.repositories.entites.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
 

public class MainTest {

    public static void main(String[] args) {
 
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceTest");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        System.out.println("-----------------");
        CriteriaBuilder criteriaBuilder = entityManagerFactory.getCriteriaBuilder();
        CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);
        Root<Product> product = query.from(Product.class);
        query.select(product).where(criteriaBuilder.equal(product.join("categories").get("id"), 2));
        List<Product> products = entityManager.createQuery(query).getResultList();
        System.out.println("All Products");
        products.forEach(productLambda -> System.out.println("Product Name: " + productLambda.getName()));
        System.out.println("-----------------");



        CriteriaQuery<BuyerBidProduct> query2 = criteriaBuilder.createQuery(BuyerBidProduct.class);
        Root<BuyerBidProduct> bId = query2.from(BuyerBidProduct.class);
        query2.select(bId).where(criteriaBuilder.equal(bId.get("product").get("id"), 1));
        List<BuyerBidProduct> bids = entityManager.createQuery(query2).getResultList();
        bids.forEach(bid -> System.out.println("bid quantity: " + bid.getQuantity()));
        System.out.println("-----------------");

    


        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Double> criteriaQuery = cb.createQuery(Double.class);
        Root<BuyerBuyProduct> buyerBuyProduct = criteriaQuery.from(BuyerBuyProduct.class);
        criteriaQuery.multiselect(cb.sum(cb.prod(buyerBuyProduct.get("amount"), buyerBuyProduct.get("quantity")))).groupBy(buyerBuyProduct.get("product").get("id"));
        Double total = entityManager.createQuery(criteriaQuery).getSingleResult();
        System.out.println("amount" + "     " + total);
        System.out.println("-----------------");
        
        

    }
}

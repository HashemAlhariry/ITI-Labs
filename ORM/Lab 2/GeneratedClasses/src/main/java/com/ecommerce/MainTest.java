package com.ecommerce;

 

import java.util.Date;
import java.util.HashSet;
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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainTest {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceTest");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


       //User user =new User("hashem@gmail.com","GIZA","011490","011490", new Date(0), new Date(0),"Hahsem","1234","HashemAlhariry",);
       
       Category category = new Category("mobile phones" ,"category for mobile phones", new HashSet<Product>(0));
       User userSeller =new User("hashem@gmail.com","GIZA",  new Date(), "Hahsem","1234");
       Seller seller = new Seller(userSeller,"new seller with name" + userSeller.getUserName(),new  HashSet<Product>(0));
    
       Set<Category> categories = new HashSet<Category>(0);
        categories.add(category);

        
       User userBuyer =new User("hazem@gmail.com","GIZA",  new Date(), "hazommaa","1234");
       Buyer buyer = new Buyer(userBuyer, "value", new HashSet<>(), new HashSet<>());

       Product product = new Product(seller,
        "I phone 13", 
        "new Iphone", 
        "apple", 
        new Date(),
        new Date(),
        5,
        new Date(),
        new Date(),
        categories,
        new HashSet<>(0),
        new HashSet<>(0));

   
 
    
    
        entityManager.getTransaction().begin();
        entityManager.persist(category);
        entityManager.persist(userSeller);
        entityManager.persist(userBuyer);
        entityManager.persist(seller);
        entityManager.persist(product);
        entityManager.persist(buyer);
        entityManager.getTransaction().commit();


    
        BuyerBuyProductId BuyerBuyProductId = new BuyerBuyProductId(buyer.getId(),product.getId());

        float price =2000f;
        BuyerBuyProduct buyProduct = new BuyerBuyProduct(BuyerBuyProductId,  buyer,  product, new Date(),price, 1);

        entityManager.getTransaction().begin();
        entityManager.persist(buyProduct);
        entityManager.getTransaction().commit();

        BuyerBidProductId buyProductBidId = new BuyerBidProductId(buyer.getId(),product.getId());

        BuyerBidProduct BuyerBidProduct = new BuyerBidProduct(buyProductBidId,  buyer,  product,new Date(), 1, 1);

        entityManager.getTransaction().begin();
        entityManager.persist(BuyerBidProduct);
        entityManager.getTransaction().commit();

    }
}

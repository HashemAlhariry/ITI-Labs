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
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class MainTest {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceTest");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        System.out.println("----------------");  

        System.out.println("All available emails");
        System.out.println(""); 
        TypedQuery<User> query1 =  entityManager.createQuery("select u from User u", User.class);
        List<User> users = query1.getResultList();
        for (User user : users) {
            System.out.println(user.getEmail());
        }
        System.out.println("----------------");
    

        System.out.println("Selected username");
        System.out.println("");
   
        String queryString2 = "from User u where u.userName like :name";
        Query query2 =entityManager.createQuery(queryString2).setParameter("name", "Hashem");
        List<User> users2 = query2.getResultList();
        for (User user : users2) {
            System.out.println(user.getUserName());
        }
        System.out.println("----------------");  



        System.out.println("Selected username with address");
        System.out.println("");
   
        String queryString3 ="from User p where p.userName like :name and p.address < :address";
        Query query3 =entityManager.createQuery(queryString3).setParameter("name", "hazommaa").setParameter("address", "GIZA");
        List<User> users3 = query3.getResultList();
        for (User user : users3) {
            System.out.println(user.getUserName());
        }
        System.out.println("----------------");  



        System.out.println("Selected product between 2 to 4");
        System.out.println("");

        String queryString4 ="from Product p where p.quantity between 2 and 4";
        Query query4 =entityManager.createQuery(queryString4);
        List<Product> products1 = query4.getResultList();
        for (Product product : products1) {
            System.out.println(product.getName());
        }
        System.out.println("----------------");  


        
        System.out.println("Selected product , BuyerBidProduct quantity");
        System.out.println("");
        System.out.println("");
        Query q = entityManager.createQuery("select p, bid from Product p, BuyerBidProduct bid");
        Iterator pairs = q. getResultList().iterator();
        while ( pairs.hasNext() ) {
            Object[] pair = (Object[]) pairs.next();
            Product product = (Product) pair[0];
            BuyerBidProduct bid = (BuyerBidProduct) pair[1];

            System.out.println("product " + product.getName() );
            System.out.println("BuyerBidProduct " + bid.getQuantity());
 
        }

        System.out.println("----------------");  
        System.out.println("");
   

        System.out.println("product counter");
        String queryString5 ="select count(p) from Product p";
        Query query5 =entityManager.createQuery(queryString5);
        List<Long> users5 = query5.getResultList();
        for (Long counter : users5) {
            System.out.println(counter);
        }
        System.out.println("----------------");  



        System.out.println("");

        System.out.println("product counter");
        String queryString6 ="from Product p join p.seller s where s.value like '%T%' and p.name like '%hp%'";
        Query query6 =entityManager.createQuery(queryString6);
        
        Iterator iterator = query6.getResultList().iterator();
        
        while ( iterator.hasNext() ) {
            Object[] pair = (Object[]) pairs.next();
            Product product = (Product) pair[0];
            Seller seller = (Seller) pair[1];
            System.out.println("product " + product.getName() );
            System.out.println("BuyerBidProduct " + seller.getValue()); 
        }
   

 /*
    //    User user =new User("hashem@gmail.com","GIZA","011490","011490", new Date(0), new Date(0),"Hahsem","1234","HashemAlhariry",);
    //    Category category = new Category("mobile phones" ,"category for mobile phones", new HashSet<Product>(0));
    //    User userSeller =new User("ashraf@gmail.com","GIZA",  new Date(), "Asrhouf","123456");
    //    Seller seller = new Seller(userSeller," new seller with name" + userSeller.getUserName(),new  HashSet<Product>(0));
    //    Set<Category> categories = new HashSet<Category>(0);
    //    categories.add(category);
    //    User userBuyer =new User("hazem@gmail.com","GIZA",  new Date(), "hazommaa","1234");
    //    Buyer buyer = new Buyer(userBuyer, "value", new HashSet<>(), new HashSet<>());
    //    Product product = new Product(seller,
    //     "Macbook air", 
    //     "new Iphone", 
    //     "apple", 
    //     new Date(),
    //     new Date(),
    //     5,
    //     new Date(),
    //     new Date(),
    //     categories,
    //     new HashSet<>(0),
    //     new HashSet<>(0));

   

    
    //     entityManager.getTransaction().begin();
    //     entityManager.persist(category);
    //     entityManager.persist(userSeller);
    //     entityManager.persist(userBuyer);
    //     entityManager.persist(seller);
    //     entityManager.persist(product);
    //     entityManager.persist(buyer);
    //     entityManager.getTransaction().commit();
    //     BuyerBuyProductId BuyerBuyProductId = new BuyerBuyProductId(buyer.getId(),product.getId());
    //     float price =2000f;
    //     BuyerBuyProduct buyProduct = new BuyerBuyProduct(BuyerBuyProductId,  buyer,  product, new Date(),price, 1);
    //     entityManager.getTransaction().begin();
    //     entityManager.persist(buyProduct);
    //     entityManager.getTransaction().commit();
    //     BuyerBidProductId buyProductBidId = new BuyerBidProductId(buyer.getId(),product.getId());
    //     BuyerBidProduct BuyerBidProduct = new BuyerBidProduct(buyProductBidId,  buyer,  product,new Date(), 1, 1);
    //     entityManager.getTransaction().begin();
    //     entityManager.persist(BuyerBidProduct);
    //     entityManager.getTransaction().commit();
 
        
        entityManager.close();
        entityManagerFactory.close();
        */
    }
}

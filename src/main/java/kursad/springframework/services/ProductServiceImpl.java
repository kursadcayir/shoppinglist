package kursad.springframework.services;

import kursad.springframework.domain.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
 public class ProductServiceImpl implements ProductService  {
    private Map<Integer, Product> products;
    private Map<String,Product> strproduct;

    public ProductServiceImpl(){
        loadProducts();
    }


    @Override
    public List<Product> listAllProducts() {
        return new ArrayList<>(products.values());
    }


    public Product getProductById(Integer id){
        return products.get(id);
    }


    public List<Product> listProductsByCategory(String s) {
        List ll= new ArrayList<>();
        for (int i=0; i<products.size();i++){
            ll.add(strproduct.values());
            System.out.println(ll+"dööööööööööööööööööööööööçxçx");
        }
        return ll;
    }


    public Product saveOrUpdateProduct(Product product){
        if(product !=null){
            if (product.getId()==null){
                product.setId(getNextKey());
            }
            products.put(product.getId(),product);
            return product;
        }
        else {throw new RuntimeException("Product Can't be null");}
    }
    private Integer getNextKey(){
        return Collections.max(products.keySet())+1;
    }

    @Override
    public void deleteProduct(Integer id) {
        products.remove(id);
    }

    private void loadProducts() {
    products = new HashMap<>();
    strproduct= new HashMap<>();

    Product product1= new Product();
        product1.setId(1);
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("12.99"));
        product1.setImageUrl("http://example.com/product1");
        product1.setCat("cat1");
        products.put(1,product1);
        strproduct.put(product1.getCat(),product1);


    Product product2= new Product();
        product2.setId(2);
        product2.setDescription("Product2");
        product2.setPrice(new BigDecimal("14.99"));
        product2.setImageUrl("http://example.com/product2");
        product2.setCat("cat1");
        products.put(2,product2);
        strproduct.put(product2.getCat(),product2);

    Product product3 = new Product();
        product3.setId(3);
        product3.setDescription("Product 3");
        product3.setPrice(new BigDecimal("34.99"));
        product3.setImageUrl("http://example.com/product3");
        product3.setCat("cat2");
        products.put(3, product3);
        strproduct.put(product3.getCat(),product3);

    Product product4 = new Product();
        product4.setId(4);
        product4.setDescription("Product 4");
        product4.setPrice(new BigDecimal("44.99"));
        product4.setImageUrl("http://example.com/product4");
        product4.setCat("cat3");
        products.put(4, product4);
        strproduct.put(product4.getCat(),product4);

        Product product5 = new Product();
        product5.setId(5);
        product5.setDescription("Product 5");
        product5.setPrice(new BigDecimal("25.99"));
        product5.setImageUrl("http://example.com/product5");
        product5.setCat("cat4");

        products.put(5, product5);
        strproduct.put(product5.getCat(),product5);
    }

}

package kursad.springframework.services;

import kursad.springframework.domain.ShoppingCart;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private Map<Integer, ShoppingCart> productsforcustomer;

    public ShoppingCartServiceImpl() {
        loadProducts();
    }


    public ShoppingCart getProductById(Integer id){
        return productsforcustomer.get(id);
    }

    public List<ShoppingCart> listAllProducts() {
        return new ArrayList<>(productsforcustomer.values());
    }



    public ShoppingCart saveOrUpdateCustomer(ShoppingCart shoppingCart) {
        if (shoppingCart!=null){
            if (shoppingCart.getId()==null){
                shoppingCart.setId(getNextKey());
            }
            productsforcustomer.put(shoppingCart.getId(),shoppingCart);
            return shoppingCart;
        }
        else {throw new RuntimeException("Customer cannot be empty.");}
    }


    private Integer getNextKey(){
        return Collections.max(productsforcustomer.keySet())+1;
    }


    @Override
    public void deleteProductforcustomer(Integer id) {

        productsforcustomer.remove(id);
    }



    private void loadProducts(){
        productsforcustomer = new HashMap<>();
       ShoppingCart hi=new ShoppingCart();
        hi.setId(1);
        hi.setDescription("productforshoppingchart");
        hi.setImageUrl("qwerthjhgfds");
        hi.setPrice(new BigDecimal("23"));
        hi.setCat("cat1");

        productsforcustomer.put(1,hi);

        ShoppingCart hi2=new ShoppingCart();
        hi2.setId(2);
        hi2.setDescription("productforshoppingchart2");
        hi2.setImageUrl("qmvnj");
        hi2.setPrice(new BigDecimal("222"));
        hi2.setCat("cat3");

        productsforcustomer.put(2,hi2);



    }
}


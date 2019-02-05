package kursad.springframework.services;

import kursad.springframework.domain.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    ShoppingCart saveOrUpdateCustomer(ShoppingCart shoppingCart);
    List<ShoppingCart> listAllProducts();
    void deleteProductforcustomer(Integer id);
    ShoppingCart getProductById(Integer id);
}

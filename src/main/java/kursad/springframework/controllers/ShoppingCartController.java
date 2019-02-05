package kursad.springframework.controllers;


import kursad.springframework.domain.ShoppingCart;
import kursad.springframework.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShoppingCartController {

    private ShoppingCartService shoppingCartService;

    @Autowired
    public void setShoppingCartService(ShoppingCartService shoppingCartService){this.shoppingCartService=shoppingCartService;}


    @RequestMapping("/shoppingcart")
    public String listAllProductInCart(Model model){
        model.addAttribute("productsforcustomer",shoppingCartService.listAllProducts());
        return "shoppingcart";
    }

    @RequestMapping("/shoppingcartitem/{id}")
    public String getProduct(@PathVariable Integer id, Model model){
        model.addAttribute("shoppingcart",shoppingCartService.getProductById(id));
        return "shoppingcartitem";
    }


    @RequestMapping("/shoppingcartitem/new")
    public String addNewProductToCart(Model model) {
        model.addAttribute("shoppingcart", new ShoppingCart());
        return "shoppingcartform";

    }
    @RequestMapping(value = "/shoppingcartitem",method = RequestMethod.POST)
    public String saveOrUpdateCustomer(ShoppingCart shoppingCart){
        ShoppingCart sa = shoppingCartService.saveOrUpdateCustomer(shoppingCart);
        return "redirect:/shoppingcartitem/"+sa.getId();

    }
    @RequestMapping("/shoppingcartitem/delete/{id}")
    public String deleteitemfromcart(@PathVariable Integer id){
        shoppingCartService.deleteProductforcustomer(id);

        return "redirect:/shoppingcart";
    }







}

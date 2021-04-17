package com.shop.mirosigns.service;

import com.shop.mirosigns.model.CartItem;
import com.shop.mirosigns.model.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {

    List<CartItem> itemsList;

    public Cart() {
        itemsList = new ArrayList<>();
    }

    public void addToCart(Product product) {
        itemsList.add(new CartItem(product, 1));
    }

    public void removeFromCart(Product product) {
        itemsList.removeIf(cartItem -> cartItem.getProduct().getId() == product.getId());
    }


    public List<CartItem> getItemsList() {
        return itemsList;
    }

}

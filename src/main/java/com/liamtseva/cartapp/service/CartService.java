package com.liamtseva.cartapp.service;

import com.liamtseva.cartapp.model.Cart;
import com.liamtseva.cartapp.model.Product;
import java.math.BigDecimal;

public interface CartService {
  Cart getNewCart();
  void addProduct(Cart cart, Product product, Integer quantity);
  void addProduct(Cart cart, Long prodId, Integer quantity);
  void delProduct(Cart cart, Product product, Integer quantity);
  BigDecimal getSum(Cart cart);
  void printCart(Cart cart);
}

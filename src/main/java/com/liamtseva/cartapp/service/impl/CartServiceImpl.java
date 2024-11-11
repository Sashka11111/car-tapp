package com.liamtseva.cartapp.service.impl;

import com.liamtseva.cartapp.model.Cart;
import com.liamtseva.cartapp.model.Product;
import com.liamtseva.cartapp.repository.ProductRepository;
import com.liamtseva.cartapp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CartServiceImpl implements CartService {
  private ProductRepository productRepository;

  @Autowired
  public void setProductRepository(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Cart getNewCart() {
    return new Cart();
  }

  @Override
  public void addProduct(Cart cart, Product product, Integer quantity) {
    cart.addProduct(product, quantity);
  }

  @Override
  public void addProduct(Cart cart, Long prodId, Integer quantity) {
    Product product = productRepository.findById(prodId);
    if (product != null) {
      addProduct(cart, product, quantity);
    }
  }

  @Override
  public void delProduct(Cart cart, Product product, Integer quantity) {
    cart.delProduct(product, quantity);
  }

  @Override
  public BigDecimal getSum(Cart cart) {
    return cart.getSum();
  }

  @Override
  public void printCart(Cart cart) {
    cart.getCartMap().forEach((product, quantity) ->
        System.out.println(product + ", Quantity: " + quantity));
  }
}

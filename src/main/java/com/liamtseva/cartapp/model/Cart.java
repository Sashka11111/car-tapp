package com.liamtseva.cartapp.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
@Scope("prototype")
public class Cart {
  private final Map<Product, Integer> cartMap = new HashMap<>();

  public Map<Product, Integer> getCartMap() {
    return cartMap;
  }

  public void addProduct(Product product, Integer quantity) {
    cartMap.merge(product, quantity, Integer::sum);
  }

  public void delProduct(Product product, Integer quantity) {
    cartMap.computeIfPresent(product, (p, q) -> q - quantity <= 0 ? null : q - quantity);
  }

  public BigDecimal getSum() {
    return cartMap.entrySet().stream()
        .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}

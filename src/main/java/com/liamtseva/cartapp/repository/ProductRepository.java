package com.liamtseva.cartapp.repository;
import com.liamtseva.cartapp.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.*;

@Component
public class ProductRepository {
  private final Map<Long, Product> productMap = new HashMap<>();

  @PostConstruct
  public void init() {
    saveOrUpdate(new Product(1L, "Product A", BigDecimal.valueOf(100.00)));
    saveOrUpdate(new Product(2L, "Product B", BigDecimal.valueOf(200.00)));
    saveOrUpdate(new Product(3L, "Product C", BigDecimal.valueOf(300.00)));
    saveOrUpdate(new Product(4L, "Product D", BigDecimal.valueOf(400.00)));
    saveOrUpdate(new Product(5L, "Product E", BigDecimal.valueOf(500.00)));
  }

  public List<Product> findAll() {
    return new ArrayList<>(productMap.values());
  }

  public void saveOrUpdate(Product product) {
    productMap.put(product.getId(), product);
  }

  public Product findById(Long id) {
    return productMap.get(id);
  }

  public void deleteById(Long id) {
    productMap.remove(id);
  }
}

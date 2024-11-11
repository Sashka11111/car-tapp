package com.liamtseva.cartapp.model;

import java.math.BigDecimal;

public class Product {
  private Long id;
  private String name;
  private BigDecimal price;

  public Product(Long id, String name, BigDecimal price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  // Getters, setters, equals, hashCode, toString

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return id.equals(product.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", price=" + price +
        '}';
  }
}

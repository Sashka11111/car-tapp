package com.liamtseva.cartapp.service.impl;

import com.liamtseva.cartapp.model.Product;
import com.liamtseva.cartapp.repository.ProductRepository;
import com.liamtseva.cartapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
  private final ProductRepository productRepository;

  @Autowired
  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public List<Product> getProductList() {
    return productRepository.findAll();
  }

  @Override
  public void saveOrUpdate(Product product) {
    productRepository.saveOrUpdate(product);
  }

  @Override
  public Product getProductById(Long id) {
    return productRepository.findById(id);
  }

  @Override
  public void deleteById(Long id) {
    productRepository.deleteById(id);
  }
}
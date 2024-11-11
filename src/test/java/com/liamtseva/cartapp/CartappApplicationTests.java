package com.liamtseva.cartapp;

import com.liamtseva.cartapp.model.Cart;
import com.liamtseva.cartapp.model.Product;
import com.liamtseva.cartapp.service.CartService;
import com.liamtseva.cartapp.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CartappApplicationTests {

  @Autowired
  private ProductService productService;

  @Autowired
  private CartService cartService;

  private Product product1;
  private Product product2;

  @BeforeEach
  void setUp() {
    // Додати продукти перед кожним тестом
    product1 = new Product(1L, "Product 1", BigDecimal.valueOf(10.00));
    product2 = new Product(2L, "Product 2", BigDecimal.valueOf(20.00));

    productService.saveOrUpdate(product1);
    productService.saveOrUpdate(product2);
  }

  @Test
  void testAddProductToCart() {
    Cart cart = cartService.getNewCart();

    cartService.addProduct(cart, product1.getId(), 2);
    cartService.addProduct(cart, product2.getId(), 1);

    assertThat(cart.getCartMap()).containsKey(product1);
    assertThat(cart.getCartMap()).containsKey(product2);
    assertThat(cart.getCartMap().get(product1)).isEqualTo(2);
    assertThat(cart.getCartMap().get(product2)).isEqualTo(1);
  }

  @Test
  void testRemoveProductFromCart() {
    Cart cart = cartService.getNewCart();

    cartService.addProduct(cart, product1.getId(), 2);
    cartService.addProduct(cart, product2.getId(), 1);

    cartService.delProduct(cart, product1, 1);

    assertThat(cart.getCartMap().get(product1)).isEqualTo(1);
    assertThat(cart.getCartMap().get(product2)).isEqualTo(1);
  }

  @Test
  void testGetSum() {
    Cart cart = cartService.getNewCart();

    cartService.addProduct(cart, product1.getId(), 2);
    cartService.addProduct(cart, product2.getId(), 1);

    BigDecimal totalSum = cartService.getSum(cart);

    assertThat(totalSum).isEqualByComparingTo(BigDecimal.valueOf(40.00));
  }

  @Test
  void testEmptyCart() {
    Cart cart = cartService.getNewCart();
    assertThat(cart.getCartMap()).isEmpty();
  }
}

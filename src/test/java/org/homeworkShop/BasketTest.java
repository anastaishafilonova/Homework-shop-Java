package org.homeworkShop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class BasketTest {
  @Test
  void tostring() {
    ArrayList<Good> goods = new ArrayList<>();
    Basket basket1 = new Basket(1, goods);
    Assertions.assertEquals(basket1.toString(), "Basket{id=1, userId=1, goods=[]}");
  }

  @Test
  void getId() {
    ArrayList<Good> goods = new ArrayList<>();
    Basket basket1 = new Basket(1, goods);
    Basket basket2 = new Basket(2, goods);
    Basket basket3 = new Basket(3, goods);
    Basket basket4 = new Basket(4, goods);
    Basket basket5 = new Basket(5, goods);
    Assertions.assertEquals(basket1.getId(), 2L);
    Assertions.assertEquals(basket2.getId(), 3L);
    Assertions.assertEquals(basket3.getId(), 4L);
    Assertions.assertEquals(basket4.getId(), 5L);
    Assertions.assertEquals(basket5.getId(), 6L);
  }
}
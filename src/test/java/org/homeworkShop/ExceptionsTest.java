package org.homeworkShop;

import org.homeworkShop.exceptions.BasketNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExceptionsTest {

  private User user;
  private User user1;

  @Test
  public void BasketNotFoundExceptionTest() {
    boolean exceptionThrown = false;

    try {
      Good good1 = new Good("Лимон", 5);
      Good good2 = new Good("Апельсин", 3);
      Good good3 = new Good("Лайм", 6);
      Good good4 = new Good("Ананас", 8);
      ArrayList<Good> goods = new ArrayList<>();
      goods.add(good1);
      goods.add(good2);
      goods.add(good3);
      goods.add(good4);
      Store store = new Store(goods);
      user = new User(store);
      Basket basket = new Basket(user.getId(), goods);
      user.myBaskets.add(basket);
      user.findBasketById(20);
    } catch (BasketNotFoundException e) {
      exceptionThrown = true;
    }

    assertTrue(exceptionThrown);
  }
}

package org.homeworkShop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
  Store store = new Store(new ArrayList<>());
  @Test
  void addBasket() {
    ArrayList<Good> goods = new ArrayList<>();
    Basket basket = new Basket(1, goods);
    ArrayList<Basket> list = new ArrayList<>();
    list.add(basket);
    assertFalse(list.size() == 0);
  }

  @Test
  void printMyBaskets() {
    User user = new User(store);
    ArrayList<Basket> myBaskets = user.myBaskets;
    ArrayList<Good> goods1 = new ArrayList<>();
    Good good1 = new Good("Лимон", 1);
    goods1.add(good1);
    Good good2 = new Good("Яблоко", 1);
    goods1.add(good2);
    ArrayList<Good> goods2 = new ArrayList<>();
    Good good3 = new Good("<Банан>", 1);
    goods2.add(good3);
    Good good4 = new Good("Лимон", 3);
    goods2.add(good4);
    Good good5 = new Good("Апельсин", 2);
    goods2.add(good5);
    Basket basket1 = new Basket(1, goods1);
    myBaskets.add(basket1);
    Basket basket2 = new Basket(2, goods2);
    myBaskets.add(basket2);
    assertEquals(user.printMyBaskets(), "Лимон - 1 шт.\n" +
            "Яблоко - 1 шт.\n" +
            "<Банан> - 1 шт.\n" +
            "Лимон - 3 шт.\n" +
            "Апельсин - 2 шт.\n");

  }

  @Test
  void getId() {
    User user1 = new User(store);
    User user2 = new User(store);
    User user3 = new User(store);
    User user4 = new User(store);
    User user5 = new User(store);
    assertEquals(user1.getId(), 2L);
    assertEquals(user2.getId(), 3L);
    assertEquals(user3.getId(), 4L);
    assertEquals(user4.getId(), 5L);
    assertEquals(user5.getId(), 6L);
  }
}
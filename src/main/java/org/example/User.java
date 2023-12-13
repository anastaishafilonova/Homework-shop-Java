package org.example;

import org.example.BasketId;
import org.example.UserActions;
import org.example.exceptions.BasketNotFoundException;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class User {
  private UserId id;
  ArrayList<Basket> myBaskets;

  public User() {
    this.id = UserActions.generateId();
  }

  public void addBasket(Basket basket) {
    // на вход принимаем словарь со списком корзины
  }

  public Basket findBasketById(BasketId id) {
    for (Basket basket: myBaskets) {
      if (basket.getId() == id) {
        return basket;
      }
    } throw new BasketNotFoundException("Not found basket with id: " + id);
  }

  public void buyBasket(BasketId id) {
    Basket basket = findBasketById(id);
    deleteBasket(basket);
    ArrayList<Good> goods = basket.goods;
    for (Good good: goods) {
      Store.decreaseNumberOfGood(good);
    }
  }

  public UserId getId() {
    return id;
  }

  public ArrayList<Basket> getMyBaskets() {
    return myBaskets;
  }

  public void deleteBasket(Basket basket) {
    myBaskets.remove(basket);
  }

  public void printMyBaskets() {
    for (Basket basket: myBaskets) {
      System.out.println(basket);
    }
  }
}

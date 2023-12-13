package org.example;

import org.example.BasketId;
import org.example.UserActions;
import org.example.exceptions.BasketNotFoundException;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class User {
  private AtomicLong id;
  ArrayList<Basket> myBaskets;

  public User() {
    this.id = UserActions.generateId();
  }

  public void createBasket() {
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
    ArrayList<Good> goods = basket.goods;
    for (Good good: goods) {
      Store.decreaseNumberOfGood(good);
    }
  }

  public AtomicLong getId() {
    return id;
  }

  public ArrayList<Basket> getMyBaskets() {
    return myBaskets;
  }
}

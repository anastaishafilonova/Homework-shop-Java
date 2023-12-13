package org.example;

import org.example.exceptions.BasketNotFoundException;

import java.util.ArrayList;

public class User {
  private long id;
  ArrayList<Basket> myBaskets = new ArrayList<>();

  public User() {
    this.id = UserActions.generateId();
  }


  public void addBasket(Basket basket) {
    myBaskets.add(basket);
  }

  public Basket findBasketById(long id) {
    for (Basket basket: myBaskets) {
      if (basket.getId() == id) {
        return basket;
      }
    } throw new BasketNotFoundException("Not found basket with id: " + id);
  }

  public void buyBasket(long id) {
    Basket basket = findBasketById(id);
    deleteBasket(basket);
    ArrayList<Good> goods = basket.goods;
    for (Good good: goods) {
      Store.decreaseNumberOfGood(good);
    }
  }

  public long getId() {
    return id;
  }

  public void deleteBasket(Basket basket) {
    myBaskets.remove(basket);
  }

  public String printMyBaskets() {
    String ans = "";
    for (Basket basket: myBaskets) {
      System.out.println("Номер корзины " + basket.getId());
      System.out.println("Содержимое корзины: ");
      for (int i = 0; i < basket.goods.size(); i++) {
        System.out.println(basket.goods.get(i).name + " - " + basket.goods.get(i).number + " шт.");
        ans += basket.goods.get(i).name + " - " + basket.goods.get(i).number + " шт.\n";
      }
    }
    return ans;
  }
}

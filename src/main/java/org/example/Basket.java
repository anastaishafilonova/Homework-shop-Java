package org.example;

import java.util.ArrayList;

public class Basket {
  private long id;
  long userId;
  ArrayList<Good> goods;

  public Basket(long userId, ArrayList<Good> goods) {
    this.id = BasketActions.generateId();
    this.userId = userId;
    this.goods = goods;
  }

  public long getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Basket{" +
        "id=" + id +
        ", userId=" + userId +
        ", goods=" + goods +
        '}';
  }
}

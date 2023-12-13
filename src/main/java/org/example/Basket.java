package org.example;

import org.example.BasketActions;
import org.example.BasketId;

import java.util.ArrayList;

public class Basket {
  private BasketId id;
  UserId userId;
  ArrayList<Good> goods;

  public Basket(UserId userId, ArrayList<Good> goods) {
    this.id = BasketActions.generateId();
    this.userId = userId;
    this.goods = goods;
  }

  public BasketId getId() {
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

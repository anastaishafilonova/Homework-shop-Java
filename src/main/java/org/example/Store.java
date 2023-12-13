package org.example;

import org.example.Good;
import org.example.exceptions.StoreDecreaseNumberOfGoodException;

import java.util.ArrayList;
import java.util.Objects;

public class Store {
  private static ArrayList<Good> allGoodsOfStore = new ArrayList<>();

  public Store(ArrayList<Good> goods) {
    allGoodsOfStore = goods;
  }

  public void addNewGood(Good newGood) {
    allGoodsOfStore.add(newGood);
  }

  public void increaseNumberOfGood(Good good, long numberOfAddedGoods) {
    if (allGoodsOfStore.contains(good)) {
      good.number += numberOfAddedGoods;
    } else {
      good.number += numberOfAddedGoods;
      addNewGood(good);
    }
  }

  public static void deleteGood(Good good) {
    allGoodsOfStore.remove(good);
  }

  public static void decreaseNumberOfGood(Good good) throws StoreDecreaseNumberOfGoodException {
    long numberOfDeletedGoods = good.number;
    for (Good goodOfStore: allGoodsOfStore) {
      if (Objects.equals(goodOfStore.name, good.name)) {
        if (goodOfStore.number >= numberOfDeletedGoods) {
          goodOfStore.number -= numberOfDeletedGoods;
          return;
        } else {
          if (goodOfStore.number == 0) {
            deleteGood(goodOfStore);
          }
          throw new StoreDecreaseNumberOfGoodException("Shortage of good with name: " + good.name);
        }
      }
    } throw new StoreDecreaseNumberOfGoodException("Lack of good with name: " + good.name);
  }
}
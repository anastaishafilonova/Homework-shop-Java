package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

  @Test
  void deleteGood() {
    ArrayList<Good> list = new ArrayList<>();
    Good good = new Good("Апельсин", 3);
    list.add(good);
    Store store = new Store(list);
    Store.deleteGood(good);
    assertEquals(store.getAllGoodsOfStore().size(), 0);
  }

  @Test
  void decreaseNumberOfGood() {
    ArrayList<Good> list = new ArrayList<>();
    Good good1 = new Good("Апельсин", 3);
    list.add(good1);
    Good good2 = new Good("Слива", 8);
    list.add(good2);
    Store store = new Store(list);
    Good good3 = new Good("Слива", 4);
    Store.decreaseNumberOfGood(good3);
    assertEquals(store.printGoods(), "Апельсин - 3 шт.\n" +
            "Слива - 4 шт.\n");
  }

  @Test
  void printGoods() {
    ArrayList<Good> list = new ArrayList<>();
    Good good1 = new Good("Апельсин", 3);
    list.add(good1);
    Good good2 = new Good("Слива", 8);
    list.add(good2);
    Store store = new Store(list);
    assertEquals(store.printGoods(), "Апельсин - 3 шт.\n" +
            "Слива - 8 шт.\n");
  }
}
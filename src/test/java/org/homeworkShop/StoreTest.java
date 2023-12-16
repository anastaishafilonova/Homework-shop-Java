package org.homeworkShop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Objects;


class StoreTest {

  @Test
  void deleteGood() {
    ArrayList<Good> list = new ArrayList<>();
    Good good = new Good("Апельсин", 3);
    list.add(good);
    Store store = new Store(list);
    store.deleteGood(good);
    Assertions.assertEquals(store.getAllGoodsOfStore().size(), 0);
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
    store.decreaseNumberOfGood(good3);
    Assertions.assertTrue(Objects.equals(store.printGoods(), "Апельсин - 3 шт.\n" + "Слива - 4 шт.\n")
        || Objects.equals(store.printGoods(),"Слива - 4 шт.\n" + "Апельсин - 3 шт.\n"));
  }

  @Test
  void printGoods() {
    ArrayList<Good> list = new ArrayList<>();
    Good good1 = new Good("Апельсин", 3);
    list.add(good1);
    Good good2 = new Good("Слива", 8);
    list.add(good2);
    Store store = new Store(list);
    Assertions.assertTrue(Objects.equals(store.printGoods(), "Апельсин - 3 шт.\n" + "Слива - 8 шт.\n")
        || Objects.equals(store.printGoods(),"Слива - 8 шт.\n" + "Апельсин - 3 шт.\n"));
  }
}
package org.homeworkShop;

import org.homeworkShop.exceptions.StoreDecreaseNumberOfGoodException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Store {
  private static final Logger logger = Logger.getLogger(Main.class.getSimpleName());
  private final Map<String, Good> allGoodsOfStore = new HashMap<>();
  private final UserRepository userRepository = new UserRepository();
  private final UserActions userActions = new UserActions(userRepository);

  public Store(ArrayList<Good> goods) {
    for (Good good: goods) {
      allGoodsOfStore.put(good.name, good);
    }
  }

  public synchronized UserRepository getUserRepository() {
    return userRepository;
  }

  public synchronized UserActions getUserActions() {
    return userActions;
  }


  public synchronized ArrayList<Good> getAllGoodsOfStore() {
    return new ArrayList<>(allGoodsOfStore.values());
  }

  public synchronized void deleteGood(Good good) {
    allGoodsOfStore.remove(good.name);
  }

  public synchronized void decreaseNumberOfGood(Good good) throws StoreDecreaseNumberOfGoodException {
    if (allGoodsOfStore.containsKey(good.name)) {
      Good goodForBuy = allGoodsOfStore.get(good.name);
      if (goodForBuy.number > good.number) {
        allGoodsOfStore.put(good.name, new Good(good.name, goodForBuy.number - good.number));
        if (goodForBuy.number == good.number) deleteGood(good);
      } else throw new StoreDecreaseNumberOfGoodException("Shortage of good with name: " + good.name);
    } else throw new StoreDecreaseNumberOfGoodException("Lack of good with name: " + good.name);
  }

  public synchronized String printGoods() {
    String ans = "";
    for (String good: allGoodsOfStore.keySet()) {
      logger.info(good + " - " + allGoodsOfStore.get(good).number + " шт.");
      ans += good + " - " + allGoodsOfStore.get(good).number + " шт.\n";
    }
    return ans;
  }
}

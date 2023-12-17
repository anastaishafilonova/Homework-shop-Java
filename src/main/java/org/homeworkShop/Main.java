package org.homeworkShop;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
  private static final Logger logger = Logger.getLogger(Main.class.getSimpleName());
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    logger.info("Программа запущена");
    ArrayList<Good> goods = new ArrayList<>();

    Scanner scanner = null;
    try {
      scanner = new Scanner(new File("store.txt"));
      int n = scanner.nextInt();
      for (int i = 0; i < n; i++) {
        String name = scanner.next();
        long count = scanner.nextLong();
        Good good = new Good(name, count);
        goods.add(good);
      }
      logger.info("Файл 'store.txt' успешно считан");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } finally {
      scanner.close();
    }

    Store store = new Store(goods);
    logger.info("Добро пожаловать в магазин!" + "\n" +
        "На данный момент в наличии имеются следующие товары: ");
    store.printGoods();
    logger.info("Введите число ваших действий: ");
    int q = input.nextInt();
    while (q <= 0) {
      logger.info("Попробуйте ещё раз");
      q = input.nextInt();
    }
    logger.info("Считано количество действий пользователя");
    for (int j = 0; j < q; j++) {
      logger.info("Выберите одну из возможных опций: " + "\n" +
          "1 - Создать нового пользователя " + "\n" +
          "2 - Добавить корзину" + "\n" +
          "3 - Купить корзину");
      String action = input.next();
      if (Objects.equals(action, "1")) {
        logger.info("Запуск исполнения первой опции");
        User user = new User(store);
        store.getUserActions().addUser(user);
        logger.info("ID пользователя: " + user.getId());
        logger.info("Первая опция была исполнена успешно");
      } else if ("2".equals(action)) {
        logger.info("Запуск исполнения второй опции");
        logger.info("Введите название файла со списком товаров со списком товаров");
        ArrayList<Good> goodsOfThisBasket = new ArrayList<>();
        try {
          scanner = new Scanner(new File(input.next()));
          int n = scanner.nextInt();
          for (int i = 0; i < n; i++) {
            String name = scanner.next();
            long count = scanner.nextLong();
            Good good = new Good(name, count);
            goodsOfThisBasket.add(good);
          }
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        } finally {
          scanner.close();
        }
        logger.info("Введите номер пользователя");
        long userId = input.nextLong();
        User user = store.getUserActions().findUserById(userId);
        user.addBasket(new Basket(userId, goodsOfThisBasket));
        logger.info("Вторая опция была исполнена успешно");
      } else if (Objects.equals(action, "3")) {
        logger.info("Запуск исполнения третьей опции");
        logger.info("Введите номер пользователя");
        long userId = input.nextLong();
        User user = store.getUserActions().findUserById(userId);
        logger.info("Доступные для покупки корзины у этого пользователя: ");
        user.printMyBaskets();
        logger.info("Введите номер покупаемой корзины");
        user.buyBasket(input.nextLong());
        logger.info("Третья опция была исполнена успешно");
      }
    }
  }
}

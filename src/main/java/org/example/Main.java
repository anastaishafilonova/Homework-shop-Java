package org.example;

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

    String fileName;
    fileName = "store.txt";
    File file;
    file = new File(fileName);
    try {
      Scanner input = new Scanner(file);
      int n = input.nextInt();
      for (int i = 0; i < n; i++) {
        String name = input.next();
        long count = input.nextLong();
        Good good = new Good(name, count);
        goods.add(good);
      }
      logger.info("Файл 'store.txt' успешно считан");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    Store store = new Store(goods);
    System.out.println("Добро пожаловать в магазин!" + "\n" +
        "На данный момент в наличии имеются следующие товары: ");
    Store.printGoods();
    System.out.println("Введите число ваших действий: ");
    int q = input.nextInt();
    while (q <= 0) {
      System.out.println("Попробуйте ещё раз");
      q = input.nextInt();
    }
    logger.info("Считано количество действий пользователя");
    for (int j = 0; j < q; j++) {
      System.out.println("Выберите одну из возможных опций: " + "\n" +
          "1 - Создать нового пользователя " + "\n" +
          "2 - Добавить корзину" + "\n" +
          "3 - Купить корзину");
      String action = input.next();
      if (Objects.equals(action, "1")) {
        logger.info("Запуск исполнения первой опции");
        User user = new User();
        UserActions.addUser(user);
        System.out.println("ID пользователя: " + user.getId());
        logger.info("Первая опция была исполнена успешно");
      } else if ("2".equals(action)) {
        logger.info("Запуск исполнения второй опции");
        System.out.println("Введите название файла со списком товаров со списком товаров");
        fileName = input.next();
        file = new File(fileName);
        ArrayList<Good> goodsOfThisBasket = new ArrayList<>();
        try {
          Scanner input = new Scanner(file);
          int n = input.nextInt();
          for (int i = 0; i < n; i++) {
            String name = input.next();
            long count = input.nextLong();
            Good good = new Good(name, count);
            goodsOfThisBasket.add(good);
          }
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
        System.out.println("Введите номер пользователя");
        long userId = input.nextLong();
        User user = UserActions.findUserById(userId);
        user.addBasket(new Basket(userId, goodsOfThisBasket));
        logger.info("Вторая опция была исполнена успешно");
      } else if (Objects.equals(action, "3")) {
        logger.info("Запуск исполнения третьей опции");
        System.out.println("Введите номер пользователя");
        long userId = input.nextLong();
        User user = UserActions.findUserById(userId);
        System.out.println("Доступные для покупки корзины у этого пользователя: ");
        user.printMyBaskets();
        System.out.println("Введите номер покупаемой корзины");
        user.buyBasket(input.nextLong());
        logger.info("Третья опция была исполнена успешно");
      }
    }
  }
}

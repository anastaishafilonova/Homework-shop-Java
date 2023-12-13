package org.example;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    ArrayList<Good> goods = new ArrayList<>();
    // изначально дан файл с описанием товаров (словарь имя и кол-во)
    // считываем файл по строчкам, пока пусть n - кол-во строк
    int n = 3;
    for (int i = 0; i < n; i++) {
      Good good = new Good("", i);
      goods.add(good);
    }
    Store store = new Store(goods);
    System.out.println("Добро пожаловать в магазин!" + "\n" +
        "На данный момент в наличии имеются следующие товары: ");
    store.printGoods();
    System.out.println("Введите число ваших действий: ");
    int q = input.nextInt();
    while (q < 0) {
      System.out.println("Попробуйте ещё раз");
      q = input.nextInt();
    }
    for (int i = 0; i < q; i++) {
      System.out.println("Выберите одну из возможных опций: " + "\n" +
          "1 создать нового пользователя " + "\n" +
          "2 добавить корзину" + "\n" +
          "3 купить корзину" + "\n" +
          "4 добавить новый товар на склад");
      String action = input.next();
      if (Objects.equals(action, "1")) {
        User user = new User();
        UserActions.addUser(user);
      } else if ("2".equals(action)) {
        System.out.println("Передайте файл со списком товаров");
        // принимает файл с товарами
        System.out.println("Введите номер пользователя");
        AtomicLong userId = new AtomicLong(input.nextLong());
        User user = UserActions.findUserById(new UserId(userId));
        // создать список товаров из файла
        ArrayList<Good> goodsOfThisBasket = new ArrayList<>();
        user.addBasket(new Basket(new UserId(userId), goodsOfThisBasket));
      } else if (Objects.equals(action, "3")) {
        System.out.println("Введите номер пользователя");
        AtomicLong userId = new AtomicLong(input.nextLong());
        User user = UserActions.findUserById(new UserId(userId));
        System.out.println("Доступные для покупки корзины у этого пользователя: ");
        user.printMyBaskets();
        System.out.println("Введите номер покупаемой корзины");
        user.buyBasket(new BasketId(new AtomicLong(input.nextLong())));
      } else if (Objects.equals(action, "4")) {
        System.out.println("Введите имя и кол-во товара через пробел");
        Store.addNewGood(new Good(input.next(), input.nextInt()));
      }
    }
  }
}

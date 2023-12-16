package org.homeworkShop;

public class BasketActions {
  private static long lastId = 0L;

  public static synchronized long generateId() {
    lastId++;
    return lastId;
  }
}

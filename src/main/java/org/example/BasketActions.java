package org.example;

public class BasketActions {
  private static long lastId = 0L;

  public static long generateId() {
    lastId++;
    return lastId;
  }
}

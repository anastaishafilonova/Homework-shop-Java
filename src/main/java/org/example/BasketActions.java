package org.example;

public class BasketActions {
  private static long lastId = 0L;

  public synchronized static long generateId() {
    lastId++;
    return lastId;
  }
}

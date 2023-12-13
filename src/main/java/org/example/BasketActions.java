package org.example;

import org.example.BasketId;

import java.util.concurrent.atomic.AtomicLong;

public class BasketActions {
  private static AtomicLong lastId;

  public static BasketId generateId() {
    lastId.incrementAndGet();
    return new BasketId(lastId);
  }
}

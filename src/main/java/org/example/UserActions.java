package org.example;

import org.example.UserRepository;

import java.util.concurrent.atomic.AtomicLong;

public class UserActions {
  private static AtomicLong lastId;

  public static AtomicLong generateId() {
    lastId.incrementAndGet();
    return lastId;
  }

  public static void addUser(User user) {
    UserRepository.add(user);
  }
}


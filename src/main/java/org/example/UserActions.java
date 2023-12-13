package org.example;

import org.example.UserRepository;

import java.util.concurrent.atomic.AtomicLong;

public class UserActions {
  private static long lastId = 0L;

  public static long generateId() {
    lastId++;
    return lastId;
  }

  public static void addUser(User user) {
    UserRepository.add(user);
  }

  public static User findUserById(long id) {
    return UserRepository.findUserById(id);
  }
}


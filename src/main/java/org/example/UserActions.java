package org.example;

import org.example.UserRepository;

import java.util.concurrent.atomic.AtomicLong;

public class UserActions {
  private static AtomicLong lastId;

  public static UserId generateId() {
    lastId.incrementAndGet();
    return new UserId(lastId);
  }

  public static void addUser(User user) {
    UserRepository.add(user);
  }

  public static User findUserById(UserId id) {
    return UserRepository.findUserById(id);
  }
}


package org.example;

public class UserActions {
  private static long lastId = 0L;

  public synchronized static long generateId() {
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


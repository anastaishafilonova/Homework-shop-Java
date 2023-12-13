package org.example;

import java.util.ArrayList;

public class UserRepository {
  private static ArrayList<User> allUsers = new ArrayList<>();

  public static void add(User user) {
    allUsers.add(user);
  }
}

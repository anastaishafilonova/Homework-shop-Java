package org.example;

import org.example.exceptions.UserNotFoundException;

import java.util.ArrayList;

public class UserRepository {
  private static ArrayList<User> allUsers = new ArrayList<>();

  public static void add(User user) {
    allUsers.add(user);
  }

  public static User findUserById(long id) {
    for (User user: allUsers) {
      if (user.getId() == id) {
        return user;
      }
    } throw new UserNotFoundException("Not found user with id: " + id);
  }
}


package org.homeworkShop;

import org.homeworkShop.exceptions.UserNotFoundException;

import java.util.ArrayList;

public class UserRepository {
  private ArrayList<User> allUsers = new ArrayList<>();

  protected void add(User user) {
    allUsers.add(user);
  }

  protected User findUserById(long id) {
    for (User user: allUsers) {
      if (user.getId() == id) {
        return user;
      }
    } throw new UserNotFoundException("Not found user with id: " + id);
  }
}


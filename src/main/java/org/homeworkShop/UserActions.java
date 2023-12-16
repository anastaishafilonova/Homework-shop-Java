package org.homeworkShop;

public class UserActions extends UserRepository {
  private static long lastId = 0L;
  private final UserRepository userRepository;

  public UserActions(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public synchronized long generateId() {
    lastId++;
    return lastId;
  }

  public void addUser(User user) {
    userRepository.add(user);
  }

  public User findUserById(long id) {
    return userRepository.findUserById(id);
  }
}


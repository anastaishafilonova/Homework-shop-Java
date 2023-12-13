package org.example.exceptions;

import org.example.User;

public class UserNotFoundException extends RuntimeException{
  public UserNotFoundException(String message) {
    super(message);
  }
}

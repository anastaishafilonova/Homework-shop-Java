package org.homeworkShop.exceptions;

public class BasketNotFoundException extends RuntimeException {
  public BasketNotFoundException(String message) {
    super(message);
  }
}

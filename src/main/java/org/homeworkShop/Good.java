package org.homeworkShop;

import java.util.Objects;

public class Good {
  String name;
  long number;

  public Good(String name, long number) {
    this.name = name;
    this.number = number;
  }

  @Override
  public String toString() {
    return "Good{" +
        "name='" + name + '\'' +
        ", number=" + number +
        '}';
  }
}

package org.example;

public class Good {
  String name;
  long number;

  @Override
  public String toString() {
    return "Good{" +
        "name='" + name + '\'' +
        ", number=" + number +
        '}';
  }

  public Good(String name, long number) {
    this.name = name;
    this.number = number;
  }
}

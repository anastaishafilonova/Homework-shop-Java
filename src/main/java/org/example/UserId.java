package org.example;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class UserId {
  AtomicLong userId;

  public UserId(AtomicLong userId) {
    this.userId = userId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserId userId1 = (UserId) o;
    return Objects.equals(userId, userId1.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId);
  }
}

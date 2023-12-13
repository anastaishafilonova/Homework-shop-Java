package org.example;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class BasketId {
  private AtomicLong id;

  public BasketId(AtomicLong id) {
    this.id = id;
  }

  public AtomicLong getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BasketId basketId = (BasketId) o;
    return Objects.equals(id, basketId.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}

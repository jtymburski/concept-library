public class Stack<E> {
  private static final int DEFAULT_SIZE = 4;

  private int itemCount = 0;
  private E[] set;
  private int size;

  public Stack() {
    set = (E[]) new Object[DEFAULT_SIZE];
    size = DEFAULT_SIZE;
  }

  // PUBLIC FUNCTIONS

  public boolean empty() {
    return (itemCount == 0);
  }

  public E peek() {
    if (itemCount > 0) {
      return set[itemCount - 1];
    }
    return null;
  }

  public E pop() {
    if (itemCount > 0) {
      E item = set[--itemCount];
      set[itemCount] = null;
      return item;
    }
    return null;
  }

  public E push(E item) {
    if (itemCount == size) {
      E[] oldSet = set;
      int oldSize = size;

      size *= 2;
      set = (E[]) new Object[size];

      System.arraycopy(oldSet, 0, set, 0, oldSize);
    }
    set[itemCount++] = item;
    return item;
  }
}

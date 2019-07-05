import java.lang.IllegalArgumentException;

public class ArrayList<E> {
  private static final int DEFAULT_SIZE = 4;

  private int itemCount = 0;
  private E[] list;
  private int size;

  public ArrayList() {
    list = (E[]) new Object[DEFAULT_SIZE];
    size = DEFAULT_SIZE;
  }

  // PUBLIC FUNCTIONS

  public void add(E e) {
    grow(itemCount + 1);
    list[itemCount++] = e;
  }

  public void add(int index, E e) throws IllegalArgumentException {
    if (index < 0 || index > itemCount) {
      throw new IllegalArgumentException("Out of range");
    }
    grow(itemCount + 1);
    shiftAdd(index);
    list[index] = e;
    itemCount++;
  }

  public E get(int index) throws IllegalArgumentException {
    if (index < 0 || index > itemCount) {
      throw new IllegalArgumentException("Out of range");
    }
    return list[index];
  }

  public void remove(int index) throws IllegalArgumentException {
    if (index < 0 || index >= itemCount) {
      throw new IllegalArgumentException("Out of range");
    }
    shiftRemove(index);
    itemCount--;
  }

  public void set(int index, E e) throws IllegalArgumentException {
    if (index < 0 || index >= itemCount) {
      throw new IllegalArgumentException("Out of range");
    }
    list[index] = e;
  }

  public int size() {
    return itemCount;
  }

  // PRIVATE FUNCTIONS

  private void grow(int length) {
    if (length > size) {
      E[] oldList = list;
      size *= 2;
      list = (E[]) new Object[size];
      System.arraycopy(oldList, 0, list, 0, itemCount);
    }
  }

  private void shiftAdd(int index) {
    if (index < itemCount) {
      System.arraycopy(list, index, list, index + 1, itemCount - index);
    }
  }

  private void shiftRemove(int index) {
    if (index < (itemCount - 1)) {
      System.arraycopy(list, index + 1, list, index, itemCount - index);
    }
  }
}

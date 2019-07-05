public class LinkedList<E> {
  static class Node<E> {
    E value;
    Node<E> prev;
    Node<E> next;

    Node(E value) {
      this.value = value;
    }
  }

  private int itemCount = 0;
  private Node<E> root;

  public LinkedList() {}

  // PUBLIC FUNCTIONS

  public void add(E e) {
    Node<E> newNode = new Node<>(e);

    // If this is a first node, set it at root
    if (itemCount == 0) {
      root = newNode;
    }
    // Otherwise, it is at the end of the list
    else {
      Node<E> lastNode = getNode(itemCount - 1);
      lastNode.next = newNode;
      newNode.prev = lastNode;
    }
    itemCount++;
  }

  public void add(int index, E e) throws IllegalArgumentException {
    if (index < 0 || index > itemCount) throw new IllegalArgumentException("out of range");

    // If at end, just use append functionality
    if (index == itemCount) {
      add(e);
    }
    // Otherwise, its at an index
    else {
      Node<E> node = getNode(index);
      Node<E> newNode = new Node<>(e);
      newNode.prev = node.prev;
      newNode.next = node;

      if (node.prev != null) {
        node.prev.next = newNode;
      } else {
        root = newNode;
      }
      node.prev = newNode;

      itemCount++;
    }
  }

  public E get(int index) throws IllegalArgumentException {
    if (index < 0 || index >= itemCount) throw new IllegalArgumentException("out of range");

    return getNode(index).value;
  }

  public void remove(int index) throws IllegalArgumentException {
    if (index < 0 || index >= itemCount) throw new IllegalArgumentException("out of range");

    Node<E> node = getNode(index);
    Node<E> nodePrev = node.prev;
    Node<E> nodeNext = node.next;

    if (nodePrev != null) {
      nodePrev.next = nodeNext;
    } else {
      root = nodeNext;
    }

    if (nodeNext != null) {
      nodeNext.prev = nodePrev;
    }

    itemCount--;
  }

  public void set(int index, E e) throws IllegalArgumentException {
    if (index < 0 || index >= itemCount) throw new IllegalArgumentException("out of range");

    getNode(index).value = e;
  }

  public int size() {
    return itemCount;
  }

  // PRIVATE FUNCTIONS

  private Node<E> getNode(int index) {
    Node<E> node = root;
    int nodeIndex = 0;
    while (index != nodeIndex) {
      node = node.next;
      nodeIndex++;
    }

    return node;
  }
}

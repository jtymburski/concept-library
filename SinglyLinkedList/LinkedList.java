public class LinkedList<E> {
  static class Node<E> {
    E value;
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
    add(itemCount, e);
  }

  public void add(int index, E e) throws IllegalArgumentException {
    if (index < 0 || index > itemCount) throw new IllegalArgumentException("out of range");

    Node<E> nodeBefore = getNodeBefore(index);
    Node<E> newNode = new Node<>(e);
    if (nodeBefore != null) {
      newNode.next = nodeBefore.next;
      nodeBefore.next = newNode;
    } else {
      newNode.next = root;
      root = newNode;
    }
    itemCount++;
  }

  public E get(int index) throws IllegalArgumentException {
    if (index < 0 || index >= itemCount) throw new IllegalArgumentException("out of range");

    Node<E> nodeBefore = getNodeBefore(index);
    return (nodeBefore != null ? nodeBefore.next : root).value;
  }

  public void remove(int index) throws IllegalArgumentException {
    if (index < 0 || index >= itemCount) throw new IllegalArgumentException("out of range");

    Node<E> nodeBefore = getNodeBefore(index);
    if (nodeBefore != null) {
      nodeBefore.next = nodeBefore.next.next;
    } else {
      root = root.next;
    }
    itemCount--;
  }

  public void set(int index, E e) throws IllegalArgumentException {
    if (index < 0 || index >= itemCount) throw new IllegalArgumentException("out of range");

    Node<E> nodeBefore = getNodeBefore(index);
    (nodeBefore != null ? nodeBefore.next : root).value = e;
  }

  public int size() {
    return itemCount;
  }

  // PRIVATE FUNCTIONS

  private Node<E> getNodeBefore(int index) {
    Node<E> nodeBefore = null;
    Node<E> node = root;
    int nodeIndex = 0;
    while (index != nodeIndex) {
      nodeBefore = node;
      node = node.next;
      nodeIndex++;
    }

    return nodeBefore;
  }
}

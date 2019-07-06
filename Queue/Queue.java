public class Queue<E> {
  static class Node<E> {
    E value;
    Node<E> next;

    Node(E e) {
      value = e;
    }
  }

  private Node<E> head;
  private Node<E> tail;

  public void add(E e) {
    Node<E> node = new Node(e);
    if (tail != null) {
      tail.next = node;
    }
    tail = node;
    if (head == null) {
      head = tail;
    }
  }

  public E peek() {
    return (head != null ? head.value : null);
  }

  public E poll() {
    if (head != null) {
      Node<E> node = head;
      head = node.next;
      if (head == null) {
        tail = null;
      }
      return node.value;
    }
    return null;
  }
}

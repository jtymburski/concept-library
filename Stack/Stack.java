public class Stack<E> {
  static class Node<E> {
    E value;
    Node<E> next;

    Node(E e) {
      value = e;
    }
  }

  private Node<E> top;

  public Stack() {}

  // PUBLIC FUNCTIONS

  public boolean empty() {
    return (top == null);
  }

  public E peek() {
    if (top != null) {
      return top.value;
    }
    return null;
  }

  public E pop() {
    if (top != null) {
      Node<E> node = top;
      top = node.next;
      return node.value;
    }
    return null;
  }

  public E push(E item) {
    Node<E> node = new Node<E>(item);
    node.next = top;
    top = node;

    return item;
  }
}

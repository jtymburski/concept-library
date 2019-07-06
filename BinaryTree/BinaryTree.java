public class BinaryTree<E> {
  static class Node<E> {
    E data;
    Node<E> first;
    Node<E> second;

    Node(E data) {
      this.data = data;
    }
  }
  static class NodeDepth<E> {
    Node<E> node;
    int depth;

    NodeDepth(Node<E> node, int depth) {
      this.node = node;
      this.depth = depth;
    }
  }

  private Node<E> root;

  public BinaryTree() {}

  // PUBLIC FUNCTIONS

  public void add(E data) {
    Node<E> newNode = new Node<>(data);

    if (root != null) {
      NodeDepth<E> result = findShallow(root, 0);
      if (result.node.first == null) {
        result.node.first = newNode;
      } else {
        result.node.second = newNode;
      }
    } else {
      root = newNode;
    }
  }

  public boolean exists(E data) {
    return (findRecursive(root, data) != null);
  }

  public void printInOrder(String prefix) {
    System.out.println(prefix + ":");
    printRecursive(root, 0, false, true, false);
  }

  public void printPost(String prefix) {
    System.out.println(prefix + ":");
    printRecursive(root, 0, false, false, true);
  }

  public void printPre(String prefix) {
    System.out.println(prefix + ":");
    printRecursive(root, 0, true, false, false);
  }

  public void remove(E data) {
    while(removeRecursive(root, null, data)) {};
  }

  public void set(E oldData, E newData) {
    Node<E> foundNode = findRecursive(root, oldData);
    while (foundNode != null) {
      foundNode.data = newData;
      foundNode = findRecursive(root, oldData);
    }
  }

  // PRIVATE FUNCTIONS

  private Node<E> findRecursive(Node<E> node, E data) {
    if (node == null) return null;
    if (node.data == data) return node;

    Node<E> firstFind = findRecursive(node.first, data);
    if (firstFind != null) {
      return firstFind;
    } else {
      return findRecursive(node.second, data);
    }
  }

  private NodeDepth<E> findShallow(Node<E> node, int depth) {
    if (node.first == null || node.second == null) {
      return new NodeDepth<E>(node, depth);
    }

    NodeDepth<E> ndFirst = findShallow(node.first, depth + 1);
    NodeDepth<E> ndSecond = findShallow(node.second, depth + 1);
    return (ndFirst.depth <= ndSecond.depth ? ndFirst : ndSecond);
  }

  private void fixDanglingRecursive(Node<E> node, Node<E> danglingNode) {
    if (node.second != null) {
      fixDanglingRecursive(node.second, danglingNode);
    } else {
      node.second = danglingNode;
    }
  }

  private void printNode(Node<E> node, int level) {
    System.out.println(" > " + level + ": " + node.data);
  }

  private void printRecursive(Node<E> node, int level, boolean pre, boolean mid, boolean post) {
    if (node != null) {
      if (pre) printNode(node, level);
      printRecursive(node.first, level + 1, pre, mid, post);
      if (mid) printNode(node, level);
      printRecursive(node.second, level + 1, pre, mid, post);
      if (post) printNode(node, level);
    }
  }

  private boolean removeRecursive(Node<E> node, Node<E> parentNode, E data) {
    if (node == null) return false;

    // Found!
    if (node.data == data) {
      // Determine node to promote to new spot
      Node<E> promotedNode;
      if (node.first != null) {
        promotedNode = node.first;
        fixDanglingRecursive(promotedNode, node.second);
      } else {
        promotedNode = node.second;
      }

      if (parentNode != null) {
        if (parentNode.first == node) {
          parentNode.first = promotedNode;
        } else {
          parentNode.second = promotedNode;
        }
      } else {
        root = promotedNode;
      }

      return true;
    }

    // Otherwise, try other nodes
    if (removeRecursive(node.first, node, data)) {
      return true;
    }
    return removeRecursive(node.second, node, data);
  }
}

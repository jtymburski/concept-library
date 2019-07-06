/**
 * This is an unbalanced binary search tree implementation
 * Therefore, over large iterations, it has a high chance of becoming close to O(n) instead of
 * O(log(n)) for operations
 */
public class BinarySearchTree<E> {
  static class Node<E> {
    int key;
    E value;
    Node<E> left;
    Node<E> right;

    Node(int key, E value) {
      this.key = key;
      this.value = value;
    }
  }

  private Node<E> root;

  public BinarySearchTree() {}

  // PUBLIC FUNCTIONS

  public void add(int key, E value) throws IllegalArgumentException {
    Node<E> newNode = new Node(key, value);

    // If no nodes, this new one must be root
    if (root == null) {
      root = newNode;
    }
    // Otherwise find the location and add
    else {
      addRecursive(root, newNode);
    }
  }

  public E find(int key) {
    Node<E> foundNode = findRecursive(root, key);
    return (foundNode != null ? foundNode.value : null);
  }

  public void print(String prefix) {
    System.out.println(prefix + ":");
    printRecursive(root, 0);
  }

  public boolean remove(int key) {
    return removeRecursive(root, null, key);
  }

  public void set(int key, E value) throws IllegalArgumentException {
    Node<E> foundNode = findRecursive(root, key);
    if (foundNode != null) {
      foundNode.value = value;
    } else {
      throw new IllegalArgumentException("no key found");
    }
  }

  // PRIVATE FUNCTIONS

  private void addRecursive(Node<E> currentNode, Node<E> newNode) throws IllegalArgumentException {
    // Left
    if (currentNode.key > newNode.key) {
      if (currentNode.left != null) {
        addRecursive(currentNode.left, newNode);
      } else {
        currentNode.left = newNode;
      }
    }
    // Right
    else if (currentNode.key < newNode.key) {
      if (currentNode.right != null) {
        addRecursive(currentNode.right, newNode);
      } else {
        currentNode.right = newNode;
      }
    }
    // Same. The caller should be using set
    else {
      throw new IllegalArgumentException("value already exists");
    }
  }

  private Node<E> findRecursive(Node<E> currentNode, int key) {
    if (currentNode == null) return null;
    if (currentNode.key == key) return currentNode;

    // Left
    if (currentNode.key > key) {
      return findRecursive(currentNode.left, key);
    }
    // Right
    else {
      return findRecursive(currentNode.right, key);
    }
  }

  private void fixDanglingRecursive(Node<E> currentNode, Node<E> danglingNode) {
    if (currentNode.right != null) {
      fixDanglingRecursive(currentNode.right, danglingNode);
    } else {
      currentNode.right = danglingNode;
    }
  }

  private void printRecursive(Node<E> node, int level) {
    if (node != null) {
      System.out.println(" > " + level + ": " + node.key + " - " + node.value);
      printRecursive(node.left, level + 1);
      printRecursive(node.right, level + 1);
    }
  }

  private boolean removeRecursive(Node<E> currentNode, Node<E> parentNode, int key) {
    if (currentNode == null) return false;

    // Found it!
    if (currentNode.key == key) {
      Node<E> promotedNode;
      if (currentNode.left != null) {
        promotedNode = currentNode.left;
        fixDanglingRecursive(promotedNode, currentNode.right);
      } else {
        promotedNode = currentNode.right;
      }

      // Valid parent node. Make sure the removed reference is changed
      if (parentNode != null) {
        if (parentNode.left == currentNode) {
          parentNode.left = promotedNode;
        } else {
          parentNode.right = promotedNode;
        }
      }
      // No parent. Removed node must be root
      else {
        root = promotedNode;
      }

      return true;
    }
    // Nope: on left side
    else if (currentNode.key > key) {
      return removeRecursive(currentNode.left, currentNode, key);
    }
    // Nope: on right side
    else {
      return removeRecursive(currentNode.right, currentNode, key);
    }
  }
}

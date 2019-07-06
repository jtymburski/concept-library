public class Main {
  public static void main(String[] args) {
    BinarySearchTree<String> bst = new BinarySearchTree<>();

    // Create a tree
    bst.add(6, "six");
    bst.add(4, "four");
    bst.add(12, "twelve");
    bst.add(2, "two");
    bst.add(5, "five");
    bst.add(10, "ten");
    bst.add(14, "fourteen");
    bst.add(1, "one");
    bst.add(3, "three");
    bst.print("After create");

    // Test a remove
    bst.remove(4);
    bst.print("After remove");

    // Test a find
    System.out.println("Found: " + bst.find(12));

    // Test a set
    bst.set(12, "zoooper");
    bst.print("After set");
  }
}

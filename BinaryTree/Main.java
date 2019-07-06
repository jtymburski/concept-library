public class Main {
  public static void main(String[] args) {
    BinaryTree<String> bt = new BinaryTree<>();

    // Create a tree
    bt.add("six");
    bt.add("four");
    bt.add("twelve");
    bt.add("two");
    bt.add("five");
    bt.add("ten");
    bt.add("fourteen");
    bt.add("one");
    bt.add("three");
    bt.printInOrder("After create");
    bt.printPre("Pre print");
    bt.printPost("Post print");

    // Test a remove
    bt.remove("four");
    bt.printInOrder("After remove");

    // Test a find
    System.out.println("Exists: " + bt.exists("five"));
    System.out.println("Does not exist: " + !bt.exists("zoop"));

    // Test a set
    bt.set("fourteen", "zoooper");
    bt.printInOrder("After set");

    // Add a bunch of the same
    for (int i = 0; i < 10; i++) {
      bt.add("anderson");
    }
    bt.printPost("Batch add");
    bt.set("anderson", "---");
    bt.printPost("Batch set");
  }
}

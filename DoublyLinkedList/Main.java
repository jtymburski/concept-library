public class Main {
  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<>();

    // Add to end
    list.add("one");
    list.add("two");
    print(list, "Add to end");

    // Add at index
    list.add(1, "one point 5");
    print(list, "Add in middle");

    // Add at front
    list.add(0, "zero");
    print(list, "Add to front");

    // Set at index
    list.set(2, "zooooop");
    print(list, "Set at index");

    // Remove
    list.remove(1);
    print(list, "Remove");
  }

  private static void print(LinkedList<String> list, String prefix) {
    System.out.print(prefix + ": ");
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + ",");
    }
    System.out.println();
  }
}

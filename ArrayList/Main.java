public class Main {
  // PROGRAM START

  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<>();

    // Add to end
    strings.add("Hello");
    strings.add(" ");
    strings.add("World");
    strings.add("!");
    print(strings, "Add to end");

    // Add at index
    strings.add(" ");
    strings.add(2, "Zoom ");
    print(strings, "Add at index");

    // Remove at index
    strings.remove(3);
    strings.remove(0);
    print(strings, "Remove at index");

    // Set at index
    strings.set(0, "Tomato ");
    strings.set(3, "-");
    print(strings, "Set at index");

    // Remove all
    while (strings.size() > 0) {
      strings.remove(0);
    }
    print(strings, "Remove all");
  }

  // PRIVATE FUNCTIONS

  private static void print(ArrayList<String> list, String prefix) {
    System.out.print(prefix + ": ");
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i));
    }
    System.out.println();
  }
}

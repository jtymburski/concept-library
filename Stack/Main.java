public class Main {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();

    // Push and pop
    stack.push("one");
    System.out.println("Pop: " + stack.pop() + ", empty? " + stack.empty());

    // Peek
    stack.push("two");
    System.out.println("Peek: " + stack.peek() + ", empty? " + stack.empty());

    // Grow
    for (int i = 0; i < 10; i++) {
      stack.push("Val #" + i);
    }
    System.out.print("Grow LIFO: ");
    while (!stack.empty()) {
      System.out.print(stack.pop() + ",");
    }
    System.out.println();
  }
}

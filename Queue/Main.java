public class Main {
  public static void main(String[] args) {
    Queue<String> queue = new Queue<>();

    // Add and poll
    queue.add("one");
    System.out.println("Add poll: " + queue.poll() + ", empty? " + (queue.peek() == null));

    // Add and peek
    queue.add("two");
    System.out.println("Add peek: " + queue.peek() + ", empty? " + (queue.peek() == null));

    // Large set and extract
    for (int i = 0; i < 10; i++) {
      queue.add("Val #" + i);
    }
    System.out.print("Queue: ");
    while (queue.peek() != null) {
      System.out.print(queue.poll() + ",");
    }
    System.out.println();

    // Add and poll after
    queue.add("one");
    System.out.println("Add poll after: " + queue.poll() + ", empty? " + (queue.peek() == null));
  }
}

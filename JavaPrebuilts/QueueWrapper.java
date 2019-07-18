import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Queue<E> core functionality
 */
public class QueueWrapper {
  public QueueWrapper() {}

  public void execute() {
    Queue<Integer> queue = new ArrayDeque<>();

    // Add / Push
    queue.add(4);
    queue.add(6);
    queue.add(122);
    queue.add(143);

    // Peek
    queue.peek(); // 4

    // Poll
    queue.poll(); // 4
    queue.poll(); // 6

    // Length / Size
    queue.size(); // Not sure how fast this implementation is. Might or might not be cached
    queue.isEmpty();
  }
}

import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList<E> core functionality
 * This falls under the same umbrella as the List<E> interface; however, based on
 * the understanding of LinkedList, only certain function calls will meet the O(1) standard
 *
 * The Java implementation is doubly linked
 */
public class LinkedListWrapper {
  public LinkedListWrapper() {}

  public void execute() {
    List<Integer> list = new LinkedList<>();

    // Add to end - O(1)
    list.add(7);
    list.add(4);
    list.add(12);

    // Add to front - O(1)
    list.add(0, 71);

    // Add at index - O(N): likely faster than ArrayList still since no copy required
    list.add(1, 18);

    // Get by index - O(N)
    list.get(1);

    // Remove by index - O(N)
    list.remove(2);

    // Set at index - O(N)
    list.set(1, 17);

    // Length / Size - O(1): my understanding is the Java implementation caches the size
    list.size();
    list.isEmpty();

    // Iterate: uses the properties of the LinkedList and thus is very fast
    // However, this would have no access to .prev or .next if changes are made
    for (Integer item : list) {}
  }

  public void timeTest() {
    List<Integer> list = new LinkedList<>();
    int listCount = 5000000;

    // ADD TO FRONT
    long startTime = System.currentTimeMillis();

    for (int i = 0; i < listCount; i++) {
      list.add(0, i);
    }

    long stopTime = System.currentTimeMillis();
    System.out.println("LinkedList add to front: " + (stopTime - startTime));
    list.clear();

    // ADD TO END
    startTime = System.currentTimeMillis();

    for (int i = 0; i < listCount; i++) {
      list.add(i);
    }

    stopTime = System.currentTimeMillis();
    System.out.println("LinkedList add to end: " + (stopTime - startTime));

    // ITERATE
    startTime = System.currentTimeMillis();
    for (Integer item : list) {
      item = item + 1;
    }
    stopTime = System.currentTimeMillis();
    System.out.println("LinkedList iterate: " + (stopTime - startTime));
  }
}

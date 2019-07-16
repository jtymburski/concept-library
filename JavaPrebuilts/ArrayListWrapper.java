import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ArrayList<E> core functionality (and all implementations of List<E>)
 */
public class ArrayListWrapper {
  public ArrayListWrapper() {}

  public void execute() {
    List<Integer> list = new ArrayList<>();

    // Add to end
    list.add(7);
    list.add(4);
    list.add(12);

    // Add at index
    list.add(1, 18);

    // Get by index
    list.get(1);

    // Remove by index
    list.remove(2);

    // Set at index
    list.set(1, 17);

    // Length / Size
    list.size();
    list.isEmpty();

    // Iterate
    for (Integer item : list) {}

    // Sort ascending
    Collections.sort(list);

    // Reverse
    Collections.reverse(list);
  }

  public void timeTest() {
    List<Integer> list = new ArrayList<>();
    int listCount = 5000000;

    // ADD TO END
    long startTime = System.currentTimeMillis();

    for (int i = 0; i < listCount / 20; i++) {
      list.add(0, i);
    }

    long stopTime = System.currentTimeMillis();
    System.out.println("ArrayList add to front (only 5%): " + (stopTime - startTime));
    list.clear();

    // ADD TO END
    startTime = System.currentTimeMillis();

    for (int i = 0; i < listCount; i++) {
      list.add(i);
    }

    stopTime = System.currentTimeMillis();
    System.out.println("ArrayList add to end: " + (stopTime - startTime));

    // ITERATE
    startTime = System.currentTimeMillis();
    for (Integer item : list) {
      item = item + 1;
    }
    stopTime = System.currentTimeMillis();
    System.out.println("ArrayList iterate: " + (stopTime - startTime));
  }
}

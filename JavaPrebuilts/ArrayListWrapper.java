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
}

import java.util.HashSet;
import java.util.Set;

public class HashSetWrapper {
  public HashSetWrapper() {}

  public void execute() {
    Set<Integer> set = new HashSet<>();

    // Add
    set.add(4);
    set.add(12);
    set.add(8);

    // Contains
    set.contains(12);
    set.contains(1010);

    // Remove
    set.remove(8);

    // Length / Size
    set.size();
    set.isEmpty();

    // Iterator
    for (Integer e : set) {}
  }
}

import java.util.Hashtable;
import java.util.Map;

public class HashtableWrapper {
  public HashtableWrapper() {}

  public void execute() {
    Hashtable<Integer, String> ht = new Hashtable<>();

    // Put
    ht.put(4, "Hello");
    ht.put(8, "World");
    ht.put(412, "WOAH");

    // Get
    ht.get(3); // null
    ht.get(4); // "Hello"

    // Contains
    ht.containsKey(3); // false
    ht.containsKey(4); // true
    ht.contains("Zoop"); // false
    ht.contains("Hello"); // true

    // Remove
    ht.remove(3); // false
    ht.remove(4); // true

    // Length / Size
    ht.size();

    // Iterate
    for (Map.Entry<Integer, String> entry : ht.entrySet()) {
      entry.getKey();
      entry.getValue();
    }
  }
}

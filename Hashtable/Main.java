public class Main {
  // PROGRAM START
  public static void main(String[] args) {
    Hashtable<Integer, String> map = new Hashtable<>();

    // First put
    map.put(1, "one");
    System.out.println("Get one: " + map.get(1));

    // Second put
    map.put(2, "two");
    System.out.println("Get both: " + map.get(1) + "," + map.get(2));

    // Overwrite
    map.put(2, "two v2");
    System.out.println("Get both after ovewrite: " + map.get(1) + "," + map.get(2));

    // Same bucket but separate value
    map.put(16, "sixteen");
    System.out.println("Same bucket: " + map.get(1) + "," + map.get(2) + "," + map.get(16));

    // Get invalid
    System.out.println("Invalid: " + map.get(14));

    // Clear
    map.clear();
    System.out.println("After clear: " + map.get(1) + "," + map.get(2) + "," + map.get(16));

    // Collision boost
    map.put(16, "SXTN");
    map.put(17, "SVTN");
    for (int i = 0; i < 16; i++) {
      map.put(i, "Val " + i);
    }
    System.out.print("Set: ");
    for (int i = 0; i < 18; i++) {
      System.out.print(map.get(i) + ",");
    }
    System.out.println();
  }
}

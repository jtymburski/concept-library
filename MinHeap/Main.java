public class Main {
  public static void main(String[] args) {
    MinHeap mh = new MinHeap();

    // Add
    mh.insert(4);
    mh.insert(50);
    mh.insert(7);
    mh.insert(55);
    mh.insert(90);
    mh.insert(87);
    mh.print("Init");

    // Add and bubble
    mh.insert(2);
    mh.print("Bubble");

    // Extract min
    System.out.println("Min: " + mh.extractMin());
    mh.print("After extract");
  }
}

public class Main {
  public static void main(String[] args) {
    // ArrayList
    ArrayListWrapper arrayList = new ArrayListWrapper();
    arrayList.execute();
    arrayList.timeTest();

    // HashSet
    HashSetWrapper hashSet = new HashSetWrapper();
    hashSet.execute();

    // Hashtable
    HashtableWrapper hashtable = new HashtableWrapper();
    hashtable.execute();

    // LinkedList
    LinkedListWrapper linkedList = new LinkedListWrapper();
    linkedList.execute();
    linkedList.timeTest();

    // Queue
    QueueWrapper queue = new QueueWrapper();
    queue.execute();

    // Stack
    StackWrapper stack = new StackWrapper();
    stack.execute();

    // StringBuilder
    StringBuilderWrapper stringBuilder = new StringBuilderWrapper();
    stringBuilder.execute();
  }
}

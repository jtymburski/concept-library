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

    // StringBuilder
    StringBuilderWrapper stringBuilder = new StringBuilderWrapper();
    stringBuilder.execute();
  }
}

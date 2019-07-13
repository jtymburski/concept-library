public class Main {
  public static void main(String[] args) {
    // ArrayList
    ArrayListWrapper arrayList = new ArrayListWrapper();
    arrayList.execute();

    // HashSet
    HashSetWrapper hashSet = new HashSetWrapper();
    hashSet.execute();

    // Hashtable
    HashtableWrapper hashtable = new HashtableWrapper();
    hashtable.execute();

    // StringBuilder
    StringBuilderWrapper stringBuilder = new StringBuilderWrapper();
    stringBuilder.execute();
  }
}

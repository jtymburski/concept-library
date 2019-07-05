public class Hashtable<K, V> {
  private static final int INITIAL_SIZE = 16;
  private static final float LOAD_FACTOR = 0.75f;

  static class Pair<K, V> {
    K key;
    V value;
    Pair<K, V> next;

    Pair(K key, V value, Pair<K, V> next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }

  private int entryCount;
  private Object[] list;
  private int size;

  public Hashtable() {
    allocateList(INITIAL_SIZE);
  }

  // PUBLIC FUNCTIONS

  public void clear() {
    allocateList(INITIAL_SIZE);
  }

  public V get(Object key) {
    Pair<K, V> node = getAtIndex(getIndex(key));
    while (node != null && node.key != key) {
      node = node.next;
    }
    return (node != null ? node.value : null);
  }

  public void put(K key, V value) {
    rehashIfOverLoaded();

    // Check if the key exists
    int index = getIndex(key);
    Pair<K, V> node = getAtIndex(index);
    while (node != null && node.key != key) {
      node = node.next;
    }

    // If it exists, replace the value
    if (node != null) {
      node.value = value;
    }
    // If no key found, this is a new entry. Add it
    else {
      list[index] = new Pair<K, V>(key, value, getAtIndex(index));
      entryCount++;
    }
  }

  public void remove(Object key) {
    int index = getIndex(key);
    Pair<K, V> nodeBefore = null;
    Pair<K, V> node = getAtIndex(index);
    while (node != null && node.key != key) {
      nodeBefore = node;
      node = node.next;
    }

    // If found, remove it
    if (node != null) {
      if (nodeBefore != null) {
        nodeBefore.next = node.next;
      } else {
        list[index] = node.next;
      }
      entryCount--;
    }
  }

  public int size() {
    return entryCount;
  }

  // PRIVATE FUNCTIONS

  private void allocateList(int size) {
    this.entryCount = 0;
    this.list = new Object[size];
    this.size = size;
  }

  private Pair<K, V> getAtIndex(int index) {
    return (Pair<K, V>) list[index];
  }

  private int getIndex(Object key) {
    return key.hashCode() & (size - 1);
  }

  private void rehash() {
    Object[] oldList = list;
    int oldSize = size;

    // Increase by one bit (x2) to decrease collisions
    allocateList(size * 2);

    // Rehash the old list
    for (int i = 0; i < oldSize; i++) {
      Pair<K, V> node = (Pair<K, V>) oldList[i];
      while (node != null) {
        put(node.key, node.value);
        node = node.next;
      }
    }
  }

  private void rehashIfOverLoaded() {
    if ((entryCount * 1.0f / size) >= LOAD_FACTOR) {
      rehash();
    }
  }
}

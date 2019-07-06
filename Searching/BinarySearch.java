public class BinarySearch {
  public static int find(int[] array, int value) {
    return findRecursive(array, value, 0, array.length - 1);
  }

  private static int findRecursive(int[] array, int value, int low, int high) {
    if (low <= high) {
      int split = (low + high) / 2;
      int splitVal = array[split];
      if (splitVal == value) {
        return split;
      } else if (splitVal < value) {
        return findRecursive(array, value, split + 1, high);
      } else {
        return findRecursive(array, value, low, split - 1);
      }
    }
    return -1;
  }
}

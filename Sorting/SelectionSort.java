public class SelectionSort {
  public static void execute(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int swap = array[i];
      int swapIndex = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < swap) {
          swap = array[j];
          swapIndex = j;
        }
      }

      if (swapIndex != i) {
        array[swapIndex] = array[i];
        array[i] = swap;
      }
    }
  }
}

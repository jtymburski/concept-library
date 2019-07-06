public class BubbleSort {
  public static void execute(int[] array) {
    boolean swapOccurred;
    do {
      swapOccurred = false;
      for (int i = 1; i < array.length; i++) {
        if (array[i - 1] > array[i]) {
          int swap = array[i - 1];
          array[i - 1] = array[i];
          array[i] = swap;

          swapOccurred = true;
        }
      }
    } while (swapOccurred);
  }
}

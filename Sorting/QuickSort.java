public class QuickSort {
  public static void execute(int[] array) {
    quicksort(array, 0, array.length - 1);
  }

  private static void quicksort(int[] array, int low, int high) {
    if (low < high) {
      int split = partition(array, low, high);
      quicksort(array, low, split - 1);
      quicksort(array, split + 1, high);
    }
  }

  private static int partition(int[] array, int low, int high) {
    int splitVal = array[high];
    int splitIndex = low;

    for (int i = low; i < high; i++) {
      if (array[i] < splitVal) {
        if (i != splitIndex) {
          int swapVal = array[i];
          array[i] = array[splitIndex];
          array[splitIndex] = swapVal;
        }
        splitIndex++;
      }
    }

    if (high != splitIndex) {
      array[high] = array[splitIndex];
      array[splitIndex] = splitVal;
    }
    return splitIndex;
  }
}

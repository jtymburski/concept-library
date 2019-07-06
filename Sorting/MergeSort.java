public class MergeSort {
  public static void execute(int[] array) {
    int[] helper = new int[array.length];
    mergesort(array, helper, 0, array.length - 1);
  }

  private static void mergesort(int[] array, int[] helper, int low, int high) {
    if (low < high) {
      int middle = (high + low) / 2;
      mergesort(array, helper, 0, middle); // bottom half
      mergesort(array, helper, middle + 1, high); // top half
      merge(array, helper, low, middle, high);
    }
  }

  private static void merge(int[] array, int[] helper, int low, int middle, int high) {
    // Bring the bottom half into the helper
    System.arraycopy(array, low, helper, low, middle - low + 1);

    // Start the merge
    int bot = low;
    int index = low;
    int top = middle + 1;
    while (bot <= middle && top <= high) {
      if (helper[bot] <= array[top]) {
        array[index++] = helper[bot++];
      } else {
        array[index++] = array[top++];
      }
    }

    // Fix the potential of remaining bottom references still in the helper array
    for (int i = bot; i <= middle; i++) {
      array[index++] = helper[i];
    }
  }
}

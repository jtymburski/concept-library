import java.util.Random;

public class Main {
  public static void main(String[] args) {
    // Selection sort
    int[] array1 = createArray();
    print(array1, "Before selection");
    SelectionSort.execute(array1);
    print(array1, "After selection");
  }

  private static int[] createArray() {
    int size = 10;
    int[] array = new int[size];

    Random rnd = new Random();
    for (int i = 0; i < size; i++) {
      array[i] = rnd.nextInt(100);
    }

    return array;
  }

  private static void print(int[] array, String prefix) {
    System.out.print(prefix + ": ");
    for (int val : array) {
      System.out.print(val + ",");
    }
    System.out.println();
  }
}

import java.util.Arrays;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    int[] array1 = createArray();
    print(array1, "Unsorted");
    Arrays.sort(array1);
    print(array1, "Sorted");
    for (int i = 0; i < array1.length; i++) {
      System.out.println("Find on index " + i + ": " + BinarySearch.find(array1, array1[i]));
    }
    System.out.println("Not found index: " + BinarySearch.find(array1, 101));
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

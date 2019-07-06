public class MinHeap {
  // TODO: Bug if reaches end. Need to implement automatic heap alloc grow
  private static final int STARTING_SIZE = 32; // must be a base 2 value

  private int itemCount = 0;
  private int[] heap = new int[STARTING_SIZE];
  private int size = STARTING_SIZE;

  public MinHeap() {}

  // PUBLIC FUNCTIONS

  public boolean empty() {
    return (itemCount == 0);
  }

  public int extractMin() throws IllegalStateException {
    if (empty()) throw new IllegalStateException("heap is empty");

    int min = heap[1];
    heap[1] = heap[itemCount--];
    if (itemCount > 0) {
      bubbleDown(1);
    }

    return min;
  }

  public void insert(int element) {
    heap[++itemCount] = element;
    bubbleUp(itemCount);
  }

  public void print(String prefix) {
    System.out.print(prefix + ": ");
    for (int i = 1; i <= itemCount; i++) {
      System.out.print(heap[i] + ",");
    }
    System.out.println();
  }

  // PRIVATE FUNCTIONS

  private void bubbleDown(int index) {
    int leftIndex = (index << 1);
    boolean grtThanLeft = (leftIndex <= itemCount && heap[index] > heap[leftIndex]);
    int rightIndex = leftIndex + 1;
    boolean grtThanRight = (rightIndex <= itemCount && heap[index] > heap[rightIndex]);

    int swapIndex = 0;
    if (grtThanLeft && grtThanRight) {
      swapIndex = (heap[leftIndex] < heap[rightIndex]) ? leftIndex : rightIndex;
    } else if (grtThanLeft) {
      swapIndex = leftIndex;
    } else if (grtThanRight) {
      swapIndex = rightIndex;
    }

    if (swapIndex > 0) {
      int element = heap[index];
      heap[index] = heap[swapIndex];
      heap[swapIndex] = element;

      bubbleDown(swapIndex);
    }
  }

  private void bubbleUp(int index) {
    int parentIndex = (index >> 1);
    if (parentIndex > 0 && heap[parentIndex] > heap[index]) {
      int element = heap[index];
      heap[index] = heap[parentIndex];
      heap[parentIndex] = element;

      bubbleUp(parentIndex);
    }
  }
}

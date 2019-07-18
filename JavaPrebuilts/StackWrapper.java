import java.util.Stack;

/**
 * Stack<E> core functionality
 */
public class StackWrapper {
  public StackWrapper() {}

  public void execute() {
    Stack<Integer> stack = new Stack<>();

    // Add / Push
    stack.push(1);
    stack.push(4);
    stack.push(8);
    stack.push(12);

    // Peek
    stack.peek(); // Integer

    // Pop
    stack.pop(); // Integer
    stack.pop();

    // Length / Size
    stack.size(); // This might be a long operation. Not sure. Depends on Java implementation
    stack.empty();
  }
}

import java.lang.StringBuilder;

/**
 * StringBuilder core functionality
 */
public class StringBuilderWrapper {
  public StringBuilderWrapper() {}

  public void execute() {
    StringBuilder sb = new StringBuilder();

    // Append and grow the string
    sb.append("Hello");
    sb.append(" ");
    sb.append("WORLD");
    sb.append('!');
    sb.append(' ');
    sb.append(415887);

    // Delete (inclusive of start, exclusive of end)
    sb.delete(1, 2);

    // Length / Size
    //  - note: this is number of chars in string, NOT the number of times append has been called
    sb.length();

    // Convert to string
    sb.toString();
  }
}

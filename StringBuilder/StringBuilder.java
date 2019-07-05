public class StringBuilder {
  private static final int DEFAULT_SIZE = 4;

  private int charCount = 0;
  private int size = DEFAULT_SIZE;
  private char[] str = new char[DEFAULT_SIZE];

  public StringBuilder() {}

  // PUBLIC FUNCTIONS

  public StringBuilder append(String sequence) {
    grow(charCount + sequence.length());
    System.arraycopy(sequence.toCharArray(), 0, str, charCount, sequence.length());
    charCount += sequence.length();

    return this;
  }

  public String toString() {
    return new String(str);
  }

  // PRIVATE FUNCTIONS

  private void grow(int length) {
    if (length > size) {
      char[] oldStr = str;
      while (length >= size) {
        size *= 2;
      }
      str = new char[size];
      System.arraycopy(oldStr, 0, str, 0, charCount);
    }
  }
}

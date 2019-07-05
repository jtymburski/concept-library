public class Main {
  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder()
        .append("Hell")
        .append("o ")
        .append("Wo")
        .append("rld!");

    System.out.println(sb.toString());

    sb.append(" ")
      .append("This is a really really long string with some serious content and this will not be the end of the beginning");

    System.out.println(sb.toString());
  }
}

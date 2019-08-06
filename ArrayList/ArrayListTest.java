import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ArrayListTest {
  @Test
  public void testInitialize() {
    ArrayList<Integer> aList = new ArrayList<>();
    assertNotNull(aList);
    assertEquals(aList.size(), 0);
  }

  @Test
  public void testArrayListAdder_WithObjectParameter_ProperlyAddsItemsToArray() {
    ArrayList<String> aList = new ArrayList<>();
    aList.add("Hello");
    assertEquals(aList.get(0), "Hello");
    assertEquals(aList.size(), 1);
    aList.add(null);
    aList.add("World!");
    assertEquals(aList.size(), 3);
    assertEquals(aList.get(2), "World!");
    assertEquals(aList.get(1), null);
  }

  @Test(expected=IllegalArgumentException.class)
  public void testArrayListAdder_WithObjectParameterAndIndexParameterNegative_ThrowsIllegalArgumentException() {
    ArrayList<String> aList = new ArrayList<>();
    aList.add(-1, "Hello there");
  }

  @Test(expected=IllegalArgumentException.class)
  public void testArrayListAdder_WithObjectParameterAndIndexParameterOutOfRange_ThrowsIllegalArgumentException() {
    ArrayList<String> aList = new ArrayList<>();
    aList.add(1, "Hello there");
  }

  @Test
  public void testArrayListAdder_WithObjectParameterAndIndex_ProperlyAddsItemsToArray() {
    ArrayList<String> aList = new ArrayList<>();
    aList.add(0, "Taren Ferry");
    aList.add(0, "Beginner Test");
    assertEquals(aList.size(), 2);
    assertEquals(aList.get(0), "Beginner Test");
  }

  @Test(expected=IllegalArgumentException.class)
  public void testArrayListGetter_IndexOutOfRange_ThrowsIllegalArgumentException() {
    ArrayList<String> aList = new ArrayList<>();
    aList.get(1);
  }

  @Test(expected=IllegalArgumentException.class)
  public void testArrayListGetter_IndexNegative_ThrowsIllegalArgumentException() {
    ArrayList<String> aList = new ArrayList<>();
    aList.get(-1);
  }

  @Test(expected=IllegalArgumentException.class)
  public void testArrayListRemover_IndexOutOfRange_ThrowsIllegalArgumentException() {
    ArrayList<String> aList = new ArrayList<>();
    aList.remove(1);
  }

  @Test(expected=IllegalArgumentException.class)
  public void testArrayListRemover_IndexNegative_ThrowsIllegalArgumentException() {
    ArrayList<String> aList = new ArrayList<>();
    aList.remove(-1);
  }

  @Test
  public void testArrayListRemover_ProperIndex_WorksAsExpected() {
    ArrayList<String> aList = new ArrayList<>();
    aList.add("Hello");
    aList.add("There.");
    aList.add("Test");
    aList.add("AnotherTest");
    aList.remove(3);
    aList.remove(0);
    aList.remove(0);
    assertEquals(aList.size(), 1);
    assertEquals(aList.get(0), "Test");
  }

  @Test(expected=IllegalArgumentException.class)
  public void testArrayListSetter_IndexOutOfRange_ThrowsIllegalArgumentException() {
    ArrayList<String> aList = new ArrayList<>();
    aList.set(1, "FailTest");
  }

  @Test(expected=IllegalArgumentException.class)
  public void testArrayListSetter_IndexNegative_ThrowsIllegalArgumentException() {
    ArrayList<String> aList = new ArrayList<>();
    aList.set(-1, "FailTest");
  }

  @Test
  public void testArrayListSetter_ProperParameters_WorksAsExpected() {
    ArrayList<String> aList = new ArrayList<>();
    aList.add("Hello");
    aList.add("There.");
    aList.add("Test");
    aList.add("AnotherTest");

    aList.set(0, "New");
    aList.set(1, "Testing");
    aList.set(3, "String");
    
    assertEquals(aList.get(0), "New");
    assertEquals(aList.get(1), "Testing");
    assertEquals(aList.get(2), "Test");
    assertEquals(aList.get(3), "String");
  }
}
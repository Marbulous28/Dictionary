import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void Word_instantiates_true() {
    Word myWord = new Word("Hi");
    assertEquals(true, myWord instanceof Word);
  }

  @Test
  public void Word_WithSpelling_String() {
    Word myWord = new Word("Hi");
    assertEquals("Hi", myWord.getSpelling()); 
  }

}

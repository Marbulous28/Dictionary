import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void Word_instantiates_true() {
    Word myWord = new Word("Mow the lawn");
    assertEquals(true, myWord instanceof Word);
  }

}

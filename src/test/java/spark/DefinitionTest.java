import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void Definition_instantiates_true() {
    Definition myDefinition = new Definition("A beautiful thing");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void Definition_GetMeaning_String() {
    Definition myDefinition = new Definition("cool");
    assertEquals("cool", myDefinition.getMeaning());
  }

}

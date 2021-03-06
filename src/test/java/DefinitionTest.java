import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @After
  public void tearDown() {
    Word.clear();
    Definition.clear();
  }

  @Test
  public void definition_instantiates_true() {
    Definition myDefinition = new Definition("A beautiful thing");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void definition_GetMeaning_String() {
    Definition myDefinition = new Definition("cool");
    assertEquals("cool", myDefinition.getMeaning());
  }

  @Test
  public void definition_ReturnAllDefinitionsOfWord_true() {
    Definition defOne = new Definition("A sweet orange fruit.");
    Definition defTwo = new Definition("A sweet yellow fruit.");
    assertTrue(Definition.all().contains(defOne));
    assertTrue(Definition.all().contains(defTwo));
  }

  @Test
  public void clear_emptiesDefinitionsFromList_0() {
    Definition myDefinition = new Definition("A delicious treat");
    Definition.clear();
    assertEquals(Definition.all().size(), 0);
  }

  @Test
  public void getId_DefinitionInstantiateWithAnID_1() {
    Definition.clear();
    Definition myDefinition = new Definition("A fun activity.");
    assertEquals(1, myDefinition.getId());
  }

  @Test
  public void find_returnsDefinitionWithCorrectId_secondDefinition() {
    Definition firstDefinition = new Definition("A sweet orange fruit.");
    Definition secondDefinition = new Definition("A sweet yellow fruit.");
    assertEquals(Definition.find(secondDefinition.getId()), secondDefinition);
  }

  @Test
  public void find_returnsNullWhenNoDefinitionFound_null() {
    assertTrue(Definition.find(999) == null);
  }

}

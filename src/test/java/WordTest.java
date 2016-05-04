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

  @Test
  public void Word_ReturnAllWords_true() {
    Word wordOne = new Word("One");
    Word wordTwo = new Word("Two");
    assertTrue(Word.all().contains(wordOne));
    assertTrue(Word.all().contains(wordTwo));
  }

  @Test
  public void Clear_emptiesWordsFromList_0() {
    Word myWord = new Word("Hi");
    Word.clear();
    assertEquals(Word.all().size(), 0);
  }

  @Test
  public void GetId_WordInstantiateWithAnID_1() {
    Word.clear();
    Word myWord = new Word("Hi.");
    assertEquals(1, myWord.getId());
  }

  @Test
  public void Find_returnsWordWithCorrectId_secondWord() {
    Word firstWord = new Word("Hello");
    Word secondWord = new Word("There");
    assertEquals(Word.find(secondWord.getId()), secondWord);
  }

  @Test
  public void find_returnsNullWhenNoWordFound_null() {
    assertTrue(Word.find(999) == null);
  }

  @Test
  public void getDefinition_initiallyReturnsEmptyList_ArrayList() {
    Word testWord = new Word("dog");
    assertEquals(0, testWord.getDefinition().size());
  }

  @Test
  public void addDefinition_addsDefinitionToList_true() {
    Word testWord = new Word("cat");
    Definition testDefinition = new Definition("A small furry creature.");
    testWord.addDefinition(testDefinition);
    assertTrue(testWord.getDefinition().contains(testDefinition));
  }


  public class DefinitionTest {
    @After
    public void tearDown() {
      Word.clear();
    }
  }
}

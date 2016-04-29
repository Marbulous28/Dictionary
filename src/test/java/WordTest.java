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
    assertEquals(1, myWord.getID());
  }

  @Test
  public void Find_returnsWordWithCorrectId_secondWord() {
    Word firstWord = new Word("Hello");
    Word secondWord = new Word("There");
    assertEquals(Word.find(secondWord.getID()), secondWord);
  }

  @Test
  public void find_returnsNullWhenNoWordFound_null() {
    assertTrue(Word.find(999) == null);
  }
}

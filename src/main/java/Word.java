import java.util.ArrayList;

public class Word {
  private String mSpelling;
  private static ArrayList<Word> instances = new ArrayList<Word>();
  private int mId;
  private ArrayList <Definition> mDefinitions;


  public Word(String spelling){
    mSpelling = spelling;
    instances.add(this);
    mId = instances.size();
    mDefinitions = new ArrayList<Definition>();
  }

  public String getSpelling() {
    return mSpelling;
  }

  public static ArrayList<Word> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public ArrayList<Definition> getDefinition() {
    return mDefinitions;
  }

  public void addDefinition(Definition definition) {
    mDefinitions.add(definition);
  }

  public static Word find(int id) {
    try {
        return instances.get(id - 1);
      } catch (IndexOutOfBoundsException exception) {
        return null;
      }
  }


}

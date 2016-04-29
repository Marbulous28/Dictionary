import java.util.ArrayList;

public class Word {
  private String mSpelling;
  private static ArrayList<Word> instances = new ArrayList<Word>();
  private int mID;


  public Word(String spelling){
    mSpelling = spelling;
    instances.add(this);
    mID = instances.size();
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

  public int getID() {
    return mID;
  }

  public static Word find(int id) {
    try {
        return instances.get(id - 1);
      } catch (IndexOutOfBoundsException exception) {
        return null;
      }
  }


}

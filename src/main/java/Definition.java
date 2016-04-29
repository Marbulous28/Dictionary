import java.util.ArrayList;

public class Definition {
  private String mMeaning;
  private static ArrayList<Definition> instances = new ArrayList<Definition>();
  private int mID;


  public Definition(String meaning){
    mMeaning = meaning;
    instances.add(this);
    mID = instances.size();
  }

  public String getMeaning() {
    return mMeaning;
  }

  public static ArrayList<Definition> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getID() {
    return mID;
  }

  public static Definition find(int id) {
    try {
        return instances.get(id - 1);
      } catch (IndexOutOfBoundsException exception) {
        return null;
      }
    }
}

//1 unoptimized_imports imports changed to java.util.*
//2 not_boxing boxed lower and higher bound into a class
//3 duplicate_code  method extract get bound from user
//4 feature_envy removed 3 print methods and moved to Musics class
//5 nested if    moved result counter condition to for contidion
//6 many condition with duplicate code  changed switch case to poly morphism
//7 bad use of operation String  -- operation string changed to toString in polymorphism

import java.util.*;

public class Third {

    public static Bound getBoundFromUser(Scanner scanner){
      int lower = scanner.nextInt();
      int higher = scanner.nextInt();
      Bound out = new Bound(lower,higher);
      return out;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxResultCount = scanner.nextInt();
        Bound yearBound = getBoundFromUser(scanner);
        Bound downloadBound = getBoundFromUser(scanner);
        Bound likeBound = getBoundFromUser(scanner);

        Musics.showResults(new Newest(),yearBound,maxResultCount);
        Musics.showResults(new mostDownloaded(),downloadBound,maxResultCount);
        Musics.showResults(new Top(),likeBound,maxResultCount);
    }

}

class Bound{
  public int lower,higher;
  Bound(int lower,int higher){
    this.lower = lower;
    this.higher = higher;
  }
}

abstract class Operation{
  public abstract boolean check(Music music,Bound bound);
}

class Newest extends Operation{
  public boolean check(Music music,Bound bound){
    return bound.lower <= music.getYear() && music.getYear() <= bound.higher;
  }
  public String toString() { return "newest"; }
}

class mostDownloaded extends Operation{
  public boolean check(Music music,Bound bound){
    return bound.lower <= music.getNumberOfDownloads() && music.getNumberOfDownloads() <= bound.higher;
  }
  public String toString() { return "mostDownloaded"; }
}

class Top extends Operation{
  public boolean check(Music music,Bound bound){
    return bound.lower <= music.getNumberOfLikes() && music.getNumberOfLikes() <= bound.higher;
  }
  public String toString() { return "top"; }
}

class Musics {

    private static ArrayList<Music> allMusics;

    //Assume that musics are loaded here to the ArrayList so DON'T change this part
    public static void load(ArrayList<Music> musics) {
        allMusics = musics;
    }

    public static int showResults(Operation operationType, Bound pivotBound, int maxResultCount) {
        ArrayList<Music> results = new ArrayList<>();
        int resultCounter = 0;
        for (int i = 0; i < allMusics.size() && resultCounter < maxResultCount; i++) {
            if ( operationType.check(allMusics.get(i),pivotBound) ){
              results.add(allMusics.get(i));
              resultCounter++;
          }
        }

        System.out.print(operationType + "  ");
        for (int i = 0; i < results.size(); i++)
            System.out.print((i + 1) + "- " + results.get(i).getName() + results.get(i).getYear() + "  ");
        System.out.println();
        return results.size();
    }
}

class Music {

    private String name;
    private int year;
    private int numberOfDownloads = 0;
    private int numberOfLikes = 0;

    public Music(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumberOfDownloads() {
        return numberOfDownloads;
    }

    public void setNumberOfDownloads(int numberOfDownloads) {
        this.numberOfDownloads = numberOfDownloads;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

}

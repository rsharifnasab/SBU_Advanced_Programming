//1 bad_name rename
//2 long method     method extract
//3 duplicate code    push up
//4 duplicate code   replace polymorphism with conditional
//5 feature envy  move method



import java.util.*;

public class Second {

    public static void main(String[] args) {
        Song.reset();
        Scanner myScanner = new Scanner(System.in);
        int songsCount = myScanner.nextInt();
        Song[] songs = new Song[songsCount];

        for (int i = 0; i < songs.length; i++)
            songs[i] = Song.getSongFromUser(myScanner);

        Song.distinct(songs);
        System.out.println(Arrays.toString(Song.popSongs.toArray()));
        System.out.println(Arrays.toString(Song.rockSongs.toArray()));
        System.out.println(Arrays.toString(Song.hiphopSongs.toArray()));
        System.out.println(Arrays.toString(Song.jazSongs.toArray()));
    }

}

class Song {

    protected static ArrayList<Song> popSongs;
    protected static ArrayList<Song> rockSongs;
    protected static ArrayList<Song> hiphopSongs;
    protected static ArrayList<Song> jazSongs;
    public String name;
    public String artist;
    public int numberOfDownloads;
    public int lengthInSeconds;
    public Date date;

    public static Song getSongFromUser(Scanner myScanner){
      Song song;

      String songType = myScanner.next().toUpperCase();
      if(songType.equals("POP")) song = new POP();
      else if(songType.equals("ROCK")) song = new ROCK();
      else if(songType.equals("HIPHOP")) song = new HIPHOP();
      else if(songType.equals("JAZ")) song = new JAZ();
      else throw new RuntimeException("undefined class");

      song.name = myScanner.next();
      song.artist = myScanner.next();
      song.lengthInSeconds = myScanner.nextInt();
      song.numberOfDownloads = myScanner.nextInt();

      return song;
    }

    //DON'T Change This method
    public static void reset() {
        popSongs = new ArrayList<>();
        rockSongs = new ArrayList<>();
        hiphopSongs = new ArrayList<>();
        jazSongs = new ArrayList<>();
    }

    protected void songDistinct(){
      date = new Date();
      numberOfDownloads += 10;
    }

    public static void distinct(Song[] newSongs) {
        for (int i = 0; i < newSongs.length; i++)
            newSongs[i].songDistinct();
    }

    @Override
    public String toString() {
        return "[" + name + "  " + artist + "  " + lengthInSeconds + "  " + numberOfDownloads + "]";
    }

}
class POP extends Song{
  @Override
  protected void songDistinct(){
      super.songDistinct();
      artist += "Aliakbari.com";
      name += "Sadegh";
      if (lengthInSeconds > 300)
        artist += "Professional";
    popSongs.add(this);

  }
  @Override
  public String toString(){
    return "(pop)"+super.toString();
  }
}

class ROCK extends Song{
  @Override
  protected void songDistinct(){
    super.songDistinct();
    artist = "Aliakbari.com";
    rockSongs.add(this);
  }
  @Override
  public String toString(){
    return "(rock)"+super.toString();
  }
}

class HIPHOP extends Song{
  @Override
  protected void songDistinct(){
    super.songDistinct();
    hiphopSongs.add(this);
  }
  @Override
  public String toString(){
    return "(hiphop)"+super.toString();
  }
}


class JAZ extends Song{

  @Override
  protected void songDistinct(){
      super.songDistinct();
      name += "@jaz";
      if (lengthInSeconds < 180) {
            numberOfDownloads += 5;
            artist += "Beginner";
      }
      jazSongs.add(this);
  }

  @Override
  public String toString(){
    return "(jaz)"+super.toString();
  }
}

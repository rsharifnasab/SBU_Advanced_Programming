//5
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


public class Second {

    public static void main(String[] args) {
        Song.reset();
        Scanner s = new Scanner(System.in);
        int inputNumber = s.nextInt();
        Song[] songs = new Song[inputNumber];
        for (int i = 0; i < songs.length; i++) {
            Song song = new Song();
            song.songType = SongType.valueOf(s.next().toUpperCase());
            song.name = s.next();
            song.artist = s.next();
            song.lengthInSeconds = s.nextInt();
            song.numberOfDownloads = s.nextInt();
            songs[i] = song;
        }
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
    public SongType songType;

    //DON'T Change This method
    public static void reset() {
        popSongs = new ArrayList<>();
        rockSongs = new ArrayList<>();
        hiphopSongs = new ArrayList<>();
        jazSongs = new ArrayList<>();
    }

    public static void distinct(Song[] newSongs) {
        for (int i = 0; i < newSongs.length; i++) {
            newSongs[i].date = new Date();
            switch (newSongs[i].songType) {
                case POP:
                    newSongs[i].numberOfDownloads += 10;
                    newSongs[i].artist += "Aliakbari.com";
                    newSongs[i].name += "Sadegh";
                    if (newSongs[i].lengthInSeconds > 300)
                        newSongs[i].artist += "Professional";
                    popSongs.add(newSongs[i]);
                    break;
                case ROCK:
                    rockSongs.add(newSongs[i]);
                    newSongs[i].numberOfDownloads += 10;
                    newSongs[i].artist = "Aliakbari.com";
                    break;
                case HIPHOP:
                    hiphopSongs.add(newSongs[i]);
                    newSongs[i].numberOfDownloads += 10;
                    break;
                case JAZ:
                    newSongs[i].name += "@jaz";
                    newSongs[i].numberOfDownloads += 10;
                    if (newSongs[i].lengthInSeconds < 180) {
                        newSongs[i].numberOfDownloads += 5;
                        newSongs[i].artist += "Beginner";
                    }
                    jazSongs.add(newSongs[i]);

            }
        }
    }

    @Override
    public String toString() {
        String type = null;
        switch (songType) {
            case POP:
                type = "(pop)";
                break;
            case ROCK:
                type = "(rock)";
                break;
            case HIPHOP:
                type = "(hiphop)";
                break;
            case JAZ:
                type = "(jaz)";
        }
        return type + "[" + name + "  " + artist + "  " + lengthInSeconds + "  " + numberOfDownloads + "]";
    }

}

enum SongType {
    POP, ROCK, HIPHOP, JAZ
}

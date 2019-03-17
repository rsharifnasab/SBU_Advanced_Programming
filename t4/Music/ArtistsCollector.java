public class ArtistsCollector extends DataCollector {
    public Object get(Music music){
      return music.getArtist();
    }
}

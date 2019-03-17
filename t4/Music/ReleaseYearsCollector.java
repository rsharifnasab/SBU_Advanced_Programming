public class ReleaseYearsCollector extends DataCollector {
    public Object get(Music music){
      return new Integer(music.getReleaseYear());
    }
}

public class FilterByArtist extends Filter {
    String [] OKs;
    public FilterByArtist(String...args){
      OKs = args;
    }
    public boolean accept(Music music){
      for(String toCheck : OKs){
        if(music.getArtist().equals(toCheck)) return true;
      }
      return false;
    }

}

public class FilterByAlbum extends Filter {
    String [] OKs;
    public FilterByAlbum(String...args){
      OKs = args;
    }
    public boolean accept(Music music){
      for(String toCheck : OKs){
        if(music.getAlbum().equals(toCheck)) return true;
      }
      return false;
    }
}

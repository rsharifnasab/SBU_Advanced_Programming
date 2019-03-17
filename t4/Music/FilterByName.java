public class FilterByName extends Filter {
    String [] OKs;
    public FilterByName(String...args){
      OKs = args;
    }
    public boolean accept(Music music){
      for(String toCheck : OKs){
        if(music.getName().equals(toCheck)) return true;
      }
      return false;
    }

}

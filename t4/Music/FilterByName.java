public class FilterByname extends Filter {
    String [] OKs;
    public FilterByname(String...args){
      OKs = args;
    }
    public boolean accept(Music music){
      for(String toCheck : OKs){
        if(music.getName().equals(toCheck)) return true;
      }
      return false;
    }

}

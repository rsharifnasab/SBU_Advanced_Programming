public class FilterByYear extends Filter {
    int [] OKs;
    public FilterByYear(int...args){
      OKs = args;
    }
    public boolean accept(Music music){
      for(int toCheck : OKs){
        if(music.getReleaseYear() == toCheck) return true;
      }
      return false;
    }

}

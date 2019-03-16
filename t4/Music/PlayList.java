public class PlayList{
  private Music[] db;
  private int last=0;

  public PlayList(int size){
    db = new Music[size];
  }

  public Music[] getMusics(){
    return db;
  }

  public int getNumberOfMusics(){
    return last;
  }

  public boolean isFull(){
    return((last+1)>=db.length);
  }

  public boolean addMusic(Music music){
    if(this.isFull()) return false;
    db[last++] = music;
    return true;
  }



}

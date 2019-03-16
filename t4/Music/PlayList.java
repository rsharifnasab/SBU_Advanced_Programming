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
    return db.size;
  }

  public int isFull(){
    return(last+1>=db.size);
  }
  public boolean addMusic(Music music){
    if(this.isFull()) return false;
    db[last++] = music;
    return true;
  }

}

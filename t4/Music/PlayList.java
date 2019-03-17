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

  public PlayList filter(PlayList accepter){
    PlayList ansBL = new PlayList(this.getNumberOfMusics());
    for (Music toCheck : db) {
      if(accepter.accept(toCheck)) ansBL.addMusic(toCheck);
    }
    int fixedSize = ansBL.getNumberOfMusics();
    PlayList ansGL = new PlayList(fixedSize);
    for (Music t:ansBL.getMusics()) {
      ansGL.addMusic(t);
    }
    return ansGL;
  }



}

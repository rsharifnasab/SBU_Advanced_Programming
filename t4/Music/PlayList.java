public class PlayList{
  //private  TODO
  Music[] db;
  private int last=0;

  public PlayList(int size){
    db = new Music[size];
  }

  public Music[] getMusics(){
    int fixedSize = this.getNumberOfMusics();
    PlayList ans = new PlayList(fixedSize);
    for (Music a : this.db) { //TODO working well but it could be dangerous
      ans.addMusic(a);
    }
    return ans.db;
  }

  public int getNumberOfMusics(){
    return last;
  }

  public boolean isFull(){
    if(last < db.length) return false;
    return true;
  }

  public boolean addMusic(Music music){
    if(this.isFull()) return false;
    db[this.last++] = music;
    return true;
  }

  public PlayList filter(Filter accepter){ //TODO
    PlayList ansBL = new PlayList(this.getNumberOfMusics());

    for (Music toCheck : db) {
      if(toCheck == null) break;
      if(accepter.accept(toCheck)) ansBL.addMusic(toCheck);
    }

    int fixedSize = ansBL.getNumberOfMusics();
    PlayList ansGL = new PlayList(fixedSize);
    for (Music t:ansBL.getMusics()) {
      ansGL.addMusic(t);
    }
    return ansGL;
  }

  public Object[] collectData(DataCollector collector){
    int fixedSize = getNumberOfMusics();
    Object[] ans = new Object[fixedSize];
    for(int i = 0; i < fixedSize; i++){
      ans[i] = collector.get(this.db[i]);
    }
    return ans;
  }

  public Object[] collectDataNoDuplicate(DataCollector collector){
    Object[] duplicate = collectData(collector);
    int allSize = duplicate.length;
    int last = 0;
    Object[] noDuplicateBL = new Object[allSize];


    for (int i=0;i<allSize;i++ ) {
      boolean hast = false;
      for (int j=0;j<allSize;j++ ) {
        if(duplicate[i].equals(noDuplicateBL[j])) hast = true;
      }
      System.out.println("hast :" + hast);
      if(!hast) noDuplicateBL[last++] =  duplicate[i];
    }
    //System.out.println("last is :" + last);
    Object[] ans = new Object[last];
    for (int i=0;i<last;i++ ) {
      ans[i] = noDuplicateBL[i];
    }
    return ans;
  }



}

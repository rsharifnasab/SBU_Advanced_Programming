public class Main{
  public static void main(String[] args) {

    PlayList playList = new PlayList(50);
    playList.addMusic(new Music("a", "b", "c", 2000));
    playList.addMusic(new Music("aa", "bb", "cc", 2000));
    playList.addMusic(new Music("aaa", "b", "cc", 2000));
    playList.addMusic(new Music("aaa", "b", "ccc", 2010));

    Object[] names = playList.getMusics();
    System.out.println("length of names : " + names.length);
    for (int i = 0; i < playList.getNumberOfMusics(); i++) {
      System.out.println(names[i]);
    }
    System.out.println();
    PlayList tmp = playList.filter(new FilterByYear(2000));
    for (int i = 0; i < tmp.getNumberOfMusics(); i++) {
      System.out.println(tmp.getMusics()[i]);
    }

    System.out.println();;

  }
}

public class Main{
  public static void main(String[] args) {
    PlayList playList = new PlayList(50);
    playList.addMusic(new Music("a", "b", "c", 2000));
    playList.addMusic(new Music("aa", "bb", "cc", 2000));
    playList.addMusic(new Music("aaa", "b", "cc", 2000));
    playList.addMusic(new Music("aaa", "b", "ccc", 2010));

    PlayList tmp = playList.filter(new FilterByAlbum("b"));
    for (int i = 0; i < tmp.getNumberOfMusics(); i++) {
      System.out.println(tmp.getMusics()[i]);
    }

    System.out.println();

    Object[] names = playList.collectData(new NamesCollector());
    System.out.println("length of names : " + names.length);
    for (int i = 0; i < names.length; i++) {
      System.out.println(names[i]);
    }


    System.out.println();

    Object[] someYears = playList.filter(new FilterByArtist("c", "cc")).collectData(new ReleaseYearsCollector());
    System.out.println("length of someYears : " + someYears.length);
    for (int i = 0; i < someYears.length; i++) {
      System.out.println(someYears[i]);
    }

    System.out.println();

    //extra
    Object[] years = playList.collectDataNoDuplicate(new ReleaseYearsCollector());
    System.out.println("length of years : " + years.length);
    for (int i = 0; i < years.length; i++) {
      System.out.println(years[i]);
    }

  }
}

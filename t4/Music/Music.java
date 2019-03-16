public class Music {
    private final String album;
    private final String name;
    private final String artist;
    private final int releaseYear;

    public Music(String name,String album,String artist,int releaseYear) {
        this.album = album;
        this.name = name;
        this.artist = artist;
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() { return "[ name : " + name + "  Artists : " + artist + "  Album : " + album + "  released : " + releaseYear + " ]"; }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Music)
            return name.equalsIgnoreCase(((Music) obj).name) && album.equalsIgnoreCase(((Music) obj).album)
                    && artist.equalsIgnoreCase(((Music) obj).artist) && releaseYear == ((Music) obj).releaseYear ;
        return false;
    }

    public String getAlbum() { return album; }

    public int getReleaseYear(){ return releaseYear; }

    public String getArtist() { return artist; }

    public String getName() { return name; }
}

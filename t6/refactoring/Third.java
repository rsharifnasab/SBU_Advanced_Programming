//4
import java.util.ArrayList;
import java.util.Scanner;

public class Third {

    public static void printNewestMusics(int maxResultCount, int yearLowerBound, int yearUpperBound) {
        String operation = "newest";
        Musics.showResults(maxResultCount, yearLowerBound, yearUpperBound, operation);
    }

    public static void printMostDownloadedMusics(int maxResultCount, int downloadLowerBound, int downloadUpperBound) {
        String operation = "mostDownloaded";
        Musics.showResults(maxResultCount, downloadLowerBound, downloadUpperBound, operation);
    }

    public static void printTopMusicsOfWeek(int maxResultCount, int likeLowerBound, int likeUpperBound) {
        String operation = "top";
        Musics.showResults(maxResultCount, likeLowerBound, likeUpperBound, operation);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxResultCount = scanner.nextInt();
        int yearLowerBound = scanner.nextInt(), yearUpperBound = scanner.nextInt();
        int downloadLowerBound = scanner.nextInt(), downloadUpperBound = scanner.nextInt();
        int likeLowerBound = scanner.nextInt(), likeUpperBound = scanner.nextInt();
        printNewestMusics(maxResultCount, yearLowerBound, yearUpperBound);
        printMostDownloadedMusics(maxResultCount, downloadLowerBound, downloadUpperBound);
        printTopMusicsOfWeek(maxResultCount, likeLowerBound, likeUpperBound);
    }

}

class Musics {

    private static ArrayList<Music> allMusics;

    //Assume that musics are loaded here to the ArrayList so DON'T change this part
    public static void load(ArrayList<Music> musics) {
        allMusics = musics;
    }

    public static int showResults(int maxResultCount, int pivotLowerBound, int pivotUpperBound, String operationType) {
        ArrayList<Music> results = new ArrayList<>();
        int resultCounter = 0;
        switch (operationType) {
            case "newest": {
                for (int i = 0; i < allMusics.size(); i++) {
                    if (resultCounter < maxResultCount) {
                        if (pivotLowerBound <= allMusics.get(i).getYear() && allMusics.get(i).getYear() <= pivotUpperBound) {
                            results.add(allMusics.get(i));
                            resultCounter++;
                        }
                    } else
                        break;
                }
                break;
            }
            case "mostDownloaded": {
                for (int i = 0; i < allMusics.size(); i++) {
                    if (resultCounter < maxResultCount) {
                        if (pivotLowerBound <= allMusics.get(i).getNumberOfDownloads() && allMusics.get(i).getNumberOfDownloads() <= pivotUpperBound) {
                            results.add(allMusics.get(i));
                            resultCounter++;
                        }
                    } else
                        break;
                }
                break;
            }
            case "top": {
                for (int i = 0; i < allMusics.size(); i++) {
                    if (resultCounter < maxResultCount) {
                        if (pivotLowerBound <= allMusics.get(i).getNumberOfLikes() && allMusics.get(i).getNumberOfLikes() <= pivotUpperBound) {
                            results.add(allMusics.get(i));
                            resultCounter++;
                        }
                    } else
                        break;
                }
            }
        }
        System.out.print(operationType + "  ");
        for (int i = 0; i < results.size(); i++)
            System.out.print((i + 1) + "- " + results.get(i).getName() + results.get(i).getYear() + "  ");
        System.out.println();
        return results.size();
    }
}

class Music {

    private String name;
    private int year;
    private int numberOfDownloads = 0;
    private int numberOfLikes = 0;

    public Music(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumberOfDownloads() {
        return numberOfDownloads;
    }

    public void setNumberOfDownloads(int numberOfDownloads) {
        this.numberOfDownloads = numberOfDownloads;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

}


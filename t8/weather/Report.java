import java.util.*;
import java.util.stream.Collectors;

class SortCityInfo implements Comparator<CityInformation>{
  public int compare(CityInformation a,CityInformation b){
    int ans = a.getCity().compareTo(b.getCity());
    //if(ans!=0) return ans;
    return ans;
  }
}
class SortCityMonthInfo implements Comparator<CityMonthInformation>{
  public int compare(CityMonthInformation a,CityMonthInformation b){
    int ans = a.getCity().compareTo(b.getCity());
    if(ans!=0) return ans;
    return new Integer(a.getMonth()).compareTo(b.getMonth());
  }
}
public class Report {

    private List<Information> listInformation;

    public Report(List<Information> listInformation) {
        this.listInformation = listInformation;
    }

    static int info2year(Information info){
      String [] yearString = info.getDate().split("/") ;
      return Integer.parseInt(yearString[0]);
    }
    static int info2month(Information info){
      String [] yearString = info.getDate().split("/") ;
      return Integer.parseInt(yearString[1]);
    }


    public List<CityInformation> sumByCity(int year) {
      List<CityInformation> ans = new ArrayList<>();
        for (Information info : listInformation) {
          if(info2year(info) == year) ans.add(new CityInformation(info.getCity(),info.getAmount()));
        }
        Collections.sort(ans,new SortCityInfo());
        return ans;
    }

    public List<CityMonthInformation> sumCityByMonth(int year) {
        List<CityMonthInformation> ans = new ArrayList<>();
        for (Information info : listInformation) {
          if(info2year(info) == year) ans.add(new CityMonthInformation(info.getCity(),info2month(info),info.getAmount()));
        }
        Collections.sort(ans,new SortCityMonthInfo());
        return ans;
    }

    public static void main(String[] args) {
        Report service = new Report(Arrays.asList(
                new Information("Hamadan", "1394/5/13", 10), new Information("Kurdistan", "1394/9/1", 50),
                new Information("Yazd", "1394/2/15", 10), new Information("Kurdistan", "1394/9/2", 2)
        ));

        List<CityInformation> sumResults = service.sumByCity(1394);
        System.out.printf("sum total: %d%n", sumResults.size());
        CityInformation sumHamadan = sumResults.get(0);
        System.out.printf("1: %s %d%n", sumHamadan.getCity(), sumHamadan.getSum());
        CityInformation sumKurdistan = sumResults.get(1);
        System.out.printf("2: %s %d%n", sumKurdistan.getCity(), sumKurdistan.getSum());
        CityInformation sumYazd = sumResults.get(2);
        System.out.printf("2: %s %d%n", sumYazd.getCity(), sumYazd.getSum());
        sumYazd = sumResults.get(3);
        System.out.printf("2: %s %d%n", sumYazd.getCity(), sumYazd.getSum());

        List<CityMonthInformation> sumMonthResults = service.sumCityByMonth(1394);
        System.out.printf("sum total: %d%n", sumMonthResults.size());
        CityMonthInformation sumFirst = sumMonthResults.get(0);
        System.out.printf("1: %s %d %d%n", sumFirst.getCity(), sumFirst.getMonth(), sumFirst.getSum());
        CityMonthInformation sumSecond = sumMonthResults.get(1);
        System.out.printf("2: %s %d %d%n", sumSecond.getCity(), sumSecond.getMonth(), sumSecond.getSum());
        CityMonthInformation sumThird = sumMonthResults.get(2);
        System.out.printf("2: %s %d %d%n", sumThird.getCity(), sumThird.getMonth(), sumThird.getSum());
        sumThird = sumMonthResults.get(3);
        System.out.printf("2: %s %d %d%n", sumThird.getCity(), sumThird.getMonth(), sumThird.getSum());
    }

}

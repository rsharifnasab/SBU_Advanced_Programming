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
      Comparator<Information> byName = Comparator.comparing(Information::getCity);
      listInformation.stream()
      .filter(a->info2year(a)==year)
      .sorted(byName)
      .map(a->new CityInformation(a.getCity(),a.getAmount()))
      .forEach(a->ans.add(a));

        for (int i=ans.size()-1;i>0 ;i-- ) {
          if(ans.get(i).getCity().equals(ans.get(i-1).getCity())) {
            ans.get(i-1).setSum(ans.get(i).getSum()+ans.get(i-1).getSum());
            ans.remove(i);
            i--;
          }
        }
        return ans;
    }

    public List<CityMonthInformation> sumCityByMonth(int year) {
        List<CityMonthInformation> ans = new ArrayList<>();
        Comparator<Information> bynameMonth = Comparator.comparing(Information::getCity).thenComparing(a-> info2month(a));
        listInformation.stream()
        .filter(a->info2year(a)==year)
        .sorted(bynameMonth)
        .map(a->new CityMonthInformation(a.getCity(),info2month(a),a.getAmount()))
        .forEach(a->ans.add(a));

        for (int i=ans.size()-1;i>0 ;i-- ) { //TODO
          if(ans.get(i).getCity().equals(ans.get(i-1).getCity()) && ans.get(i).getMonth() == ans.get(i-1).getMonth()) {
            ans.get(i-1).setSum(ans.get(i).getSum()+ans.get(i-1).getSum());
            ans.remove(i);
            i--;
          }
        }
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
        //CityInformation sumtemp = sumResults.get(3);
        //System.out.printf("2: %s %d%n", sumtemp.getCity(), sumtemp.getSum());


        List<CityMonthInformation> sumMonthResults = service.sumCityByMonth(1394);
        System.out.printf("sum total: %d%n", sumMonthResults.size());
        CityMonthInformation sumFirst = sumMonthResults.get(0);
        System.out.printf("1: %s %d %d%n", sumFirst.getCity(), sumFirst.getMonth(), sumFirst.getSum());
        CityMonthInformation sumSecond = sumMonthResults.get(1);
        System.out.printf("2: %s %d %d%n", sumSecond.getCity(), sumSecond.getMonth(), sumSecond.getSum());
        CityMonthInformation sumThird = sumMonthResults.get(2);
        System.out.printf("2: %s %d %d%n", sumThird.getCity(), sumThird.getMonth(), sumThird.getSum());

    }

}

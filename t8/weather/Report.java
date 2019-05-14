import java.util.*;
import java.util.stream.Collectors;

public class Report {

    private List<Information> listInformation;

    public Report(List<Information> listInformation) {
        this.listInformation = listInformation;
    }

    public List<CityInformation> sumByCity(int year) {
        // TODO
        return null;
    }

    public List<CityMonthInformation> sumCityByMonth(int year) {
        // TODO
        return null;
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

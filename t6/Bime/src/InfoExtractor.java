import java.util.*;
public class InfoExtractor{
    private static  int max;
    public static void setMax(int mmax){
        max = mmax;
    }

    public static void main(String[] args) {
        System.out.println("salam");
    }

    private static void checkList(List<Person> people) throws RuntimeException{
        if(people == null) throw new EmptyInputException();
        if(people.isEmpty()) throw new EmptyInputException();
        if(people.size()>max) throw new DataInputOverflowException();
        for( Person p : people)
            if (p == null) throw new NullPointerException();

    }

    public static List<Integer> getPaymentsPerHour(List<Person> people){
        checkList(people);
        List<Integer> ans = new ArrayList<>();
        for (Person p : people ) {
            if( p instanceof Employee == false)
                ans.add(0);
            else{
                Employee e = (Employee) p
                int kaf = e.getPaymentPerMonth() * 12;
                kaf /= (366 * e.getWorkHoursPerDay());
                ans.add(kaf);
            }
        }
        return ans;
    }

    public static Person getLaziest(List<Person> people){
        checkList(people);
        List<Person> ans = new ArrayList<>();
        for (Person p : people )
            if( p instanceof Employee == false) ans.add(p)

        if (ans.isEmpty()) return null;
        int laziestIndex = 0;
        long laziestMoney = Long.MAX_VALUE;
        for (int i=0;i < ans.size();i++ ) {
            Person p = ans.get(i);
            if(laziestMoney > p.getBalance()){
                laziestIndex = i;
                laziestMoney = p.getBalance();
            }
        }
        return ans.get(laziestIndex);
    }
    private static boolean comp(Employee a,Employee b){ // check if a is succerser than b
        Integer Akaf = a.getPaymentPerMonth() * 12;
        Akaf /= (366 * a.getWorkHoursPerDay());

        Integer Bkaf = b.getPaymentPerMonth() * 12;
        Bkaf /= (366 * b.getWorkHoursPerDay());

        if(Akaf > Bkaf) return true;
        if(Akaf < Bkaf) return false;

        if(a.getAge() < b.getAge()) return true;
        if(a.getAge() > b.getAge()) return false;

        return false;
    }

    public static List<Employee> sortOnSuccess(List<Person> people){
        checkList(people);
        ArrayList <Employee> tempA = new ArrayList<>();
        for (Person p: people) {
            if(p instanceof Employee) temp.add(p);
        }

        Employee[] all = tempA.toArray(new Employee[0]);
        int n = all.length;
        for (int i =0;i < n-1;i++ ) {
            for (int j = 0; j< n-i-1 ;j++ ) {
                if(comp(all[j],all[j+1])){
                    Employee temp = all[j];
                    all[j] = all[j+1];
                    all[j+1] = temp;
                }
            }
        }

        ArrayList<Employee> ans = new ArrayList<Employee>(Arrays.asList(all));
        return ans;
    }

    private static Double averMoney (List<Person> people){
        double sum = 0;
        for (Person p: poeple) {
             sum+= p.getBalance();
        }
        return (double) sum/poeple.length;
    }

    private static Double averPay (List<Person> people){
        double sum = 0;
        for (Person p: poeple) {
            if (p instanceof Employee == false) continue;
            Employee e = (Employee) p;
            Integer Akaf = e.getPaymentPerMonth() * 12;
            Akaf /= (366 * e.getWorkHoursPerDay());
            sum+= Akaf;
        }
        return (double) sum/people.length;
    }
    public static List<Person> getRichestSorted(List<Person> people){
        Double moneyAver = averMoney(poeple);
        Double payAver = averPay(poeple)

        List <Person> richList =  new ArrayList<Person>();
        for (Person p:people) {
            if(p.getBalance() > moneyAver && p instanceof Employee){
                Employee e = (Employee) p;
                Integer Akaf = e.getPaymentPerMonth() * 12;
                Akaf /= (366 * e.getWorkHoursPerDay());
                if(Akaf > payAver) richList.add(p);
            }
        }
        Person[] richArr = richList.toArray(new Person[0]);
        int n = richArr.size;
        for (int i =0;i < n-1;i++ ) {
            for (int j = 0; j< n-i-1 ;j++ ) {
                if( richArr[j].getName().compareTo(richArr[j+1].getName()) > 0  ) {
                    Person temp = richArr[j];
                    richArr[j] = richArr[j+1];
                    richArr[j+1] = temp;
                }
            }
        }

        ArrayList<Person> ans = new ArrayList<>(Arrays.asList(richArr));
        return ans;
    }

}

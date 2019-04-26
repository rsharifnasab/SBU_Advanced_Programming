public class InfoExtractor{
  int max;
  public static void setMax(int max){
    this.max = max;
  }

  private static void checkList(list<Person> people) throws RuntimeException{
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
          int kaf = p.getPaymentPerMonth() * 12;
          kaf /= (366 * getWorkHoursPerDay());
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
    int laziestMoney = Integer.MAX_VALUE;
    for (int i=0;i < ans.size();i++ ) {
      Person p = ans.get(i);
      if(laziestMoney > p.getBalance()){
        laziestIndex = i;
        laziestMoney = p.getBalance();
      }
    }
    return ans.get(laziestIndex);
  }
  private static boolean comp(Person a,Person b){ // check if a is succerser than b
    if(a.)
  }

  public static List<Employee> sortOnSuccess(List<Person> people){
    checkList(people);
    Person[] all = poeple.toArray();
    for (int i =0;i < all.size();i++ ) {
      for (int j = i; j< all.size() ;j++ ) {
        if(comp(all[i],all[j])){
          Person temp = all[i];
          all[i] = all[j];
          all[j] = temp;
        }
      }
    }

  }

  public static List<Person> getRichestSorted(List<Person> people){

  }

}

public class Main{
  public static void main(String[] args) {
    Integer a = new Integer(1);
    Integer a2 = a; // 1
    Integer b = new Integer(7);
    swap(a,b);
    System.out.println(" a : "+ a + " - b : " + b + " and a2 : "+ a2);
  }
  public static void swap(Integer first, Integer second)
  {
    try{
      Integer temp= new Integer(second);
      java.lang.reflect.Field field= Integer.class.getDeclaredField("value");
      field.setAccessible(true);
      field.set(second, first.intValue());
      field.set(first, temp.intValue());
      field.setAccessible(false);
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  public static void swap2(Integer first,Integer second){
    try {
        Integer temp = new Integer(second);
        java.lang.reflect.Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        field.set(second,first.intValue());
        field.set(first,temp.intValue());
        field.setAccessible(false);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}

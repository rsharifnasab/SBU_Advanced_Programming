public class Main{
  public static void main(String[] args) {
    Jacket linenCoat = new Jacket("Linen Coat", Season.FALL, 100000);
    System.out.println("Linen Coat: "  + linenCoat.getPrice());

    linenCoat.setDiscountStrategy(new YaldaDiscountStrategy());
    System.out.println("Linen Coat with Yalda discount: "  + linenCoat.getPrice());

    linenCoat.setDiscountStrategy(new WinterDiscountStrategy());
    System.out.println("Linen Coat with Winter discount: "  + linenCoat.getPrice());

    Clothing woolenSocks = new Pants("Woolen Socks", Season.WINTER, 10000);
    System.out.println("Woolen Socks: "  + woolenSocks.getPrice());

    woolenSocks.setDiscountStrategy(new SummerDiscountStrategy());
    System.out.println("Woolen Socks with Summer discount: "  + woolenSocks.getPrice());

    woolenSocks.setDiscountStrategy(new WinterDiscountStrategy());
    System.out.println("Woolen Socks with Winter discount: "  + woolenSocks.getPrice());
  }
}

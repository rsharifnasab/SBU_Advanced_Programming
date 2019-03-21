public class YaldaDiscountStrategy implements DiscountStrategy
{
    @Override
    public long priceByDiscount(Clothing clothing)
    {
		  long basePrice = clothing.getBasePrice();
      String clothType = clothing.getClass().getName(); //ERROR?
      double priceRatio = 0.75;

      if(clothType.equals("Jacket")) priceRatio = 0.9;
      else if(clothType.equals("Socks")) priceRatio = 0.8;
      System.err.println("clothType :" + clothType);

      return (long) (basePrice * priceRatio);
    }
}

public class WinterDiscountStrategy implements DiscountStrategy
{
    @Override
    public long priceByDiscount(Clothing clothing)
    {
      long basePrice = clothing.getBasePrice();
      Season season = clothing.getSeason();
      //SPRING, SUMMER, FALL, WINTER
      Long price = basePrice
      if(season == Season.SPRING) price = 0.6*basePrice;
      if(season == Season.SUMMER) price = 0.75*basePrice;
      if(season == Season.WINTER) price = 0.7*basePrice;


      String clothType = clothing.getName(); //ERROR?
      if(clothType.equals("Jacket")) price *= 0.9;

      return price;

    }
}

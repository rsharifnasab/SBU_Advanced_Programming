public class SummerDiscountStrategy implements DiscountStrategy
{
    @Override
    public long priceByDiscount(Clothing clothing)
    {
        long basePrice = clothing.getBasePrice();
        Season season = clothing.getSeason();
        //SPRING, SUMMER, FALL, WINTER
        if(season == Season.SPRING) return 0.6*basePrice;
        if(season == Season.SUMMER) return 0.5*basePrice;
        if(season == Season.FALL) return 1*basePrice;
        if(season == Season.WINTER) return 0.7*basePrice;

    }
}

public class SummerDiscountStrategy implements DiscountStrategy
{
    @Override
    public long priceByDiscount(Clothing clothing)
    {
        long basePrice = clothing.getBasePrice();
        Season season = clothing.getSeason();
        if(season == Season.SPRING) return (long) (0.6*basePrice);
        else if(season == Season.SUMMER) return (long) (0.5*basePrice);
        else if(season == Season.WINTER) return (long) (0.7*basePrice);
        return basePrice;
        //if(season == Season.FALL) return (long) (1*basePrice);
    }
}

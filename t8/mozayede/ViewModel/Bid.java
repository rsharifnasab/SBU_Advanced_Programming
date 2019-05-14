package ViewModel;

public class Bid {
    private final int time;
    private final long price;

    public Bid(int time, long price) {
        this.time = time;
        this.price = price;
    }

    public int getTime() {
        return time;
    }

    public long getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bid bid = (Bid) o;
        return time == bid.time &&
                price == bid.price;
    }
}

public class Auctioneer implements Runnable {
    private long startPrice;
    private long interval;
    private Buyer finalBuyer;
    private long finalPrice;

    public Auctioneer(long startPrice, long interval) {
        this.startPrice = startPrice;
        this.interval = interval;
        finalPrice = -1;
        finalBuyer = null;
    }

    public Buyer getFinalBuyer() {
        return finalBuyer;
    }

    public long getFinalPrice() {
        return finalPrice;
    }

    @Override
    public void run() {
        synchronized (this) {
            notifyAll(); // notify all buyers to start biding
        }

        // TODO
    }
}

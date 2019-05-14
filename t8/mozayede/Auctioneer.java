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
    public void run() throws InterruptedException{
        synchronized (this) {
            notifyAll(); // notify all buyers to start biding
        }
        long last = 0;
        while (true)
        {
          long startTime = System.currentTimeMillis();
          Thread.wait(500-last);
          last = 0;
          long endTime = System.currentTimeMillis();
          if(endTime-startTime >= 500) return;
          if()
        }

    }
}

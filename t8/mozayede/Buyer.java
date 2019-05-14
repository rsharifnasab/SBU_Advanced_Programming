import ViewModel.Bid;

import java.util.List;

public class Buyer implements Runnable {
    private String name;
    private final List<Bid> bids;
    private final Auctioneer auctioneer;

    public Buyer(String name, List<Bid> bids, Auctioneer auctioneer) {
        this.name = name;
        this.bids = bids;
        this.auctioneer = auctioneer;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        synchronized (auctioneer) {
            try {
                auctioneer.wait(); // wait until auctioneer start auction
            } catch (InterruptedException e) {
                // ignore it
            }
        }

        // TODO
    }
}

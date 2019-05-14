import ViewModel.Bid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Auction {
    public static void main(String[] args) {
        List<Buyer> buyers = new ArrayList<>();
        Auctioneer auctioneer = new Auctioneer(200, 500);
        buyers.add(new Buyer("buyer1", Arrays.asList(
                new Bid(50, 100), new Bid(400, 500), new Bid(850, 700), new Bid(1300, 750)), auctioneer));
        buyers.add(new Buyer("buyer2", Arrays.asList(
                new Bid(200, 400), new Bid(700, 1)), auctioneer));

        startAuction(auctioneer, buyers);
    }

    public static void startAuction(Auctioneer auctioneer, List<Buyer> buyers) {
        // Create enough thread for buyers and auctioneer
        for (Buyer buyer : buyers)
            new Thread(buyer).start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            // ignore it
        }
        Thread auctioneerThread = new Thread(auctioneer);
        auctioneerThread.start();
        try {
            auctioneerThread.join(); // Wait for auction
            if (auctioneer.getFinalBuyer() != null)
                System.out.println(auctioneer.getFinalBuyer().getName() + " give best price: " +
                        auctioneer.getFinalPrice());
            else
                System.out.println("No good price suggested");
        } catch (InterruptedException e) {
            // ignore it
        }
    }
}

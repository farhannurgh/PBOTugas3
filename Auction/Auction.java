import java.util.ArrayList;

public class Auction {
    private ArrayList<Lot> lots;
    private int nextLotNumber;

    public Auction() {
        lots = new ArrayList<>();
        nextLotNumber = 1;
    }

    public void enterLot(String description) {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    public Lot getLot(int lotNumber) {
        for (Lot lot : lots) {
            if (lot.getLotNumber() == lotNumber) {
                return lot;
            }
        }
        return null;
    }

    public boolean makeBid(int lotNumber, Person person, double amount) {
        Lot selectedLot = getLot(lotNumber);
        if (selectedLot != null) {
            return selectedLot.bidFor(new Bid(person, amount));
        }
        return false;
    }

    public static void main(String[] args) {
        Auction auction = new Auction();

        Person person1 = new Person("BUDUNG");
        Person person2 = new Person("PAKDUNG");
        Person person3 = new Person("DUDUNG");

        auction.enterLot("Golden");
        auction.enterLot("Diamond");
        auction.enterLot("Silver");

        System.out.println("Items available for auction:");
        for (Lot lot : auction.lots) {
            System.out.println("Lot " + lot.getLotNumber() + ": " + lot.getDescription());
        }
        System.out.println();

        System.out.println("Bidding process:");

        if (auction.makeBid(1, person1, 200)) {
            System.out.println(person1.getName() + " successfully bid 200 dollars for Lot 1.");
        } else {
            System.out.println(person1.getName() + " failed to bid for Lot 1.");
        }

        if (auction.makeBid(1, person2, 300)) {
            System.out.println(person2.getName() + " successfully bid 300 dollars for Lot 1.");
        } else {
            System.out.println(person2.getName() + " failed to bid for Lot 1.");
        }

        if (auction.makeBid(1, person1, 100)) {
            System.out.println(person1.getName() + " successfully bid 100 dollars for Lot 1.");
        } else {
            System.out.println(person1.getName() + " failed to bid for Lot 1.");
        }

        if (auction.makeBid(2, person3, 400)) {
            System.out.println(person3.getName() + " successfully bid 400 dollars for Lot 2.");
        } else {
            System.out.println(person3.getName() + " failed to bid for Lot 2.");
        }

        if (auction.makeBid(2, person2, 500)) {
            System.out.println(person2.getName() + " successfully bid 500 dollars for Lot 2.");
        } else {
            System.out.println(person2.getName() + " failed to bid for Lot 2.");
        }

        if (auction.makeBid(3, person1, 600)) {
            System.out.println(person1.getName() + " successfully bid 600 dollars for Lot 3.");
        } else {
            System.out.println(person1.getName() + " failed to bid for Lot 3.");
        }

        if (auction.makeBid(3, person3, 700)) {
            System.out.println(person3.getName() + " successfully bid 700 dollars for Lot 3.");
        } else {
            System.out.println(person3.getName() + " failed to bid for Lot 3.");
        }

        System.out.println("\nFinal Auction Results:");
        for (Lot lot : auction.lots) {
            if (lot.getHighestBid() != null) {
                System.out.println("Lot " + lot.getLotNumber() + " (" + lot.getDescription() + "):");
                System.out.println("Highest Bid: " + lot.getHighestBid().getBidder().getName() +
                        " with amount of " + lot.getHighestBid().getAmount());
            } else {
                System.out.println("Lot " + lot.getLotNumber() + " (" + lot.getDescription() + "): No bids.");
            }
            System.out.println();
        }
    }
}
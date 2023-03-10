package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction testAuction = new Auction("testAuction");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");
        Auction buyoutAuction = new Auction("");
        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids
        ReserveAuction reserveAuction = new ReserveAuction("smelly old shoe", 800);

        List<Auction> auctionList = new ArrayList<Auction>();
        auctionList.add(generalAuction);
        auctionList.add(reserveAuction);
        auctionList.add(buyoutAuction);

        System.out.println("Polymorphism example looping over a list of Auctions and getting specific response for each auction type");
        for(Auction currentAuction : auctionList){
            System.out.println(currentAuction.getHighBid().getBidAmount() + " was the highest bidder with a bid of: " + currentAuction.getHighBid().getBidAmount());
        }
    }

}

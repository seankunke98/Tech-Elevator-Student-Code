package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction testAuction = new Auction("This is a stupid string!");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));

        for(Bid bid : generalAuction.getAllBids()){
            System.out.println(bid.getBidder());
            System.out.println(bid.getBidAmount());
        }

        System.out.println("The winner of the auction is: " + generalAuction.getHighBid().getBidder());

        ReserveAuction reserveAuction = new ReserveAuction("smelly old shoe", 80);
        reserveAuction.placeBid(new Bid("Mark", 2));
        reserveAuction.placeBid(new Bid("Nife", 10));
        reserveAuction.placeBid(new Bid("Nate", 81));
        System.out.println("The winner of the reserve auction is: " + reserveAuction.getHighBid().getBidder());

        BuyoutAuction buyoutAuction = new BuyoutAuction("Cat-ption genernator", 20);
        buyoutAuction.placeBid(new Bid("Kat", 18));
        buyoutAuction.placeBid(new Bid("James", 1000));
        buyoutAuction.placeBid(new Bid("Rachelle", 1000));
        System.out.println("The winner of the buyout auction is: " + buyoutAuction.getHighBid().getBidder() + " with a bid of: " + buyoutAuction.getHighBid().getBidAmount());

        List<Auction> auctionList = new ArrayList<Auction>();
        auctionList.add(generalAuction);
        auctionList.add(reserveAuction);
        auctionList.add(buyoutAuction);

        System.out.println("Polymorphism example looping over a list of Auctions and getting specific response from each auction type.");
        for(Auction currentAuction : auctionList){
            currentAuction.placeBid(new Bid("GenericBid", 100));
            System.out.println(currentAuction.getHighBid().getBidder() + " was the highest bidder with a bid of: " + currentAuction.getHighBid().getBidAmount());
        }
    }
}

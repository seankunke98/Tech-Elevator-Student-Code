package com.techelevator;

public class ReserveAuction extends Auction {

    private int reservePrice;

    //need to add constructor because ReserveAuction is-a auction and Auctions require a
    //a bid item when created
    public ReserveAuction(String itemForSale, int reservePrice){
        super(itemForSale);
        this.reservePrice = reservePrice;
    }



    /*
    This class overrides the default placeBid behavior of the parent class.
    If the offeredBid does not meet or exceed the reserve price,
    the bid is ignored.
     */
    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = false;
        if(offeredBid.getBidAmount() >= reservePrice){
            isCurrentWinningBid = super.placeBid(offeredBid); //invokes placeBid method on super class
        }
        return isCurrentWinningBid;
    }
}

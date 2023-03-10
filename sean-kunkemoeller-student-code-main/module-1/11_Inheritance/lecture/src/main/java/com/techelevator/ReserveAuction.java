package com.techelevator;


public class ReserveAuction extends Auction {
    private int reservePrice;
    //need to add constructor because ReserveAuction is-a auction class
    //a bid item when created
    public ReserveAuction(String itemForSale, int reservePrice){
        super(itemForSale);
        this.reservePrice = reservePrice;

    }
    @Override
    public boolean placeBid(Bid offeredBid){
        boolean isCurrentWinningBid = false;
        if (offeredBid.getBidAmount() >= reservePrice){
            isCurrentWinningBid = super.placeBid(offeredBid);
        }
        return isCurrentWinningBid;
    }
}

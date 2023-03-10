package com.techelevator;

public class BuyoutAuction extends Auction{
    {

    }
    private int buyoutPrice;
    public BuyoutAuction(String itemForSale, int buyoutPrice){
        super(itemForSale);
        this.buyoutPrice = buyoutPrice;
    }

    /*
    this class overrides the default placeBid behavior of the parent class. If the offeredBid meets or exceeds the pbuyoutPrice, the offeredBid is set to the buyout price and all future bids are ignored
     */
}

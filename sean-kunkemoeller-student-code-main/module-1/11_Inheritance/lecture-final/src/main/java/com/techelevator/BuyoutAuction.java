package com.techelevator;

public class BuyoutAuction extends Auction{

    private int buyoutPrice;
    private boolean isBuyoutMet;

    public BuyoutAuction(String itemForSale, int buyoutPrice){
        super(itemForSale);
        this.buyoutPrice = buyoutPrice;
    }

    /*
    This class overrides the default placeBid behavior of the parent class.
    If the offeredBid meets or exceeds the buyout price, the offeredBid is
    set to the buyout price and all future bids are ignored.

    * */

    @Override
    public boolean placeBid(Bid offeredBid){

        boolean isCurrentWinningBid = false;

        if(isBuyoutMet == true){
            return isCurrentWinningBid;
        }
        //find out if the offeredBid is greater than buyout price
        if(offeredBid.getBidAmount() >= buyoutPrice){
            //set offeredBid to the buyout price
            String bidder = offeredBid.getBidder();
            offeredBid = new Bid(bidder,buyoutPrice);
            //ignore all future bids
            isBuyoutMet = true;
        }
            isCurrentWinningBid = super.placeBid(offeredBid);

        return isCurrentWinningBid;
    }

}

/*The video game machines at your local arcade output coupons according to how well you play the game.
You can redeem 10 coupons for a candy bar or 3 coupons for a gumball.  You prefer candy bars to gumballs.
Write a program that defines a variable initially assigned to the number of coupons you win.
Next, the program should output how many candy bars and gumballs you can get
if you spend all of your coupons on candy bars first, and any remaining coupons on gumballs. */



public class Redeem {
    public static void main(String[] args) {
        int couponsWon = 177;
        int candyBarRedeemCost = 10;
        int gumballRedeemCost = 3;

        int totleCandyBarRedeemed = couponsWon / candyBarRedeemCost;
        int totleGumballRedeemed =  (couponsWon % candyBarRedeemCost) / gumballRedeemCost;
        int remainingToken =  (couponsWon % candyBarRedeemCost) % gumballRedeemCost;

        System.out.println("Total CandyBar Redeemed : " + totleCandyBarRedeemed);
        System.out.println("Total Gumball Redeemed : " + totleGumballRedeemed);
        System.out.println("Remaining Token : " + remainingToken);
    }  
}
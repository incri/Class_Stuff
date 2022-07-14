public class Account {
    private int openingBalance;
    private int currentBalance;
    private int creditLimit;

    // Static variable to store the total number of accounts
    public static int numOfAccounts = 0;

    /**
     * Constructor
     */
    public Account(int startAmount, int balance, int credit)  {       
        openingBalance = startAmount;
        currentBalance = balance;
        creditLimit = credit;
        numOfAccounts++;
    }

    /**
     * Set the balance
     */
    public void setBalance( int amount)  {
        currentBalance = amount;
    }

    /**
     * Get the balance
     */
    public int getBalance()   {
        return currentBalance;
    }

    /**
     * Set the credit limit
     */
    public void setCreditLimit(int amount) {
        creditLimit = amount;
    }

    /**
     * Get the credit limit
     */
    public int getCreditLimit()   {
        return creditLimit;
    }

    /**
     * Show the current balance and the credit limit
     */ 
    public void showData()     {
        System.out.println("balance = " + currentBalance + " credit = " + creditLimit);
    }
    
    
}

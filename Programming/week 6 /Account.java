public class Account {
    private int openingBalance;
    private int currentBalance;
    private int creditLimit;
    private String holderName;
    private String holderAddress;

    // Static variable to store the total number of accounts
    public static int numOfAccounts = 0;

    /**
     * Constructor
     */
    public Account(int startAmount, int balance, int credit, String Name, String Address)  {       
        openingBalance = startAmount;
        currentBalance = balance;
        creditLimit = credit;
        holderName = Name;
        holderAddress = Address;
        numOfAccounts++;
    }
    // Set the Account Holder's Name
    public void setaccHolderName(String name){
        holderName = name;
    }
    // Get the Account Holder's Name

    public String getaccHolderName(){
        return holderName;
    }
    // Set the Account Holder's Address

    public void setholderAddress(String address){
        holderAddress = address;
    }
    // Get the Account Holder's Address

    public String getholderAddress(){
        return holderAddress;
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
        System.out.println("Account Holder Name = " + " " + holderName);
        System.out.println("Account Holder Address = " + " " + holderAddress);

        System.out.println("balance = " + currentBalance + " credit = " + creditLimit);
    }
}

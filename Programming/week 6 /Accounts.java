
//importing Sccanner class form java.util package
import java.util.Scanner;
//Creating a class
public class Accounts {

    static int startAmount;
    static int balance;
    static int credit;
    //Main method is declared
    public static void main(String[] args){
        Scanner acc = new Scanner(System.in);
        System.out.println("Please enter the fullname of account holder");
        String name = acc.nextLine();
        System.out.println("Please enter the address of account holder");
        String address = acc.nextLine();
        acc.close();
        //instantiating Class Account as count 
       Account count = new Account(startAmount, balance, credit, name, address);
       count.getaccHolderName();
       count.getholderAddress();
       count.showData();
;
    }
    
}

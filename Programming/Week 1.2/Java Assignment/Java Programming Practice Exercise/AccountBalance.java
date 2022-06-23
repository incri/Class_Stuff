public class AccountBalance {
    public static void main(String[] args) {

        double percent = 0.05;
        int balance = 1000;
        
        double year1 = balance * percent + balance;
        double year2 = year1 * percent + balance;
        double year3 = year2 * percent + balance;

        System.out.println(year1 + year2 + year3);

    }
    
}
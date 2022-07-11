public class OddEven {
    public void oddEvenChecker(int number) {
        if (number % 2 == 0 )
            System.out.println(number + " is Even");
        else{
            System.out.println(number + " is Odd");
        }

    }
    public static void main(String[] args) {
        OddEven c = new OddEven();
        c.oddEvenChecker(17);
        
    }
}


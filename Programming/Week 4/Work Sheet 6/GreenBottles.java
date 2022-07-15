import java.util.Scanner;

public class GreenBottles{
    public void tenGreenBottles(){
        for (int i=10; i>0; i--){
            System.out.println(i+"green bottles standing on the wall,");
            System.out.println(i+"green bottles standing on the wall,");
            System.out.println("And if 1 green bottle should accidently fall,");
            if(i>1){
                System.out.println("There’ll be "+ (i-1) + " green bottles standing on the wall.\n\n");
            }
            else{
                System.out.println("There’ll be no green bottles standing on the wall.");
            }
        }
    }public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total number of green bottles: ");
        int n = scanner.nextInt();
        scanner.close();
        GreenBottles gb = new GreenBottles();
        gb.tenGreenBottles();
    }

}
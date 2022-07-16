//importing scanner pakage
import java.util.Scanner;

public class GreenBottles{
    //needed variables
    public static int x;
    public static int y;
    public void tenGreenBottles(){
        //for loop where loop run from 10 to 0
        for (int i=10; i>0; i--){
            //printing according to question
            System.out.println(i+"green bottles standing on the wall,");
            System.out.println(i+"green bottles standing on the wall,");
            System.out.println("And if 1 green bottle should accidently fall,");
            //if condition to differ print of last line according to question
            if(i>1){
                System.out.println("There’ll be "+ (i-1) + " green bottles standing on the wall.\n\n");
            }
            else{
                System.out.println("There’ll be no green bottles standing on the wall.");
            }
        }
    }
    public void xGreenBottles(){
        //method where we can give the starting point of the poem
        for (int i=x; i>0; i--){
            //the starting point is x that is input by the user
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
    }
    public void xyGreenBottles(){
        //method where we can give the starting point as well as the finish point of the poem
        for (int i=x; i>y; i--){
            //the starting point is x and the ending point is y that is input by the user
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
    }
    public static void main(String[] args) {
        //main function with scanner instantiation and message for user input
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter you X number: ");
        x = scan.nextInt();
        System.out.println("Enter you Y number: ");
        y = scan.nextInt();
        scan.close();
        //calling the xyGreenBottle function as it is enough output for now
        GreenBottles gb = new GreenBottles();
        gb.xyGreenBottles();
    }

}
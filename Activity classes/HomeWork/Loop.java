import java.util.Scanner;

public class Loop {
    public static int number;
    public void greater(){
        do { // providing the output if the condition is right
			System.out.println("Number is not Greater Than 10");
		}while (number > 10);//giving condition for the Do statement
    }
    public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        System.out.println("Enter your number");
        number = scan.nextInt();
        scan.close();
        Loop l = new Loop();
        l.greater();

	}
}

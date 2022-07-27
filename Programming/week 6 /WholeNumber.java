import java.util.Scanner;
public class WholeNumber{ 
    static int number;
    static int sum;
    public void error(){
        if(number<0){
            System.out.println("INVALID !!!!"+ " " + "Please enter the positive numbers");
        }
        else if(number == 0){
            System.out.println(0);
        }
        else if(number == 1){
            System.out.println(1);
        }
        else {
            for(int no = 0; no <= number; no++){
                sum = sum + no;
            }
        System.out.println("The sum of the given numbers is"+ " "+ sum);
        }
    }
    public static void main(String[]args){
        Scanner loop = new Scanner(System.in);
        System.out.println("Please enter a wholenumber");
        number = loop.nextInt();
        loop.close();
        WholeNumber whole = new WholeNumber();
        whole.error();

    }
    
    
}


import java.util.Scanner;//importing scanner pakage

public class Sum {//needed variable
    public static int n;
    public static int sum;

    public Sum(){//constructor
        sum=0;
    }

    public void addition(){//function to calculate the required result
        if (n<0){//first condition where input value is negative
            System.out.println("Invlid data, Number can't be negative");
        }
        else if (n==0){//secounf condition where input value is 0
            System.out.println("sum = 0");
        }
        else if (n==1){//third condition where input value is 1
            System.out.println("sum = 1");
        }
        else{//fourth condition where input value is valid above 1
            for (int i = 0; i <= n; i++){//loop that run 0 to given input number
                sum = sum + i;//every looped number upto n is added 
            }
            System.out.println("addition upto "+ n + " = "+ sum);
        }
            
        
    }
    public static void main(String[] args) {
        //initializing Scanner and calling method
        Scanner scan = new Scanner(System.in);
        System.out.println("enter your data : ");
        n = scan.nextInt();
        scan.close();
        Sum s = new Sum();
        s.addition();
    }
}

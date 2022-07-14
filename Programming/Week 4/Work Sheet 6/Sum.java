import java.util.Scanner;

public class Sum {
    public static int n;
    public static int sum;

    public Sum(){
        sum=0;
    }

    public void addition(){
        if (n<0){
            System.out.println("Invlid data, Number can't be negative");
        }
        else if (n==0){
            System.out.println("sum = 0");
        }
        else if (n==1){
            System.out.println("sum = 1");
        }
        else{
            for (int i = 0; i <= n; i++){
                sum = sum + i;
            }
            System.out.println("addition upto "+ n + " = "+ sum);
        }
            
        
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter your data : ");
        n = scan.nextInt();
        scan.close();
        Sum s = new Sum();
        s.addition();
    }
}

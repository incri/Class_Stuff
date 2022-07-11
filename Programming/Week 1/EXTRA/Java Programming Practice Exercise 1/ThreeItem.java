import java.util.Scanner;
public class ThreeItem {
    public static void main(String[] args) {
        try (Scanner data = new Scanner(System.in)) {


            System.out.print("Catagories only string : ");
            String catagories = data.next();

            System.out.print("Data 1 : ");
            String data1 = data.next();

            System.out.print("Data 2 : ");
            String data2 = data.next();

            System.out.print("Data 3 : ");
            String data3 = data.next();

            System.out.println("My three best" + " " + catagories);
            System.out.println(data1);
            System.out.println(data2);
            System.out.println(data3);
        }
    }
}

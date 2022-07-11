/** Baibhav Paudel and 2022/06/18
* Program to print 4 marks , sum of there marks and there average marks
*/


public class Average {
    public static void main(String[] args){
        int mark1 = 45;
        int mark2 = 56;
        int mark3 = 34;
        int mark4 = 89;

        int sum = mark1 + mark2 + mark3 + mark4;
        int average = (mark1 + mark2 + mark3 + mark4)/4;

        System.out.println(mark1 + " " + mark2 + " " + mark3 + " " + mark4);
        System.out.println("Sum of marks is " + sum);
        System.out.println("Average of marks is " + average);


    }
    
}
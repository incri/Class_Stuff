/*
* Please fill or complete the comments of this class so that
* they reflect what their subsequent line(s) are doing
*/
public class SecretClass {
    // Its initiating and defining a constant having data type double named PI.
    static final double PI = 3.141592653589793;
    /*
    * The purpose of the main() method is to be a program execution start point.
    */
    public static void main(String args[]) {
        /*Calling System pakage which contain out 
        object with println Method (Printing Java is cool!).*/
        System.out.println("Java is cool!");
        // (Printing 5 that is 2+3).
        System.out.println(2 + 3);
        // (Printing 24 that is "2"String + (2+2=4)String).
        System.out.println("2" + (2 + 2));
        /*
        * The next two lines print PI = 3.141592653589793
        */
        String str = "PI = ";
        System.out.println(str + PI);
        // defining piSquare with 3.141592653589793 * 3.141592653589793
        double piSquare = PI * PI;
        // print The square of PI is 3.141592653589793 * 3.141592653589793
        System.out.println("The square of PI is " + piSquare);
        // defining fakePI with 3.141592653589793 / 2
        double fakePI = piSquare/2;
    
        // checking with true or false if PI = fakePI or not
        boolean checkPI = (PI == fakePI);
        // printing PI and the Fake PI are equal. This statement is False.
        System.out.println("PI and the fake PI are equal. " +
        " This statement is " + checkPI + ".");
        /*
        * The next 3 lines printing PI and the Fake PI are equal. Now This statement is True.
        */
        fakePI = 3.141592653589793;
        checkPI = (PI == fakePI);
        System.out.println("PI and the fake PI are equal. " +
        " Now this statement is " + checkPI + ".");
         // printing if "Hussain" == "Fred" and that is false.
        System.out.println("Hussain".equals("Fred"));
    }
}
   
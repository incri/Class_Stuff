/* The following program will compile and run, but it uses poor programming style.
Modify the program so that it uses the recommended spelling conventions,
 constant naming conventions, and formatting style.

public class messy {
	public static void main(String[] args)
	{
		double TIME; double PACE;
		System.out.println("This program calculates your pace given a time and distance traveled.");
		TIME = 35.5;
		PACE = TIME / distance;
		System.out.println("Your pace is " + PACE + " miles per hour.");
	}
	public static final double distance = 6.21;
} */


public class Messy {

    public static final float DISTANCE = 6.21f;


    public static void main(String[] args){

        System.out.println("This program calculates your pace given a time and distance traveled.");
        float time = 35.5f; /* 35 minutes and 30 seconds */
        float pace = time / DISTANCE;
        System.out.println("Your pace is " + pace + " miles per hour.");
    }
}

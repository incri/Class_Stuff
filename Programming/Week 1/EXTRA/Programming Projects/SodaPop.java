/* A government research lab has concluded that an artificial sweetener commonly used in diet 
soda pop will cause death in laboratory mice.  A friend of yours is desperate to lose weight 
but cannot give up soda pop.  Your friend wants to know how much diet soda pop it is possible 
to drink without dying as a result.  

Write a program to supply the answer. The program has no input but does have defined constants
for the following items: the amount of artificial sweetener needed to kill a mouse, the weight
of the mouse, the starting weight of the dieter, and the desired weight of the dieter. 
To ensure the safety of your friend, be sure the program uses the weight at which the dieter
will stop dieting, rather than the dieter’s current weight, to calculate how much soda pop 
the dieter can safely drink. You may use any reasonable values for these defined constants.
Assume that diet soda contains 1/10th of 1% artificial sweetener. Use another named constant
for this fraction.

You may want to express the percent as the double value 0.001. (If your program turns out 
not to use a defined constant, you may remove that defined constant from your program.) */


public class SodaPop {
    public static void main(String[] args) {

        final double SWEETENER_LEVEL = 0.001; //in percent
        final double SODA_WEIGHT = 200; // in gram
        double SweetenerInSoda = SODA_WEIGHT * SWEETENER_LEVEL;// in gram


        final double SWEETENER_TO_KILL_MOUSE = 8;// in gram
        final double MOUSE_WEIGHT = 800;// in gram


        final int CURRENT_WEIGHT = 145000;// in gram
        //final int DESIRED_WEIGHT = 75000;// in gram

        final double LIMIT_SAFE_POINT = 0.5;//in percent

        double mouseSweetenerConsumeLimit = (SWEETENER_TO_KILL_MOUSE/MOUSE_WEIGHT)*100; //in percent
        double sweetenerSafeConsumeLimit = mouseSweetenerConsumeLimit - LIMIT_SAFE_POINT;//in percent

        double currentWeightSafeConsumeLimit = CURRENT_WEIGHT * sweetenerSafeConsumeLimit/100;//in gram
        double sodaConsumeLimit = currentWeightSafeConsumeLimit*SweetenerInSoda;//in gram

         System.out.println(sodaConsumeLimit);
    }
}

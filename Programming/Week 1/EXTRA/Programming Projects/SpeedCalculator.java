/* Bicyclists can calculate their speed if the gear size and cadence is known.  
Gear size refers to the effective diameter of the wheel.  Gear size multiplied by pi (3.14) 
gives the distance travelled with one turn of the pedals. Cadence refers to the number of pedal
 revolutions per minute (rpm). The speed in miles per hour is calculated by the following:

This is a program that calculates the speed for a gear size of 100 inches and a cadence of 
90 rpm.  This would be considered a high cadence and a maximum gear size for a typical bicycle. 
1/12 will result in 0, because both 1 and 12 are integers, and when the
 */


public class SpeedCalculator {
    public static void main(String[] args) {

        final double PI = 22 / 7;
        double cadance = 90;

        double oneInch = 0.0254; //in meter
        double gearSize = 100 * oneInch;

        double wheelSize = gearSize * PI;
        int hour = 60;

        double totalDistanceCovered = wheelSize * cadance * hour;

        double mile = 1609.34;
        totalDistanceCovered = totalDistanceCovered / mile; 

        System.out.println("The max speed bycicle travel is : " + totalDistanceCovered + " mph ");
    }
}

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

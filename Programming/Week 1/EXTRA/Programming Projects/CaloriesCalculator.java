/*One way to measure the amount of energy that is expended during exercise is to use 
metabolic equivalents (MET).  Here are some METS for various activities:

Running 6 MPH: 10 METS
Basketball: 8 METS
Sleeping: 1 MET

The number of calories burned per minute may be estimated using the following formula:

CaloriesjMinute = 0.0175 * MET * Weight in kilograms

Write a program that calculates and outputs the total number of calories 
burned for a 150-pound person who runs 6 MPH for 30 minutes, plays basketball for 
30 minutes, and then sleeps for 6 hours.  One kilogram is equal to 2.2 pounds. */



public class CaloriesCalculator {
    public static int calories() {

        int runningMET = 10;
        int basketballMET = 8;
        int sleepingMET = 1;

        final int minute = 60;

        int runTime = minute / 2;
        int basketballTime = minute / 30;
        int sleepTime = minute * 6;

        int IntialWeightInKg = 150;
        final double weightInPound = IntialWeightInKg * 2.2;

        double caloriesWhileRunning = ((0.0175*runningMET*weightInPound)*runTime);
        double caloriesWhileBasketball = ((0.0175*basketballMET*weightInPound)*basketballTime);
        double caloriesWhileSleep = ((0.0175*sleepingMET*weightInPound)*sleepTime);

        return ((int)caloriesWhileRunning + (int)caloriesWhileBasketball + (int)caloriesWhileSleep);
    }
    public static void main(String[] args) {
        
        System.out.println("Total Calories Burned in Pound  : " + CaloriesCalculator.calories());
    }
}
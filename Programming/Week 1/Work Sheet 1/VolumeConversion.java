/** Baibhav Paudel and 2022/06/18
* Program to print Conversion of gallons into liters
*/


public class VolumeConversion {
    public static void main(String[] args) {
        final double GALLON = 4.546;
        int gallons = 14;
        double litres;
        String word1 = " The number of liters in ";
        String word2 = " gallons is ";

        litres = gallons*GALLON;
        System.out.println(word1 + gallons + word2 + litres );
    }
}

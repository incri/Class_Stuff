public class DistanceConverter {
    public void convertInSquareKilometer(int inSquareMeter) {
        double Squarekilometer = 1000000;
        double inSquareKiloMeter = inSquareMeter/Squarekilometer;
        System.out.println("In SquareKilometer = " + inSquareKiloMeter);

    }
    public static void main(String[] args) {
        DistanceConverter c = new  DistanceConverter();
        c.convertInSquareKilometer(22);

    }
}

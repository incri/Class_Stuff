public class Convert {
    public void convertInMile(int inKilometer) {
        double mile = 0.621;
        double kilometerInMile = inKilometer*mile;
        System.out.println(" in Miles = " + kilometerInMile);

    }
    public void convertInKilometer(int inMiles) {
        double kilometer = 1.609;
        double mileInKiloMeter = inMiles*kilometer;
        System.out.println("in Kilometer = " + mileInKiloMeter);

    }
    public static void main(String[] args) {
        Convert c = new Convert();
        c.convertInMile(23);
        c.convertInKilometer(17);

    }
}
public class IdealBodyWeight {
    public static void main(String[] args) {
        int allowedWeight = 110;

        int additionalWeightPerInch = 5;

        int allowedWightHeight = 5;
        int takenHeightInFeet = 7;
        int takenHeightInInch = 2;

        int inch = 12;

        int additionalInch = ((takenHeightInFeet-allowedWightHeight)*inch)+takenHeightInInch;

        int idealWeight = allowedWeight + (additionalInch*additionalWeightPerInch);

        System.out.println(idealWeight);
    }
}

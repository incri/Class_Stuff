public class SodaPop {
    public static void main(String[] args) {

        final double SWEETENER_LEVEL = 0.001; //in percent
        final double SODA_WEIGHT = 200; // in gram
        final double SweetenerInSoda = SODA_WEIGHT * SWEETENER_LEVEL;// in gram


        final double SWEETENER_TO_KILL_MOUSE = 8;// in gram
        final double MOUSE_WEIGHT = 800;// in gram


        final int CURRENT_WEIGHT = 145000;// in gram
        final int DESIRED_WEIGHT = 75000;// in gram

        final double LIMIT_SAFE_POINT = 0.5;//in percent

        double mouseSweetenerConsumeLimit = (SWEETENER_TO_KILL_MOUSE/MOUSE_WEIGHT)*100; //in percent
        double sweetenerSafeConsumeLimit = mouseSweetenerConsumeLimit - LIMIT_SAFE_POINT;//in percent

        double currentWeightSafeConsumeLimit = CURRENT_WEIGHT * sweetenerSafeConsumeLimit/100;//in gram
        double sodaConsumeLimit = currentWeightSafeConsumeLimit*SweetenerInSoda;//in gram

         System.out.println(sodaConsumeLimit);
    }
}

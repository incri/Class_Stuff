public class Messy {

    public static final float DISTANCE = 6.21f;


    public static void main(String[] args){

        System.out.println("This program calculates your pace given a time and distance traveled.");
        float time = 35.5f; /* 35 minutes and 30 seconds */
        float pace = time / DISTANCE;
        System.out.println("Your pace is " + pace + " miles per hour.");
    }
}

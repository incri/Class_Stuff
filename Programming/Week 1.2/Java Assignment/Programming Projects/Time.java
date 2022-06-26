/* Write a program that outputs the number of hours, minutes, and seconds that 
corresponds to 50,391 total seconds.  The output should be 13 hours, 59 minutes, and 51 seconds. 
Test your program with a different number of total seconds to ensure that it works for other cases. */


public class Time {
    public static void main(String[] args) {
        
        int givenSecound = 50391;
        final int MINUTE = 60;
        int hour = givenSecound / (MINUTE*MINUTE);
        int minute = (givenSecound % (MINUTE*MINUTE)/MINUTE);
        int secound = ((givenSecound % (MINUTE*MINUTE))%MINUTE);
        System.out.println("In "+ givenSecound + " Secound " + " There are " + hour + " Hours, " + minute + " Minute and " + secound + " Secound .");

    }
}

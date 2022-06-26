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

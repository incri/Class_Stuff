public class MiniCalc {

    public int add (int a, int b){
        return a + b;
    }
    public int multiply (int a, int b){
        return a * b;
    }
    public int substract (int a, int b){
        return a - b;
    }
    public float division (float a, float b){
        return a / b;
    }
    public static void main (String[] args){
        System.out.println("MiniCalc");
        MiniCalc mc = new MiniCalc();
        int c = mc.add(1,2);
        int d = mc.multiply(3 ,4);
        int e = mc.substract(6, 7);
        double f = mc.division(10, 7);
        System.out.println(c + " " + d + " " + e + " " + f);
    }
}

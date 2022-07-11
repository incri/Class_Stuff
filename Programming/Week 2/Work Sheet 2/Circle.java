public class Circle {

    public final static double PI = 3.142857;

    public void circumference(int radius) {

        double circumferenceValue = 2*PI*radius;
        System.out.println("Circumference = " + circumferenceValue);

    }
    public void area(int radius) {

        double areaValue = PI*(Math.pow(radius,2));
        System.out.println("Area = " + areaValue);

    }
    public void volume(int radius) {

        double volumeValue = (4*PI*(Math.pow(radius,3)))/3;
        System.out.println("Volume = " + volumeValue);

    }
    
    public static void main(String[] args) {
        Circle c = new Circle();
        c.circumference(22);
        c.area(22);
        c.volume(22);

    }
}

public class Calculator{
    public static void main(String[] args) {
        Mathematic m = new Mathematic();
        try{
            m.setOp("/");
            m.setOp(5);
            m.setOp2(0);
            System.out.println(m.calculate());
        }
        catch (ArithmeticException e) {
            System.out.println("You must have divided by 0");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
 
        }
    }
    }
    
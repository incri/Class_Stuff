
public class Mathematic {
    public int calculate(String Op,int Op1, int Op2) throws MyCustomException{
        switch(Op){
            case "+":
                return Op1+Op2;
            case "-":
                return Op1+Op2;
            case "*":
                return Op1*Op2;
            case "/":
                try {
                    return Op1/Op2;
                } catch (ArithmeticException e){
                    throw new MyCustomException();
                }
            default:
                return 0;
        }
    }

    public void setOp(int i) {
    }

    public void setOp2(int i) {
    }

    public void setOp(String string) {
    }

    public char[] calculate() {
        return null;
    }
}
   

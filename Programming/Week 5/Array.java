public class Array{
    int [] number = {8, 4, 5, 21, 7, 9, 18, 2, 100};
    double [] number2 = {8, 4, 5, 21, 7, 9, 18, 2, 100};
    private void print (){
        System.out.println("Number of array is : "+number.length);
        System.out.println("First number of array is : "+ number[0]);
        System.out.println("First number of array is : "+ number[8]);
        System.out.println("x[x.length-1] is :"+ number[number.length-1]);
    }
    private void looping(){
        for (int i=0;i<number.length;i++){
            System.out.println("All number in Array is : "+number[i]);
        }
        System.out.println("For Loop");
        for (int i=0;i<number.length;i++){
            System.out.println("number"+i+" :"+number[i]);
        }
        System.out.println("Reverse Loop");
        for (int i=number.length-1;i>0;i--){
            System.out.println("number"+i+" :"+number[i]);
        }
        System.out.println("Enhanced Loop :");
        for(int numbers: number) {
            System.out.println(numbers);
          }
          System.out.println("Enhanced Loop double :");
        double sum = 0;
        for(double numbers: number2) {
             sum += numbers;
        }
        System.out.println("Sum is :"+sum);
        System.out.println("For loop double");
        for(int i=0;i<number.length;i++) {
            sum += i;
        }
        System.out.println("Sum is :"+sum);
        double min = number2[0];
        for (int i = 0; i<number.length;i++){
            if (number[0]>number[i]){
                min = number[i];
            }
        }
        double mini = number2[0];
        int index = 0;
        for (int i = 0; i<number.length;i++){
            if (number[0]>number[i]){
                mini = number[i];
                index = i;
            }
        }
        System.out.println("min value is :"+min+" index number2 : "+index);
    }
    private void rotate(int[]x, int n){
        
    }
    public static void main(String[] args) {
        Array a= new Array();
        a.print();
        a.looping();
        
    }
}
public class GreenBottles {
    public void tenGreenBottles(){
        for(int n=10; n>0; n--){
            System.out.println(n + " " + "green bottles standing on the wall,");
            System.out.println(n + " " + "green bottles standing on the wall,");
            System.out.println("And if 1 green bottle should accidently fall,");
            if(n==1){
                System.out.println("There’ll be no green bottles standing on the wall,\n\n");
            }
            else if(n>1){
                System.out.println("There’ll be "+ (n-1) + " green bottles standing on the wall,\n\n");
            }
        }
    }
    public static void main(String[] args){
        GreenBottles bottle = new GreenBottles();
        bottle.tenGreenBottles();
    }
}

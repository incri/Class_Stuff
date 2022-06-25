public class PigLatin {
    public static void main(String[] args) {
        String firstName = "baibhav";
        String lastName = "paudel";

        String firstNamePig = firstName.substring(1) + firstName.substring(0,1) + "ay" ;
        firstNamePig = firstNamePig.substring(0, 1).toUpperCase() + firstNamePig.substring(1);

        String lastNamePig = lastName.substring(1) + lastName.substring(0,1) + "ay" ;
        lastNamePig = lastNamePig.substring(0, 1).toUpperCase() + lastNamePig.substring(1);

        System.out.println("Pig Latin of " + firstName + " " + lastName + " is " + firstNamePig + " " + lastNamePig);
    }
}

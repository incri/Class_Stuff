/* Write a program that starts with the string variable first set to your first name and the string
 variable last set to your last name.  Both names should be all lowercase.
Your program should then create a new string that contains your full name in pig latin with the f
irst letter capitalized for the first and last name.  Use only the pig latin rule of moving the first 
letter to the end of the word and adding “ay.” Output the pig latin name to the screen.  
Use the substring and toUpperCase methods to construct the new name.

For example, given
first = "walt";
last = "savitch";
the program should create a new string with the text “Altway Avitchsay” and print it. */


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

//importing Scanner class
import java.util.Scanner;

/* 
 * declaring class as Student
*/
class Student{


    // declaring variables
    int id;
    String name;
    String level;

    //declaring object for scanner
    Scanner s;

    //constructor is declared
    public Student(String name, int id, String level){

        //assigning the value of local vaariable to global variable
        this.id = id;
        this.level = level;
        this.name = name;
        this.initialise();
    }

    //declaring method
    public void initialise(){

        //assigning value to object in scanner
        s = new Scanner(System.in);
    }

    //method getname
    public String getName(){

        //returns the value in the name to the getname method
        return name;
    }

    //method getlevel
    public String getLevel(){

        //returns the value in the level to the getlevel method
        return level;
    }

    //method getid
    public int getID(){

        //returns the value in the id to the getid method
        return id;
    }

    //method marks is declared
    public double marks(){

        System.out.println("Enter the marks of math subject : ");
        double m1 = s.nextDouble();
        System.out.println("Enter the marks of science subjects : ");
        double m2 = s.nextDouble();
        System.out.println("Enter the marks of social subjects : ");
        double m3 = s.nextDouble();
        System.out.println("Enter the marks of english subjects : ");
        double m4 = s.nextDouble();
        System.out.println("Enter the marks of nepali subjects : ");
        double m5 = s.nextDouble();
        s.close();

        //mathematical calculation
        double avg = (m1 + m2 + m3 + m4 + m5) / 5;

        //returns value of avg to marks method
        return avg;
    }

    //main method is declared
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter student name : ");
        String name = s.nextLine();
        System.out.println("Enter student level : ");
        String level = s.nextLine();
        System.out.println("Enter student id : ");
        int id = s.nextInt();

        //callling the student constructor
        Student stf = new Student(name, id, level);

        //printing the obtained results
        System.out.println(stf.getName() + " studying in " + stf.getLevel() + " with id no. " + stf.getID() + " got the average marks of " + stf.marks());

    }
}
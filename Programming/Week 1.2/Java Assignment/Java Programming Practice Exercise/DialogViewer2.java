import javax.swing.JOptionPane;

public class DialogViewer2{
	public static void main(String[] args){
	    String name = JOptionPane.showInputDialog("What is your name?");
        JOptionPane.showMessageDialog(null, "Hello," + " " + name + " !");

	    System.out.println(name);
    }   
}
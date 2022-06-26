public class TextChanger {

	public static final String HATE_STRING = "I hate the way you hate others.";
	public static void main(String[] args)
	{
		String loveString = HATE_STRING.replaceFirst("hate", "love");
		
		System.out.println("The line of hate to be changed is:");
		System.out.println(HATE_STRING);		
		
		System.out.println("I that hate line to read:");
		System.out.println(loveString);
	}
}
import java.util.*; 
public class EightBall {
    public static void main (String[] args) {
        if (args.length > 0) System.out.println(args[0]+" "+Arrays.asList("Yes", "No", "Maybe", "Infinite Possibilities").get((int)(Math.random()*4)));
    }
}
import java.util.*;
import java.io.*;

/**
 * Write a description of class Interface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class main
{
    private static Scanner scanner = new Scanner(System.in);
    private static String selection;
    
    public main() {}
    
    public static void main(String[] args)
    {
        startQuiz();
    }
    
    public static void startQuiz()
    {
        System.out.println("Choose a quiz.\nA. Croatia\nB. League of Legends\nC. Geography\n");
     
        while (true) 
        {
            String selection = scanner.nextLine();
            
            if(selection.equals("A"))
            {
                croatia.startQuiz();
                break;
            }
            if(selection.equals("B"))
            {
                leagueOfLegends.startQuiz();
                break;
            }
            if(selection.equals("C"))
            {
                geography.startQuiz();
                break;
            }
        
            System.out.println("Please type A, B or C.");
        }
    }
}

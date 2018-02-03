import java.util.*;

public class main
{
    public static int round = -1;
    public static int score = 0;
    public static float percent;
    public static int quiz;
    public static String name;
    public static ArrayList<String> questionList = new ArrayList<String>();
    public static ArrayList<String> questionAnswers = new ArrayList<String>();
    public static ArrayList<Integer> questionShown = new ArrayList<Integer>();
    
    public main() {}
    
    public static void main(String[] args)
    {   
        menu.start();
    }
    
    public static void quit()
    {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Quitting...");
    }
}
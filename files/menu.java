import java.util.*;

public class menu
{
    private static Scanner input = new Scanner(System.in);
    private static String selection;
    
    public menu() {}
    
    public static void main(String[] args)
    {   
        start();
    }
    
    public static void start()
    {
        if (main.round == -1)
        {
            main.round = main.round + 1;
        }
        else
        {
            main.questionList.clear();
            main.questionAnswers.clear();
            main.questionShown.clear();
            main.round = 0;
            main.score = 0;
        }
        
        System.out.println("--------------------------------------------------------------");
        System.out.println("MENU\nA. Quizes\nS. Highscores \nD. Quit\n");
     
        while (true) 
        {
            String selection = input.nextLine();
            selection = selection.toLowerCase();
            
            if(selection.equals("a"))
            {
                quizes();
                break;
            }
            else if(selection.equals("s"))
            {
                main.quit();
                break;
            }
            else if(selection.equals("d"))
            {
                main.quit();
                break;
            }
            else
            {
                System.out.println("Valid inputs: A, S and D.\n");
            }
        }
    }
    
    public static void quizes()
    {
        System.out.println("--------------------------------------------------------------");
        System.out.println("MENU - QUIZES\nA. Croatia\nS. League of Legends\nD. Geography\nF. Back\n");
     
        while (true) 
        {
            String selection = input.nextLine();
            selection = selection.toLowerCase();
            
            if(selection.equals("a"))
            {
                quizes.a();
                break;
            }
            else if(selection.equals("s"))
            {
                quizes.b();
                break;
            }
            else if(selection.equals("d"))
            {
                quizes.c();
                break;
            }
            else if(selection.equals("f"))
            {
                start();
                break;
            }
            else
            {
                System.out.println("Valid inputs: A, S, D and F.\n");
            }
        }
    }
}

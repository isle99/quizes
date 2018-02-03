import java.util.*;

public class Menu
{
    private static Scanner input = new Scanner(System.in);
    private static String selection;
    
    public Menu()
    {
        
    }
    
    public static void start()
    {
        if (Game.round == -1)
        {
            Game.round = Game.round + 1;
        }
        else
        {
            Quizes.questionList.clear();
            Quizes.questionAnswers.clear();
            Quizes.questionShown.clear();
            Game.round = 0;
            Game.score = 0;
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
                Main.quit();
                break;
            }
            else if(selection.equals("d"))
            {
                Main.quit();
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
                Quizes.a();
                break;
            }
            else if(selection.equals("s"))
            {
                Quizes.b();
                break;
            }
            else if(selection.equals("d"))
            {
                Quizes.c();
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

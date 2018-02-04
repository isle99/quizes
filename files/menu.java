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
        String[] inputsArray = new String[] {"a","s","d","f","g","h","j","k"};
        Main.inputs.addAll(Arrays.asList(inputsArray));
        
        if (Game.round == -2)
        {
            Game.round = Game.round + 1;
        }
        else
        {
            Quizes.questionAnswer0.clear();
            Quizes.questionAnswer1.clear();
            Quizes.questionAnswer2.clear();
            Quizes.questionAnswer3.clear();
            Quizes.questionAnswer4.clear();
            Quizes.questionList.clear();
            Quizes.questionCorrectAnswers.clear();
            Quizes.questionShown.clear();
            Game.round = -1;
            Game.score = 0;
        }
        
        System.out.println("--------------------------------------------------------------");
        System.out.println("MENU\nQ. Quizes\nW. Highscores \nE. Quit\n");
     
        while (true) 
        {
            String selection = input.nextLine();
            selection = selection.toLowerCase();
            
            if(selection.equals("q"))
            {
                quizes();
                break;
            }
            else if(selection.equals("w"))
            {
                Main.quit();
                break;
            }
            else if(selection.equals("e"))
            {
                Main.quit();
                break;
            }
            else
            {
                System.out.println("Valid inputs: Q, W and E.\n");
            }
        }
    }
    
    public static void quizes()
    {
        System.out.println("--------------------------------------------------------------");
        System.out.println("MENU - QUIZES\nQ. Croatia\nW. League of Legends\nE. Geography\nR. Back\n");
     
        while (true) 
        {
            String selection = input.nextLine();
            selection = selection.toLowerCase();
            
            if(selection.equals("q"))
            {
                Quizes.quiz = 0;
                Quizes.quiz0();
                Game.start();
                break;
            }
            else if(selection.equals("w"))
            {
                Quizes.quiz = 1;
                Quizes.quiz1();
                Game.start();
                break;
            }
            else if(selection.equals("e"))
            {
                Quizes.quiz = 2;
                Quizes.quiz2();
                Game.start();
                break;
            }
            else if(selection.equals("r"))
            {
                start();
                break;
            }
            else
            {
                System.out.println("Valid inputs: Q, W, E and R.\n");
            }
        }
    }
}

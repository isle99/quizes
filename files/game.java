import java.util.*;
import java.io.*;

public class Game
{       
    public static int round = -1;
    public static int score = 0;
    public static float percent;
    public static String name;
    
    private static Scanner input = new Scanner(System.in);
    private static String selection;
    private static Random randomizer = new Random();
    
    public Game ()
    {
        
    }
    
    public static void start()
    {
        int choice = randomizer.nextInt(Quizes.questionAnswers.size());
        
        if (round == 0)
        {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Enter your name:\n");
            name = input.nextLine();
        }
        
        while (round < 5)
        {
            boolean i = Quizes.questionShown.contains(choice);
            
            while(i == true)
            {
                choice = randomizer.nextInt(Quizes.questionAnswers.size());
                i = Quizes.questionShown.contains(choice);
            }
            
            Quizes.questionShown.add(choice);
            percent = (float) score / round * 100;
            
            System.out.println("--------------------------------------------------------------");
            System.out.println("F. Menu\n");
            if (round == 0)
            {
                System.out.println("Correct answers: " + score + " / " + round + "\nPercent: 0.0%\n");
            }
            else
            {
                System.out.println("Correct answers: " + score + " / " + round + "\nPercent: " + percent + "%\n");
            }
            
            System.out.println(Quizes.questionList.get(choice));
            
            while (true) 
            {
                String selection = input.nextLine();
                selection = selection.toLowerCase();
                
                if(selection.equals("a"))
                {
                    if (selection.equals(Quizes.questionAnswers.get(choice)))
                    {
                        System.out.println("Correct!");
                        score = score + 1;
                    }
                    else
                    {
                        System.out.println("Incorrect, the correct answer was " + Quizes.questionAnswers.get(choice).toUpperCase() + ".");
                    }
                    break;
                }
                else if(selection.equals("s"))
                {
                    if (selection.equals(Quizes.questionAnswers.get(choice)))
                    {
                        System.out.println("Correct!");
                        score = score + 1;
                    }
                    else
                    {
                        System.out.println("Incorrect, the correct answer was " + Quizes.questionAnswers.get(choice).toUpperCase() + ".");
                    }
                    break;
                }
                else if(selection.equals("d"))
                {
                    if (selection.equals(Quizes.questionAnswers.get(choice)))
                    {
                        System.out.println("Correct!");
                        score = score + 1;
                    }
                    else
                    {
                        System.out.println("Incorrect, the correct answer was " + Quizes.questionAnswers.get(choice).toUpperCase() + ".");
                    }
                    break;
                }
                else if(selection.equals("f"))
                {
                    pause();
                    return;
                }
                else
                {
                    System.out.println("Valid inputs: A, S, D and F.\n");
                }
            }
              
            round++;
        }

        percent = (float) score / round * 100;
        System.out.println("--------------------------------------------------------------");
        System.out.println("Name: \n" + name + "\n");
        System.out.println("Final score: \n" + score + " out of " + round + ".\n");
        System.out.println("Final percentage: \n" + percent + "%\n");
        System.out.println("A. Main Menu\nS. Quit\n");
        
        
        while (true) 
        {
            String selection = input.nextLine();
            selection = selection.toLowerCase();
            
            if(selection.equals("a"))
            {
                Menu.start();
                break;
            }
            else if(selection.equals("s"))
            {
                Main.quit();
                break;
            }
            else
            {
                System.out.println("Valid inputs: A and S.\n");
            }
        }
    }
    
    public static void pause()
    {
        System.out.println("--------------------------------------------------------------");
        System.out.println("PAUSE\nA. Back\nS. Menu\nD. Quit\n");
     
        while (true) 
        {
            String selection = input.nextLine();
            selection = selection.toLowerCase();
            
            if(selection.equals("a"))
            {
                start();
                break;
            }
            else if(selection.equals("s"))
            {
                Menu.start();
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
}

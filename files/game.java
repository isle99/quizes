import java.util.*;
import java.io.*;

public class game
{   
    private static Scanner input = new Scanner(System.in);
    private static String selection;
    private static Random randomizer = new Random();
    
    public game () {}
    
    public static void start()
    {
        int choice = randomizer.nextInt(main.questionAnswers.size());
        
        if (main.round == 0)
        {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Enter your name:\n");
            main.name = input.nextLine();
        }
        
        while (main.round < 5)
        {
            boolean i = main.questionShown.contains(choice);
            
            while(i == true)
            {
                choice = randomizer.nextInt(main.questionAnswers.size());
                i = main.questionShown.contains(choice);
            }
            
            main.questionShown.add(choice);
            main.percent = (float) main.score / main.round * 100;
            
            System.out.println("--------------------------------------------------------------");
            System.out.println("F. Menu\n");
            if (main.round == 0)
            {
                System.out.println("Correct answers: " + main.score + " / " + main.round + "\nPercent: 0.0%\n");
            }
            else
            {
                System.out.println("Correct answers: " + main.score + " / " + main.round + "\nPercent: " + main.percent + "%\n");
            }
            
            System.out.println(main.questionList.get(choice));
            
            while (true) 
            {
                String selection = input.nextLine();
                selection = selection.toLowerCase();
                
                if(selection.equals("a"))
                {
                    if (selection.equals(main.questionAnswers.get(choice)))
                    {
                        System.out.println("Correct!");
                        main.score = main.score + 1;
                    }
                    else
                    {
                        System.out.println("Incorrect, the correct answer was " + main.questionAnswers.get(choice).toUpperCase() + ".");
                    }
                    break;
                }
                else if(selection.equals("s"))
                {
                    if (selection.equals(main.questionAnswers.get(choice)))
                    {
                        System.out.println("Correct!");
                        main.score = main.score + 1;
                    }
                    else
                    {
                        System.out.println("Incorrect, the correct answer was " + main.questionAnswers.get(choice).toUpperCase() + ".");
                    }
                    break;
                }
                else if(selection.equals("d"))
                {
                    if (selection.equals(main.questionAnswers.get(choice)))
                    {
                        System.out.println("Correct!");
                        main.score = main.score + 1;
                    }
                    else
                    {
                        System.out.println("Incorrect, the correct answer was " + main.questionAnswers.get(choice).toUpperCase() + ".");
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
              
            main.round++;
        }

        main.percent = (float) main.score / main.round * 100;
        System.out.println("--------------------------------------------------------------");
        System.out.println("Name: \n" + main.name + "\n");
        System.out.println("Final score: \n" + main.score + " out of " + main.round + ".\n");
        System.out.println("Final percentage: \n" + main.percent + "%\n");
        System.out.println("A. Main Menu\nS. Quit\n");
        
        
        while (true) 
        {
            String selection = input.nextLine();
            selection = selection.toLowerCase();
            
            if(selection.equals("a"))
            {
                menu.start();
                break;
            }
            else if(selection.equals("s"))
            {
                main.quit();
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
                menu.start();
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
}

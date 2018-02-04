import java.util.*;
import java.io.*;

public class Game
{       
    public static int round = -2;
    public static int score = 0;
    public static float percent;
    public static String name;
    
    private static Scanner input = new Scanner(System.in);
    private static String selection;
    private static Random randomizer = new Random();
    private static int numberOfinputs;
    
    public Game ()
    {
        
    }
    
    public static void name()
    {
        if (round == -1)
        {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Enter your name:\n");
            name = input.nextLine();
            round = round + 1;
        }
    }
    
    public static void start()
    {
        int choice = randomizer.nextInt(Quizes.questionList.size());
        
        name();
        
        while (round < 5)
        {
            boolean same = Quizes.questionShown.contains(choice);
            
            while(same == true)
            {
                choice = randomizer.nextInt(Quizes.questionList.size());
                same = Quizes.questionShown.contains(choice);
            }
            
            Quizes.questionShown.add(choice);
            percent = (float) score / round * 100;
            
            System.out.println("--------------------------------------------------------------");
            System.out.println("Q. Menu\n");
            if (round == 0)
            {
                System.out.println("Correct answers: " + score + " / " + round + "\nPercent: 0.0%\n");
            }
            else
            {
                System.out.println("Correct answers: " + score + " / " + round + "\nPercent: " + percent + "%\n");
            }
            
            System.out.println(Quizes.questionList.get(choice));
            if(choice == 0)
            {
                for(int i = 0; i < Quizes.questionAnswer0.size(); i++)
                {
                    System.out.println(Main.inputs.get(i).toUpperCase() + ". " + Quizes.questionAnswer0.get(i));
                    numberOfinputs = Quizes.questionAnswer0.size();
                }
                System.out.println();
            }
            else if(choice == 1)
            {
                for(int i = 0; i < Quizes.questionAnswer1.size(); i++)
                {
                    System.out.println(Main.inputs.get(i).toUpperCase() + ". " + Quizes.questionAnswer1.get(i));
                    numberOfinputs = Quizes.questionAnswer1.size();
                }
                System.out.println();
            }
            else if(choice == 2)
            {
                for(int i = 0; i < Quizes.questionAnswer2.size(); i++)
                {
                    System.out.println(Main.inputs.get(i).toUpperCase() + ". " + Quizes.questionAnswer2.get(i));
                    numberOfinputs = Quizes.questionAnswer2.size();
                }
                System.out.println();
            }
            else if(choice == 3)
            {
                for(int i = 0; i < Quizes.questionAnswer3.size(); i++)
                {
                    System.out.println(Main.inputs.get(i).toUpperCase() + ". " + Quizes.questionAnswer3.get(i));
                    numberOfinputs = Quizes.questionAnswer3.size();
                }
                System.out.println();
            }
            else if(choice == 4)
            {
                for(int i = 0; i < Quizes.questionAnswer4.size(); i++)
                {
                    System.out.println(Main.inputs.get(i).toUpperCase() + ". " + Quizes.questionAnswer4.get(i));
                    numberOfinputs = Quizes.questionAnswer4.size();
                }
                System.out.println();
            }
            
            while (true) 
            {
                String selection = input.nextLine();
                selection = selection.toLowerCase();
                
                if(selection.equals("a"))
                {
                    if (selection.equals(Quizes.questionCorrectAnswers.get(choice)))
                    {
                        System.out.println("\nCorrect!");
                        score = score + 1;
                    }
                    else
                    {
                        System.out.println("\nIncorrect, the correct answer was " + Quizes.questionCorrectAnswers.get(choice).toUpperCase() + ".");
                    }
                    break;
                }
                else if(selection.equals("s"))
                {
                    if (selection.equals(Quizes.questionCorrectAnswers.get(choice)))
                    {
                        System.out.println("\nCorrect!");
                        score = score + 1;
                    }
                    else
                    {
                        System.out.println("\nIncorrect, the correct answer was " + Quizes.questionCorrectAnswers.get(choice).toUpperCase() + ".");
                    }
                    break;
                }
                else if(selection.equals("d"))
                {
                    if (selection.equals(Quizes.questionCorrectAnswers.get(choice)))
                    {
                        System.out.println("\nCorrect!");
                        score = score + 1;
                    }
                    else
                    {
                        System.out.println("\nIncorrect, the correct answer was " + Quizes.questionCorrectAnswers.get(choice).toUpperCase() + ".");
                    }
                    break;
                }
                else if(selection.equals("f"))
                {
                    if (selection.equals(Quizes.questionCorrectAnswers.get(choice)))
                    {
                        System.out.println("\nCorrect!");
                        score = score + 1;
                    }
                    else
                    {
                        System.out.println("\nIncorrect, the correct answer was " + Quizes.questionCorrectAnswers.get(choice).toUpperCase() + ".");
                    }
                    break;
                }
                else if(selection.equals("g"))
                {
                    if (selection.equals(Quizes.questionCorrectAnswers.get(choice)))
                    {
                        System.out.println("\nCorrect!");
                        score = score + 1;
                    }
                    else
                    {
                        System.out.println("\nIncorrect, the correct answer was " + Quizes.questionCorrectAnswers.get(choice).toUpperCase() + ".");
                    }
                    break;
                }
                else if(selection.equals("h"))
                {
                    if (selection.equals(Quizes.questionCorrectAnswers.get(choice)))
                    {
                        System.out.println("\nCorrect!");
                        score = score + 1;
                    }
                    else
                    {
                        System.out.println("\nIncorrect, the correct answer was " + Quizes.questionCorrectAnswers.get(choice).toUpperCase() + ".");
                    }
                    break;
                }
                else if(selection.equals("j"))
                {
                    if (selection.equals(Quizes.questionCorrectAnswers.get(choice)))
                    {
                        System.out.println("\nCorrect!");
                        score = score + 1;
                    }
                    else
                    {
                        System.out.println("\nIncorrect, the correct answer was " + Quizes.questionCorrectAnswers.get(choice).toUpperCase() + ".");
                    }
                    break;
                }
                else if(selection.equals("k"))
                {
                    if (selection.equals(Quizes.questionCorrectAnswers.get(choice)))
                    {
                        System.out.println("\nCorrect!");
                        score = score + 1;
                    }
                    else
                    {
                        System.out.println("\nIncorrect, the correct answer was " + Quizes.questionCorrectAnswers.get(choice).toUpperCase() + ".");
                    }
                    break;
                }
                else if(selection.equals("q"))
                {
                    pause();
                    return;
                }
                else
                {
                    System.out.print("Valid inputs: ");
                    for(int i = 0; i < numberOfinputs - 1; i++)
                    {
                        System.out.print(Main.inputs.get(i).toUpperCase() + ", ");
                    }
                    System.out.print(Main.inputs.get(numberOfinputs - 1).toUpperCase());
                    System.out.println(" and Q.\n");
                }
            }
              
            round++;
        }

        percent = (float) score / round * 100;
        System.out.println("--------------------------------------------------------------");
        System.out.println("Name: \n" + name + "\n");
        System.out.println("Final score: \n" + score + " out of " + round + ".\n");
        System.out.println("Final percentage: \n" + percent + "%\n");
        System.out.println("Q. Main Menu\nW. Quit\n");
        
        
        while (true) 
        {
            String selection = input.nextLine();
            selection = selection.toLowerCase();
            
            if(selection.equals("q"))
            {
                Menu.start();
                break;
            }
            else if(selection.equals("w"))
            {
                Main.quit();
                break;
            }
            else
            {
                System.out.println("Valid inputs: Q and W.\n");
            }
        }
    }
    
    public static void pause()
    {
        System.out.println("--------------------------------------------------------------");
        System.out.println("PAUSE\nQ. Back\nW. Menu\nE. Quit\n");
     
        while (true) 
        {
            String selection = input.nextLine();
            selection = selection.toLowerCase();
            
            if(selection.equals("q"))
            {
                start();
                break;
            }
            else if(selection.equals("w"))
            {
                Menu.start();
                break;
            }
            else if(selection.equals("e"))
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

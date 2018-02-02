import java.util.*;
import java.io.*;

/**
 *
 *
 * @author Filip Bozicevic
 * @version 1.0
 */
public class leagueOfLegends
{
    private static int score = 0;
    private static int round = 0;
    private static Scanner input = new Scanner(System.in);
    private static Random randomizer = new Random();
    private static ArrayList<String> questionList = new ArrayList<String>();
    private static ArrayList<String> questionAnswers = new ArrayList<String>();
    
    public leagueOfLegends() {}
    
    /**
     *
     */
    public static void startQuiz()
    {
        questionList.add("What is the highest rank in Leauge of Legends?\nA: Master\nB: Challenger\nC: Gold\n");
        questionAnswers.add("B");
        questionList.add("What team has been the world champion the most?\nA: SKT\nB: Fnatic\nC: Samsung\n");
        questionAnswers.add("A");
        questionList.add("Who's the best professionall League of Legends player?\nA: Uzi\nB: Bjergsen\nC: Faker\n");
        questionAnswers.add("C");
        questionList.add("What's the name of the Chinese profesional league?\nA: LPL\nB: LCK\nC: LCS\n");
        questionAnswers.add("A");
        questionList.add("Where were the League of Legends 2017 Worlds Finals held?\nA: The Bird's Nest\nB: Staples Center\nC: Madison Square Garden\n");
        questionAnswers.add("A");
        
        int choice = randomizer.nextInt(questionAnswers.size());
        int[] questionShown = new int [questionAnswers.size() + 1];
        questionShown[round] = choice;
        
        while (round < 5)
        {
            for(int i = 0;i < questionAnswers.size(); i++) 
            {
                if(choice == questionShown[i])
                {
                    choice = randomizer.nextInt(questionAnswers.size());
                    i = 0;
                }
            }
            
            questionShown[round + 1] = choice;
            
            System.out.println("--------------------------------------------------------------");
            System.out.println("Correct answers: " + score + " / " + round + "\n");
            System.out.println(questionList.get(choice));
            
            
            while (true) 
            {
                String selection = input.nextLine();
                
                if(selection.equals("A"))
                {
                    if (selection.equals(questionAnswers.get(choice)))
                    {
                        System.out.println("Correct!");
                        score = score + 1;
                    }
                    else
                    {
                        System.out.println("Incorrect, the correct answer was " + questionAnswers.get(choice) + ".");
                    }
                    break;
                }
                if(selection.equals("B"))
                {
                    if (selection.equals(questionAnswers.get(choice)))
                    {
                        System.out.println("Correct!");
                        score = score + 1;
                    }
                    else
                    {
                        System.out.println("Incorrect, the correct answer was " + questionAnswers.get(choice) + ".");
                    }
                    break;
                }
                if(selection.equals("C"))
                {
                    if (selection.equals(questionAnswers.get(choice)))
                    {
                        System.out.println("Correct!");
                        score = score + 1;
                    }
                    else
                    {
                        System.out.println("Incorrect, the correct answer was " + questionAnswers.get(choice) + ".");
                    }
                    break;
                }
        
                System.out.println("Please type A, B or C.");
            }
              
            round++;
        }

        System.out.println("--------------------------------------------------------------");
        System.out.println("Final score: \n" + score + " out of " + round + ".\n");
        System.out.println("A: Menu\nB: Quit\n");
        
        while (true) 
            {
                String selection = input.nextLine();
                
                if(selection.equals("A"))
                {
                    main.startQuiz();
                    break;
                }
                if(selection.equals("B"))
                {
                    System.out.println("Quitting...");
                    break;
                }
                else
                {
                    System.out.println("Please type A or B.");
                }
            }
        
        String selection = input.nextLine();
    }
}


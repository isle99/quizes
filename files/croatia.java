import java.util.*;
import java.io.*;

/**
 *
 *
 * @author Filip Bozicevic
 * @version 1.0
 */
public class croatia
{    
    private static int score = 0;
    private static int round = 0;
    private static Scanner input = new Scanner(System.in);
    private static Random randomizer = new Random();
    private static ArrayList<String> questionList = new ArrayList<String>();
    private static ArrayList<String> questionAnswers = new ArrayList<String>();
    
    public croatia() {}
    
    /**
     *
     */
    public static void startQuiz()
    {
        questionList.add("What is the capital of Croatia? \nA: Osijek\nB: Zagreb\nC: Split\n");
        questionAnswers.add("B");
        questionList.add("What famous inventor was from Croatia? \nA: Nikola Tesla\nB: Miroslav Penkala\nC: Ruder Boskovic\n");
        questionAnswers.add("A");
        questionList.add("What is the name of Croatia's first king? \nA: Tomislav\nB: Marko\nC: Trpimir\n");
        questionAnswers.add("A");
        questionList.add("What is Croatia's most prestige national park? \nA: Kopacki Rit\nB: Plitvicka Jezera\nC: Kornati\n");
        questionAnswers.add("B");
        questionList.add("Where was Game of Thrones filmed? \nA: Zadar\nB: Rijeka\nC: Dubrovnik\n");
        questionAnswers.add("C");
        
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

import java.util.*;
import java.io.*;

/**
 *
 *
 * @author Filip Bozicevic
 * @version 1.0
 */
public class geography
{   
    private static int score = 0;
    private static int round = 0;
    private static Scanner input = new Scanner(System.in);
    private static Random randomizer = new Random();
    private static ArrayList<String> questionList = new ArrayList<String>();
    private static ArrayList<String> questionAnswers = new ArrayList<String>();
    
    public geography() {}
    
    /**
     *
     */
    public static void startQuiz()
    {
        questionList.add("What is the capital of the USA? \nA: Los Angeles\nB: New York\nC: Washington D.C.\n");
        questionAnswers.add("C");
        questionList.add("Where is the Nile located? \nA: Iraq\nB: Egypt\nC: Israel\n");
        questionAnswers.add("B");
        questionList.add("What is the smallest country in the world? \nA: San Marino\nB: Monaco\nC: Vatican\n");
        questionAnswers.add("C");
        questionList.add("What's the second biggest country in the world? \nA: China\nB: Canada\nC: Australia\n");
        questionAnswers.add("B");
        questionList.add("What's the only Portugese speaking country in South America? \nA: Argentina\nB: Brasil\nC: Chile\n");
        questionAnswers.add("B");
        questionList.add("Which ocean lies on the east coast of the United States? \nA: Pacific\nB: Indian\nC: Atlantic\n");
        questionAnswers.add("C");
        questionList.add("Which is the world's highest mountain? \nA: Mount Everest\nB: Kilimanjaro\nC: Makalu\n");
        questionAnswers.add("A");
        questionList.add("How many Great Lakes are there? \nA: 5\nB: 6\nC: 3\n");
        questionAnswers.add("A");
        questionList.add("What is the biggest desert in the world? \nA: The Arabian Desert\nB: The Great Australian Desert\nC: Sahara\n");
        questionAnswers.add("C");
        questionList.add("The United Kingdom is comprised of how many countries? \nA: 5\nB: 4\nC: 6\n");
        questionAnswers.add("B");
        
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

import java.util.*;
import java.io.*;

public class QuizesUI
{
    Database database;
    public ArrayList<String> inputs;
    public ArrayList<Integer> questionsShown;
    public Random randomizer;
    public Scanner scanner;
    public int round;
    public int score;
    public int numberOfAnswers;
    public int choice;
    public float percent;
    public boolean found;
    public boolean same;
    public String selection;
    public String name;
    
    public QuizesUI()
    {
        inputs = new ArrayList<String>();
        String[] inputsArray = new String[] {"a","s","d","f","g","h","j","k"};
        inputs.addAll(Arrays.asList(inputsArray));
        randomizer = new Random();
        scanner = new Scanner(System.in);
        questionsShown = new ArrayList<Integer>();
        int round = -2;
        int score = 0;
        
        menu();
    }
    
    public static void main(String[] args)
    {   
        Database database = new Database();
        QuizesUI quizesUI = new QuizesUI();
    }
    
    public void menu()
    {
        if (round == -2)
        {
            round = round + 1;
        }
        else
        {
            QuizesOriginal.questionAnswer0.clear();
            QuizesOriginal.questionAnswer1.clear();
            QuizesOriginal.questionAnswer2.clear();
            QuizesOriginal.questionAnswer3.clear();
            QuizesOriginal.questionAnswer4.clear();
            QuizesOriginal.questionList.clear();
            QuizesOriginal.questionCorrectAnswers.clear();
            questionsShown.clear();
            round = -1;
            score = 0;
        }
        
        System.out.println("--------------------------------------------------------------");
        System.out.println("MENU\nQ. Quizes\nW. Add Quiz \nE. Highscores \nR. Quit\n");
     
        boolean run = true;
        while (run) 
        {
            String selection = scanner.nextLine();
            selection = selection.toLowerCase();
            
            if(selection.equals("q"))
            {
                quizes();
                run = false;
            }
            else if(selection.equals("w"))
            {
                addQuiz();
                run = false;
            }
            else if(selection.equals("e"))
            {
                quit();
                run = false;
            }
            else if(selection.equals("r"))
            {
                quit();
                run = false;
            }
            else
            {
                System.out.println("Valid inputs: Q, W, E and R.\n");
            }
        }
    }
    
    public void quizes()
    {
        System.out.println("--------------------------------------------------------------");
        System.out.println("MENU - QUIZES\nQ. Croatia\nW. League of Legends\nE. Geography\nR. New Quiz\nT. Back\n");
     
        boolean run = true;
        while (run) 
        {
            String selection = scanner.nextLine();
            selection = selection.toLowerCase();
            
            if(selection.equals("q"))
            {
                QuizesOriginal.croatia();
                startQuizOriginal();
                run = false;
            }
            else if(selection.equals("w"))
            {
                QuizesOriginal.leagueOfLegends();
                startQuizOriginal();
                run = false;
            }
            else if(selection.equals("e"))
            {
                QuizesOriginal.geography();
                startQuizOriginal();
                run = false;
            }
            else if(selection.equals("r"))
            {
                System.out.println(database.quizes.get(0).getName());
                run = false;
            }
            else if(selection.equals("t"))
            {
                menu();
                run = false;
            }
            else
            {
                System.out.println("Valid inputs: Q, W, E, R and T.\n");
            }
        }
    }
    
    public void addQuiz()
    {
        System.out.println("--------------------------------------------------------------");
        System.out.println("MENU - ADD QUIZ\n");
     
        System.out.println("Type a name to create a quiz.\n");
        String name = scanner.nextLine();
        Quiz quiz0 = new Quiz(name);
        database.addQuiz(quiz0);
        
        menu();
    }
    
    public void startQuizOriginal()
    {
        //NAME
        if (round == -1)
        {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Enter your name:\n");
            name = scanner.nextLine();
            round = round + 1;
        }
        
        int choice = randomizer.nextInt(QuizesOriginal.questionList.size());
        while (round < QuizesOriginal.numberOfQuestions)
        {
            found = false;
            same = questionsShown.contains(choice);
            
            while(same == true)
            {
                choice = randomizer.nextInt(QuizesOriginal.questionList.size());
                same = questionsShown.contains(choice);
            }
            questionsShown.add(choice);
            
            //INTERFACE
            System.out.println("--------------------------------------------------------------");
            System.out.println("Q. Menu\n");
            percent = (float) score / round * 100;
            if (round == 0)
            {
                System.out.println("Correct answers: " + score + " / " + round + "\nPercent: 0.0%\n");
            }
            else
            {
                System.out.println("Correct answers: " + score + " / " + round + "\nPercent: " + percent + "%\n");
            }
            System.out.print((round + 1) + ". ");
            
            //QUESTION
            System.out.println(QuizesOriginal.questionList.get(choice));
            if(choice == 0)
            {
                for(int i = 0; i < QuizesOriginal.questionAnswer0.size(); i++)
                {
                    System.out.println(inputs.get(i).toUpperCase() + ". " + QuizesOriginal.questionAnswer0.get(i));
                    numberOfAnswers = QuizesOriginal.questionAnswer0.size();
                }
                System.out.println();
            }
            else if(choice == 1)
            {
                for(int i = 0; i < QuizesOriginal.questionAnswer1.size(); i++)
                {
                    System.out.println(inputs.get(i).toUpperCase() + ". " + QuizesOriginal.questionAnswer1.get(i));
                    numberOfAnswers = QuizesOriginal.questionAnswer1.size();
                }
                System.out.println();
            }
            else if(choice == 2)
            {
                for(int i = 0; i < QuizesOriginal.questionAnswer2.size(); i++)
                {
                    System.out.println(inputs.get(i).toUpperCase() + ". " + QuizesOriginal.questionAnswer2.get(i));
                    numberOfAnswers = QuizesOriginal.questionAnswer2.size();
                }
                System.out.println();
            }
            else if(choice == 3)
            {
                for(int i = 0; i < QuizesOriginal.questionAnswer3.size(); i++)
                {
                    System.out.println(inputs.get(i).toUpperCase() + ". " + QuizesOriginal.questionAnswer3.get(i));
                    numberOfAnswers = QuizesOriginal.questionAnswer3.size();
                }
                System.out.println();
            }
            else if(choice == 4)
            {
                for(int i = 0; i < QuizesOriginal.questionAnswer4.size(); i++)
                {
                    System.out.println(inputs.get(i).toUpperCase() + ". " + QuizesOriginal.questionAnswer4.get(i));
                    numberOfAnswers = QuizesOriginal.questionAnswer4.size();
                }
                System.out.println();
            }
            
            //ANSWER
            boolean run = true;
            while (run)
            {
                String selection = scanner.nextLine();
                selection = selection.toLowerCase();
                
                for(int i = 0; i < numberOfAnswers; i++)
                {
                    if(selection.equals(inputs.get(i)))
                    {
                        if (selection.equals(QuizesOriginal.questionCorrectAnswers.get(choice)))
                        {
                            System.out.println("\nCorrect!");
                            score = score + 1;
                        }
                        else
                        {
                            System.out.println("\nIncorrect, the correct answer was " + QuizesOriginal.questionCorrectAnswers.get(choice).toUpperCase() + ".");
                        }
                        found = true;
                        run = false;
                    }
                }
                
                if (found == true)
                {
                    run = false;
                }
                else if(selection.equals("q"))
                {
                    pauseOriginal();
                    run = false;
                }
                else 
                {
                    System.out.print("Valid inputs: ");
                    for(int i = 0; i < numberOfAnswers - 1; i++)
                    {
                        System.out.print(inputs.get(i).toUpperCase() + ", ");
                    }
                    System.out.print(inputs.get(numberOfAnswers - 1).toUpperCase());
                    System.out.println(" and Q.\n");
                }
            }
            
            round++;
        }
        
        //ENDING
        percent = (float) score / round * 100;
        System.out.println("--------------------------------------------------------------");
        System.out.println("Name: \n" + name + "\n");
        System.out.println("Final score: \n" + score + " out of " + round + ".\n");
        System.out.println("Final percentage: \n" + percent + "%\n");
        System.out.println("Q. Main Menu\nW. Quit\n");
        
        boolean run = true;
        while (run) 
        {
            String selection = scanner.nextLine();
            selection = selection.toLowerCase();
            
            if(selection.equals("q"))
            {
                menu();
                run = false;
            }
            else if(selection.equals("w"))
            {
                quit();
                run = false;
            }
            else
            {
                System.out.println("Valid inputs: Q and W.\n");
            }
        }
    } 
    
    public void startQuiz()
    {
        //NAME
        if (round == -1)
        {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Enter your name:\n");
            name = scanner.nextLine();
            round = round + 1;
        }
        
        int choice = randomizer.nextInt(QuizesOriginal.questionList.size());
        while (round < QuizesOriginal.numberOfQuestions)
        {
            found = false;
            same = questionsShown.contains(choice);
            
            while(same == true)
            {
                choice = randomizer.nextInt(QuizesOriginal.questionList.size());
                same = questionsShown.contains(choice);
            }
            questionsShown.add(choice);
            
            //INTERFACE
            System.out.println("--------------------------------------------------------------");
            System.out.println("Q. Menu\n");
            percent = (float) score / round * 100;
            if (round == 0)
            {
                System.out.println("Correct answers: " + score + " / " + round + "\nPercent: 0.0%\n");
            }
            else
            {
                System.out.println("Correct answers: " + score + " / " + round + "\nPercent: " + percent + "%\n");
            }
            System.out.print((round + 1) + ". ");
            
            //QUESTION
            System.out.println(QuizesOriginal.questionList.get(choice));
            if(choice == 0)
            {
                for(int i = 0; i < QuizesOriginal.questionAnswer0.size(); i++)
                {
                    System.out.println(inputs.get(i).toUpperCase() + ". " + QuizesOriginal.questionAnswer0.get(i));
                    numberOfAnswers = QuizesOriginal.questionAnswer0.size();
                }
                System.out.println();
            }
            else if(choice == 1)
            {
                for(int i = 0; i < QuizesOriginal.questionAnswer1.size(); i++)
                {
                    System.out.println(inputs.get(i).toUpperCase() + ". " + QuizesOriginal.questionAnswer1.get(i));
                    numberOfAnswers = QuizesOriginal.questionAnswer1.size();
                }
                System.out.println();
            }
            else if(choice == 2)
            {
                for(int i = 0; i < QuizesOriginal.questionAnswer2.size(); i++)
                {
                    System.out.println(inputs.get(i).toUpperCase() + ". " + QuizesOriginal.questionAnswer2.get(i));
                    numberOfAnswers = QuizesOriginal.questionAnswer2.size();
                }
                System.out.println();
            }
            else if(choice == 3)
            {
                for(int i = 0; i < QuizesOriginal.questionAnswer3.size(); i++)
                {
                    System.out.println(inputs.get(i).toUpperCase() + ". " + QuizesOriginal.questionAnswer3.get(i));
                    numberOfAnswers = QuizesOriginal.questionAnswer3.size();
                }
                System.out.println();
            }
            else if(choice == 4)
            {
                for(int i = 0; i < QuizesOriginal.questionAnswer4.size(); i++)
                {
                    System.out.println(inputs.get(i).toUpperCase() + ". " + QuizesOriginal.questionAnswer4.get(i));
                    numberOfAnswers = QuizesOriginal.questionAnswer4.size();
                }
                System.out.println();
            }
            
            //ANSWER
            boolean run = true;
            while (run)
            {
                String selection = scanner.nextLine();
                selection = selection.toLowerCase();
                
                for(int i = 0; i < numberOfAnswers; i++)
                {
                    if(selection.equals(inputs.get(i)))
                    {
                        if (selection.equals(QuizesOriginal.questionCorrectAnswers.get(choice)))
                        {
                            System.out.println("\nCorrect!");
                            score = score + 1;
                        }
                        else
                        {
                            System.out.println("\nIncorrect, the correct answer was " + QuizesOriginal.questionCorrectAnswers.get(choice).toUpperCase() + ".");
                        }
                        found = true;
                        run = false;
                    }
                }
                
                if (found == true)
                {
                    run = false;
                }
                else if(selection.equals("q"))
                {
                    pause();
                    run = false;
                }
                else 
                {
                    System.out.print("Valid inputs: ");
                    for(int i = 0; i < numberOfAnswers - 1; i++)
                    {
                        System.out.print(inputs.get(i).toUpperCase() + ", ");
                    }
                    System.out.print(inputs.get(numberOfAnswers - 1).toUpperCase());
                    System.out.println(" and Q.\n");
                }
            }
            
            round++;
        }
        
        //ENDING
        percent = (float) score / round * 100;
        System.out.println("--------------------------------------------------------------");
        System.out.println("Name: \n" + name + "\n");
        System.out.println("Final score: \n" + score + " out of " + round + ".\n");
        System.out.println("Final percentage: \n" + percent + "%\n");
        System.out.println("Q. Main Menu\nW. Quit\n");
        
        boolean run = true;
        while (run) 
        {
            String selection = scanner.nextLine();
            selection = selection.toLowerCase();
            
            if(selection.equals("q"))
            {
                menu();
                run = false;
            }
            else if(selection.equals("w"))
            {
                quit();
                run = false;
            }
            else
            {
                System.out.println("Valid inputs: Q and W.\n");
            }
        }
    }
    
    public void pauseOriginal()
    {
        System.out.println("--------------------------------------------------------------");
        System.out.println("PAUSE\nQ. Back\nW. Menu\nE. Quit\n");
     
        boolean run = true;
        while (run) 
        {
            String selection = scanner.nextLine();
            selection = selection.toLowerCase();
            
            if(selection.equals("q"))
            {
                startQuizOriginal();
                run = false;
            }
            else if(selection.equals("w"))
            {
                menu();
                run = false;
            }
            else if(selection.equals("e"))
            {
                quit();
                run = false;
            }
            else
            {
                System.out.println("Valid inputs: A, S and D.\n");
            }
        }
    }
    
    public void pause()
    {
        System.out.println("--------------------------------------------------------------");
        System.out.println("PAUSE\nQ. Back\nW. Menu\nE. Quit\n");
     
        boolean run = true;
        while (run) 
        {
            String selection = scanner.nextLine();
            selection = selection.toLowerCase();
            
            if(selection.equals("q"))
            {
                startQuiz();
                run = false;
            }
            else if(selection.equals("w"))
            {
                menu();
                run = false;
            }
            else if(selection.equals("e"))
            {
                quit();
                run = false;
            }
            else
            {
                System.out.println("Valid inputs: A, S and D.\n");
            }
        }
    }
    
    public void quit()
    {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Quitting...");
    }
}
import java.util.*;
import java.io.*;

public class QuizesUI
{
    public Database database;
    public Quiz quiz0;
    public Quiz quiz1;
    public Quiz quiz2;
    public Quiz quiz;
    public ArrayList<String> inputsMenu;
    public ArrayList<String> inputsQuiz;
    //public ArrayList<Integer> quizNumbers;
    public ArrayList<Integer> questionsShown;
    public Random randomizer;
    public Scanner scanner;
    public int round;
    public int score;
    public int numberOfQuizes;
    public int numberOfQuestions;
    public int numberOfAnswers;
    public int choice;
    public float percent;
    public boolean same;
    public String selection;
    public String name;
    
    public QuizesUI()
    {
        database = new Database();
        inputsMenu = new ArrayList<String>();
        String[] inputsMenuArray = new String[] {"q","w","e","r","t","y","u","i"};
        inputsMenu.addAll(Arrays.asList(inputsMenuArray));
        inputsQuiz = new ArrayList<String>();
        String[] inputsQuizArray = new String[] {"a","s","d","f","g","h","j","k"};
        inputsQuiz.addAll(Arrays.asList(inputsQuizArray));
        //quizNumbers = new ArrayList<Integer>();
        //Integer[] quizNumbersArray = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        //quizNumbers.addAll(Arrays.asList(quizNumbersArray));
        randomizer = new Random();
        scanner = new Scanner(System.in);
        questionsShown = new ArrayList<Integer>();
        round = -1;
        score = 0;
        
        menu();
    }
    
    public static void main(String[] args)
    {   
        Database database = new Database();
        QuizesUI quizesUI = new QuizesUI();
    }
    
    public void menu()
    {   
        if (round > 0)
        {
            questionsShown.clear();
            round = 0;
            score = 0;
        }
        
        System.out.println("--------------------------------------------------------------");
        System.out.println("MENU\nQ. Quizes\nW. Highscores \nE. Quit\n");
     
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
                quit();
                run = false;
            }
            else if(selection.equals("e"))
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
        numberOfQuizes = database.getNumberOfQuizes();
        
        System.out.println("--------------------------------------------------------------");
        System.out.println("MENU - QUIZES\nQ. Add Quiz\nW. Back\n");
     
        for(int i = 0; i < numberOfQuizes; i++)
        {
            System.out.println(inputsQuiz.get(i).toUpperCase() + ". " + database.getQuiz(i).getName());
        }
        
        boolean run = true;
        while (run)
        {
            String selection = scanner.nextLine();
            selection = selection.toLowerCase();
            
            for(int i = 0; i < database.getNumberOfQuizes(); i++)
            {
                if(selection.equals(inputsQuiz.get(i)))
                {
                    quiz = database.getQuiz(i);
                    startQuiz();
                    run = false;
                }
            }
            
            if(selection.equals("q"))
            {
                addQuiz();
                run = false;
            }
            else if(selection.equals("w"))
            {
                menu();
                run = false;
            }
            else 
            {
                System.out.print("Valid inputs: ");
                for(int i = 0; i < database.getNumberOfQuizes() - 1; i++)
                {
                    System.out.print(inputsQuiz.get(i).toUpperCase() + ", ");
                }
                System.out.print(inputsQuiz.get(database.getNumberOfQuizes() - 1).toUpperCase());
                System.out.println(", Q and W.\n");
            }
        }
    }
    
    public void addQuiz()
    {
        System.out.println("--------------------------------------------------------------");
        System.out.println("MENU - QUIZES - ADD QUIZ\n");
     
        System.out.println("Type a name to create the quiz.\n");
        String name = scanner.nextLine();
        //String quizName = "quiz" + quizNumbers.get(database.getNumberOfQuizes());
        Quiz newQuiz = new Quiz(name);
        database.addQuiz(quiz0);
        numberOfQuizes = database.getNumberOfQuizes();
        
        menu();
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
        
        int choice = randomizer.nextInt(quiz.questions.size());
        boolean found;
        while (round < quiz.questions.size())
        {
            found = false;
            same = questionsShown.contains(choice);
            
            while(same == true)
            {
                choice = randomizer.nextInt(quiz.questions.size());
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
            System.out.println(quiz.questions.get(choice).getQuestion());
            for(int i = 0; i < quiz.questions.get(i).answers.size(); i++)
            {
                System.out.println(inputsQuiz.get(i).toUpperCase() + ". " + quiz.questions.get(i).getAnswer(i));
                numberOfAnswers = quiz.questions.get(i).getNumberOfAnswers();
            }
            System.out.println();
            
            //ANSWER
            boolean run = true;
            while (run)
            {
                selection = scanner.nextLine();
                selection = selection.toLowerCase();
                
                for(int i = 0; i < numberOfAnswers; i++)
                {
                    if(selection.equals(inputsQuiz.get(i)))
                    {
                        selection = quiz.questions.get(choice).getAnswer(i);
                        
                        if (selection.equals(quiz.questions.get(choice).getCorrectAnswer()))
                        {
                            System.out.println("\nCorrect!");
                            score = score + 1;
                        }
                        else
                        {
                            System.out.println("\nIncorrect, the correct answer was " + quiz.questions.get(choice).getCorrectAnswer() + ".");
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
                        System.out.print(inputsQuiz.get(i).toUpperCase() + ", ");
                    }
                    System.out.print(inputsQuiz.get(numberOfAnswers - 1).toUpperCase());
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
    
    public void pause()
    {
        System.out.println("--------------------------------------------------------------");
        System.out.println("PAUSE\nQ. Back\nW. Menu\nE. Quit\n");
     
        while (true) 
        {
            String selection = scanner.nextLine();
            selection = selection.toLowerCase();
            
            if(selection.equals("q"))
            {
                startQuiz();
                break;
            }
            else if(selection.equals("w"))
            {
                menu();
                break;
            }
            else if(selection.equals("e"))
            {
                quit();
                break;
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
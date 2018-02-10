import java.util.*;
import java.io.*;

public class QuizesUI
{
    public Database database;
    public ArrayList<String> inputsMenu;
    public ArrayList<String> inputsQuiz;
    public Random randomizer;
    public Scanner scanner;
    public int round;
    public int score;
    public int numberOfQuizes;
    public Quiz quiz;
    public int numberOfQuestions;
    public int numberOfAnswers;
    public int choice;
    public ArrayList<Integer> questionsShown;
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
        //RESET
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
        System.out.println("QUIZES\nQ. Add Quiz\nW. Remove Quiz\nE. Back\n");
     
        for(int i = 0; i < numberOfQuizes; i++)
        {
            System.out.println(inputsQuiz.get(i).toUpperCase() + ". " + database.getQuiz(i).getName());
        }
        System.out.println();
        
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
                removeQuiz();
                run = false;
            }
            else if(selection.equals("e"))
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
        System.out.println("ADD QUIZ - NAME\nQ. Cancel\n");
     
        System.out.println("Type the name of the quiz:\n");
        String name = scanner.nextLine();
        if(name.equals("q"))
        {
            quizes();
        }
        for(int k = 0; k < database.getNumberOfQuizes(); k++)
        {
            while(name.equals(database.getQuiz(k).getName()))
            {
                System.out.println("--------------------------------------------------------------");
                System.out.println("ADD QUIZ - NAME\nQ. Cancel\n");
                System.out.println("Name taken. Choose a different name:\n");
                name = scanner.nextLine();
                if(name.equals("q"))
                {
                    quizes();
                }
            }
        }
        Quiz newQuiz = new Quiz(name);
        database.addQuiz(newQuiz);
        numberOfQuizes = database.getNumberOfQuizes();
        
        System.out.println("--------------------------------------------------------------");
        System.out.println("ADD QUIZ - QUESTIONS\nQ. Cancel\n");
        System.out.println("Type the number of questions:\n");
        String numberOfQuestions = scanner.nextLine();
        if(numberOfQuestions.equals("q"))
        {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Do you want to save the quiz:\nQ. Yes\nW. No\n");
            selection = scanner.nextLine();
            selection = selection.toLowerCase();
            if(selection.equals("q"))
            {
                quizes();
            }
            else if(selection.equals("w"))
            {
                database.removeQuiz(numberOfQuizes - 1);
                quizes();
            }
        }
        
        int loop = Integer.parseInt(numberOfQuestions);
        for(int i = 0; i < loop; i++)
        {    
            System.out.println("--------------------------------------------------------------");
            System.out.println("ADD QUIZ - QUESTIONS\nQ. Cancel\n");
            System.out.println("Type the " + (i + 1) + ". question:\n");
            String question = scanner.nextLine();
            if(question.equals("q"))
            {
                System.out.println("--------------------------------------------------------------");
                System.out.println("Do you want to save the quiz:\nQ. Yes\nW. No\n");
                selection = scanner.nextLine();
                selection = selection.toLowerCase();
                if(selection.equals("q"))
                {
                    quizes();
                }
                else if(selection.equals("w"))
                {
                    database.removeQuiz(numberOfQuizes - 1);
                    quizes();
                }
            }
            Question newQuestion = new Question(question);
            newQuiz.addQuestion(newQuestion);
            
            System.out.println("--------------------------------------------------------------");
            System.out.println("ADD QUIZ - QUESTION - ANSWERS\nQ. Cancel\n");
            System.out.println("Type the number of answers:\n");
            String numberOfAnswers = scanner.nextLine();
            if(numberOfAnswers.equals("q"))
            {
                System.out.println("--------------------------------------------------------------");
                System.out.println("Do you want to save the quiz:\nQ. Yes\nW. No\n");
                selection = scanner.nextLine();
                selection = selection.toLowerCase();
                if(selection.equals("q"))
                {
                    quizes();
                }
                else if(selection.equals("w"))
                {
                    database.removeQuiz(numberOfQuizes - 1);
                    quizes();
                }
            }
            int loopJ = Integer.parseInt(numberOfAnswers);
            for(int j = 0; j < loopJ; j++)
            {
                System.out.println("--------------------------------------------------------------");
                System.out.println("ADD QUIZ - QUESTION - ANSWERS\nQ. Cancel\n");
                System.out.println("Type the " + (j + 1) + ". answer:\n");
                String answer = scanner.nextLine();
                if(answer.equals("q"))
                {
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Do you want to save the quiz:\nQ. Yes\nW. No\n");
                    selection = scanner.nextLine();
                    selection = selection.toLowerCase();
                    if(selection.equals("q"))
                    {
                        quizes();
                    }
                    else if(selection.equals("w"))
                    {
                        database.removeQuiz(numberOfQuizes - 1);
                        quizes();
                    }
                }
                newQuestion.addAnswer(answer);
            }
            
            System.out.println("--------------------------------------------------------------");
            System.out.println("ADD QUIZ - QUESTION - CORRECT ANSWER\nQ. Cancel\n");
            System.out.println("Type the correct answer for question " + (i +1) + ":\n");
            String correctAnswer = scanner.nextLine();
            if(correctAnswer.equals("q"))
            {
                System.out.println("--------------------------------------------------------------");
                System.out.println("Do you want to save the quiz:\nQ. Yes\nW. No\n");
                selection = scanner.nextLine();
                selection = selection.toLowerCase();
                if(selection.equals("q"))
                {
                    quizes();
                }
                else if(selection.equals("w"))
                {
                    database.removeQuiz(numberOfQuizes - 1);
                    quizes();
                }
            }
            newQuestion.setCorrectAnswer(correctAnswer);
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println(name + " created.");
        
        quizes();
    }
    
    public void removeQuiz()
    {
        numberOfQuizes = database.getNumberOfQuizes();
        
        System.out.println("--------------------------------------------------------------");
        System.out.println("REMOVE QUIZ\nQ. Cancel\n");
     
        for(int i = 0; i < numberOfQuizes; i++)
        {
            System.out.println(inputsQuiz.get(i).toUpperCase() + ". " + database.getQuiz(i).getName());
        }
        System.out.println();
        
        System.out.println("--------------------------------------------------------------");
        System.out.println("Type the name of the quiz you want to remove:\n");
        boolean run = true;
        boolean found = false;
        while (run)
        {
            String selection = scanner.nextLine();
            
            for(int i = 0; i < database.getNumberOfQuizes(); i++)
            {
                if(selection.equals(database.getQuiz(i).getName()))
                {
                    database.removeQuiz(i);
                    System.out.println("--------------------------------------------------------------");
                    System.out.println(selection + " removed.");
                    found = true;
                }
            }
            
            if(found == true)
            {
                quizes();
                run = false;
            }
            else if(selection.equals("q"))
            {
                quizes();
                run = false;
            }
            else 
            {
                System.out.println("--------------------------------------------------------------");
                System.out.println("There is no quiz with that name. Try again:\n");
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
            for(int i = 0; i < quiz.questions.get(choice).getNumberOfAnswers(); i++)
            {
                System.out.println(inputsQuiz.get(i).toUpperCase() + ". " + quiz.questions.get(choice).getAnswer(i));
                numberOfAnswers = quiz.questions.get(choice).getNumberOfAnswers();
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
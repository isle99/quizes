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
    public int numberOfHighscores;
    public Quiz quiz;
    public Highscore highscore;
    public int numberOfQuestions;
    public int numberOfAnswers;
    public int choice;
    public ArrayList<Integer> questionsShown;
    public float percent;
    public boolean same;
    public String selection;
    public String selectionAddQuiz;
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
        //NAME
        if (round == -1)
        {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Enter your name:\n");
            name = scanner.nextLine();
            round = round + 1;
            
            Highscore newHighscore = new Highscore(name, 0, 0);
            database.addHighscore(newHighscore);
            highscore = newHighscore;
            numberOfHighscores = database.getNumberOfHighscores();
        }
        
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
                highscores();
                run = false;
            }
            else if(selection.equals("e"))
            {
                quit();
                run = false;
            }
            else
            {
                System.out.println("Valid inputs: Q, W, and E.\n");
            }
        }
    }
    
    public void quizes()
    {
        numberOfQuizes = database.getNumberOfQuizes();
        
        System.out.println("--------------------------------------------------------------");
        System.out.println("QUIZES\nQ. Start Quiz\nW. Add Quiz\nE. Remove Quiz\nR. Edit Quiz\nT. Back\n");
        
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
                addQuiz();
                run = false;
            }
            else if(selection.equals("e"))
            {
                removeQuiz();
                run = false;
            }
            else if(selection.equals("r"))
            {
                editQuiz();
                run = false;
            }
            else if(selection.equals("t"))
            {
                menu();
                run = false;
            }
            else 
            {
                System.out.print("Valid inputs: Q, W, E, R and T.\n");
            }
        }
    }
    
    public void highscores()
    {
        numberOfHighscores = database.getNumberOfHighscores();
        
        System.out.println("--------------------------------------------------------------");
        System.out.println("HIGHSCORES\nQ. Back\n");
     
        for(int i = 0; i < numberOfHighscores; i++)
        {
            System.out.print((i + 1) + ". " + database.getHighscore(i).getName() + " - " + database.getHighscore(i).getScore());
            System.out.println("/" + database.getHighscore(i).getQuestionsAnswered() + " - " + database.getHighscore(i).getPercent() + "%");
        }
        System.out.println();
        
        while (true)
        {
            String selection = scanner.nextLine();
            selection = selection.toLowerCase();
                        
            if(selection.equals("q"))
            {
                menu();
                break;
            }
            else 
            {
                System.out.println("--------------------------------------------------------------");
                System.out.print("Valid inputs: Q.");
            }
        }
    }
    
    public void startQuiz()
    {
        numberOfQuizes = database.getNumberOfQuizes();
        
        System.out.println("--------------------------------------------------------------");
        System.out.println("START QUIZ\nQ. Back\n");
     
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
                    play();
                    run = false;
                }
            }
            
            if(selection.equals("q"))
            {
                quizes();
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
                System.out.println(" and Q.\n");
            }
        }
    }
    
    public void addQuiz()
    {
        //NAME
        System.out.println("--------------------------------------------------------------");
        System.out.println("ADD QUIZ - NAME\nQ. Cancel\n");
        System.out.println("Type the name of the quiz:\n");
        selectionAddQuiz = scanner.nextLine();
        if(selectionAddQuiz.equals("q"))
        {
            quizes();
        }
        for(int k = 0; k < database.getNumberOfQuizes(); k++)
        {
            while(selectionAddQuiz.equals(database.getQuiz(k).getName()))
            {
                System.out.println("--------------------------------------------------------------");
                System.out.println("ADD QUIZ - NAME\nQ. Cancel\n");
                System.out.println("Name taken. Choose a different name:\n");
                selectionAddQuiz = scanner.nextLine();
                if(selectionAddQuiz.equals("q"))
                {
                    quizes();
                }
            }
        }
        Quiz newQuiz = new Quiz(selectionAddQuiz);
        database.addQuiz(newQuiz);
        numberOfQuizes = database.getNumberOfQuizes();
        
        //NUMBER OF QUESTIONS
        System.out.println("--------------------------------------------------------------");
        System.out.println("ADD QUIZ - QUESTIONS\nQ. Cancel\n");
        System.out.println("Type the number of questions:\n");
        selectionAddQuiz = scanner.nextLine();
        if(selectionAddQuiz.equals("q"))
        {
            cancel();
            return;
        }
        
        //QUESTIONS
        int loop = Integer.parseInt(selectionAddQuiz);
        for(int i = 0; i < loop; i++)
        {    
            System.out.println("--------------------------------------------------------------");
            System.out.println("ADD QUIZ - QUESTIONS\nQ. Cancel\n");
            System.out.println("Type the " + (i + 1) + ". question:\n");
            String question = scanner.nextLine();
            if(selectionAddQuiz.equals("q"))
            {
                cancel();
                return;
            }
            Question newQuestion = new Question(selectionAddQuiz);
            newQuiz.addQuestion(newQuestion);
            
            //NUMBER OF ANSWERS
            System.out.println("--------------------------------------------------------------");
            System.out.println("ADD QUIZ - QUESTION - ANSWERS\nQ. Cancel\n");
            System.out.println("Type the number of answers:\n");
            selectionAddQuiz = scanner.nextLine();
            if(selectionAddQuiz.equals("q"))
            {
                cancel();
                return;
            }
            
            //ANSWERS
            int loopJ = Integer.parseInt(selectionAddQuiz);
            for(int j = 0; j < loopJ; j++)
            {
                System.out.println("--------------------------------------------------------------");
                System.out.println("ADD QUIZ - QUESTION - ANSWERS\nQ. Cancel\n");
                System.out.println("Type the " + (j + 1) + ". answer:\n");
                selectionAddQuiz = scanner.nextLine();
                if(selectionAddQuiz.equals("q"))
                {
                    cancel();
                    return;
                }
                newQuestion.addAnswer(selectionAddQuiz);
            }
            
            //CORRECT ANSWER
            System.out.println("--------------------------------------------------------------");
            System.out.println("ADD QUIZ - QUESTION - CORRECT ANSWER\nQ. Cancel\n");
            System.out.println("Type the correct answer for question " + (i +1) + ":\n");
            String correctAnswer = scanner.nextLine();
            if(selectionAddQuiz.equals("q"))
            {
                cancel();
                return;
            }
            newQuestion.setCorrectAnswer(correctAnswer);
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println(newQuiz.getName() + " created.");
        
        quizes();
    }
    
    public void cancel()
    {
        System.out.println("--------------------------------------------------------------");
        System.out.println("You haven't completed all the necessary fields.");
        System.out.println("Do you still want to exit?\nQ. Yes\nW. No\n");
        selectionAddQuiz = scanner.nextLine();
        selectionAddQuiz = selectionAddQuiz.toLowerCase();
        if(selectionAddQuiz.equals("q"))
        {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Do you want to save this quiz?\nQ. Yes\nW. No\n");
            selectionAddQuiz = scanner.nextLine();
            selectionAddQuiz = selectionAddQuiz.toLowerCase();
            if(selectionAddQuiz.equals("q"))
            {
                System.out.println("--------------------------------------------------------------");
                System.out.println(database.getQuiz(numberOfQuizes - 1).getName() + " created.\n");
                System.out.println("WARNING: The quiz might break if you run it like this!\nYou can edit it later in the menu to make it work.");
                quizes();
            }
            else if(selectionAddQuiz.equals("w"))
            {
                database.removeQuiz(numberOfQuizes - 1);
                quizes();
            }
            else 
            {
                System.out.print("Valid inputs: Q and W.\n");
            }
        }
        else if(selectionAddQuiz.equals("w"))
        {
            addQuiz();
        }
        else 
        {
            System.out.print("Valid inputs: Q and W.\n");
        }
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
        
        boolean run = true;
        boolean found = false;
        while (run)
        {
            String selection = scanner.nextLine();
            selection = selection.toLowerCase();
                
            for(int i = 0; i < numberOfQuizes; i++)
            {
                if(selection.equals(inputsQuiz.get(i)))
                {
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Are you sure?\nQ. Yes\nW. No\n");
                    selection = scanner.nextLine();
                    selection = selection.toLowerCase();
                    if(selection.equals("q"))
                    {
                        database.removeQuiz(i);
                        System.out.println("--------------------------------------------------------------");
                        System.out.println(selection + " removed.");
                        
                        found = true;
                    }
                    else if(selection.equals("w"))
                    {
                        found = true;
                    }
                    
                }
            }
            
            if(found == true)
            {
                removeQuiz();
                run = false;
            }
            else if(selection.equals("q"))
            {
                quizes();
                run = false;
            }
            else 
                {
                    System.out.print("Valid inputs: ");
                    for(int i = 0; i < numberOfQuizes - 1; i++)
                    {
                        System.out.print(inputsQuiz.get(i).toUpperCase() + ", ");
                    }
                    System.out.print(inputsQuiz.get(numberOfQuizes - 1).toUpperCase());
                    System.out.println(" and Q.\n");
                }
        }
    }
    
    public void editQuiz()
    {
        numberOfQuizes = database.getNumberOfQuizes();
        
        System.out.println("--------------------------------------------------------------");
        System.out.println("EDIT QUIZ\nQ. Back\n");
     
        for(int i = 0; i < numberOfQuizes; i++)
        {
            System.out.println(inputsQuiz.get(i).toUpperCase() + ". " + database.getQuiz(i).getName());
        }
        System.out.println();
        
        boolean run = true;
        boolean found = false;
        while (run)
        {
            String selection = scanner.nextLine();
            selection = selection.toLowerCase();
                
            for(int i = 0; i < numberOfQuizes; i++)
            {
                if(selection.equals(inputsQuiz.get(i)))
                {
                    numberOfQuestions = database.getQuiz(i).getNumberOfQuestions();
                    
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("EDIT QUIZ - " + database.getQuiz(i).getName().toUpperCase() + "\nQ. Back\n");
                    
                    for(int j = 0; j < numberOfQuestions; j++)
                    {
                        System.out.println(inputsQuiz.get(j).toUpperCase() + ". " + database.getQuiz(i).getQuestion(j).getQuestion());
                    }
                    System.out.println();
                    
                    boolean run1 = true;
                    boolean found1 = false;
                    while (run1)
                    {
                        selection = scanner.nextLine();
                        selection = selection.toLowerCase();
                        
                        for(int j = 0; j < numberOfQuestions; j++)
                        {
                            if(selection.equals(inputsQuiz.get(j)))
                            {
                                numberOfAnswers = database.getQuiz(i).getQuestion(j).getNumberOfAnswers();
        
                                System.out.println("--------------------------------------------------------------");
                                System.out.print("EDIT QUIZ - " + database.getQuiz(i).getName().toUpperCase() + " - "); 
                                System.out.println(database.getQuiz(i).getQuestion(j).getQuestion() + "\nQ. Back\n");
                             
                                for(int k = 0; k < numberOfQuizes; k++)
                                {
                                    System.out.println(inputsQuiz.get(k).toUpperCase() + ". " + database.getQuiz(i).getQuestion(j).getAnswer(k));
                                }
                                System.out.println(inputsQuiz.get(numberOfQuizes).toUpperCase() + ". Correct: " + database.getQuiz(i).getQuestion(j).getCorrectAnswer());
                                System.out.println();
                                
                                boolean run2 = true;
                                boolean found2 = false;
                                while (run2)
                                {
                                    selection = scanner.nextLine();
                                    selection = selection.toLowerCase();
                                    
                                    for(int k = 0; k < numberOfAnswers; k++)
                                    {
                                        if(selection.equals(inputsQuiz.get(k)))
                                        {
                                            numberOfAnswers = database.getQuiz(i).getQuestion(j).getNumberOfAnswers();
        
                                            System.out.print("EDIT QUIZ - " + database.getQuiz(i).getName() + " - "); 
                                            System.out.print(database.getQuiz(i).getQuestion(j).getQuestion() + " - ");
                                            System.out.println(database.getQuiz(i).getQuestion(j).getAnswer(k) + "\nQ. Back\n");
                                        }
                                        if(found2 == true)
                                        {
                                            run2 = false;
                                        }
                                        else if(selection.equals("q"))
                                        {
                                            quizes();
                                            run2 = false;
                                        }
                                        else 
                                        {
                                            System.out.print("Valid inputs: ");
                                            for(int l = 0; l < numberOfQuestions - 1; l++)
                                            {
                                                System.out.print(inputsQuiz.get(l).toUpperCase() + ", ");
                                            }
                                            System.out.print(inputsQuiz.get(numberOfQuestions- 1).toUpperCase());
                                            System.out.println(" and Q.\n");
                                        }
                                    }
                                }
                            }
                            if(found1 == true)
                            {
                                run1 = false;
                            }
                            else if(selection.equals("q"))
                            {
                                quizes();
                                run1 = false;
                            }
                            else 
                            {
                                System.out.print("Valid inputs: ");
                                for(int k = 0; k < numberOfQuestions - 1; k++)
                                {
                                    System.out.print(inputsQuiz.get(k).toUpperCase() + ", ");
                                }
                                System.out.print(inputsQuiz.get(numberOfQuestions- 1).toUpperCase());
                                System.out.println(" and Q.\n");
                            }
                        }
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
                    System.out.print("Valid inputs: ");
                    for(int j = 0; j < numberOfQuizes - 1; j++)
                    {
                        System.out.print(inputsQuiz.get(j).toUpperCase() + ", ");
                    }
                    System.out.print(inputsQuiz.get(numberOfQuizes - 1).toUpperCase());
                    System.out.println(" and Q.\n");
                }
            }
        }
    }
    
    public void play()
    {
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
            
            //QUESTIONS AND ANSWERS
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
        
        database.getHighscore(database.highscores.indexOf(highscore)).setScore(database.getHighscore(database.highscores.indexOf(highscore)).getScore() + score);
        database.getHighscore(database.highscores.indexOf(highscore)).setQuestionsAnswered(database.getHighscore(database.highscores.indexOf(highscore)).getQuestionsAnswered() + round);
        database.getHighscore(database.highscores.indexOf(highscore)).setPercent();
        
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
                play();
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
                System.out.println("Valid inputs: Q, W and E.\n");
            }
        }
    }
    
    public void quit()
    {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Quitting...");
    }
}
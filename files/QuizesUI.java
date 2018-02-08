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
        database = new Database();
        database.addQuiz(quiz0);
        database.addQuiz(quiz1);
        database.addQuiz(quiz2);
        quiz0 = database.quizes.get(0);
        quiz1 = database.quizes.get(1);
        quiz2 = database.quizes.get(2);
        inputsMenu = new ArrayList<String>();
        String[] inputsArray = new String[] {"q","w","e","r","t","y","u","i"};
        inputsMenu.addAll(Arrays.asList(inputsArray));
        inputsQuiz = new ArrayList<String>();
        String[] inputsArray1 = new String[] {"a","s","d","f","g","h","j","k"};
        inputsQuiz.addAll(Arrays.asList(inputsArray));
        randomizer = new Random();
        scanner = new Scanner(System.in);
        questionsShown = new ArrayList<Integer>();
        int round = -1;
        int score = 0;
        
        menu();
    }
    
    public static void main(String[] args)
    {   
        QuizesUI quizesUI = new QuizesUI();
    }
    
    public void addOriginalQuestions()
    {
        Quiz quiz0 = new Quiz("Croatia");
        
        Question question0 = new Question("What is the capital of Croatia?");
        question0.addAnswers("Osijek");
        question0.addAnswers("Zagreb");
        question0.addAnswers("Split");
        question0.addCorrectAnswer("Zagreb");
        
        Question question1 = new Question("What famous inventor was from Croatia?");
        question1.addAnswers("Nikola Tesla");
        question1.addAnswers("Miroslav Penkala");
        question1.addAnswers("Ruder Boskovic");
        question1.addCorrectAnswer("Nikola Tesla");
        
        Question question2 = new Question("What is the name of Croatia's first king?");
        question2.addAnswers("Tomislav");
        question2.addAnswers("Marko");
        question2.addAnswers("Trpimir");
        question2.addCorrectAnswer("Tomislav");
        
        Question question3 = new Question("What is Croatia's most prestige national park?");
        question3.addAnswers("Kopacki Rit");
        question3.addAnswers("Plitvicka Jezera");
        question3.addAnswers("Kornati");
        question3.addCorrectAnswer("Plitvicka Jezera");
        
        Question question4 = new Question("Where was Game of Thrones filmed?");
        question4.addAnswers("Zadar");
        question4.addAnswers("Rijeka");
        question4.addAnswers("Dubrovnik");
        question4.addCorrectAnswer("Dubrovnik");
        
        
        Quiz quiz1 = new Quiz("League of Legends");
        
        Question question5 = new Question("What is the highest rank in Leauge of Legends");
        question5.addAnswers("Gold");
        question5.addAnswers("Master");
        question5.addAnswers("Challenger");
        question5.addCorrectAnswer("Challenger");
        
        Question question6 = new Question("What team has been the world champion the most?");
        question6.addAnswers("SKT");
        question6.addAnswers("Fnatic");
        question6.addAnswers("TSM");
        question6.addCorrectAnswer("SKT");
        
        Question question7 = new Question("Who's the best professionall League of Legends player?");
        question7.addAnswers("Uzi");
        question7.addAnswers("Faker");
        question7.addAnswers("Perkz");
        question7.addCorrectAnswer("Faker");
        
        Question question8 = new Question("What's the name of the Chinese profesional league?");
        question8.addAnswers("LCS");
        question8.addAnswers("LCK");
        question8.addAnswers("LPL");
        question8.addCorrectAnswer("LPL");
        
        Question question9 = new Question("Where were the League of Legends 2017 Worlds Finals held?");
        question9.addAnswers("The Bird's Nest");
        question9.addAnswers("Staples Center");
        question9.addAnswers("Madison Square Garden");
        question9.addCorrectAnswer("Zagreb");
        
        
        
        Quiz quiz2 = new Quiz("Geography");
        
        Question question10 = new Question("What is the capital of the USA?");
        question10.addAnswers("New York");
        question10.addAnswers("Washington D.C.");
        question10.addAnswers("Los Angeles");
        question10.addCorrectAnswer("Washington D.C.");
        
        Question question11 = new Question("Where is the Nile located?");
        question11.addAnswers("Syria");
        question11.addAnswers("Egypt");
        question11.addAnswers("Iraq");
        question11.addCorrectAnswer("Egypt");
        
        Question question12 = new Question("What is the smallest country in the world?");
        question12.addAnswers("Monaco");
        question12.addAnswers("San Marino");
        question12.addAnswers("Vatican");
        question12.addCorrectAnswer("Vatican");
        
        Question question13 = new Question("What's the second biggest country in the world?");
        question13.addAnswers("China");
        question13.addAnswers("Canada");
        question13.addAnswers("India");
        question13.addCorrectAnswer("Canada");
        
        Question question14 = new Question("What's the only Portugese speaking country in South America?");
        question14.addAnswers("Argentina");
        question14.addAnswers("Colombia");
        question14.addAnswers("Brazil");
        question14.addCorrectAnswer("Brazil");
    }
    
    public void menu()
    {        
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
                quiz = quiz0;
                startQuiz();
                run = false;
            }
            else if(selection.equals("w"))
            {
                quiz = quiz1;
                startQuiz();
                run = false;
            }
            else if(selection.equals("e"))
            {
                quiz = quiz2;
                startQuiz();
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
                
                /*System.out.print("Valid inputs: ");
                    for(int i = 0; i < numberOfAnswers - 1; i++)
                    {
                        System.out.print(inputs.get(i).toUpperCase() + ", ");
                    }
                    System.out.print(inputs.get(numberOfAnswers - 1).toUpperCase());
                    System.out.println(" and Q.\n");*/
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
            System.out.println(quiz.questions.get(choice));
            if(choice == 0)
            {
                for(int i = 0; i < quiz.questions.get(0).answers.size(); i++)
                {
                    System.out.println(inputsQuiz.get(i).toUpperCase() + ". " + quiz.questions.get(0).getAnswer(i));
                    numberOfAnswers = quiz.questions.get(0).getNumberOfAnswers();
                }
                System.out.println();
            }
            else if(choice == 1)
            {
                for(int i = 0; i < quiz.questions.get(1).answers.size(); i++)
                {
                    System.out.println(inputsQuiz.get(i).toUpperCase() + ". " + quiz.questions.get(1).getAnswer(i));
                    numberOfAnswers = quiz.questions.get(1).getNumberOfAnswers();
                }
                System.out.println();
            }
            else if(choice == 2)
            {
                for(int i = 0; i < quiz.questions.get(2).answers.size(); i++)
                {
                    System.out.println(inputsQuiz.get(i).toUpperCase() + ". " + quiz.questions.get(2).getAnswer(i));
                    numberOfAnswers = quiz.questions.get(2).getNumberOfAnswers();
                }
                System.out.println();
            }
            else if(choice == 3)
            {
                for(int i = 0; i < quiz.questions.get(3).answers.size(); i++)
                {
                    System.out.println(inputsQuiz.get(i).toUpperCase() + ". " + quiz.questions.get(3).getAnswer(i));
                    numberOfAnswers = quiz.questions.get(3).getNumberOfAnswers();
                }
                System.out.println();
            }
            else if(choice == 4)
            {
                for(int i = 0; i < quiz.questions.get(4).answers.size(); i++)
                {
                    System.out.println(inputsQuiz.get(i).toUpperCase() + ". " + quiz.questions.get(4).getAnswer(i));
                    numberOfAnswers = quiz.questions.get(4).getNumberOfAnswers();
                }
                System.out.println();
            }
            
            //ANSWER
            boolean run = true;
            while (run)
            {
                String selection = scanner.nextLine();
                selection = selection.toLowerCase();
                //selection = ;
                
                for(int i = 0; i < numberOfAnswers; i++)
                {
                    if(selection.equals(inputsQuiz.get(i)))
                    {
                        if (selection.equals(quiz.questions.get(choice).getCorrectAnswer()))
                        {
                            System.out.println("\nCorrect!");
                            score = score + 1;
                        }
                        else
                        {
                            System.out.println("\nIncorrect, the correct answer was " + quiz.questions.get(choice).getCorrectAnswer().toUpperCase() + ".");
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
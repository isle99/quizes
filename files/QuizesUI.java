
/*public class QuizesUI
{

    public SignUp signUp;
    public Login login;
    public Database database;
    public Write write;
    public Read read;
    public ArrayList<String> inputsMenu;
    public ArrayList<String> inputsQuiz;
    public Random randomizer;
    public Scanner scanner;
    public int round;
    public int score;
    public int numberOfQuizes;
    public int numberOfAccounts;
    public Quiz quiz;
    public Account account;
    public int numberOfQuestions;
    public int numberOfAnswers;
    public int choice;
    public ArrayList<Integer> questionsShown;
    public float percent;
    public boolean same;
    public String selection;
    public String selectionAddQuiz;
    public String username;
    public String password;
    
    public QuizesUI()
    {
        login = new Login();
        signUp = login.signUp;
        read = new Read();
        write = new Write();
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
    
    public void menu()
    {   
        //CREATE ACCOUNT
        if (round == -1)
        {       
            while(login.run == true)
            {
                username = login.username;
                password = login.password;
            }
            account = new Account(username, password, database);
            database.addAccount(account);
            write.serializeAccount(account);
            
            round = round + 1;
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
        numberOfAccounts = database.getNumberOfAccounts();
        
        System.out.println("--------------------------------------------------------------");
        System.out.println("HIGHSCORES\nQ. Back\n");
     
        for(int i = 0; i < numberOfAccounts; i++)
        {
            System.out.print((i + 1) + ". " + database.getAccount(i).getUsername() + " - " + database.getAccount(i).getScore());
            System.out.println("/" + database.getAccount(i).getQuestionsAnswered() + " - " + database.getAccount(i).getPercent() + "%");
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
        Quiz newQuiz = new Quiz(selectionAddQuiz, database);
        database.addQuiz(newQuiz);
        numberOfQuizes = database.getNumberOfQuizes();
        write.serializeQuiz(newQuiz);
        
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
            Question newQuestion = new Question(selectionAddQuiz, newQuiz);
            newQuiz.addQuestion(newQuestion);
            write.serializeQuestion(newQuestion, newQuiz);
            
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
        
        write.serializeQuiz(newQuiz);
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
}
*/
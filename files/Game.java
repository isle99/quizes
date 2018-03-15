/*
public class Game
{
    
    public Game()
    {
        
    }

    public void play()
    {
        int choice = randomizer.nextInt(quiz.getNumberOfQuestions());
        boolean found;
        while (round < quiz.getNumberOfQuestions())
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
        System.out.println("Username: \n" + username + "\n");
        System.out.println("Final score: \n" + score + " out of " + round + ".\n");
        System.out.println("Final percentage: \n" + percent + "%\n");
        System.out.println("Q. Main Menu\nW. Quit\n");
        
        database.getAccount(database.accounts.indexOf(account)).setScore(database.getAccount(database.accounts.indexOf(account)).getScore() + score);
        database.getAccount(database.accounts.indexOf(account)).setQuestionsAnswered(database.getAccount(database.accounts.indexOf(account)).getQuestionsAnswered() + round);
        database.getAccount(database.accounts.indexOf(account)).calculatePercent();
        write.serializeAccount(account);
        
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
}
*/
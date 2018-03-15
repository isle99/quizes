import java.io.Serializable;
import java.util.ArrayList;
import java.io.*;

public class Database implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    public ArrayList<Quiz> quizes;
    public ArrayList<Account> accounts;
    int numberOfAccounts;
    public Read read;

    public Database()
    {
        quizes = new ArrayList<Quiz>();
        accounts = new ArrayList<Account>();
        readData();
    }
    
    public void readData()
    {
        read = new Read();
        
        //ACCOUNTS       
        int k = 0;
        numberOfAccounts = new File(".\\database\\accounts\\").listFiles().length;
       
        if (numberOfAccounts > 0)
        {
            while(k < numberOfAccounts)
            {
                String currentAccount = "account" + k;
                
                Account account = read.deserialzeAccount(".\\database\\accounts\\" + currentAccount + ".ser");
                addAccount(account);
    
                k++;
            }
        }
        
        //QUIZES
        int i = 0;
        int numberOfQuizes = new File(".\\database\\quizes\\").listFiles().length;
        while(i < numberOfQuizes)
        {
            String currentQuiz = "quiz" + i;
            
            Quiz quiz = read.deserialzeQuiz(".\\database\\quizes\\" + currentQuiz + "\\" + currentQuiz + ".ser");
            addQuiz(quiz);
            
            int j = 0;
            int numberOfQuestions = new File(".\\database\\quizes\\" + currentQuiz + "\\questions").listFiles().length;
            while(j < numberOfQuestions)
            {
                String currentQuestion = "question" + j;
                Question question = read.deserialzeQuestion(".\\database\\quizes\\" + currentQuiz + "\\questions\\" + currentQuestion + ".ser");
                quiz.addQuestion(question);
                
                j++;
            }
            
            i++;
        }
    }
    
    public Quiz getQuiz(int index)
    {
        return quizes.get(index);
    }
    
    public int getNumberOfQuizes()
    {
        return quizes.size();
    }
    
    public Account getAccount(int index)
    {
        return accounts.get(index);
    }
    
    public int getNumberOfAccounts()
    {
        return accounts.size();
    }

    public void addQuiz(Quiz quiz)
    {
        quizes.add(quiz);
    }
    
    public void addAccount(Account account)
    {
        accounts.add(account);
    }
    
    public void removeQuiz(int index)
    {
        quizes.remove(index);
    }

    public void removeAccount(int index)
    {
        accounts.remove(index);
    }
    
    public void removeAllQuizes()
    {
        quizes.clear();
    }
    
    public void removeAllAccounts()
    {
        accounts.clear();
    }
}
import java.util.ArrayList;
import java.io.Serializable;

public class Account implements Serializable
{   
    private static final long serialVersionUID = 1L;
    
    public Database database;
    public String username;
    public String password;
    public int number;
    public int score;
    public int questionsAnswered;
    public float percent;
    
    public Account(String username, String password, Database database)
    {
        this.username = username;
        this.password = password;
        score = 0;
        questionsAnswered = 0;
        percent = 0;
        
        number = 0;
        boolean run = true;
        while(run == true)
        {
            if (database.getNumberOfAccounts() == 0)
            {
                run = false;
            }
            for (int i = 0; i < database.getNumberOfAccounts(); i++)
            {
                if (database.getAccount(i).getNumber() != number)
                {
                    run = false;
                    break;
                }
                else
                {
                    number = number + 1;
                }
            }
        }
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public int getNumber()
    {
        return number;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public int getQuestionsAnswered()
    {
        return questionsAnswered;
    }
    
    public float getPercent()
    {
        return percent;
    }
    
    public void setUsername(String name)
    {
        this.username = username;
    }
    
    public void setPassword()
    {
        this.password = password;
    }
    
    public void setScore(int score)
    {
        this.score = score;
    }
    
    public void setQuestionsAnswered(int questionsAnswered)
    {
        this.questionsAnswered = questionsAnswered;
    }
    
    public void calculatePercent()
    {
        percent = (float) score / questionsAnswered * 100;
    }
}

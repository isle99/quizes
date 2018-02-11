import java.util.ArrayList;
import java.io.Serializable;

public class Highscore implements Serializable
{   
    private static final long serialVersionUID = 1L;
    
    public String name;
    public int score;
    public int questionsAnswered;
    public float percent;
    
    public Highscore(String name, int score, int questionsAnswered)
    {
        this.name = name;
        this.score = score;
        this.questionsAnswered = questionsAnswered;
        if (score > 0 && questionsAnswered > 0)
        {
            percent = score / questionsAnswered;
        }
        else
        {
            percent = 0;
        }
    }
    
    public String getName()
    {
        return name;
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
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setScore(int score)
    {
        this.score = score;
    }
    
    public void setQuestionsAnswered(int questionsAnswered)
    {
        this.questionsAnswered = questionsAnswered;
    }
    
    public void setPercent()
    {
        percent = (float) score / questionsAnswered * 100;
    }
}

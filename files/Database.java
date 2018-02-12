import java.io.Serializable;
import java.util.ArrayList;

public class Database implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    public ArrayList<Quiz> quizes;
    public ArrayList<Highscore> highscores;

    public Database()
    {
        quizes = new ArrayList<Quiz>();
        highscores = new ArrayList<Highscore>();
    }
    
    public Quiz getQuiz(int index)
    {
        return quizes.get(index);
    }
    
    public int getNumberOfQuizes()
    {
        return quizes.size();
    }
    
    public Highscore getHighscore(int index)
    {
        return highscores.get(index);
    }
    
    public int getNumberOfHighscores()
    {
        return highscores.size();
    }

    public void addQuiz(Quiz quiz)
    {
        quizes.add(quiz);
    }
    
    public void addHighscore(Highscore highscore)
    {
        highscores.add(highscore);
    }
    
    public void removeQuiz(int index)
    {
        quizes.remove(index);
    }

    public void removeHighscore(int index)
    {
        highscores.remove(index);
    }
    
    public void removeAllQuizes()
    {
        quizes.clear();
    }
    
    public void removeAllHighscores()
    {
        highscores.clear();
    }
}
import java.io.Serializable;
import java.util.ArrayList;
import java.io.*;

public class Database implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    public ArrayList<Quiz> quizes;
    public ArrayList<Highscore> highscores;
    public Read read;

    public Database()
    {
        quizes = new ArrayList<Quiz>();
        highscores = new ArrayList<Highscore>();
        readQuizes();
    }
    
    public void readQuizes()
    {
        read = new Read();
        
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
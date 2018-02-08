import java.util.*;

public class Question
{   
    public String question;
    public ArrayList<String> answers;
    public int numberOfAnswers;
    public String correctAnswer;
    
    public Question(String question)
    {
        this.question = question;
        answers = new ArrayList<String>();
    }
    
    public void addAnswers(String answer)
    {
        answers.add(answer);
    }
    
    public void addCorrectAnswer(String correctAnswer)
    {
        this.correctAnswer = correctAnswer;
    }
    
    public String getQuestion()
    {
        return question;
    }
    
    public String getAnswer(int index)
    {
        return answers.get(index);
    }
    
    public int getNumberOfAnswers()
    {
        return numberOfAnswers;
    }
    
    public String getCorrectAnswer()
    {
        return correctAnswer;
    }
}

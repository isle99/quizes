import java.util.ArrayList;

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
    
    public String getQuestion()
    {
        return question;
    }
    
    public String getAnswer(int index)
    {
        return answers.get(index);
    }
    
    public String getCorrectAnswer()
    {
        return correctAnswer;
    }
    
    public int getNumberOfAnswers()
    {
        numberOfAnswers = answers.size();
        return numberOfAnswers;
    }
    
    public void addAnswer(String answer)
    {
        answers.add(answer);
    }
    
    public void removeAnswer(int index)
    {
        answers.remove(index);
    }
    
    public void removeAllAnswers()
    {
        answers.clear();
        numberOfAnswers= answers.size();
    }
    
    public void setCorrectAnswer(String correctAnswer)
    {
        this.correctAnswer = correctAnswer;
    }
}

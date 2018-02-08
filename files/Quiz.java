import java.util.*;

public class Quiz
{   
    public String name;
    public ArrayList<Question> questions;
    public int numberOfQuestions;
    public ArrayList<String> questionCorrectAnswers;
    
    public Quiz(String name)
    {
        this.name = name;
        numberOfQuestions = 0;
        questions = new ArrayList<Question>();
        questionCorrectAnswers = new ArrayList<String>();
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getNumberOfQuestions()
    {
        return numberOfQuestions;
    }
    
    public void addQuestion(Question question)
    {
        questions.add(question);
        numberOfQuestions = questions.size();
    }
}

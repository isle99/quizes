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
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getNumberOfQuestions()
    {
        return numberOfQuestions;
    }
    
    public Question getQuestion(int index)
    {
        return questions.get(index);
    }
    
    public void addQuestion(Question question)
    {
        questions.add(question);
        numberOfQuestions = questions.size();
    }
    
    public void removeQuestion(int index)
    {
        questions.remove(index);
        numberOfQuestions = questions.size();
    }
    
    public void removeAllQuestions()
    {
        questions.clear();
        numberOfQuestions = questions.size();
    }
}

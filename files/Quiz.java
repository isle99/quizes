import java.util.ArrayList;

public class Quiz
{   
    public String name;
    public ArrayList<Question> questions;
    public int numberOfQuestions;
    
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
    
    public Question getQuestion(int index)
    {
        return questions.get(index);
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
    
    public void setName()
    {
        this.name = name;
    }
}

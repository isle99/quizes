import java.util.ArrayList;
import java.io.Serializable;

public class Quiz implements Serializable
{   
    private static final long serialVersionUID = 1L;
    
    public Database database;
    public String name;
    public int number;
    public ArrayList<Question> questions;
    public int numberOfQuestions;
    
    public Quiz(String name, Database database)
    {
        this.database = database;
        this.name = name;
        numberOfQuestions = 0;
        questions = new ArrayList<Question>();
        number = 0;
        boolean run = true;
        while(run == true)
        {
            boolean found = true;
            if (database.getNumberOfQuizes() == 0)
            {
                found = false;
            }
            for (int i = 0; i < database.getNumberOfQuizes(); i++)
            {
                if (database.getQuiz(i).getNumber() != number)
                {
                    found = false;
                }
                else
                {
                    number = number + 1;
                }
            } 
            if (found == false)
            {
                run = false;
            }
        }
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getNumber()
    {
        return number;
    }
    
    public Question getQuestion(int index)
    {
        return questions.get(index);
    }
    
    public int getNumberOfQuestions()
    {
        return numberOfQuestions;
    }
    
    public void setName(String name)
    {
        this.name = name;
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

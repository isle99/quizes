import java.util.ArrayList;
import java.io.Serializable;

public class Question implements Serializable
{   
    private static final long serialVersionUID = 1L;
    
    public Quiz quiz;
    public String question;
    public int number;
    public ArrayList<String> answers;
    public int numberOfAnswers;
    public String correctAnswer;
    
    public Question(String question, Quiz quiz)
    {
        this.quiz = quiz;
        this.question = question;
        answers = new ArrayList<String>();
        number = 0;
        boolean run = true;
        while(run == true)
        {
            boolean found = true;
            if (quiz.getNumberOfQuestions() == 0)
            {
                found = false;
            }
            for (int i = 0; i < quiz.getNumberOfQuestions(); i++)
            {
                if (quiz.getQuestion(i).getNumber() != number)
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
    
    public String getQuestion()
    {
        return question;
    }
    
    public int getNumber()
    {
        return number;
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
    
    public void setCorrectAnswer(String correctAnswer)
    {
        this.correctAnswer = correctAnswer;
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
}

import java.util.*;

public class Quiz
{   
    public String name;
    public ArrayList<Integer> questionsShown;
    public ArrayList<String> questions;
    public int numberOfQuestions;
    public ArrayList<String> questionAnswers0;
    public ArrayList<String> questionAnswers1;
    public ArrayList<String> questionAnswers2;
    public ArrayList<String> questionCorrectAnswers;
    
    public Quiz(String name)
    {
        this.name = name;
        questionsShown = new ArrayList<Integer>();
        numberOfQuestions = 0;
        questions = new ArrayList<String>();
        questionAnswers0 = new ArrayList<String>();
        questionAnswers1 = new ArrayList<String>();
        questionAnswers2 = new ArrayList<String>();
        questionCorrectAnswers = new ArrayList<String>();
    }
    
    public String getName()
    {
        return name;
    }
    
    public void addQuestion(String question)
    {
        questions.add(question);
    }
    
    public void addAnswers0(String answer)
    {
        questionAnswers0.add(answer);
    }
    
    public void addAnswers1(String answer)
    {
        questionAnswers1.add(answer);
    }
    
    public void addAnswers2(String answer)
    {
        questionAnswers2.add(answer);
    }
    
    public void addCorrectAnswer(String correctAnswer)
    {
        questionCorrectAnswers.add(correctAnswer);
    }
}

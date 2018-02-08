import java.util.ArrayList;

public class Database
{
    public ArrayList<Quiz> quizes;

    public Database()
    {
        quizes = new ArrayList<Quiz>();
    }

    public void addQuiz(Quiz quiz)
    {
        quizes.add(quiz);
    }

    /*public String list()
    {
        String theList = "";
        for (Quiz quiz : quizes )
        {            
             theList = theList + quiz.getDetails() +"\n";
        }    
        return theList;
    }*/
}
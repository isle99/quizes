import java.util.ArrayList;

public class Database
{
    public ArrayList<Quiz> quizes;
    public QuizesUI quizesUI;

    public Database()
    {
        quizes = new ArrayList<Quiz>();
    }

    public void addQuiz(Quiz quiz)
    {
        quizes.add(quiz);
    }
}
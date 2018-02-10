import java.util.ArrayList;

public class Database
{
    public ArrayList<Quiz> quizes;
    public QuizesUI quizesUI;

    public Database()
    {
        quizes = new ArrayList<Quiz>();
        addOriginalQuizes();
    }
    
    public Quiz getQuiz(int index)
    {
        return quizes.get(index);
    }
    
    public int getNumberOfQuizes()
    {
        return quizes.size();
    }

    public void addQuiz(Quiz quiz)
    {
        quizes.add(quiz);
    }
    
    public void removeQuiz(int index)
    {
        quizes.remove(index);
    }
    
    public void removeAllQuizes()
    {
        quizes.clear();
    }
    
    public void addOriginalQuizes()
    {
        Quiz quiz0 = new Quiz("Croatia");      
        addQuiz(quiz0);
        
        Question question0 = new Question("What is the capital of Croatia?");
        quiz0.addQuestion(question0);
        question0.addAnswer("Osijek");
        question0.addAnswer("Zagreb");
        question0.addAnswer("Split");
        question0.setCorrectAnswer("Zagreb");
        
        Question question1 = new Question("What famous inventor was from Croatia?");
        quiz0.addQuestion(question1);
        question1.addAnswer("Nikola Tesla");
        question1.addAnswer("Miroslav Penkala");
        question1.addAnswer("Ruder Boskovic");
        question1.setCorrectAnswer("Nikola Tesla");
        
        Question question2 = new Question("What is the name of Croatia's first king?");
        quiz0.addQuestion(question2);
        question2.addAnswer("Tomislav");
        question2.addAnswer("Marko");
        question2.addAnswer("Trpimir");
        question2.setCorrectAnswer("Tomislav");
        
        Question question3 = new Question("What is Croatia's most prestige national park?");
        quiz0.addQuestion(question3);
        question3.addAnswer("Kopacki Rit");
        question3.addAnswer("Plitvicka Jezera");
        question3.addAnswer("Kornati");
        question3.setCorrectAnswer("Plitvicka Jezera");
        
        Question question4 = new Question("Where was Game of Thrones filmed?");
        quiz0.addQuestion(question4);
        question4.addAnswer("Zadar");
        question4.addAnswer("Rijeka");
        question4.addAnswer("Dubrovnik");
        question4.setCorrectAnswer("Dubrovnik");
        
        
        
        Quiz quiz1 = new Quiz("League of Legends");
        addQuiz(quiz1);
        
        Question question5 = new Question("What is the highest rank in Leauge of Legends");
        quiz1.addQuestion(question5);
        question5.addAnswer("Gold");
        question5.addAnswer("Master");
        question5.addAnswer("Challenger");
        question5.setCorrectAnswer("Challenger");
        
        Question question6 = new Question("What team has been the world champion the most?");
        quiz1.addQuestion(question6);
        question6.addAnswer("SKT");
        question6.addAnswer("Fnatic");
        question6.addAnswer("TSM");
        question6.setCorrectAnswer("SKT");
        
        Question question7 = new Question("Who's the best professionall League of Legends player?");
        quiz1.addQuestion(question7);
        question7.addAnswer("Uzi");
        question7.addAnswer("Faker");
        question7.addAnswer("Perkz");
        question7.setCorrectAnswer("Faker");
        
        Question question8 = new Question("What's the name of the Chinese profesional league?");
        quiz1.addQuestion(question8);
        question8.addAnswer("LCS");
        question8.addAnswer("LCK");
        question8.addAnswer("LPL");
        question8.setCorrectAnswer("LPL");
        
        Question question9 = new Question("Where were the League of Legends 2017 Worlds Finals held?");
        quiz1.addQuestion(question9);
        question9.addAnswer("The Bird's Nest");
        question9.addAnswer("Staples Center");
        question9.addAnswer("Madison Square Garden");
        question9.setCorrectAnswer("Zagreb");
        
        
        
        Quiz quiz2 = new Quiz("Geography");
        addQuiz(quiz2);
        
        Question question10 = new Question("What is the capital of the USA?");
        quiz2.addQuestion(question10);
        question10.addAnswer("New York");
        question10.addAnswer("Washington D.C.");
        question10.addAnswer("Los Angeles");
        question10.setCorrectAnswer("Washington D.C.");
        
        Question question11 = new Question("Where is the Nile located?");
        quiz2.addQuestion(question11);
        question11.addAnswer("Syria");
        question11.addAnswer("Egypt");
        question11.addAnswer("Iraq");
        question11.setCorrectAnswer("Egypt");
        
        Question question12 = new Question("What is the smallest country in the world?");
        quiz2.addQuestion(question12);
        question12.addAnswer("Monaco");
        question12.addAnswer("San Marino");
        question12.addAnswer("Vatican");
        question12.setCorrectAnswer("Vatican");
        
        Question question13 = new Question("What's the second biggest country in the world?");
        quiz2.addQuestion(question13);
        question13.addAnswer("China");
        question13.addAnswer("Canada");
        question13.addAnswer("India");
        question13.setCorrectAnswer("Canada");
        
        Question question14 = new Question("What's the only Portugese speaking country in South America?");
        quiz2.addQuestion(question14);
        question14.addAnswer("Argentina");
        question14.addAnswer("Colombia");
        question14.addAnswer("Brazil");
        question14.setCorrectAnswer("Brazil");
    }
}
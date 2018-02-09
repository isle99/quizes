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
    
    public void removeQuizes()
    {
        quizes.clear();
    }
    
    public void addOriginalQuizes()
    {
        Quiz quiz0 = new Quiz("Croatia");      
        addQuiz(quiz0);
        
        Question question0 = new Question("What is the capital of Croatia?");
        quiz0.addQuestion(question0);
        question0.addAnswers("Osijek");
        question0.addAnswers("Zagreb");
        question0.addAnswers("Split");
        question0.setCorrectAnswer("Zagreb");
        
        Question question1 = new Question("What famous inventor was from Croatia?");
        quiz0.addQuestion(question1);
        question1.addAnswers("Nikola Tesla");
        question1.addAnswers("Miroslav Penkala");
        question1.addAnswers("Ruder Boskovic");
        question1.setCorrectAnswer("Nikola Tesla");
        
        Question question2 = new Question("What is the name of Croatia's first king?");
        quiz0.addQuestion(question2);
        question2.addAnswers("Tomislav");
        question2.addAnswers("Marko");
        question2.addAnswers("Trpimir");
        question2.setCorrectAnswer("Tomislav");
        
        Question question3 = new Question("What is Croatia's most prestige national park?");
        quiz0.addQuestion(question3);
        question3.addAnswers("Kopacki Rit");
        question3.addAnswers("Plitvicka Jezera");
        question3.addAnswers("Kornati");
        question3.setCorrectAnswer("Plitvicka Jezera");
        
        Question question4 = new Question("Where was Game of Thrones filmed?");
        quiz0.addQuestion(question4);
        question4.addAnswers("Zadar");
        question4.addAnswers("Rijeka");
        question4.addAnswers("Dubrovnik");
        question4.setCorrectAnswer("Dubrovnik");
        
        
        
        Quiz quiz1 = new Quiz("League of Legends");
        addQuiz(quiz1);
        
        Question question5 = new Question("What is the highest rank in Leauge of Legends");
        quiz1.addQuestion(question5);
        question5.addAnswers("Gold");
        question5.addAnswers("Master");
        question5.addAnswers("Challenger");
        question5.setCorrectAnswer("Challenger");
        
        Question question6 = new Question("What team has been the world champion the most?");
        quiz1.addQuestion(question6);
        question6.addAnswers("SKT");
        question6.addAnswers("Fnatic");
        question6.addAnswers("TSM");
        question6.setCorrectAnswer("SKT");
        
        Question question7 = new Question("Who's the best professionall League of Legends player?");
        quiz1.addQuestion(question7);
        question7.addAnswers("Uzi");
        question7.addAnswers("Faker");
        question7.addAnswers("Perkz");
        question7.setCorrectAnswer("Faker");
        
        Question question8 = new Question("What's the name of the Chinese profesional league?");
        quiz1.addQuestion(question8);
        question8.addAnswers("LCS");
        question8.addAnswers("LCK");
        question8.addAnswers("LPL");
        question8.setCorrectAnswer("LPL");
        
        Question question9 = new Question("Where were the League of Legends 2017 Worlds Finals held?");
        quiz1.addQuestion(question9);
        question9.addAnswers("The Bird's Nest");
        question9.addAnswers("Staples Center");
        question9.addAnswers("Madison Square Garden");
        question9.setCorrectAnswer("Zagreb");
        
        
        
        Quiz quiz2 = new Quiz("Geography");
        addQuiz(quiz2);
        
        Question question10 = new Question("What is the capital of the USA?");
        quiz2.addQuestion(question10);
        question10.addAnswers("New York");
        question10.addAnswers("Washington D.C.");
        question10.addAnswers("Los Angeles");
        question10.setCorrectAnswer("Washington D.C.");
        
        Question question11 = new Question("Where is the Nile located?");
        quiz2.addQuestion(question11);
        question11.addAnswers("Syria");
        question11.addAnswers("Egypt");
        question11.addAnswers("Iraq");
        question11.setCorrectAnswer("Egypt");
        
        Question question12 = new Question("What is the smallest country in the world?");
        quiz2.addQuestion(question12);
        question12.addAnswers("Monaco");
        question12.addAnswers("San Marino");
        question12.addAnswers("Vatican");
        question12.setCorrectAnswer("Vatican");
        
        Question question13 = new Question("What's the second biggest country in the world?");
        quiz2.addQuestion(question13);
        question13.addAnswers("China");
        question13.addAnswers("Canada");
        question13.addAnswers("India");
        question13.setCorrectAnswer("Canada");
        
        Question question14 = new Question("What's the only Portugese speaking country in South America?");
        quiz2.addQuestion(question14);
        question14.addAnswers("Argentina");
        question14.addAnswers("Colombia");
        question14.addAnswers("Brazil");
        question14.setCorrectAnswer("Brazil");
    }
}
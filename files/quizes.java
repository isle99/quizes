import java.util.*;

public class Quizes
{      
    public static int quiz;
    public static int numberOfQuestions;
    public static ArrayList<String> questionList = new ArrayList<String>();
    public static ArrayList<String> questionAnswer0 = new ArrayList<String>();
    public static ArrayList<String> questionAnswer1 = new ArrayList<String>();
    public static ArrayList<String> questionAnswer2 = new ArrayList<String>();
    public static ArrayList<String> questionAnswer3 = new ArrayList<String>();
    public static ArrayList<String> questionAnswer4 = new ArrayList<String>();
    public static ArrayList<String> questionCorrectAnswers = new ArrayList<String>();
    public static ArrayList<Integer> questionShown = new ArrayList<Integer>();
    
    public Quizes ()
    {
       
    }
    
    public static void quiz0()
    {
        questionList.add("What is the capital of Croatia?");
        questionAnswer0.add("Osijek");
        questionAnswer0.add("Zagreb");
        questionAnswer0.add("Split");
        questionAnswer0.add("Dubrovnik");
        questionCorrectAnswers.add("s");
        
        questionList.add("What famous inventor was from Croatia?");
        questionAnswer1.add("Nikola Tesla");
        questionAnswer1.add("Miroslav Penkala");
        questionAnswer1.add("Ruder Boskovic");
        questionCorrectAnswers.add("a");
        
        questionList.add("What is the name of Croatia's first king?");
        questionAnswer2.add("Tomislav");
        questionAnswer2.add("Marko");
        questionAnswer2.add("Trpimir");
        questionCorrectAnswers.add("a");
        
        questionList.add("What is Croatia's most prestige national park?");
        questionAnswer3.add("Kopacki Rit");
        questionAnswer3.add("Plitvicka Jezera");
        questionAnswer3.add("Kornati");
        questionCorrectAnswers.add("s");
        
        questionList.add("Where was Game of Thrones filmed?");
        questionAnswer4.add("Zadar");
        questionAnswer4.add("Rijeka");
        questionAnswer4.add("Dubrovnik");
        questionCorrectAnswers.add("d");
        
        numberOfQuestions = questionList.size();
    }
    
    public static void quiz1()
    {
        questionList.add("What is the highest rank in Leauge of Legends");
        questionAnswer0.add("Master");
        questionAnswer0.add("Challenger");
        questionAnswer0.add("Gold");
        questionCorrectAnswers.add("s");
    
        questionList.add("What team has been the world champion the most?");
        questionAnswer1.add("SKT");
        questionAnswer1.add("Fnatic");
        questionAnswer1.add("Samsung");
        questionCorrectAnswers.add("a");

        questionList.add("Who's the best professionall League of Legends player?");
        questionAnswer2.add("Uzi");
        questionAnswer2.add("Bjergsen");
        questionAnswer2.add("Faker");
        questionCorrectAnswers.add("d");
    
        questionList.add("What's the name of the Chinese profesional league?");
        questionAnswer3.add("LPL");
        questionAnswer3.add("LCK");
        questionAnswer3.add("LCS");
        questionCorrectAnswers.add("a");
    
        questionList.add("Where were the League of Legends 2017 Worlds Finals held?");
        questionAnswer4.add("The Bird's Nest");
        questionAnswer4.add("Staples Center");
        questionAnswer4.add("Madison Square Garden");
        questionCorrectAnswers.add("a");
        
        numberOfQuestions = questionList.size();
    }
    
    public static void quiz2()
    {
        questionAnswer0.add("Los Angeles");
        questionAnswer0.add("New York");
        questionAnswer0.add("Washington D.C.");
        
        questionAnswer1.add("Iraq");
        questionAnswer1.add("Egypt");
        questionAnswer1.add("Israel");
        
        questionAnswer2.add("San Marino");
        questionAnswer2.add("Monaco");
        questionAnswer2.add("Vatican");
        
        questionAnswer3.add("China");
        questionAnswer3.add("Canada");
        questionAnswer3.add("Australia");
        
        questionAnswer4.add("Argentina");
        questionAnswer4.add("Brasil");
        questionAnswer4.add("Chile");
        
        questionList.add("What is the capital of the USA?");
        questionCorrectAnswers.add("d");
        
        questionList.add("Where is the Nile located?");
        questionCorrectAnswers.add("s");
        
        questionList.add("What is the smallest country in the world?");
        questionCorrectAnswers.add("d");
        
        questionList.add("What's the second biggest country in the world?");
        questionCorrectAnswers.add("s");
        
        questionList.add("What's the only Portugese speaking country in South America?");
        questionCorrectAnswers.add("s");
        
        numberOfQuestions = questionList.size();
    }
}

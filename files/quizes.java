import java.util.*;

public class Quizes
{      
    public static int quiz;
    public static ArrayList<String> questionList = new ArrayList<String>();
    public static ArrayList<String> questionAnswers = new ArrayList<String>();
    public static ArrayList<Integer> questionShown = new ArrayList<Integer>();
    
    public Quizes ()
    {
        
    }
    
    public static void a()
    {
        //System.out.println("--------------------------------------------------------------");
        //System.out.println("CROATIA\n");
        quiz = 0;
        
        questionList.add("What is the capital of Croatia? \nA. Osijek\nS. Zagreb\nD. Split\n");
        questionAnswers.add("s");
        questionList.add("What famous inventor was from Croatia? \nA. Nikola Tesla\nS. Miroslav Penkala\nD. Ruder Boskovic\n");
        questionAnswers.add("a");
        questionList.add("What is the name of Croatia's first king? \nA. Tomislav\nS. Marko\nD. Trpimir\n");
        questionAnswers.add("a");
        questionList.add("What is Croatia's most prestige national park? \nA. Kopacki Rit\nS. Plitvicka Jezera\nD. Kornati\n");
        questionAnswers.add("s");
        questionList.add("Where was Game of Thrones filmed? \nA. Zadar\nS. Rijeka\nD. Dubrovnik\n");
        questionAnswers.add("d");
        
        Game.start();
    }
    
    public static void b()
    {
        //System.out.println("--------------------------------------------------------------");
        //System.out.println("LEAGUE OF LEGENDS\n");
        quiz = 1;
        
        questionList.add("What is the highest rank in Leauge of Legends?\nA. Master\nS. Challenger\nD. Gold\n");
        questionAnswers.add("s");
        questionList.add("What team has been the world champion the most?\nA. SKT\nS. Fnatic\nD. Samsung\n");
        questionAnswers.add("a");
        questionList.add("Who's the best professionall League of Legends player?\nA. Uzi\nS. Bjergsen\nD. Faker\n");
        questionAnswers.add("d");
        questionList.add("What's the name of the Chinese profesional league?\nA. LPL\nS. LCK\nD. LCS\n");
        questionAnswers.add("a");
        questionList.add("Where were the League of Legends 2017 Worlds Finals held?\nA. The Bird's Nest\nS. Staples Center\nD. Madison Square Garden\n");
        questionAnswers.add("a");
        
        Game.start();
    }
    
    public static void c()
    {
        //System.out.println("--------------------------------------------------------------");
        //System.out.println("GEOGRAPHY\n");
        quiz = 2;
        
        questionList.add("What is the capital of the USA? \nA. Los Angeles\nS. New York\nD. Washington D.C.\n");
        questionAnswers.add("d");
        questionList.add("Where is the Nile located? \nA. Iraq\nS. Egypt\nD. Israel\n");
        questionAnswers.add("s");
        questionList.add("What is the smallest country in the world? \nA. San Marino\nS. Monaco\nD. Vatican\n");
        questionAnswers.add("d");
        questionList.add("What's the second biggest country in the world? \nA. China\nS. Canada\nD. Australia\n");
        questionAnswers.add("s");
        questionList.add("What's the only Portugese speaking country in South America? \nA. Argentina\nS. Brasil\nD. Chile\n");
        questionAnswers.add("s");
        questionList.add("Which ocean lies on the east coast of the United States? \nA. Pacific\nS. Indian\nD. Atlantic\n");
        questionAnswers.add("d");
        questionList.add("Which is the world's highest mountain? \nA. Mount Everest\nS. Kilimanjaro\nD. Makalu\n");
        questionAnswers.add("a");
        questionList.add("How many Great Lakes are there? \nA. 5\nS. 6\nD. 3\n");
        questionAnswers.add("a");
        questionList.add("What is the biggest desert in the world? \nA. The Arabian Desert\nS. The Great Australian Desert\nD. Sahara\n");
        questionAnswers.add("d");
        questionList.add("The United Kingdom is comprised of how many countries? \nA. 5\nS. 4\nD. 6\n");
        questionAnswers.add("s");
        
        Game.start();
    }
}

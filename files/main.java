import java.util.*;

public class Main
{
    public static ArrayList<String> inputs = new ArrayList<String>();
    
    public Main()
    {

    }
    
    public static void main(String[] args)
    {   
        Main main = new Main();
        Menu menu = new Menu();
        Game game = new Game();
        Quizes quizes = new Quizes();
        menu.start();
    }
    
    public static void quit()
    {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Quitting...");
    }
}
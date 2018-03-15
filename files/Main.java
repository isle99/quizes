
public class Main
{
    /**
     * Constructor for objects of class Main
     */
    public Main() { }

    public static void main(String[] args)
    {   
        Write write = new Write();
        Database database = new Database();
        write.serializeDatabase(database);
        Login login = new Login();
    }
}

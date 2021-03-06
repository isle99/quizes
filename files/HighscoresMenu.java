import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*; 

public class HighscoresMenu extends JFrame implements ActionListener 
{
      public JTextField usernameText;
      public JTextField passwordText;
      public String username;
      public String password;
      public Database database;
    
      public HighscoresMenu() 
      { 
          super("Quizes");
          Read read = new Read();
          database = read.deserialzeDatabase(".\\database\\database.ser");
          makeFrame();
          showFrame();
      }
    
      private void makeFrame() 
      {
          setLayout(new FlowLayout());
          
          int numberOfAccounts = database.getNumberOfAccounts();
          for(int i = 0; i < numberOfAccounts; i++)
          {
               JButton account = new JButton(database.getAccount(i).getUsername() + " " + database.getAccount(i).getScore());
               add(account);
          }
      }
    
      private void showFrame()
      {  
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setSize(400, 200);
          setLocation(0,0); 
          setLocationRelativeTo(null);    
          setVisible(true);
      }  
      
      public void actionPerformed(ActionEvent evt) {}
}
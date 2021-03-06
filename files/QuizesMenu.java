import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*; 

public class QuizesMenu extends JFrame implements ActionListener 
{
      public JTextField usernameText;
      public JTextField passwordText;
      public String username;
      public String password;
      public Database database;
    
      public QuizesMenu() 
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
          
          int numberOfQuizes = database.getNumberOfQuizes();
          for(int i = 0; i < numberOfQuizes; i++)
          {
               JButton quiz = new JButton(database.getQuiz(i).getName());
               add(quiz);
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
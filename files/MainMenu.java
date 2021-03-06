import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*; 

public class MainMenu extends JFrame implements ActionListener 
{
      public JTextField usernameText;
      public JTextField passwordText;
      public String username;
      public Account account;
      public String password;
    
      public MainMenu(Account account) 
      { 
          super("Quizes");
          account = this.account;
          makeFrame();
          showFrame();
      }
    
      private void makeFrame() 
      {
          //CREATE AN ACCOUNT AFTER SIGN UP
          
          //RESET ROUND
          
          //SHOW MENU
          JButton quizes = new JButton("Quizes");
          JButton highscores = new JButton("Highscores");
          
          quizes.addActionListener(new ActionListener()
          {
             @Override
             public void actionPerformed(ActionEvent arg0)
             {
                dispose();
                QuizesMenu quizesMenu = new QuizesMenu();
             }
          });
          
          highscores.addActionListener(new ActionListener()
          {
             @Override
             public void actionPerformed(ActionEvent arg0)
             {
                  dispose();
                  HighscoresMenu highscoresMenu = new HighscoresMenu();
             }
          });
          
          setLayout(new FlowLayout());
          add(quizes);
          add(highscores);
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
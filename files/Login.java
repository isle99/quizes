import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*; 

public class Login extends JFrame implements ActionListener 
{
      public JTextField usernameText;
      public JTextField passwordText;
      public String username;
      public String password;
      public SignUp signUp;
      public Database database;
    
      public Login() 
      { 
          super("Quizes");
          Read read = new Read();
          database = read.deserialzeDatabase(".\\database\\database.ser");
          makeFrame();
          showFrame();
      }
    
      private void makeFrame() 
      {
          JLabel blank0 = new JLabel("__________");
          JLabel blank1 = new JLabel("__________");
          JLabel usernameLbl = new JLabel("Username: "); 
          usernameText = new JTextField(15); 
          JLabel passwordLbl = new JLabel("Password: "); 
          passwordText = new JTextField(15);
          JButton login = new JButton("Login");
          JButton signUp = new JButton("Sign Up");
          
          setLayout(new FlowLayout());
          add(usernameLbl);
          add(usernameText);
          add(blank0);
          add(passwordLbl);
          add(passwordText);
          add(blank1);
          add(login);
          add(signUp);
          
          login.addActionListener(new ActionListener()
          {
               @Override
               public void actionPerformed(ActionEvent arg0)
               {
                    username = usernameText.getText();
                    password = passwordText.getText();
                  
                    int numberOfAccounts = database.getNumberOfAccounts();
                    boolean usernameNotFound = true;
                    for(int i = 0; i < numberOfAccounts; i++)
                    {
                        if (database.getAccount(i).getUsername().equals(username))
                        {
                            usernameNotFound = false;
                            
                            if (database.getAccount(i).getPassword().equals(password))
                            {
                                dispose();
                                MainMenu mainMenu = new MainMenu();
                            }
                            else
                            {
                                JLabel passwordNotCorrectLbl = new JLabel("Password not correct"); 
                                add(passwordNotCorrectLbl);
                                break;
                            }
                        }
                    }
                  
                    if(usernameNotFound)
                    {
                        JLabel usernameNotFoundLbl = new JLabel("Username not found."); 
                        add(usernameNotFoundLbl);
                    }
               }
          });
          
          signUp.addActionListener(new ActionListener()
          {
               @Override
               public void actionPerformed(ActionEvent arg0)
               {
                  dispose();
                  SignUp signUp = new SignUp();
               }
          });
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
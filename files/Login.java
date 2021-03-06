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
      public Write write;
      public Database database;
      public Account account;
      public JLabel passwordNotCorrectLbl;
      public JLabel usernameNotFoundLbl;
      public JLabel blank2;
      public JButton login;
      public JButton signUp;
      public int error;
    
      public Login() 
      { 
          super("Login");
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
          login = new JButton("Login");
          signUp = new JButton("Sign Up");
          
          setLayout(new FlowLayout());
          add(usernameLbl);
          add(usernameText);
          add(blank0);
          add(passwordLbl);
          add(passwordText);
          add(blank1);
          add(login);
          add(signUp);
          
          login.addActionListener(this);
          signUp.addActionListener(this);
      }
    
      private void showFrame()
      {  
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setSize(400, 200);
          setLocation(0,0); 
          setLocationRelativeTo(null);    
          setVisible(true);
      }  
      
      public void actionPerformed(ActionEvent ae)
      {
          if(ae.getSource() == login)
          {
              login();
          }
          else if(ae.getSource() == signUp)
          {
              signUp();
          }
      }
      
      public void login()
      {
          int count = getContentPane().getComponentCount();
          if(getContentPane().getComponentCount() > 8)
          {
              getContentPane().remove(blank2);
              
              if(error == 1)
              {
                  getContentPane().remove(passwordNotCorrectLbl);
              }
              else if(error == 2)
              {
                  getContentPane().remove(usernameNotFoundLbl);
              }
              
              revalidate();
              repaint();
          }
           
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
                      account = database.getAccount(i);
                      MainMenu mainMenu = new MainMenu(account);
                  }
                  else
                  {
                      error = 1;
                      passwordNotCorrectLbl = new JLabel("Password not correct");
                      blank2 = new JLabel("_______________________");
                      add(blank2);
                      add(passwordNotCorrectLbl);
                      revalidate();
                      repaint();
                      break;
                  }
              }
          }
          
          if(usernameNotFound)
          {
              error = 2;
              usernameNotFoundLbl = new JLabel("Username not found."); 
              blank2 = new JLabel("_______________________");
              add(blank2);
              add(usernameNotFoundLbl);
              revalidate();
              repaint();
          }
      }
      
      public void signUp()
      {
          write = new Write();
                   
          username = usernameText.getText();
          password = passwordText.getText();
          account = new Account(username, password, database);
          database.addAccount(account);
          write.serializeAccount(account);
          
          dispose();
          MainMenu mainMenu = new MainMenu(account);
      }
}
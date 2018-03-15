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
      public Boolean run;
      public SignUp signUp;
    
      public Login() 
      { 
          super("Quizes");
          run = true;
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
          
          login.addActionListener(new ActionListener()
          {
             @Override
             public void actionPerformed(ActionEvent arg0)
             {
                System.out.println("button A Action");
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
          
          setLayout(new FlowLayout());
          add(usernameLbl);
          add(usernameText);
          add(blank0);
          add(passwordLbl);
          add(passwordText);
          add(blank1);
          add(login);
          add(signUp);
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
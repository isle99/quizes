import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*; 

public class SignUp extends JFrame implements ActionListener 
{
      public JTextField usernameText;
      public JTextField passwordText;
      public String username;
      public String password;
    
      public SignUp() 
      { 
          super("Quizes");
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
          JButton signUp = new JButton("Sign Up");
          signUp.addActionListener(this);
          
          setLayout(new FlowLayout());
          add(usernameLbl);
          add(usernameText);
          add(blank0);
          add(passwordLbl);
          add(passwordText);
          add(blank1);
          add(signUp);
      }
      
      public void actionPerformed(ActionEvent evt)
      {
          username = usernameText.getText();
          password = passwordText.getText();
          dispose();
          MainMenu mainMenu = new MainMenu();
      }
    
      private void showFrame()
      {  
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setSize(400, 200);
          setLocation(0,0); 
          setLocationRelativeTo(null);    
          setVisible(true);
      }           
}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*; 

public class GUI extends JFrame implements ActionListener 
{ 
      JPanel panel;
      JButton signUp;
      JTextField usernameText;
      JTextField passwordText;
      public String username;
      public String password;
      Boolean run;
    
      public GUI() 
      { 
          super("Quizes");
          run = true;
          makeFrame();
          showFrame();
      }
    
      private void  makeFrame() 
      {
          panel = new JPanel();
          JLabel usernameLbl = new JLabel ("Username: "); 
          usernameText = new JTextField(15); 
          JLabel passwordLbl = new JLabel ("Password: "); 
          passwordText = new JTextField(15); 
          signUp = new JButton ("Sign Up");
          signUp.addActionListener(this);
          /*setLayout(new FlowLayout());
          add(usernameLbl); 
          add(usernameText);
          add(passwordLbl); 
          add(passwordText); 
          add(signUp);*/
          
          GroupLayout layout = new GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
          layout.createSequentialGroup()
              .addComponent(usernameLbl)
              .addComponent(usernameText)
              .addComponent(passwordLbl)
              .addComponent(passwordText)
              .addComponent(signUp)
              //.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)        
          );
          layout.setVerticalGroup(
          layout.createSequentialGroup()
                .addComponent(usernameLbl)
                .addComponent(usernameText)
                .addComponent(passwordLbl)
                .addComponent(passwordText)
                .addComponent(signUp)
              //.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)         
          );
      }
      
      public void actionPerformed(ActionEvent evt)
      {
          username = usernameText.getText();
          password = passwordText.getText();
          run = false;
          dispose();
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
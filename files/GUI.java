import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*; 

public class GUI extends JFrame implements ActionListener 
{ 
      JButton start;
      JTextField text;
      public String name;
    
      public GUI() 
      { 
          super("Basic GUI Template - No Event Handling");
          name = "nothing";
          makeFrame();
          showFrame();
      }
    
      private void  makeFrame() 
      {
          JLabel lbl = new JLabel ("Enter your name: "); 
          text = new JTextField(15); 
          start = new JButton ("Start");
          start.addActionListener(this);
          setLayout(new FlowLayout());
          add(lbl); 
          add(text); 
          add(start);
      }
       
      public void actionPerformed(ActionEvent evt)
      {
          name = text.getText();
          dispose();
      }
    
      private void showFrame()
      {  
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setSize(400, 75);
          setLocation(0,0); 
          setLocationRelativeTo(null);    
          setVisible( true );               
      }           
}
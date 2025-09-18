import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    JButton btn;
    JTextField fName, lName, mName, uEmail;
    JPanel inputPanel;
    
    Frame(){
        this.setResizable(false);

        //Main Frame
        this.setTitle("05 Hands-on Activity");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,500);

        inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(new JLabel("Given Name:"));
        inputPanel.add(fName = new JTextField());
        inputPanel.add(new JLabel("Middle Name:"));
        inputPanel.add(mName = new JTextField());
        inputPanel.add(new JLabel("Last Name:"));
        inputPanel.add(lName = new JTextField());
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(uEmail = new JTextField());
        inputPanel.setBounds(50, 50, 400, 200);

        //Button
        btn = new JButton("Submit");
        btn.setBounds(190, 300, 100, 50);



        this.add(inputPanel);
        //Adds button
        this.add(btn);

        //Whole form is visible
        this.setVisible(true);

        
    }
}

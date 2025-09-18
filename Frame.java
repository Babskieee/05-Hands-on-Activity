import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame {

    JButton btn;
    JLabel lbl;
    
    Frame(){
        this.setResizable(false);

        //Main Frame
        this.setTitle("05 Hands-on Activity");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,500);

        //Label
        lbl = new JLabel("Hello World");
        lbl.setBounds(100, 100, 100, 50);
        

        //Button
        btn = new JButton("Submit");
        btn.setBounds(190, 350, 100, 50);
        

        //Adds button
        this.add(btn);

        //Whole form is visible
        this.setVisible(true);

        
    }
}

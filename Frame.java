import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame {

    JButton btn;
    JTextField fName, lName, mName, uEmail;
    JPanel inputPanel;
    Font myFont = new Font("Arial", Font.PLAIN, 14); // global font

    Frame(){
        this.setResizable(false);

        // Main Frame
        this.setTitle("05 Hands-on Activity");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,500);

        // Input fields design
        inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Input fields
        inputPanel.add(new JLabel("Given Name:"));
        inputPanel.add(fName = new JTextField());
        inputPanel.add(new JLabel("Middle Name:"));
        inputPanel.add(mName = new JTextField());
        inputPanel.add(new JLabel("Last Name:"));
        inputPanel.add(lName = new JTextField());
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(uEmail = new JTextField());
        inputPanel.setBounds(50, 50, 400, 200);

        // Apply font to all components in input panel
        setFontAll(inputPanel, myFont);

        // Button
        btn = new JButton("Submit");
        btn.setFont(myFont);
        btn.setBounds(190, 300, 120, 50);

        // Button response
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get inputs
                String given = fName.getText();
                String middle = mName.getText();
                String last = lName.getText();
                String email = uEmail.getText();

                // Remove the input fields
                remove(inputPanel);
                remove(btn);

                // New panel for output
                JPanel outputPanel = new JPanel(new GridLayout(5, 1, 10, 10));
                outputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

                outputPanel.add(new JLabel("Given Name: " + given));
                outputPanel.add(new JLabel("Middle Name: " + middle));
                outputPanel.add(new JLabel("Last Name: " + last));
                outputPanel.add(new JLabel("Email: " + email));

                // Apply font to all output labels automatically
                setFontAll(outputPanel, myFont);

                outputPanel.setBounds(50, 100, 400, 200);
                add(outputPanel);

                // Refresh for output
                revalidate();
                repaint();
            }
        });

        //Elements
        this.add(inputPanel);
        this.add(btn);

        //Whole form is visible
        this.setVisible(true);
    }

    // Helper method: apply font to all components in a container
    private void setFontAll(Container c, Font font) {
        for (Component comp : c.getComponents()) {
            comp.setFont(font);
            if (comp instanceof Container) {
                setFontAll((Container) comp, font); // recursive for nested panels
            }
        }
    }

    public static void main(String[] args) {
        new Frame();
    }
}


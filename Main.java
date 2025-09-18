import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventDriven000 extends JFrame {
    // Input components
    private JTextField tfFirstName, tfLastName, tfMiddleName, tfEmail;
    private JButton btnSubmit, btnClear;
    private JFrame outputFrame;

    public EventDriven000() {
        // Set up the main INPUT frame
        setTitle("INPUT");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for input fields
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Labels and text fields
        inputPanel.add(new JLabel("First Name:"));
        tfFirstName = new JTextField();
        inputPanel.add(tfFirstName);

        inputPanel.add(new JLabel("Last Name:"));
        tfLastName = new JTextField();
        inputPanel.add(tfLastName);

        inputPanel.add(new JLabel("Middle Name:"));
        tfMiddleName = new JTextField();
        inputPanel.add(tfMiddleName);

        inputPanel.add(new JLabel("E-mail Address:"));
        tfEmail = new JTextField();
        inputPanel.add(tfEmail);

        // Buttons panel
        btnSubmit = new JButton("Submit");
        btnClear = new JButton("Clear All");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnSubmit);
        buttonPanel.add(btnClear);

        // Add padding to button panel
        JPanel paddedButtonPanel = new JPanel(new BorderLayout());
        paddedButtonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0)); // top, left, bottom, right
        paddedButtonPanel.add(buttonPanel, BorderLayout.CENTER);

        // Add panels to frame
        add(inputPanel, BorderLayout.CENTER);
        add(paddedButtonPanel, BorderLayout.SOUTH);

        // Add action listeners
        btnSubmit.addActionListener(new Submit());
        btnClear.addActionListener(new ClearAll());
    }

    // Inner class for Submit button
    private class Submit implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Retrieve input data
            String firstName = tfFirstName.getText().trim();
            String lastName = tfLastName.getText().trim();
            String middleName = tfMiddleName.getText().trim();
            String email = tfEmail.getText().trim();

            // Disable Submit button
            btnSubmit.setEnabled(false);

            // Create and display output frame
            outputFrame = new JFrame("OUTPUT");
            outputFrame.setSize(400, 300);
            outputFrame.setLocationRelativeTo(null);
            outputFrame.setLayout(new BorderLayout());

            // Text area to display info
            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            String outputText = "First Name: " + firstName + "\n" +
                                "Last Name: " + lastName + "\n" +
                                "Middle Name: " + middleName + "\n" +
                                "E-mail Address: " + email;
            textArea.setText(outputText);
            outputFrame.add(new JScrollPane(textArea), BorderLayout.CENTER);

            // Okay button
            JButton btnOkay = new JButton("Okay");
            btnOkay.addActionListener(new Okay());
            JPanel outputButtonPanel = new JPanel();
            outputButtonPanel.add(btnOkay);
            outputFrame.add(outputButtonPanel, BorderLayout.SOUTH);

            outputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            outputFrame.setVisible(true);
        }
    }

    // Inner class for Okay button
    private class Okay implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            outputFrame.dispose();
            btnSubmit.setEnabled(true); // Re-enable submit button
        }
    }

    // Inner class for Clear All button
    private class ClearAll implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            tfFirstName.setText("");
            tfLastName.setText("");
            tfMiddleName.setText("");
            tfEmail.setText("");
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EventDriven000 frame = new EventDriven000();
            frame.setVisible(true);
        });
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class app extends JFrame {
  private JTextField nameField, emailField;
  private JPasswordField passwordField, confirmPasswordField;

  public app() {
    setTitle("User Registration");
    setSize(300, 200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new GridLayout(5, 2));

    nameField = new JTextField();
    emailField = new JTextField();
    passwordField = new JPasswordField();
    confirmPasswordField = new JPasswordField();

    add(new JLabel("Name:"));
    add(nameField);
    add(new JLabel("Email:"));
    add(emailField);
    add(new JLabel("Password:"));
    add(passwordField);
    add(new JLabel("Confirm Password:"));
    add(confirmPasswordField);

    JButton submitButton = new JButton("Submit");
    JButton clearButton = new JButton("Clear");

    add(submitButton);
    add(clearButton);

    submitButton.addActionListener(e -> handleSubmit());
    clearButton.addActionListener(e -> clearFields());

    setVisible(true);
  }

  private void handleSubmit() {
    String name = nameField.getText();
    String email = emailField.getText();
    String password = new String(passwordField.getPassword());
    String confirmPassword = new String(confirmPasswordField.getPassword());

    if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
      JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
      String message = String.format("Name: %s\nEmail: %s\nPassword: %s", name, email, password);
      JOptionPane.showMessageDialog(this, message, "User Information", JOptionPane.INFORMATION_MESSAGE);
    }
  }

  private void clearFields() {
    nameField.setText("");
    emailField.setText("");
    passwordField.setText("");
    confirmPasswordField.setText("");
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(app::new);
  }
}

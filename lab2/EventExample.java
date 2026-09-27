
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class  EventExample extends JFrame implements ActionListener {

    JLabel lblFullName, lblEmail, lblContact, lblAddress, lblGender;
    JTextField txtFullName, txtEmail, txtContact, txtAddress;
    JComboBox<String> gender;
    JButton selectFile, accept, clear;

    public EventExample() {

        setTitle("DAV KYC FORM");
        setBounds(100, 150, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 12));

        // Full Name
        lblFullName = new JLabel("Full Name:");
        txtFullName = new JTextField();

        panel.add(lblFullName);
        panel.add(txtFullName);

        // Email
        lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();

        panel.add(lblEmail);
        panel.add(txtEmail);

        // Contact
        lblContact = new JLabel("Contact:");
        txtContact = new JTextField();

        panel.add(lblContact);
        panel.add(txtContact);

        // Address
        lblAddress = new JLabel("Address:");
        txtAddress = new JTextField();

        panel.add(lblAddress);
        panel.add(txtAddress);

        // Gender
        lblGender = new JLabel("Gender:");

        gender = new JComboBox<>();

        gender.addItem("Female");
        gender.addItem("Male");
        gender.addItem("Others");

        panel.add(lblGender);
        panel.add(gender);

        // File Selection
        panel.add(new JLabel("Select File:"));

        selectFile = new JButton("Choose File");
        panel.add(selectFile);

        // Accept
        accept = new JButton("Accept");
        panel.add(new JLabel(""));
        panel.add(accept);

        // Clear
        clear = new JButton("Clear");
        panel.add(new JLabel(""));
        panel.add(clear);

        // Add ActionListener
        selectFile.addActionListener(this);
        accept.addActionListener(this);
        clear.addActionListener(this);

        add(panel);

        setVisible(true);
    }

    // Button Action
    @Override
    public void actionPerformed(ActionEvent e) {

        // Clear button
        if (e.getSource() == clear) {

            resetForm();
        }

        // Accept button
        else if (e.getSource() == accept) {

            submitForm();
        }

        // Choose File button
        else if (e.getSource() == selectFile) {

            JFileChooser fileChooser = new JFileChooser();

            int result = fileChooser.showOpenDialog(this);

            if (result == JFileChooser.APPROVE_OPTION) {

                String fileName =
                        fileChooser.getSelectedFile().getAbsolutePath();

                JOptionPane.showMessageDialog(
                        this,
                        "Selected File:\n" + fileName,
                        "File Selected",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }

    // Reset Form
    public void resetForm() {

        txtFullName.setText("");
        txtEmail.setText("");
        txtContact.setText("");
        txtAddress.setText("");

        gender.setSelectedIndex(0);

        JOptionPane.showMessageDialog(
                this,
                "Form has been cleared.",
                "Clear",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // Submit Form
    public void submitForm() {

        String fullName = txtFullName.getText().trim();
        String email = txtEmail.getText().trim();
        String contact = txtContact.getText().trim();
        String address = txtAddress.getText().trim();

        String selectedGender =
                (String) gender.getSelectedItem();

        // Check empty fields
        if (fullName.isEmpty() ||
            email.isEmpty() ||
            contact.isEmpty() ||
            address.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all the fields first.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        // Email validation
        String emailRegex =
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (!Pattern.matches(emailRegex, email)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid email address.",
                    "Invalid Email",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        // Contact validation
        if (!contact.matches("\\d{10}")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Contact number must contain exactly 10 digits.",
                    "Invalid Contact",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        // Successful submission
        JOptionPane.showMessageDialog(
                this,
                "KYC Form Submitted Successfully!\n\n"
                + "Full Name: " + fullName + "\n"
                + "Email: " + email + "\n"
                + "Contact: " + contact + "\n"
                + "Address: " + address + "\n"
                + "Gender: " + selectedGender,
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // Main Method
    public static void main(String[] args) {

        new EventExample();
    }
}


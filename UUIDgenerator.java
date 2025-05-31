import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.UUID;

public class UUIDGenerator extends JFrame {
    private JTextField uuidField;

    public UUIDGenerator() {
        // Set up the main window
        setTitle("UUID Generator");
        setSize(500, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Create components
        JLabel titleLabel = new JLabel("Generated UUID:");
        uuidField = new JTextField();
        uuidField.setEditable(false);
        uuidField.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JButton generateButton = new JButton("Generate UUID");
        JButton copyButton = new JButton("Copy to Clipboard");

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(generateButton);
        buttonPanel.add(copyButton);

        // Add components to frame
        add(titleLabel, BorderLayout.NORTH);
        add(uuidField, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Generate first UUID
        generateUUID();

        // Button actions
        generateButton.addActionListener(e -> generateUUID());

        copyButton.addActionListener(e -> {
            StringSelection selection = new StringSelection(uuidField.getText());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, null);
            JOptionPane.showMessageDialog(this, "UUID copied to clipboard!");
        });
    }

    private void generateUUID() {
        UUID uuid = UUID.randomUUID();
        uuidField.setText(uuid.toString().toUpperCase());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new UUIDGenerator().setVisible(true);
        });
    }
}

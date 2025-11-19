package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private final JFrame frame = new JFrame("My second Java graphical interface");
    private final Controller controller = new Controller();

    /**
     * Creates a new SimpleGUIWithFileChooser.
     */
    public SimpleGUIWithFileChooser() {
        final JPanel mainPanel = new JPanel();
        final JPanel panel = new JPanel();
        final JTextArea textArea = new JTextArea();
        final JButton save = new JButton("Save");
        final JTextField textField = new JTextField(controller.getFilePath());
        final JButton browse = new JButton("Browse");
        textField.setEditable(false);
        mainPanel.setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());
        mainPanel.add(textArea, BorderLayout.CENTER);
        mainPanel.add(save, BorderLayout.SOUTH);
        panel.add(textField, BorderLayout.CENTER);
        panel.add(browse, BorderLayout.LINE_END);
        mainPanel.add(panel, BorderLayout.NORTH);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent event) {
                try {
                    controller.saveString(textArea.getText());
                } catch (final IOException e) {
                    JOptionPane.showMessageDialog(frame, e, "Error", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace(); // NOPMD: allowed as this is just an exercise
                }
            }
        });

        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent event) {
                final JFileChooser fileChooser = new JFileChooser();
                switch (fileChooser.showSaveDialog(frame)) {
                case JFileChooser.APPROVE_OPTION:
                    controller.setCurrentFile(fileChooser.getSelectedFile());
                    textField.setText(controller.getFilePath());
                    break;
                case JFileChooser.CANCEL_OPTION:
                    break;
                default:
                    JOptionPane.showMessageDialog(frame, event, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw, sh);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Launches the application.
     *
     * @param args ignored
     */
    public static void main(final String... args) {
       new SimpleGUIWithFileChooser().display();
    }

}

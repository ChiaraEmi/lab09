package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();

    /**
     * Creates a new SimpleGUIWithFileChooser.
     */
    public SimpleGUIWithFileChooser() {
        final JPanel mainPanel = new JPanel();
        final JPanel panel = new JPanel();
        final JTextField textField = new JTextField(controller.getFilePath());
        final JButton browse = new JButton("Browse");
        mainPanel.setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());
        mainPanel.add(panel, BorderLayout.NORTH);
        panel.add(textField, BorderLayout.CENTER);
        panel.add(browse, BorderLayout.LINE_END);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

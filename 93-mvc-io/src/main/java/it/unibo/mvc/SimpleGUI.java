package it.unibo.mvc;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private final Controller controller;

    /**
     * Creates a new SimpleGUI.
     * 
     * @param c the controller instance
     */
    @SuppressFBWarnings(
        value = "EI2",
        justification = "Suppressed beacuase of project specifications."
    )
    public SimpleGUI(final Controller c) {
        this.controller = c;
        final JPanel mainPanel = new JPanel();
        final JPanel panel = new JPanel();
        final JTextField textField = new JTextField();
        final JTextArea textArea = new JTextArea();
        final JButton print = new JButton("Print");
        final JButton showHistory = new JButton("Show history");
        mainPanel.setLayout(new BorderLayout());
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        mainPanel.add(textField, BorderLayout.NORTH);
        mainPanel.add(textArea, BorderLayout.CENTER);
        mainPanel.add(panel, BorderLayout.SOUTH);
        panel.add(print);
        panel.add(showHistory);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent event) {
                controller.setNextString(textField.getText());
                controller.printCurrentString();
            }
        });

        showHistory.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent event) {
                final List<String> history = controller.getHistory();
                textArea.setText(history.toString());
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
       new SimpleGUI(new SimpleController()).display();
    }

}

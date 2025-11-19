package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final String SAVE = "Save";
    private static final String OPTION = "Do you really want to save?";
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame("SCEMO");

    /**
     * Create a new SimpleGUI.
     */
    public SimpleGUI() {
        final JPanel myCanvas = new JPanel();
        final JPanel newCanvas = new JPanel();
        newCanvas.setLayout(new BorderLayout());
        myCanvas.setLayout(new BorderLayout());
        final JTextArea myText = new JTextArea();
        final JButton myButton = new JButton(SAVE);
        final JTextField myTextField = new JTextField();
        final JButton myButton2 = new JButton("Browse...");
        newCanvas.add(myButton2, BorderLayout.EAST);
        newCanvas.add(myTextField, BorderLayout.WEST);
        myCanvas.add(newCanvas, BorderLayout.NORTH);
        myCanvas.add(myText, BorderLayout.CENTER);
        myCanvas.add(myButton, BorderLayout.SOUTH);
        frame.setContentPane(myCanvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final int choice = JOptionPane.showConfirmDialog(
                    frame,
                    OPTION,
                    "Saving",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );

                if (choice == JOptionPane.YES_OPTION) {
                    System.out.println("YES"); // NOPMD
                } else if (choice == JOptionPane.NO_OPTION) {
                    System.out.println("NO"); // NOPMD
                } else {
                    System.out.println("CLOSED"); // NOPMD
                }
            }
        });
    }

    /**
     * Correct way to display the GUI.
     */
    private void display() {
        final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = (int) dim.getWidth();
        final int height = (int) dim.getHeight();
        frame.setSize(width / PROPORTION, height / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * The initiation of the GUI.
     * 
     * @param args the arguments that you want to add when using it
     */
    public static void main(final String... args) {
        new SimpleGUI().display();
    }
}

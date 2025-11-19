package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final String SAVE = "Save";
    private static final String OPTION = "Do you really want to save?";
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame(this.getClass().getSimpleName());
    private final Controller mycontroller = new Controller();

    /**
     * Create a new SimpleGUI.
     */
    public SimpleGUIWithFileChooser() {
        final JPanel myCanvas = new JPanel();
        final JPanel newCanvas = new JPanel();
        newCanvas.setLayout(new BorderLayout());
        myCanvas.setLayout(new BorderLayout());
        final JTextArea myText = new JTextArea();
        final JButton myButton = new JButton(SAVE);
        final JTextField myTextField = new JTextField(mycontroller.getCurrentPath());
        myTextField.setEditable(false);
        final JButton myButton2 = new JButton("Browse...");
        newCanvas.add(myButton2, BorderLayout.LINE_END);
        newCanvas.add(myTextField, BorderLayout.CENTER);
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
        myButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChosen = new JFileChooser();
                final int choice = fileChosen.showSaveDialog(frame);
                if (choice == JFileChooser.APPROVE_OPTION) {
                    mycontroller.setCurrentFile(fileChosen.getSelectedFile());
                    myTextField.setText(mycontroller.getCurrentPath());
                } else if (choice != JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(frame, "An error has occurred");
                }
            }
        });
    }

    /**
     * Correct way to display the GUI.
     */
    void display() {
        final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = (int) dim.getWidth();
        final int height = (int) dim.getHeight();
        frame.setSize(width / PROPORTION, height / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}

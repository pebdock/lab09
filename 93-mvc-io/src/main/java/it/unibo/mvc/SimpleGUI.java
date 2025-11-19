package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {

    private static final int PROPORTION = 4;
    private final JFrame frame = new JFrame(this.getClass().getSimpleName());
    private final Controller myController = new SimpleController();

    /**
     * The constructor of the GUI.
     */
    private SimpleGUI() {
        final JPanel myCanvas = new JPanel(new BorderLayout());
        final JPanel myCanvas2 = new JPanel(new BorderLayout());
        final JTextField myField = new JTextField();
        final JTextArea myArea = new JTextArea();
        final JButton printButton = new JButton("Print");
        final JButton historyButton = new JButton("Show history");
        myCanvas.add(myField, BorderLayout.NORTH);
        myCanvas.add(myArea, BorderLayout.CENTER);
        myCanvas2.add(printButton, BorderLayout.EAST);
        myCanvas2.add(historyButton, BorderLayout.WEST);
        myCanvas.add(myCanvas2, BorderLayout.SOUTH);
        frame.setContentPane(myCanvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        printButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                myController.setNext(myField.getText());
                myController.printCurrent();
            }
        });
        historyButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                myArea.setText(myController.getHistory().toString());
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

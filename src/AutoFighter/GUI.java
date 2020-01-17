package AutoFighter;

import javax.swing.*;
import java.awt.*;

public class GUI{

    public void initGui(){
        JFrame frame = new JFrame("GUI");
        frame.setSize(300, 300);

        JPanel inputPanel = new JPanel();
        GridBagConstraints c = new GridBagConstraints();

        inputPanel.setLayout(new GridBagLayout());

        JLabel attText = new JLabel("Strength");
        c.gridx = 0;
        c.gridy = 1;
        inputPanel.add(attText, c);

        JLabel strText = new JLabel("Attack");
        c.gridx = 0;
        c.gridy = 0;
        inputPanel.add(strText, c);

        JLabel defText = new JLabel("Defence");
        c.gridx = 0;
        c.gridy = 2;
        inputPanel.add(defText, c);

        JTextField attInput = new JTextField("99", 2);
        c.gridx = 1;
        c.gridy = 0;
        inputPanel.add(attInput, c);

        JTextField strInput = new JTextField("99", 2);
        c.gridx = 1;
        c.gridy = 1;
        inputPanel.add(strInput, c);

        JTextField defInput = new JTextField("99", 2);
        c.gridx = 1;
        c.gridy = 2;
        inputPanel.add(defInput, c);

        JButton button = new JButton("Confirm");
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        inputPanel.add(button, c);


        frame.getContentPane().add(inputPanel);

        frame.setVisible(true);
    }


}

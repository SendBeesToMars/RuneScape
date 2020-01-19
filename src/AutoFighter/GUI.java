package AutoFighter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI{

    public void initGui(DataBean data){
        JFrame frame = new JFrame("GUI");
        frame.setSize(300, 300);

        JPanel inputPanel = new JPanel();
        GridBagConstraints c = new GridBagConstraints();

        inputPanel.setLayout(new GridBagLayout());

        // attack type input y0-2
        JLabel attText = new JLabel("Strength");
        c.gridx = 0;
        c.gridy = 0;
        inputPanel.add(attText, c);

        JLabel strText = new JLabel("Attack");
        c.gridx = 0;
        c.gridy = 1;
        inputPanel.add(strText, c);

        JLabel defText = new JLabel("Defence");
        c.gridx = 0;
        c.gridy = 2;
        inputPanel.add(defText, c);


        JTextField attInput = new JTextField("99", 3);
        c.gridx = 1;
        c.gridy = 0;
        inputPanel.add(attInput, c);

        JTextField strInput = new JTextField("99", 3);
        c.gridx = 1;
        c.gridy = 1;
        inputPanel.add(strInput, c);

        JTextField defInput = new JTextField("99", 3);
        c.gridx = 1;
        c.gridy = 2;
        inputPanel.add(defInput, c);


        // fight area range input y3
        JLabel rangeText = new JLabel("Attack area range");
        c.gridx = 0;
        c.gridy = 3;
        inputPanel.add(rangeText, c);

        JTextField rangeInput = new JTextField("99", 3);
        c.gridx = 1;
        c.gridy = 3;
        inputPanel.add(rangeInput, c);

        // mob min level y4
        JLabel mobMinText = new JLabel("Mob min level");
        c.gridx = 0;
        c.gridy = 4;
        inputPanel.add(mobMinText, c);

        JTextField mobMinInput = new JTextField("1", 3);
        c.gridx = 1;
        c.gridy = 4;
        inputPanel.add(mobMinInput, c);

        // mob max level y5
        JLabel mobMaxText = new JLabel("Mob max level");
        c.gridx = 0;
        c.gridy = 5;
        inputPanel.add(mobMaxText, c);

        JTextField mobMaxInput = new JTextField("1520", 3);
        c.gridx = 1;
        c.gridy = 5;
        inputPanel.add(mobMaxInput, c);

        // mob max level y6
        JLabel healText = new JLabel("Heal at hp %");
        c.gridx = 0;
        c.gridy = 6;
        inputPanel.add(healText, c);

        JTextField healInput = new JTextField("30", 3);
        c.gridx = 1;
        c.gridy = 6;
        inputPanel.add(healInput, c);


        // confirm button y99
        JButton button = new JButton("Confirm");
        c.gridx = 0;
        c.gridy = 99;
        c.gridwidth = 2;
        button.addActionListener(e -> {
            data.setFightLocationSize(Integer.parseInt(rangeInput.getText()));
            data.setHealPercent(Integer.parseInt(healInput.getText()));
            data.setMaxAtt(Integer.parseInt(attInput.getText()));
            data.setMaxStr(Integer.parseInt(strInput.getText()));
            data.setMaxDef(Integer.parseInt(defInput.getText()));
            data.setMobMaxLevel(Integer.parseInt(mobMaxInput.getText()));
            data.setMobMinLevel(Integer.parseInt(mobMinInput.getText()));
            data.setConfirm(true);
            frame.dispose();
        });
        inputPanel.add(button, c);


        frame.getContentPane().add(inputPanel);

        frame.setVisible(true);
    }


}

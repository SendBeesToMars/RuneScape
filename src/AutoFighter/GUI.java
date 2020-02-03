package AutoFighter;

import org.powerbot.bot.rt4.TPlayer;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Constants;

import javax.swing.*;
import java.awt.*;

public class GUI{

    public void initGui(DataBean data, ClientContext ctx){
        JFrame frame = new JFrame("GUI");
        frame.setSize(300, 300);

        JPanel inputPanel = new JPanel();
        GridBagConstraints c = new GridBagConstraints();

        inputPanel.setLayout(new GridBagLayout());

        // attack type input y0-2
        JLabel attText = new JLabel("Attack");
        c.gridx = 0;
        c.gridy = 0;
        inputPanel.add(attText, c);

        JLabel strText = new JLabel("Strength");
        c.gridx = 0;
        c.gridy = 1;
        inputPanel.add(strText, c);

        JLabel defText = new JLabel("Defence");
        c.gridx = 0;
        c.gridy = 2;
        inputPanel.add(defText, c);


        JTextField attInput = new JTextField(Integer.toString(ctx.skills.level(Constants.SKILLS_ATTACK)), 3);
        c.gridx = 1;
        c.gridy = 0;
        inputPanel.add(attInput, c);

        JTextField strInput = new JTextField(Integer.toString(ctx.skills.level(Constants.SKILLS_STRENGTH)), 3);
        c.gridx = 1;
        c.gridy = 1;
        inputPanel.add(strInput, c);

        JTextField defInput = new JTextField(Integer.toString(ctx.skills.level(Constants.SKILLS_DEFENSE)), 3);
        c.gridx = 1;
        c.gridy = 2;
        inputPanel.add(defInput, c);


        // fight area range input y3
        JLabel rangeText = new JLabel("Attack area range");
        c.gridx = 0;
        c.gridy = 3;
        inputPanel.add(rangeText, c);

        JTextField rangeInput = new JTextField("20", 3);
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
        JButton buttonConfirm = new JButton("Confirm");
        c.gridx = 0;
        c.gridy = 99;
        c.gridwidth = 2;
        buttonConfirm.addActionListener(e -> {
            data.setFightLocationSize(Integer.parseInt(rangeInput.getText()));
            data.setHealPercent(Integer.parseInt(healInput.getText()));
            data.setMaxAtt(Integer.parseInt(attInput.getText()));
            data.setMaxStr(Integer.parseInt(strInput.getText()));
            data.setMaxDef(Integer.parseInt(defInput.getText()));
            data.setMobMaxLevel(Integer.parseInt(mobMaxInput.getText()));
            data.setMobMinLevel(Integer.parseInt(mobMinInput.getText()));
            data.setGuiConfirmFlag(true);
            frame.dispose();
        });
        inputPanel.add(buttonConfirm, c);

        JButton buttonIncrement = new JButton("+");
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 1;
        inputPanel.add(buttonIncrement, c);

        JButton buttonDecrement = new JButton("-");
        c.gridx = 3;
        c.gridy = 0;
        c.gridwidth = 1;
        inputPanel.add(buttonDecrement, c);


        frame.getContentPane().add(inputPanel);

        frame.setVisible(true);
    }


}

package AutoFighter;

import org.powerbot.bot.rt4.TPlayer;
import org.powerbot.script.StringUtils;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class GUI{
    Map<String, JTextField> map = new HashMap<>();

    public void initGui(DataBean data, ClientContext ctx){
        JFrame frame = new JFrame("GUI");
        frame.setLayout(new GridBagLayout());
        frame.setSize(300, 300);

//        JPanel inputPanel = new JPanel(new GridBagLayout());
//        GridBagConstraints c = new GridBagConstraints();
//
//        // attack type input y0-2
//        JLabel attText = new JLabel("Attack");
//        c.gridx = 0;
//        c.gridy = 0;
//        inputPanel.add(attText, c);
//
//        JLabel strText = new JLabel("Strength");
//        c.gridx = 0;
//        c.gridy = 1;
//        inputPanel.add(strText, c);
//
//        JLabel defText = new JLabel("Defence");
//        c.gridx = 0;
//        c.gridy = 2;
//        inputPanel.add(defText, c);
//
//
//        JTextField attInput = new JTextField(Integer.toString(ctx.skills.level(Constants.SKILLS_ATTACK)), 3);
//        c.gridx = 1;
//        c.gridy = 0;
//        inputPanel.add(attInput, c);
//
//        JTextField strInput = new JTextField(Integer.toString(ctx.skills.level(Constants.SKILLS_STRENGTH)), 3);
//        c.gridx = 1;
//        c.gridy = 1;
//        inputPanel.add(strInput, c);
//
//        JTextField defInput = new JTextField(Integer.toString(ctx.skills.level(Constants.SKILLS_DEFENSE)), 3);
//        c.gridx = 1;
//        c.gridy = 2;
//        inputPanel.add(defInput, c);
//
//
//        // fight area range input y3
//        JLabel rangeText = new JLabel("Attack area range");
//        c.gridx = 0;
//        c.gridy = 3;
//        inputPanel.add(rangeText, c);
//
//        JTextField rangeInput = new JTextField("20", 3);
//        c.gridx = 1;
//        c.gridy = 3;
//        inputPanel.add(rangeInput, c);
//
//        // mob min level y4
//        JLabel mobMinText = new JLabel("Mob min level");
//        c.gridx = 0;
//        c.gridy = 4;
//        inputPanel.add(mobMinText, c);
//
//        JTextField mobMinInput = new JTextField("1", 3);
//        c.gridx = 1;
//        c.gridy = 4;
//        inputPanel.add(mobMinInput, c);
//
//        // mob max level y5
//        JLabel mobMaxText = new JLabel("Mob max level");
//        c.gridx = 0;
//        c.gridy = 5;
//        inputPanel.add(mobMaxText, c);
//
//        JTextField mobMaxInput = new JTextField("1520", 3);
//        c.gridx = 1;
//        c.gridy = 5;
//        inputPanel.add(mobMaxInput, c);
//
//        // mob max level y6
//        JLabel healText = new JLabel("Heal at hp %");
//        c.gridx = 0;
//        c.gridy = 6;
//        inputPanel.add(healText, c);
//
//        JTextField healInput = new JTextField("30", 3);
//        c.gridx = 1;
//        c.gridy = 6;
//        inputPanel.add(healInput, c);
//
//
//        // confirm button y99
//        JButton buttonConfirm = new JButton("Confirm");
//        c.gridx = 0;
//        c.gridy = 99;
//        c.gridwidth = 2;
//        buttonConfirm.addActionListener(e -> {
//            data.setFightLocationSize(Integer.parseInt(rangeInput.getText()));
//            data.setHealPercent(Integer.parseInt(healInput.getText()));
//            data.setMaxAtt(Integer.parseInt(attInput.getText()));
//            data.setMaxStr(Integer.parseInt(strInput.getText()));
//            data.setMaxDef(Integer.parseInt(defInput.getText()));
//            data.setMobMaxLevel(Integer.parseInt(mobMaxInput.getText()));
//            data.setMobMinLevel(Integer.parseInt(mobMinInput.getText()));
//            data.setGuiConfirmFlag(true);
//            frame.dispose();
//        });
//        inputPanel.add(buttonConfirm, c);
//
//        JButton buttonIncrement = new JButton("+");
//        c.gridx = 2;
//        c.gridy = 0;
//        c.gridwidth = 1;
//        inputPanel.add(buttonIncrement, c);
//
//        JButton buttonDecrement = new JButton("-");
//        c.gridx = 3;
//        c.gridy = 0;
//        c.gridwidth = 1;
//        inputPanel.add(buttonDecrement, c);
//
//
//        frame.getContentPane().add(inputPanel);
        JPanel att = guiField("Attack", Integer.toString(ctx.skills.level(Constants.SKILLS_ATTACK)), "att", true, 1);
        JPanel str = guiField("Strength", Integer.toString(ctx.skills.level(Constants.SKILLS_STRENGTH)), "str", true, 1);
        JPanel def = guiField("Defence", Integer.toString(ctx.skills.level(Constants.SKILLS_DEFENSE)), "def", true, 1);

        JPanel area = guiField("Attack area range", "20", "area", true, 5);
        JPanel min = guiField("Mob min level", "1", "min", true, 1);
        JPanel max = guiField("Mob max level", "1520", "max", true, 1);
        JPanel heal = guiField("heal at %", "30", "heal", true, 5);


        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_END;
        c.gridy = 0;
        frame.getContentPane().add(att, c);
        c.gridy = 1;
        frame.getContentPane().add(str, c);
        c.gridy = 2;
        frame.getContentPane().add(def, c);
        c.gridy = 3;
        frame.getContentPane().add(area, c);
        c.gridy = 4;
        frame.getContentPane().add(min, c);
        c.gridy = 5;
        frame.getContentPane().add(max, c);
        c.gridy = 6;
        frame.getContentPane().add(heal, c);

        JButton buttonConfirm = new JButton("Confirm");
        c.gridy = 99;
        c.gridwidth = 2;
        buttonConfirm.addActionListener(e -> {
            data.setFightLocationSize(Integer.parseInt(map.get("area").getText()));
            data.setHealPercent(Integer.parseInt(map.get("heal").getText()));
            data.setMaxAtt(Integer.parseInt(map.get("att").getText()));
            data.setMaxStr(Integer.parseInt(map.get("str").getText()));
            data.setMaxDef(Integer.parseInt(map.get("def").getText()));
            data.setMobMaxLevel(Integer.parseInt(map.get("max").getText()));
            data.setMobMinLevel(Integer.parseInt(map.get("min").getText()));
            data.setGuiConfirmFlag(true);
            frame.dispose();
        });
        frame.add(buttonConfirm, c);

        frame.setVisible(true);
    }

    private JPanel guiField(String label, String defaultText, String type, boolean incrementable, int increment){
        JPanel panel = new JPanel(new GridBagLayout());
        JLabel labelField = new JLabel(label);
        JTextField textField = new JTextField(defaultText, 3);
        GridBagConstraints c = new GridBagConstraints();


        map.put(type, textField);

        c.ipadx = 8; // ads a margin between label and input field
        panel.add(labelField, c);
        panel.add(textField);

        if (incrementable){
            JButton incrementButton = new JButton("+");
            incrementButton.setBackground(new Color(153, 204, 0));
            incrementButton.setPreferredSize( new Dimension(35, 20));
            incrementButton.setFocusPainted(false);
            incrementButton.setMargin(new Insets(0,0, 0, 0));

            JButton decrementButton = new JButton("-");
            decrementButton.setBackground(new Color(255, 153, 0));
            decrementButton.setPreferredSize( new Dimension(35, 20));
            decrementButton.setFocusPainted(false);
            decrementButton.setMargin(new Insets(0,0, 0, 0));

            incrementButton.addActionListener(e -> textField.setText(Integer.toString(Integer.parseInt(textField.getText()) + increment)));
            decrementButton.addActionListener(e -> textField.setText(Integer.toString(Integer.parseInt(textField.getText()) - increment)));

            panel.add(incrementButton);
            panel.add(decrementButton);
        }
        return panel;
    }

}


package AIOFisher;

import org.powerbot.script.*;
import org.powerbot.script.rt4.ClientContext;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

@Script.Manifest(name = "PowerFisherTasked", description ="fished fishes")

public class PowerFisher extends PollingScript<ClientContext> implements PaintListener, MessageListener {

    private static final Font TAHOMA = new Font("Tahoma", Font.PLAIN, 12);

    private int lobster_count = 0;
    private int lobster_price = 138;

    private List<Task> taskList = new ArrayList<>();

    @Override
    public void start(){
        taskList.addAll(Arrays.asList(new Fish(ctx), new Drop(ctx)));
//        drawGUI();
    }

    @Override
    public void poll() {
        for (Task task: taskList){
            if (task.activate()){
                System.out.println("executing");
                task.execute();
            }
        }
    }

    @Override
    public void repaint(Graphics graphics) {
        final Graphics2D g = (Graphics2D) graphics;
        g.setFont(TAHOMA);

        final int profit = lobster_price * lobster_count;
        final int profitHr = (int) ((profit * 3600000D) / getRuntime());
        final int fursHr = (int) ((lobster_count * 3600000D) / getRuntime());

        g.setColor(new Color(.5f,1f,.5f,.2f));
        g.fillRect(5, 290, 155, 45);

        g.setColor(Color.WHITE);

        g.drawString(String.format("Lobsters: %,d (%,d)", lobster_price, fursHr), 10, 307);
        g.drawString(String.format("Profit: %,d (%,d)", profit, profitHr), 10, 327);
    }

    @Override
    public void messaged(MessageEvent messageEvent) {
        final String msg = messageEvent.text().toLowerCase();
        //when we receive a message that says "20 coins have been removed..."
        System.out.println("Message received: " + msg);
        if (msg.equals("you catch a lobster.")) {
            //that means we bought a fur; increment the count.
            lobster_count++;
        }
    }

    public void drawGUI(){
        JFrame frame = new JFrame();

        JButton button = new JButton("click");
        button.setBounds(130,100,100, 40);

        frame.add(button);

        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

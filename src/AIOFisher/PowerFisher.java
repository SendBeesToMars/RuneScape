package AIOFisher;

import org.powerbot.script.*;
import org.powerbot.script.rt4.ClientContext;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

// TODO: make GUI
//  implement better stat tracking :)

@Script.Manifest(name = "PowerFisherTasked", description ="fished fishes")

public class PowerFisher extends PollingScript<ClientContext> implements PaintListener, MessageListener {

    private static final Font TAHOMA = new Font("Tahoma", Font.PLAIN, 12);

    private int fish_count = 0;
    private int fish_cooked =0;
    private int lobster_price = 138;
    private int FIRE_ID = 26185;

    private List<Task> taskList = new ArrayList<>();

    @Override
    public void start(){
//        taskList.addAll(Arrays.asList(new Fish(ctx), new Drop(ctx)));
        taskList.addAll(Arrays.asList(new Bank(ctx), new Cook(ctx), new Fire(ctx),new Fish(ctx), new Chop(ctx)));
//        drawGUI();
        ctx.camera.pitch(Random.nextInt(75,99));
    }

    @Override
    public void poll() {
        for (Task task: taskList){
            if (task.activate()){
                task.execute();
            }
        }
    }

    @Override
    public void repaint(Graphics graphics) {
        final Graphics2D g = (Graphics2D) graphics;
        g.setFont(TAHOMA);

        final int profit = lobster_price * fish_count;
        final int profitHr = (int) ((profit * 3600000D) / getRuntime());
        final int fishHr = (int) ((fish_count * 3600000D) / getRuntime());

        g.setColor(new Color(.5f,1f,.5f,.2f));
        g.fillRect(5, 290, 155, 45);

        g.setColor(Color.WHITE);

        g.drawString(String.format("Caught: %,d (%,d)", fish_count, fishHr), 10, 307);
        g.drawString(String.format("Cooked: %,d", fish_cooked), 10, 327);
    }

    @Override
    public void messaged(MessageEvent messageEvent) {

        final String msg = messageEvent.text().toLowerCase();

        System.out.println("Message received: " + msg);

        if (msg.contains("you catch")) {
            fish_count++;
        }
        else if(msg.contains("successfully cook some")){
            fish_cooked++;
        }
        else if (msg.equals("nothing interesting happens.")){
            ctx.camera.angle(ctx.camera.yaw() + Random.nextInt(110,180));
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

package AutoFighter;

import org.powerbot.script.*;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Constants;
import org.powerbot.script.rt4.Player;

import java.awt.*;

@Script.Manifest(name = "AutoFighterTasked", description ="it'll fight yer nan")

public class AutoFighter extends PollingScript<ClientContext> implements PaintListener, MessageListener {

    private static final Font TAHOMA = new Font("Tahoma", Font.PLAIN, 12);
    private final int initial_att = ctx.skills.experience(Constants.SKILLS_ATTACK);
    private final int initial_str = ctx.skills.experience(Constants.SKILLS_STRENGTH);
    private final int initial_def = ctx.skills.experience(Constants.SKILLS_DEFENSE);
    private final Tile initial_loc = ctx.players.local().tile();


    @Override
    public void messaged(MessageEvent messageEvent) {
        final String msg = messageEvent.text().toLowerCase();

        System.out.println("Message received: " + msg);
    }

    @Override
    public void repaint(Graphics graphics) {
        final Graphics2D g = (Graphics2D) graphics;
        g.setFont(TAHOMA);

        final int current_att = ctx.skills.experience(Constants.SKILLS_ATTACK);
        final int current_str = ctx.skills.experience(Constants.SKILLS_STRENGTH);
        final int current_def = ctx.skills.experience(Constants.SKILLS_DEFENSE);

        final int prog_att = current_att - initial_att;
        final int prog_str = current_str - initial_str;
        final int prog_def = current_def - initial_def;
//        final int profitHr = (int) ((profit * 3600000D) / getRuntime());
//        final int fishHr = (int) ((fish_count * 3600000D) / getRuntime());

        g.setColor(new Color(.5f,1f,.5f,.2f));
        g.fillRect(5, 290, 155, 45);

        g.setColor(Color.WHITE);

        g.drawString(String.format("Att  Str  Def"), 10, 307);
        g.drawString(String.format("%,d  %,d  %,d", prog_att, prog_str, prog_def), 10, 327);
    }

    Kill kill = new Kill(ctx);
    @Override
    public void poll() {
        if (kill.activate()){
            kill.execute();
        }
    }
}
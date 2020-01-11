package AutoFighter;

import org.powerbot.script.*;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Constants;

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

        if (msg.contains("congratulations, you've just advanced your")){
            System.out.println("att " + ctx.skills.level(Constants.SKILLS_ATTACK));
            System.out.println("str " + ctx.skills.level(Constants.SKILLS_STRENGTH));
            System.out.println("def " + ctx.skills.level(Constants.SKILLS_DEFENSE));
        }
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

        g.setColor(new Color(.5f,1f,.5f,.2f));
        g.fillRect(5, 290, 155, 45);

        g.setColor(Color.WHITE);

        g.drawString("Att  Str  Def", 10, 307);
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
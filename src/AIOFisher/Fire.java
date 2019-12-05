package AIOFisher;

import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Constants;
import org.powerbot.script.rt4.Item;

import java.util.concurrent.Callable;

public class Fire extends Task<ClientContext> {

    private int LOG_ID = 1511;
    private int TIDERBOX_ID = 590;
    private int FIRE_ID = 26185;

    public Fire(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return !ctx.objects.select().id(FIRE_ID).nearest().poll().inViewport()
                && !ctx.players.local().inMotion()
                && ctx.players.local().animation() == -1
                && ctx.inventory.select().id(LOG_ID).count() >= 1
                && ctx.inventory.select().id(TIDERBOX_ID).count() >= 1;
    }

    @Override
    public void execute() {
        System.out.println("@@@ FIRE");
        Item tinderbox = ctx.inventory.select().id(TIDERBOX_ID).poll();
        Item log = ctx.inventory.select().id(LOG_ID).poll();
        tinderbox.interact("Use");
        log.interact("Use");
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.players.local().animation() == -1;
            }
        }, 100, 10);
    }
}

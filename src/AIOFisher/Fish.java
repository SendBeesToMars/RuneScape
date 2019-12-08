package AIOFisher;

import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Npc;

public class Fish extends Task<ClientContext> {
    private int[] FISHING_SPOT_ID = {1522, 1525};
    private int LOG_ID = 1511;

    public Fish(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return !ctx.inventory.isFull()
                && ctx.inventory.select().id(LOG_ID).count() == 1
                && ctx.players.local().animation() == -1;
    }

    @Override
    public void execute() {
        System.out.println("@@@ FISH");
        Npc fishing_spot = ctx.npcs.select().id(FISHING_SPOT_ID).nearest().poll();
        if (fishing_spot.inViewport() && !ctx.players.local().inMotion()){
            ctx.camera.turnTo(fishing_spot);
            fishing_spot.interact("Small net");
            Condition.sleep(Random.nextInt(50,800));
            ctx.input.move(-3,Random.nextInt(15,300)); // moves mouse outside of play window(anti-anti-cheat??)
        } else {
            ctx.camera.turnTo(fishing_spot);
            ctx.movement.step(fishing_spot);
            System.out.println();
            Condition.sleep(Random.nextInt(50,800));
        }
    }
}

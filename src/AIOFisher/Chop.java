package AIOFisher;

import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Objects;

import java.util.concurrent.Callable;

public class Chop extends Task<ClientContext> {

    private int LOG_ID = 1511;
    private int FIRE_ID = 26185;
    private int[] TREE_ID = {1276, 1278};

    public Chop(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return !ctx.inventory.isFull()
                && !ctx.players.local().inMotion()
                && ctx.players.local().animation() == -1
                && ctx.inventory.select().id(LOG_ID).count() == 0
                && !ctx.objects.select().id(FIRE_ID).nearest().poll().inViewport();
    }

    @Override
    public void execute() {
        System.out.println("@@@ CHOP");
        GameObject tree = ctx.objects.select().id(TREE_ID).nearest().poll();

        if(ctx.widgets.component(231, 0).visible()){ // tree next to varrock bank, cant be chopped down
            ctx.camera.angle(ctx.camera.yaw() + Random.nextInt(110,180));
        }

        if (tree.inViewport()){
            tree.interact("Chop down", "Tree");
        } else {
            ctx.camera.turnTo(tree);
            ctx.movement.step(tree);
        }
    }
}

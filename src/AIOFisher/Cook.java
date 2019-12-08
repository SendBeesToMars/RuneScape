package AIOFisher;

import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Item;

import java.util.concurrent.Callable;

public class Cook extends Task<ClientContext> {

    private int FIRE_ID = 26185;
    private int[] RAW_FISH_ID = {317, 321};
    private int[] COOKED_FISH_ID = {323, 319, 315, 7954};


    public Cook(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.movement.distance(ctx.objects.select().id(FIRE_ID).nearest().poll(), ctx.players.local()) < 5
                && ctx.movement.distance(ctx.objects.select().id(FIRE_ID).nearest().poll(), ctx.players.local()) != -1
                && !ctx.players.local().inMotion()
                && ctx.players.local().animation() == -1
                && ctx.inventory.select().count() >= 27
                && ctx.inventory.select().id(COOKED_FISH_ID).count() != 24;
    }

    @Override
    public void execute() {
        System.out.println("@@@ COOK");
        Item fish = ctx.inventory.select().id(RAW_FISH_ID).poll();
        GameObject fire = ctx.objects.select().id(FIRE_ID).nearest().poll();

        Condition.sleep(Random.nextInt(3000,3550));

        if (ctx.players.local().animation() == -1 && fire.inViewport()){
            fish.interact("Use");
            fire.interact("Use", "Fire");

            Condition.sleep(Random.nextInt(450,800));
            ctx.input.send("{VK_SPACE}");

        } else {
            ctx.camera.turnTo(fire);
        }
    }
}

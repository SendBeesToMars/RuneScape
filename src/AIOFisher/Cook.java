package AIOFisher;

import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Item;

import java.util.concurrent.Callable;

public class Cook extends Task<ClientContext> {

    private int FIRE_ID = 26185;
    private int FISH_ID[] = {317, 321};

    public Cook(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.objects.select().id(FIRE_ID).nearest().poll().inViewport()
                && !ctx.players.local().inMotion()
                && ctx.players.local().animation() == -1;
    }

    @Override
    public void execute() {
        System.out.println("@@@ COOK");
        Item fish = ctx.inventory.select().id(FISH_ID).poll();
        GameObject fire = ctx.objects.select().id(FIRE_ID).nearest().poll();

        Condition.sleep(Random.nextInt(1500,2550));

        if (ctx.players.local().animation() == -1 && fire.inViewport()){
            fish.interact("Use");
            fire.interact("Use");

//          ctx.chat.clickContinue(); // sends virtual space key
            if (ctx.widgets.component(270, 14).component(29).visible()){
                Condition.sleep(Random.nextInt(450,800));
                ctx.input.send("{VK_SPACE}");
            }

        } else {
            ctx.camera.turnTo(fire);
        }
    }
}

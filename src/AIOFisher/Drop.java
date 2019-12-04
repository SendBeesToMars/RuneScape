package AIOFisher;

import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;

public class Drop extends Task<ClientContext>{

    private int LOG_ID = 377;

    public Drop(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.isFull();
    }

    @Override
    public void execute() {
        Condition.sleep(Random.nextInt(500,5000));
        for (Item i : ctx.inventory.select().id(LOG_ID)){
            ctx.inventory.drop(i, true);
            Condition.sleep(Random.nextInt(30,250));
        }
    }
}

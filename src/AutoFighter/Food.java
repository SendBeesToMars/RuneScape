package AutoFighter;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class Food extends Task<ClientContext> {

    public Food(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate(DataBean data) {
        return ctx.players.local().healthPercent() <= data.getHealPercent();
    }

    @Override
    public void execute(DataBean data) {
        if (ctx.players.local().animation() != 829){ // checks if already eating
            ctx.inventory.select().action("Eat").poll().interact("Eat");
        }
    }
}

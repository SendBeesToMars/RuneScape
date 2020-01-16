package AutoFighter;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class Food extends Task<ClientContext> {

    public Food(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate(Tile initial_loc) {
        return ctx.players.local().healthPercent() <= 30;
    }

    @Override
    public void execute(Tile initial_loc) {
        if (ctx.players.local().animation() != 829){ // checks if already eating
            ctx.inventory.select().action("Eat").poll().interact("Eat");
        }
    }
}

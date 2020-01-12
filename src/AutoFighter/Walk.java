package AutoFighter;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class Walk extends Task<ClientContext>  {
    public Walk(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.players.local().animation() == -1
                && !ctx.players.local().inMotion();
    }

    @Override
    public void execute(Tile initial_loc) {

    }
}

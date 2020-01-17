package AutoFighter;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class FightLocation extends Task<ClientContext> {

    public FightLocation(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate(Tile initial_loc) {
        return ctx.movement.distance(initial_loc) > 20 &&
                !ctx.players.local().inMotion();
    }

    @Override
    public void execute(Tile initial_loc) {
        ctx.movement.step(initial_loc);
    }
}

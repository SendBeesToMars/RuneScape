package AutoFighter;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class FightLocation extends Task<ClientContext> {

    public FightLocation(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate(DataBean data) {
        return ctx.movement.distance(data.getInitialPlayerLocation()) > 20 &&
                !ctx.players.local().inMotion();
    }

    @Override
    public void execute(DataBean data) {
        ctx.movement.step(data.getInitialPlayerLocation());
    }
}

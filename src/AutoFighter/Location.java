package AutoFighter;

import org.powerbot.script.rt4.ClientContext;

public class Location extends Task<ClientContext> {

    public Location(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate(DataBean data) {
        return ctx.movement.distance(data.getInitialPlayerLocation()) > data.getFightLocationSize() &&
                ctx.players.local().animation() == -1;
    }

    @Override
    public void execute(DataBean data) {
        ctx.movement.step(data.getInitialPlayerLocation());
    }
}

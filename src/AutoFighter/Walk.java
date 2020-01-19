package AutoFighter;

import org.powerbot.script.rt4.ClientContext;

public class Walk extends Task<ClientContext>  {
    public Walk(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate(DataBean data) {
        return !ctx.movement.running() &&
                ctx.movement.energyLevel() == 100;
    }

    @Override
    public void execute(DataBean data) {
        ctx.movement.running(true);
    }
}

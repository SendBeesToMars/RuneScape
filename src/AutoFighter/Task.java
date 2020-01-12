package AutoFighter;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientAccessor;
import org.powerbot.script.rt4.ClientContext;

public abstract class Task<C extends ClientContext> extends ClientAccessor {

    public Task(C ctx) {
        super(ctx);
    }

    public abstract boolean activate();
    public abstract void execute(Tile initial_loc);
}

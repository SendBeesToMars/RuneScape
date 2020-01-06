package AutoFighter;

import org.powerbot.script.Filter;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Npc;

public class Kill extends Task<ClientContext> {

    private int[] GOBLIN_ID = {3031, 3033, 3034, 3017, 3029, 3036, 3030};

    public Kill(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        System.out.println(getAttackable());
        return ctx.players.local().animation() == -1
                && !ctx.players.local().inMotion()
                && ctx.npcs.select().id(GOBLIN_ID).nearest().poll().inViewport()
                && ctx.npcs.select().id(GOBLIN_ID).nearest().poll().interacting().name().equals("")
                && getCombatant().name().equals("");
    }

    @Override
    public void execute() {
        System.out.println("killing");
        ctx.npcs.select().id(GOBLIN_ID).nearest().poll().interact("Attack");

    }
    public Npc getCombatant() {
        return ctx.npcs.select().action("Attack").nearest()
                .select(n -> n.interacting().name().equals(ctx.players.local().name())).peek();
    }

    public Npc getAttackable() {
        return ctx.npcs.select().action("Attack").nearest().poll();
    }
}

package AutoFighter;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Npc;

public class Bones extends Task<ClientContext> {

    public Bones(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate(DataBean data) {
        return ctx.players.local().animation() == -1 &&
                !ctx.players.local().inMotion() &&
                getCombatant().healthPercent() == 0;
    }

    @Override
    public void execute(DataBean data) {
        System.out.println("bones picking up lakshjgd");
        System.out.println("does this say bones? " + ctx.objects.select().select(gameObject -> gameObject.name().equals("Bones")).nearest().poll().name());
//        ctx.objects.select().select(gameObject -> gameObject.name().equals("Bones")).poll().interact("Take", "Bones");
    }

    public Npc getCombatant() {
        return ctx.npcs.select().action("Attack").nearest()
                .select(n -> n.interacting().name().equals(ctx.players.local().name())).poll();
    }
}

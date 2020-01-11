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
        return ctx.players.local().animation() == -1
                && !ctx.players.local().inMotion()
                && !getAttackable().interacting().valid()
                && getAttackable().combatLevel() >= 2
                &&getAttackable().combatLevel() <= 7;
    }

    @Override
    public void execute() {
        Npc target = getAttackable();

        if (!getCombatant().name().equals("")){
            getCombatant().interact("Attack");
        }
        else if (target.healthPercent() != 0 && target.inViewport() && ctx.players.local().animation() == -1){
            printAllNpcs();
            target.interact("Attack");
        }
        else{
            ctx.camera.turnTo(target);
            ctx.movement.step(target);
        }
    }

    public Npc getCombatant() {
        return ctx.npcs.select().action("Attack").nearest()
                .select(n -> n.interacting().name().equals(ctx.players.local().name())).poll();
    }

    public void printAllNpcs(){
        System.out.println(ctx.npcs.select().each(npc -> {
            System.out.println(npc.interacting().name());
            return false;
        }));
    }

    public Npc getAttackable() {
        return ctx.npcs.select().action("Attack").nearest().poll();
    }
}

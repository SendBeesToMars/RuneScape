package AutoFighter;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Npc;

public class Kill extends Task<ClientContext> {

    public Kill(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate(DataBean data) {
        return ctx.players.local().animation() == -1
                && !ctx.players.local().inMotion()
                && !data.getLevelupFlag();
    }

    @Override
    public void execute(DataBean data) {
        Npc target = getAttackable(data);

        if (getCombatant().healthPercent() != 0 && getCombatant().healthPercent() != -1){ //anti stuck
            if (!ctx.players.local().interacting().valid()){
                getCombatant().interact("Attack");
            }
        }
        else if (target.healthPercent() != 0 && target.inViewport() && ctx.players.local().animation() == -1){
            target.interact("Attack");
        }
        else{
            if (!target.inViewport()){
                ctx.camera.turnTo(target);
            }
            if (ctx.movement.distance(ctx.movement.destination()) < ctx.movement.distance(ctx.movement.destination(), data.getInitialPlayerLocation())){
                ctx.movement.step(target);
            }
        }
    }

    public Npc getCombatant() {
        return ctx.npcs.select().action("Attack").nearest()
                .select(n -> n.interacting().name().equals(ctx.players.local().name())).poll();
    }

    public void printAllNpcs(){
//        System.out.println("interacting with: " + ctx.npcs.select().each(npc -> npc.interacting().valid()).nearest().poll().interacting().name());
        System.out.println("interacting with: " + ctx.movement.distance(ctx.npcs.select().nearest().poll().tile()));
    }

    public Npc getAttackable(DataBean data) {
        return ctx.npcs.select().action("Attack").select(npc ->
                !npc.interacting().valid() &&
                npc.combatLevel() >= data.getMobMinLevel() &&
                npc.combatLevel() <= data.getMobMaxLevel()).nearest().poll();
    }
}

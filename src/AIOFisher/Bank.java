package AIOFisher;

import org.powerbot.script.Locatable;
import org.powerbot.script.rt4.ClientContext;

public class Bank extends Task<ClientContext> {

    private int[] TO_BANK = {323, 319, 315, 7954};
    private int[] DONT_BANK = {1351, 303, 590, 1511};

    public Bank(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return !ctx.players.local().inMotion()
                && ctx.players.local().animation() == -1
                && ctx.inventory.select().id(TO_BANK).count() == 24;
    }

    @Override
    public void execute() {
        System.out.println("@@@ BANK");
        Locatable bank = ctx.bank.nearest().tile();

        if (!ctx.bank.inViewport()){
            ctx.camera.turnTo(bank);
            ctx.movement.step(bank);
        } else {
            ctx.bank.open();
            ctx.bank.depositAllExcept(DONT_BANK);
            ctx.bank.close();
        }

    }
}

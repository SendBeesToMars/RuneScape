package AutoFighter;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Constants;

public class CombatType extends Task<ClientContext> {
    public CombatType(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate(DataBean data) {
        return ctx.skills.level(Constants.SKILLS_ATTACK)  >= data.getMaxAtt() &&
                ctx.skills.level(Constants.SKILLS_STRENGTH) >= data.getMaxStr() &&
                ctx.skills.level(Constants.SKILLS_DEFENSE) >= data.getMaxDef();
    }

    @Override
    public void execute(DataBean data) {

        System.out.println("stopping bot due to lever combat level requirements being met");
        ctx.controller.stop();
    }
}

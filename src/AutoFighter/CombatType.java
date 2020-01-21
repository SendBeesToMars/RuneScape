package AutoFighter;

import org.powerbot.script.rt4.*;

public class CombatType extends Task<ClientContext> {
    Combat.Style style = Combat.Style.AGGRESSIVE;

    public CombatType(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate(DataBean data) {
        return data.getLevelupFlag();
    }

    @Override
    public void execute(DataBean data) {
        if (ctx.skills.level(Constants.SKILLS_ATTACK)  >= data.getMaxAtt() &&
                ctx.skills.level(Constants.SKILLS_STRENGTH) >= data.getMaxStr() &&
                ctx.skills.level(Constants.SKILLS_DEFENSE) >= data.getMaxDef()){
            System.out.println("stopping bot due to lever combat level requirements being met");
            ctx.controller.stop();
        }
        if (ctx.skills.level(Constants.SKILLS_ATTACK)  < data.getMaxAtt()){
            style = Combat.Style.ACCURATE;
        }
        if (ctx.skills.level(Constants.SKILLS_STRENGTH)  < data.getMaxStr()){
            style = Combat.Style.AGGRESSIVE;
        }
        if (ctx.skills.level(Constants.SKILLS_DEFENSE) < data.getMaxDef()){
            style = Combat.Style.DEFENSIVE;
        }

//        if (ctx.skills.level(Constants.SKILLS_DEFENSE) < data.getMaxDef()){
//            if (ctx.skills.level(Constants.SKILLS_ATTACK) >= data.getMaxAtt()){
//                style = Combat.Style.DEFENSIVE;
//            }
//            else if ((ctx.skills.level(Constants.SKILLS_ATTACK) - ctx.skills.level(Constants.SKILLS_DEFENSE) >= 5)){
//                style = Combat.Style.DEFENSIVE;
//            }
//            else {
//                style = Combat.Style.ACCURATE;
//            }
//        }
        if (ctx.game.tab() == Game.Tab.ATTACK){
            ctx.combat.style(style);
            if (ctx.combat.style() == style){
                data.setLevelupFlag(false);
            }
            ctx.game.tab(Game.Tab.INVENTORY);
        }
        else {
            ctx.game.tab(Game.Tab.ATTACK);
        }
    }
}

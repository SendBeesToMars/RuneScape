package AutoFighter;

import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.*;

public class CombatStyle extends Task<ClientContext> {
    Combat.Style style = Combat.Style.AGGRESSIVE;

    public CombatStyle(ClientContext ctx) {
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
            Condition.sleep(Random.nextInt(200, 1400));
            if (ctx.game.loggedIn()){
                ctx.game.logout();
            }
            ctx.controller.stop();
        }
        else{
            // checks if difference between combat styles is higher than 5 -> if so level the lover one
            if (ctx.skills.level(Constants.SKILLS_ATTACK)  < data.getMaxAtt()){
                style = Combat.Style.ACCURATE;
                if (ctx.skills.level(Constants.SKILLS_STRENGTH)  < data.getMaxStr() && (ctx.skills.level(Constants.SKILLS_ATTACK) - ctx.skills.level(Constants.SKILLS_STRENGTH)) >= 5) {
                    style = Combat.Style.AGGRESSIVE;
                    if (ctx.skills.level(Constants.SKILLS_DEFENSE)  < data.getMaxDef() && (ctx.skills.level(Constants.SKILLS_STRENGTH) - ctx.skills.level(Constants.SKILLS_DEFENSE)) >= 5) {
                        style = Combat.Style.DEFENSIVE;
                    }
                }
                if (ctx.skills.level(Constants.SKILLS_DEFENSE)  < data.getMaxDef() && (ctx.skills.level(Constants.SKILLS_ATTACK) - ctx.skills.level(Constants.SKILLS_DEFENSE)) >= 5) {
                    style = Combat.Style.DEFENSIVE;
                    if (ctx.skills.level(Constants.SKILLS_STRENGTH)  < data.getMaxStr() && (ctx.skills.level(Constants.SKILLS_DEFENSE) - ctx.skills.level(Constants.SKILLS_STRENGTH)) >= 5) {
                        style = Combat.Style.AGGRESSIVE;
                    }
                }
            }
            if (ctx.skills.level(Constants.SKILLS_STRENGTH)  < data.getMaxStr()){
                style = Combat.Style.AGGRESSIVE;
                if (ctx.skills.level(Constants.SKILLS_ATTACK)  < data.getMaxAtt() && (ctx.skills.level(Constants.SKILLS_STRENGTH) - ctx.skills.level(Constants.SKILLS_ATTACK)) >= 5) {
                    style = Combat.Style.ACCURATE;
                    if (ctx.skills.level(Constants.SKILLS_DEFENSE)  < data.getMaxDef() && (ctx.skills.level(Constants.SKILLS_ATTACK) - ctx.skills.level(Constants.SKILLS_DEFENSE)) >= 5) {
                        style = Combat.Style.DEFENSIVE;
                    }
                }
                if (ctx.skills.level(Constants.SKILLS_DEFENSE)  < data.getMaxDef() && (ctx.skills.level(Constants.SKILLS_STRENGTH) - ctx.skills.level(Constants.SKILLS_DEFENSE)) >= 5) {
                    style = Combat.Style.DEFENSIVE;
                    if (ctx.skills.level(Constants.SKILLS_DEFENSE)  < data.getMaxDef() && (ctx.skills.level(Constants.SKILLS_DEFENSE) - ctx.skills.level(Constants.SKILLS_ATTACK)) >= 5) {
                        style = Combat.Style.ACCURATE;
                    }
                }
            }
            if (ctx.skills.level(Constants.SKILLS_DEFENSE) < data.getMaxDef()){
                style = Combat.Style.DEFENSIVE;
                if (ctx.skills.level(Constants.SKILLS_ATTACK)  < data.getMaxAtt() && (ctx.skills.level(Constants.SKILLS_DEFENSE) - ctx.skills.level(Constants.SKILLS_ATTACK)) >= 5) {
                    style = Combat.Style.ACCURATE;
                    if (ctx.skills.level(Constants.SKILLS_STRENGTH)  < data.getMaxStr() && (ctx.skills.level(Constants.SKILLS_ATTACK) - ctx.skills.level(Constants.SKILLS_STRENGTH)) >= 5) {
                        style = Combat.Style.AGGRESSIVE;
                    }
                }
                if (ctx.skills.level(Constants.SKILLS_STRENGTH)  < data.getMaxStr() && (ctx.skills.level(Constants.SKILLS_DEFENSE) - ctx.skills.level(Constants.SKILLS_STRENGTH)) >= 5) {
                    style = Combat.Style.AGGRESSIVE;
                    if (ctx.skills.level(Constants.SKILLS_ATTACK)  < data.getMaxAtt() && (ctx.skills.level(Constants.SKILLS_STRENGTH) - ctx.skills.level(Constants.SKILLS_ATTACK)) >= 5) {
                        style = Combat.Style.ACCURATE;
                    }
                }
            }

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
}

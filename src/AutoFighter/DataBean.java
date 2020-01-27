package AutoFighter;

import org.powerbot.script.Tile;

import java.io.Serializable;

public class DataBean implements Serializable {
    private int mobMaxLevel;
    private int mobMinLevel = 1;
    private Tile initialPlayerLocation;
    private int fightLocationSize;
    private int healPercent;
    private int MaxAtt = 99;
    private int MaxStr = 99;
    private int MaxDef = 99;
    private boolean guiConfirmFlag = false;
    private boolean levelupFlag = true;
    private boolean targetDead = false;


    public int getMobMaxLevel() {
        return mobMaxLevel;
    }

    public void setMobMaxLevel(int mobMaxLevel) {
        this.mobMaxLevel = mobMaxLevel;
    }

    public int getMobMinLevel() {
        return mobMinLevel;
    }

    public void setMobMinLevel(int mobMinLevel) {
        this.mobMinLevel = mobMinLevel;
    }

    public Tile getInitialPlayerLocation() {
        return initialPlayerLocation;
    }

    public void setInitialPlayerLocation(Tile initialPlayerLocation) {
        this.initialPlayerLocation = initialPlayerLocation;
    }

    public int getFightLocationSize() {
        return fightLocationSize;
    }

    public void setFightLocationSize(int fightLocationSize) {
        this.fightLocationSize = fightLocationSize;
    }

    public int getHealPercent() {
        return healPercent;
    }

    public void setHealPercent(int healPercent) {
        this.healPercent = healPercent;
    }

    public int getMaxAtt() {
        return MaxAtt;
    }

    public void setMaxAtt(int maxAtt) {
        MaxAtt = maxAtt;
    }

    public int getMaxStr() {
        return MaxStr;
    }

    public void setMaxStr(int maxStr) {
        MaxStr = maxStr;
    }

    public int getMaxDef() {
        return MaxDef;
    }

    public void setMaxDef(int maxDef) {
        MaxDef = maxDef;
    }

    public boolean getGuiConfirmFlag() {
        return guiConfirmFlag;
    }

    public void setGuiConfirmFlag(boolean confirm) {
        this.guiConfirmFlag = confirm;
    }

    public boolean getLevelupFlag() {
        return levelupFlag;
    }

    public void setLevelupFlag(boolean levelupFlag) {
        this.levelupFlag = levelupFlag;
    }

    public boolean getTargetDead() {
        return targetDead;
    }

    public void setTargetDead(boolean targetDead) {
        this.targetDead = targetDead;
    }
}

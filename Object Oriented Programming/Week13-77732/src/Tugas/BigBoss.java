package Tugas;

public class BigBoss {
    private int hitPoint;
    private int damageReduction;
    private int damageTaken;
    private BattleLog report;

    public BigBoss(int hitPoint, int damageReduction) {
        this.hitPoint = hitPoint;
        this.damageReduction = damageReduction;
        this.damageTaken = 0;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public void registerBattleLog(BattleLog report) {
        this.report = report;
    }

    public void onDamageApplied(Player player) {
        int damageTakenByBoss = Math.max(0, player.getDamage() - this.damageReduction);
        this.hitPoint -= damageTakenByBoss;
        this.damageTaken += damageTakenByBoss;

        report.reportBattle(player, damageTakenByBoss, this.hitPoint);
        report.playerHitBack(player, this.damageReduction);
    }
}

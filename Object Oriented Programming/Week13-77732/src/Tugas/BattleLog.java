package Tugas;

public interface BattleLog {
    void playerHitBack(Player player, int damageReductionFromBoss);
    void reportBattle(Player player, int damageTakenBoss, int hitPointBoss);
}


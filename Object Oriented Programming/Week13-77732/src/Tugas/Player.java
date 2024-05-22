package Tugas;

public class Player {
    private String name;
    private int hitPoint;
    private int damage;
    private int energy;

    public Player(String name, int hitPoint, int damage, int energy) {
        this.name = name;
        this.hitPoint = hitPoint;
        this.damage = damage;
        this.energy = energy;
    }

    // Getters dan Setters
    public String getName() {
        return name;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public int getDamage() {
        return damage;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}


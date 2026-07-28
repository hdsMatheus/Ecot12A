package re3;

public abstract class Enemy extends Character {
    protected int damage;
    protected double speed;
    protected int experienceValue;

    public Enemy(String name, int health, int maxHealth, int damage, double speed, int experienceValue) {
        super(name, health, maxHealth);
        this.damage = damage;
        this.speed = speed;
        this.experienceValue = experienceValue;
    }

    @Override
    public abstract void attack(Character target); //cada inimigo ataca de um jeito diferente

    public void pursue(Character target) { // imprime quem está perseguindo
        System.out.println(name + " is pursuing " + target.getName() + " at speed " + speed + "!");
    }

    public int getDamage() { //get
        return this.damage;
    }
}

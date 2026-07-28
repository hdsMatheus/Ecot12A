package re3;

public class Nemesis extends Enemy {
    private int phase;
    private boolean canUseTentacle;
    private boolean isInvulnerable;

    public Nemesis(String name, int health, int damage, double speed) { //construtor
        super(name, health, health, damage, speed, 1000);
        this.phase = 1;
        this.canUseTentacle = true;
        this.isInvulnerable = false;
    }

    @Override
    public void attack(Character target) { //sobrescreve o metodo attack da classe Enemy
        if (isInvulnerable) {
            System.out.println(name + " is roaring and invulnerable this turn!");
            return;
        }

        if (canUseTentacle && Math.random() < 0.6) {
            tentacleAttack(target);
        } else {
            System.out.println(name + " delivers a heavy punch to " + target.getName() + " dealing " + damage + " damage!");
            target.takeDamage(damage);
            GameManager.getInstance().notifyObservers(new CombatEvent(this, target, damage));
        }
    }

    public void tentacleAttack(Character target) { //ataque com tentaculo
        int tentacleDamage = damage + 15;
        System.out.println(name + " launches a tentacle attack on " + target.getName() + " dealing " + tentacleDamage + " damage!");
        target.takeDamage(tentacleDamage);
        GameManager.getInstance().notifyObservers(new CombatEvent(this, target, tentacleDamage));
    }

    public void evolve() { //evolução do boss, aumenta stats e muda fase
        if (phase < 3) {
            this.phase++;
            this.damage += 20;
            this.maxHealth += 200;
            this.health = this.maxHealth;
            System.out.println(name + " evolved to Phase " + phase + "! Stats increased!");
            GameManager.getInstance().notifyObservers(new BossEvent(this, phase, false));
        }
    }

    public Item dropItem() { //dropa item ao morrer
        System.out.println(name + " dropped a rare item!");
        return new HealingItem("First Aid Spray", 100);
    }

    @Override
    public void takeDamage(int amount) { //sobrescreve o metodo takeDamage da classe Enemy
        if (isInvulnerable) {
            System.out.println(name + " blocks the attack! Invulnerable!");
            return;
        }
        super.takeDamage(amount);
        if (!isAlive()) {
            GameManager.getInstance().notifyObservers(new BossEvent(this, phase, true));
        }
    }
}

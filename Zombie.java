package re3;

public class Zombie extends Enemy {
    private double grabRange;
    private boolean isInfected;

    public Zombie(String name, int health, int damage, double speed, double grabRange) { //construtor
        super(name, health, health, damage, speed, 50);
        this.grabRange = grabRange;
        this.isInfected = true;
    }

    @Override
    public void attack(Character target) { 
        if (Math.random() < 0.6) {
            bite(target);
        } else {
            grab(target);
        }
    }

    public void bite(Character target) { //Mordida do zumbi, causa dano e notifica o GameManager
        System.out.println(name + " bites " + target.getName() + " dealing " + damage + " damage!");
        target.takeDamage(damage);
        GameManager.getInstance().notifyObservers(new CombatEvent(this, target, damage));
    }

    public void grab(Character target) { //Agarrar do zumbi, causa dano reduzido e notifica o GameManager
        System.out.println(name + " lunges to grab " + target.getName() + " within range " + grabRange + "!");
        int grabDamage = damage / 2;
        target.takeDamage(grabDamage);
        GameManager.getInstance().notifyObservers(new CombatEvent(this, target, grabDamage));
    }
}

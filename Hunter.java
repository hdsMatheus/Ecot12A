package re3;

public class Hunter extends Enemy {
    private double jumpRange; 
    private int clawDamage; //garras

    public Hunter(String name, int health, int damage, double speed, double jumpRange, int clawDamage) { //construtor
        super(name, health, health, damage, speed, 150);
        this.jumpRange = jumpRange;
        this.clawDamage = clawDamage;
    }

    @Override
    public void attack(Character target) { //randomiza o ataque entre garras e salto
        if (Math.random() < 0.5) {
            slash(target);
        } else {
            leap(target);
        }
    }

    public void slash(Character target) { //ataque com garras
        System.out.println(name + " slashes " + target.getName() + " with sharp claws dealing " + clawDamage + " damage!");
        target.takeDamage(clawDamage);
        GameManager.getInstance().notifyObservers(new CombatEvent(this, target, clawDamage));
    }

    public void leap(Character target) { //ataque com salto
        System.out.println(name + " leaps from " + jumpRange + " meters and strikes " + target.getName() + "!");
        int leapDamage = damage + 10;
        target.takeDamage(leapDamage);
        GameManager.getInstance().notifyObservers(new CombatEvent(this, target, leapDamage));
    }
}

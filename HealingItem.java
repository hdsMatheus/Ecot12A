package re3;

public class HealingItem extends Item { //herda de item
    private int healAmount;
    private String type;

    public HealingItem(String name, String description, double weight, int healAmount, String type) { //construtor 1
        super(name, description, weight);
        this.healAmount = healAmount;
        this.type = type;
    }

    public HealingItem(String name, int healAmount) { //construtor 2
        super(name, "A healing item that restores " + healAmount + " health", 0.2);
        this.healAmount = healAmount;
        this.type = name;
    }

    @Override
    public void use(Survivor target) {
        System.out.println(target.getName() + " uses " + name + " healing for " + healAmount + " points.");
        target.heal(healAmount); // aplica a cura ao sobrevivente
    }

    public int getHealAmount() { //get
        return this.healAmount;
    }
}

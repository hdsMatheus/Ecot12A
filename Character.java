package re3;

public abstract class Character {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected String status;

    public Character(String name, int health, int maxHealth) { //construtor
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
        this.status = "Fine";
    }

    public abstract void attack(Character target); //abstract porque vai ser reescrito depois

    public void takeDamage(int amount) {
        this.health = Math.max(0, this.health - amount); //impede que a vida fique negativa
        if (this.health == 0) {
            this.status = "Dead";
        } else if (this.health < this.maxHealth * 0.3) { //se tiver < 30 danger
            this.status = "Danger";
        } else if (this.health < this.maxHealth * 0.7) { //se tiver < 70 caution
            this.status = "Caution";
        }
    }

    public void heal(int amount) {
        if (isAlive()) {
            this.health = Math.min(this.maxHealth, this.health + amount);//impede vida maxima
            if (this.health >= this.maxHealth * 0.7) {
                this.status = "Fine";
            } else if (this.health >= this.maxHealth * 0.3) {
                this.status = "Caution";
            }
        }
    }

    public boolean isAlive() { //verifica se ta vivo
        return this.health > 0; 
    }

    public String getName() { //get
        return this.name;
    }

    public int getHealth() { //get
        return this.health;
    }
}
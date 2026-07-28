package re3;

public class CombatEvent extends GameEvent {
    private Character attacker;
    private Character defender;
    private int damageDealt; //dano causado

    public CombatEvent(Character attacker, Character defender, int damageDealt) { //construtor
        super("COMBAT", attacker);
        this.attacker = attacker;
        this.defender = defender;
        this.damageDealt = damageDealt;
    }

    public Character getAttacker() { //get
        return this.attacker;
    }

    public Character getDefender() { //get
        return this.defender;
    }

    public int getDamageDealt() { //get
        return this.damageDealt;
    }
}

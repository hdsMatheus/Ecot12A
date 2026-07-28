package re3;

public class BossEvent extends GameEvent {
    private Nemesis boss;
    private int phase;
    private boolean isDefeated;

    public BossEvent(Nemesis boss, int phase, boolean isDefeated) { //construtor
        super("BOSS", boss);
        this.boss = boss;
        this.phase = phase;
        this.isDefeated = isDefeated;
    }

    public Nemesis getBoss() { //get
        return boss;
    }

    public int getPhase() { //get
        return phase;
    }

    public boolean isDefeated() { //get
        return isDefeated;
    }
}
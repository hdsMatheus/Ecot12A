package re3;

public class GameEvent {
    protected String eventType;
    protected long timestamp;
    protected Object source;

    public GameEvent(String eventType, Object source) {
        this.eventType = eventType;
        this.source = source;
        this.timestamp = System.currentTimeMillis();
    }

    public String getEventType() { //construtor
        return this.eventType;
    }

    public long getTimestamp() { //get
        return this.timestamp;
    }

    public Object getSource() { //get
        return this.source;
    }
}

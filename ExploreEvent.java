package re3;

public class ExploreEvent extends GameEvent {
    private Location location;
    private Item itemFound;

    public ExploreEvent(Location location, Item itemFound) { //construtor
        super("EXPLORE", location);
        this.location = location;
        this.itemFound = itemFound;
    }

    public Location getLocation() { //get
        return this.location;
    }

    public Item getItemFound() { //get
        return this.itemFound;
    }
}

package re3;

public class KeyItem extends Item {
    private String keyId;
    private String usedAt; 

    public KeyItem(String name, String description, double weight, String keyId, String usedAt) { //construtor
        super(name, description, weight);
        this.keyId = keyId;
        this.usedAt = usedAt;
    }

    @Override
    public void use(Survivor survivor) { //verifica se o item pode ser usado na localizacao atual
        Location currentLoc = GameManager.getInstance().getCurrentLocation();
        if (isUsable(currentLoc)) {
            System.out.println(survivor.getName() + " uses " + name + " to unlock progress in " + currentLoc.getName() + ".");
        } else {
            System.out.println(name + " cannot be used in " + currentLoc.getName() + ". It needs to be used at " + usedAt + ".");
        }
    }

    public boolean isUsable(Location location) { //get
        return location != null && location.getName().equalsIgnoreCase(usedAt);
    }

    public String getKeyId() { //get
        return this.keyId;
    }

    public String getUsedAt() { //get
        return this.usedAt;
    }
}

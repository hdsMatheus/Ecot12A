package re3;

public abstract class Item {
    protected String name;
    protected String description;
    protected double weight;

    public Item(String name, String description, double weight) { //construtor
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    public abstract void use(Survivor target); //metodo abstrato que será implementado nas subclasses

    public String getName() { //get
        return this.name;
    }

    public String getDescription() { //get
        return this.description;
    }
}

package re3;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private String name;
    private String description;
    private boolean isAccessible;
    private List<Enemy> enemies;
    private List<Item> items;

    public Location(String name, String description, boolean isAccessible) { //construtor
        this.name = name;
        this.description = description;
        this.isAccessible = isAccessible;
        this.enemies = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public void addEnemy(Enemy enemy) { //adiciona inimigo a lista de inimigos da localizacao
        enemies.add(enemy);
    }

    public void removeEnemy(Enemy enemy) { //remove inimigo da lista de inimigos da localizacao
        enemies.remove(enemy);
    }

    public List<Enemy> getEnemies() { //get
        return this.enemies;
    }

    public boolean isCleared() { //get
        return enemies.isEmpty();
    }

    public void addItem(Item item) { //adiciona item a lista de itens da localizacao
        items.add(item);
    }

    public void removeItem(Item item) { //remove item da lista de itens da localizacao
        items.remove(item);
    }

    public List<Item> getItems() { //get
        return this.items;
    }

    public String getName() { //get
        return name;
    }

    public String getDescription() { //get
        return description;
    }

    public boolean isAccessible() { //get
        return isAccessible;
    }

    public void setAccessible(boolean accessible) { //get
        isAccessible = accessible;
    }
}

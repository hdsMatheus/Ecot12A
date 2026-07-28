package re3;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;
    private int maxSlots;
    private int currentSlots;

    public Inventory(int maxSlots) { //construtor
        this.items = new ArrayList<>();
        this.maxSlots = maxSlots;
        this.currentSlots = 0;
    }

    public boolean addItem(Item item) {
        if (!isFull()) { //se nao estiver cheio, adiciona o item
            items.add(item);
            currentSlots = items.size();
            System.out.println(item.getName() + " was added to the inventory.");
            return true;
        } else {
            System.out.println("Inventory is full! Cannot add " + item.getName() + ".");
            return false;
        }
    }

    public void removeItem(Item item) {
        if (items.remove(item)) { //tenta remover o item, se conseguir, atualiza currentSlots
            currentSlots = items.size();
            System.out.println(item.getName() + " was removed from the inventory.");
        }
    }

    public boolean hasItem(Item item) { //tem o item no inventario?
        return items.contains(item);
    }

    public boolean hasItem(String name) { // verifica se tem o item pelo nome
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() { //get
        return currentSlots >= maxSlots;
    }

    public List<Item> getItems() { //get
        return this.items;
    }

    public int getMaxSlots() { //get
        return maxSlots;
    } 

    public int getCurrentSlots() { //get
        return currentSlots;
    }
}

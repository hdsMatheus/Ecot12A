package re3;

public class Survivor extends Character {
    private Inventory inventory;
    private Weapon weaponEquipped;

    public Survivor(String name, int health, int maxHealth) { //construtor
        super(name, health, maxHealth);
        this.inventory = new Inventory(8);
    }

    @Override
    public void attack(Character target) { //sobrescreve o metodo attack da classe Character
        if (weaponEquipped != null && weaponEquipped.getAmmoCount() > 0) {
            shoot(target);
        } else {
            int damage = 5;
            System.out.println(name + " attacks " + target.getName() + " with bare hands for " + damage + " damage!");
            target.takeDamage(damage);
            GameManager.getInstance().notifyObservers(new CombatEvent(this, target, damage));
        }
    }

    public void equipWeapon(Weapon weapon) { //equipa a arma
        this.weaponEquipped = weapon;
        System.out.println(name + " equipped " + weapon.getName() + ".");
    }

    public void shoot(Character target) { //ataca com a arma equipada
        if (weaponEquipped != null) {
            if (weaponEquipped.getAmmoCount() > 0) {
                weaponEquipped.fire();
                int damage = weaponEquipped.getDamage();
                System.out.println(name + " shoots " + target.getName() + " using " + weaponEquipped.getName() + " dealing " + damage + " damage!");
                target.takeDamage(damage);
                GameManager.getInstance().notifyObservers(new CombatEvent(this, target, damage));
            } else {
                System.out.println("Click! " + weaponEquipped.getName() + " is out of ammo!");
            }
        } else {
            System.out.println(name + " has no weapon equipped to shoot!");
        }
    }

    public void reload() { //recarrega a arma equipada
        if (weaponEquipped != null) {
            for (Item item : inventory.getItems()) {
                if (item instanceof Ammo) {
                    Ammo ammoItem = (Ammo) item;
                    if (ammoItem.getAmmoType().equals(weaponEquipped.getAmmoType())) {
                        weaponEquipped.reload(ammoItem);
                        inventory.removeItem(ammoItem);
                        System.out.println(name + " reloaded " + weaponEquipped.getName() + ".");
                        return;
                    }
                }
            }
            System.out.println("No matching ammo found in inventory to reload " + weaponEquipped.getName() + "!");
        } else {
            System.out.println("No weapon equipped to reload!");
        }
    }

    public void useItem(Item item) { //usa item do inventario
        if (inventory.hasItem(item)) {
            item.use(this);
            inventory.removeItem(item);
        } else {
            System.out.println(name + " doesn't have " + item.getName() + " in inventory!");
        }
    }

    public Inventory getInventory() { //get
        return this.inventory;
    }

    public Weapon getWeaponEquipped() { //get
        return this.weaponEquipped;
    }
}

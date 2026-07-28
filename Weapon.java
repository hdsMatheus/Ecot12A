package re3;

public class Weapon {
    private String name;
    private int damage;
    private String ammoType;
    private int currentAmmo;
    private int maxAmmo;

    public Weapon(String name, int damage, String ammoType, int maxAmmo, int currentAmmo) { //construtor
        this.name = name;
        this.damage = damage;
        this.ammoType = ammoType;
        this.currentAmmo = currentAmmo;
        this.maxAmmo = maxAmmo;
    }

    public void fire() { //dispara a arma, reduzindo a quantidade de munição
        if (currentAmmo > 0) {
            currentAmmo--;
        }
    }

    public void reload(Ammo ammo) { //recarrega a arma com o tipo de munição correto 
        if (ammo.getAmmoType().equals(this.ammoType)) {
            this.currentAmmo = Math.min(this.maxAmmo, this.currentAmmo + ammo.getQuantity());
        } else {
            System.out.println("Ammo type mismatch! Weapon uses " + ammoType + " but got " + ammo.getAmmoType());
        }
    }

    public int getAmmoCount() { //get
        return this.currentAmmo;
    }

    public boolean isEmpty() { //get
        return this.currentAmmo == 0;
    }

    public String getName() { //get
        return name;
    }

    public int getDamage() { //get
        return damage;
    }

    public String getAmmoType() { //get
        return ammoType;
    }

    public int getMaxAmmo() { //get
        return maxAmmo;
    }
}

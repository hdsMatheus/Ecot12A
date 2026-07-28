package re3;

public class Ammo extends Item { //herda de item
    private String ammoType;
    private int quantity;

    public Ammo(String name, String description, double weight, //construtor
                String ammoType, int quantity) {
        super(name, description, weight);//para acessar a superclasse item
        this.ammoType = ammoType;
        this.quantity = quantity;
    }

    @Override
    public void use(Survivor survivor) { //função de usar munição
        if (quantity <= 0) {
            System.out.println("Nao sobrou municao");
            return;
        }

        if (survivor.getWeaponEquipped() != null &&
            survivor.getWeaponEquipped().getAmmoType().equals(ammoType)) { // verififica se há arma equipada e compara a munição

            survivor.reload();
            quantity--;

        } else {
            System.out.println(
                "Nao e possivel usar municao. A arma equipada nao e compativel com o tipo de municao: "
                + ammoType
            );
        }
    }

    public String getAmmoType() { //get
        return ammoType;
    }

    public int getQuantity() { //get
        return quantity;
    }
}
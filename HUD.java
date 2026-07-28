package re3;

public class HUD implements GameObserver { //herda de gameobserver
    private int healthBar;
    private String ammoDisplay;
    private boolean mapVisible;

    public HUD() { //construtor
        this.healthBar = 100;
        this.ammoDisplay = "0/0";
        this.mapVisible = false;
    }

    @Override
    public void onGameEvent(GameEvent event) {
        System.out.println("\n[HUD Event Notification Received: " + event.getEventType() + "]");
        
        // Verifica o estado do jogador e atualiza o HUD 
        Survivor player = GameManager.getInstance().getPlayer();
        if (player != null) { //existe um jogador?
            updateHealthBar(player.getHealth());
            if (player.getWeaponEquipped() != null) {
                updateAmmoDisplay(player.getWeaponEquipped().getAmmoCount() + "/" + player.getWeaponEquipped().getMaxAmmo());
            } else {
                updateAmmoDisplay("N/A");
            }
        }

        if (event instanceof CombatEvent) { //verifica se é combatevent
            CombatEvent ce = (CombatEvent) event; //vira combatevent
            System.out.println("HUD update -> Combat detected! Damage dealt: " + ce.getDamageDealt() + " to " + ce.getDefender().getName());
        } else if (event instanceof ExploreEvent) {
            ExploreEvent ee = (ExploreEvent) event;
            System.out.println("HUD update -> Entered Location: " + ee.getLocation().getName());
        } else if (event instanceof BossEvent) {
            BossEvent be = (BossEvent) event;
            System.out.println("HUD update -> Boss Encounter Event! Nemesis Phase: " + be.getPhase() + " (Defeated: " + be.isDefeated() + ")");
        }
        
        displayHUD();//mostra o hud atualizado
    }

    public void updateHealthBar(int health) { //atualiza a barra de vida
        this.healthBar = health;
    }

    public void updateAmmoDisplay(String display) { //atualiza a munição
        this.ammoDisplay = display;
    }

    public void toggleMap() { //ativa ou desativa o minimapa
        this.mapVisible = !this.mapVisible;
        System.out.println("HUD -> Minimap is now " + (mapVisible ? "VISIBLE" : "HIDDEN") + ".");
    }

    public void displayHUD() { //display do hud
        System.out.println("================== HUD DISPLAY ==================");
        System.out.println("Health: [" + healthBar + "%] | Ammo: [" + ammoDisplay + "] | Map: [" + (mapVisible ? "ON" : "OFF") + "]");
        System.out.println("=================================================");
    }

    public int getHealthBar() { //get
        return healthBar;
    }

    public String getAmmoDisplay() { //get
        return ammoDisplay;
    }

    public boolean isMapVisible() { //get
        return mapVisible;
    }
}

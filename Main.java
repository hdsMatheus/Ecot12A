package re3;

public class Main {
    public static void main(String[] args) {
        // Get GameManager Singleton instance
        GameManager game = GameManager.getInstance();
        game.setDifficulty("Hard Mode");

        // Setup Observer (HUD)
        HUD hud = new HUD();
        game.addObserver(hud);

        //Create Locations
        Location streets = new Location("Raccoon City Streets", "Dark alleys littered with wreckage", true);
        Location policeStation = new Location("R.P.D. Police Station", "The local precinct, now silent and dangerous", true);

        // Create Survivor (Jill Valentine)
        Survivor jill = new Survivor("Jill Valentine", 100, 100);

        //Create Items and Weapons
        Weapon handgun = new Weapon("STI Eagle 6.0 Handgun", 20, "9mm Para", 15, 15);
        Ammo handgunAmmo = new Ammo("9mm Ammo Box", "Standard 9mm handgun rounds", 0.2, "9mm Para", 15);
        HealingItem greenHerb = new HealingItem("Green Herb", "A medicinal herb native to Raccoon City", 0.1, 40, "Herb");
        KeyItem cardKey = new KeyItem("RPD Card Key", "Electronic card key with the R.P.D. emblem", 0.05, "RPD_CARD_01", "R.P.D. Police Station");

        // Put items in Jill's inventory
        jill.getInventory().addItem(greenHerb);
        jill.getInventory().addItem(handgunAmmo);
        jill.getInventory().addItem(cardKey);

        //Create Enemies
        Zombie zombie = new Zombie("Zombie Cop", 45, 15, 1.2, 1.5);
        Hunter hunter = new Hunter("Hunter Beta", 120, 25, 3.5, 5.0, 30);
        Nemesis nemesis = new Nemesis("Nemesis T-Type", 500, 35, 4.0);

        streets.addEnemy(zombie);
        streets.addEnemy(nemesis);
        policeStation.addEnemy(hunter);

        // Start Game
        game.startGame(jill, streets);

        // Equip Weapon
        jill.equipWeapon(handgun);

        // Simulate combat with Zombie
        System.out.println("\n--- Combat Simulation: Zombie cop approaches! ---");
        zombie.pursue(jill);
        jill.attack(zombie);
        zombie.attack(jill);
        jill.attack(zombie);
        jill.attack(zombie); // Zombie should be dead now (45 hp, handgun does 20 damage each)
        
        if (!zombie.isAlive()) {
            System.out.println("The " + zombie.getName() + " collapses to the ground!");
            streets.removeEnemy(zombie);
        }

        // Use Healing Item
        System.out.println("\n--- Healing Simulation ---");
        jill.useItem(greenHerb);

        // Change Location (RPD)
        System.out.println("\n--- Location Transition Simulation ---");
        // Verify key usage
        cardKey.use(jill);
        game.changeLocation(policeStation);
        
        System.out.println("\n--- Combat Simulation: Hunter Beta leaps from the shadows! ---");
        hunter.attack(jill);
        jill.attack(hunter);
        jill.reload(); // Reload handgun with inventory ammo

        // Boss Encounter: Nemesis
        System.out.println("\n--- Boss Battle: STAAARS! ---");
        game.changeLocation(streets); // Move back to face Nemesis
        
        nemesis.attack(jill);
        jill.attack(nemesis);
        
        System.out.println("\n--- Boss Evolution ---");
        nemesis.evolve(); // Nemesis enters phase 2
        
        nemesis.takeDamage(480); // Simulate heavy damage
        jill.attack(nemesis); // Deal final damage
        
        if (!nemesis.isAlive()) {
            System.out.println(nemesis.getName() + " defeated!");
            Item drop = nemesis.dropItem();
            jill.getInventory().addItem(drop);
        }

        // End Game
        System.out.println();
        game.endGame();
    }
}

package re3;

import java.util.ArrayList;
import java.util.List;

public class GameManager { //objeto unico
    private static GameManager instance;
    
    private Survivor player;
    private Location currentLocation;
    private boolean isGameOver;
    private String difficulty;
    private List<GameObserver> observers;

    private GameManager() { // construtor privado para objeto único
        this.observers = new ArrayList<>();
        this.isGameOver = false;
        this.difficulty = "Normal";
    }

    public static GameManager getInstance() { // get instance do objeto único
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void startGame(Survivor player, Location startingLocation) { //coloca o jogador e a localização inicial do jogo
        this.player = player;
        this.currentLocation = startingLocation;
        this.isGameOver = false;
        System.out.println("--- Resident Evil 3 Game Started ---");
        System.out.println("Difficulty: " + difficulty);
        System.out.println("Player: " + player.getName());
        System.out.println("Starting Location: " + startingLocation.getName() + " - " + startingLocation.getDescription());
        notifyObservers(new ExploreEvent(startingLocation, null));
    }

    public void endGame() { //se game over for true printa
        this.isGameOver = true;
        System.out.println("--- Game Over ---");
    }

    public void saveGame() { //salva o game
        System.out.println("Game progression saved successfully.");
    }

    public void loadGame() { //carrega o game
        System.out.println("Game progression loaded successfully.");
    }

    public void changeLocation(Location newLocation) {//muda a localização do jogador
        if (newLocation.isAccessible()) {
            this.currentLocation = newLocation; 
            System.out.println(player.getName() + " moved to " + newLocation.getName() + ".");
            notifyObservers(new ExploreEvent(newLocation, null)); //cria um evento de exploração e notifica os observadores
        } else {
            System.out.println("Location " + newLocation.getName() + " is locked!");
        }
    }

    public void addObserver(GameObserver observer) { //adiciona um observador na lista
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(GameObserver observer) { //remove um observador da lista
        observers.remove(observer);
    }

    public void notifyObservers(GameEvent event) { //função de notificação para todos os observadores
        for (GameObserver observer : observers) {
            observer.onGameEvent(event);
        }
    }

    public Survivor getPlayer() { //get
        return player;
    }

    public Location getCurrentLocation() { //get
        return currentLocation;
    }

    public boolean isGameOver() { //get
        return isGameOver;
    }

    public String getDifficulty() { //get
        return difficulty;
    }

    public void setDifficulty(String difficulty) { //set
        this.difficulty = difficulty;
    }
}

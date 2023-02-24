import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private final int maxHealth; 
    protected int currentHealth; 
    private final String name; 
    private static List<Character> allCharacters = new ArrayList<Character>(); 
    private Weapon weapon; 

    public int getMaxHealth() {
        return maxHealth; 
    }

    public int getCurrentHealth() {
        return currentHealth; 
    }

    public String getName() {
        return name; 
    }

    public Weapon getWeapon() {
        return weapon; 
    }

    public Character(String Name, int MaxHealth, Weapon weapon) {
        this.name = Name; 
        this.maxHealth = MaxHealth; 
        this.currentHealth = MaxHealth;
        this.weapon = weapon; 
        allCharacters.add(this);
    }

    public String toString() {
        if (currentHealth > 0) {
        return String.format("%s : %s/%s", name, currentHealth, maxHealth);
        }
        return String.format("%s : KO", name);

    }
    
    public abstract void takeDamage(int damage) throws DeadCharacterException; 

    public abstract void attack (Character target) throws DeadCharacterException; 

    public static String printStatus() {
        String status;
        String no_character = "------------------------------------------\nNobody's fighting right now !\n------------------------------------------";
        if (allCharacters.size() == 0) {
            status = no_character;
        } else {
            status = "------------------------------------------\nCharacters currently fighting :\n";
            for (Character character : allCharacters) {
                status += " - " + character.toString() + "\n";
            }
            status += "------------------------------------------";
        }
        return status;
    }


    public static Character fight(Character character1, Character character2)  {
        while (character1.getCurrentHealth() > 0 && character2.getCurrentHealth() > 0) {
            try {
                character1.attack(character2);
            } catch (DeadCharacterException e) {
                System.out.println(e.getMessage());
                return character1;
            }
            try {
                character2.attack(character1);
            } catch (DeadCharacterException e) {
                System.out.println(e.getMessage());
                return character2;
            }
        }
        return character2;
    }
}

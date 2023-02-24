public class Weapon {

    private final String name;
    private final int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }
    
    public int getDamage() {
        return damage;
    }

    public String toString() {
        return String.format("%s deals %s damages", name, damage); 
    }     
    
}

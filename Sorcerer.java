
public class Sorcerer extends Character implements Healer {
    
    private final int healCapacity;
    
    public Sorcerer(String name, int MaxHealth, int HealCapacity, Weapon weapon) {
        super(name, MaxHealth, weapon);
        this.healCapacity = HealCapacity;
    }
    
    public void heal(Character character) throws DeadCharacterException {
        if (this.getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        if (character.getCurrentHealth() == 0 ) {
            throw new DeadCharacterException(character);
        } else {
            if (character.getCurrentHealth() + healCapacity > character.getMaxHealth()) {
                character.currentHealth = character.getMaxHealth();
            } else {
                character.currentHealth += healCapacity;
            }
        }
    }
    
    public int getHealCapacity() {
        return this.healCapacity;
    }
    
    public String toString() {
        if (this.getCurrentHealth() > 0) {
            return String.format("%s is a sorcerer with %s HP. It can heal %s HP", this.getName(),  this.getCurrentHealth(), this.getHealCapacity(), this.getWeapon().getName(), this.getWeapon().getDamage());
        } else {
            return String.format("%s is a dead sorcerer. So bad, it could heal %s HP", this.getName(), this.getHealCapacity(), this.getWeapon().getName(), this.getWeapon().getDamage());
        }
    }

    @Override
    public void attack(Character target) throws DeadCharacterException {
        if (this.getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        if (target.getCurrentHealth() == 0 ) {
            throw new DeadCharacterException(target);
        } else {
            heal(this);
            if (target.getCurrentHealth() - 10 > 0) {
                target.takeDamage(getWeapon().getDamage());
            } else {
                target.currentHealth = 0;
            }
        }
    }

    @Override
    public void takeDamage(int damage) throws DeadCharacterException {
        if (getCurrentHealth() == 0)
            throw new DeadCharacterException(this);
        else {
            if (this.getCurrentHealth() - damage > 0) {
                this.currentHealth -= damage;
            } else {
                this.currentHealth = 0; 
            }
        }
    }
}


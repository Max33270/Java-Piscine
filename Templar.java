public class Templar extends Character implements Healer, Tank {

    private final int healCapacity;
    private final int shield;

    public Templar(String Name, int MaxHealth, int HealCapacity, int Shield, Weapon weapon) {
        super(Name, MaxHealth, weapon);
        this.healCapacity = HealCapacity;
        this.shield = Shield;
    }

    @Override
    public int getShield() {
        return shield; 
    }

    @Override
    public void heal(Character character) throws    DeadCharacterException {
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

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public String toString(){
        if (this.getCurrentHealth() > 0) {
            return String.format("%s is a strong Templar with %s HP. It can heal %s HP and has a shield of %s. He has the weapon %s deals %s damages", getName(), getCurrentHealth(),getHealCapacity() , getShield(), this.getWeapon().getName(), this.getWeapon().getDamage()); 
        } 
        return String.format("%s has been beaten, even with its %s shield. So bad, it could heal %s HP. He has the weapon %s deals %s damages", getName(), getCurrentHealth(), getHealCapacity(), this.getWeapon().getName(), this.getWeapon().getDamage()); 
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
            if (target.getCurrentHealth() - 6 > 0) {
                target.takeDamage(getWeapon().getDamage());
            } else {
                target.currentHealth = 0;
            }
        }
    }

    @Override
    public void takeDamage(int damage) throws DeadCharacterException {
        if (getCurrentHealth() == 0 ) {
            throw new DeadCharacterException(this);
        }
        else {
            if (damage - shield > 0) {
                if (this.getCurrentHealth() - (damage - shield) > 0) {
                    this.currentHealth -= (damage - shield);
                } else {
                    this.currentHealth = 0;
                }
            }
        }
    }
}

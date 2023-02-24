
public class Monster extends Character {
    public Monster(String Name, int MaxHealth, Weapon weapon) {
        super(Name, MaxHealth, weapon);
    }

    @Override
    public String toString() {
        if (getCurrentHealth() > 0) {
            return String.format("%s is a monster with %s HP", getName(), getCurrentHealth(), this.getWeapon().getName(), this.getWeapon().getDamage());
        } else {
            return String.format("%s is a monster and is dead", getName(), this.getWeapon().getName(), this.getWeapon().getDamage());
        } 
    }

    @Override
    public void takeDamage(int damage) throws DeadCharacterException {
        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        } else {
            if (this.getCurrentHealth() - (int) (damage * 0.8) > 0) {
                this.currentHealth -= (int) (damage * 0.8);
            } else {
                this.currentHealth = 0;
            }
        }
    }
    
    @Override
    public void attack(Character target) throws DeadCharacterException {
        if (this.getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        if (target.getCurrentHealth() == 0 ) {
            throw new DeadCharacterException(target);
        }
        else {
            if (target.getCurrentHealth() - 10 > 0) {
                target.takeDamage(getWeapon().getDamage());
            } else {
                target.currentHealth = 0;
            }
        }
    }
}


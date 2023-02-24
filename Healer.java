public interface Healer {

    public abstract void heal(Character character) throws DeadCharacterException; 

    public abstract int getHealCapacity(); 
}

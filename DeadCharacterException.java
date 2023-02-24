public class DeadCharacterException extends Exception {
    
    private Character character;

    public DeadCharacterException(Character character) {
        this.character = character;
    }
    
    @Override
    public String getMessage() {
        return String.format("The %s %s is dead.", character.getClass().getName().toLowerCase(), character.getName());
    }
 
}

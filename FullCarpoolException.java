public class FullCarpoolException extends Exception {
    
    public FullCarpoolException(String message) {
        super(message);
    }

    public FullCarpoolException() {
        super("The carpool is full. No more passengers can be added.");
    }
}

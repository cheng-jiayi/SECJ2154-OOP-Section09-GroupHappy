public interface RideShareable {
    void offerRide();
    void joinRide(User user) throws FullCarpoolException;
}

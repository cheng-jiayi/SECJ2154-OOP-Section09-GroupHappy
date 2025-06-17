public class Route {
    private final String pickupPoint;
    private final String dropPoint;
    private final String pickupTime;
    private final String dropTime;

    public Route(String pickupPoint, String dropPoint, String pickupTime, String dropTime) {
        this.pickupPoint = pickupPoint;
        this.dropPoint = dropPoint;
        this.pickupTime = pickupTime;
        this.dropTime = dropTime;
    }

    public void displayRoute() {
        System.out.println("Route Information:");
        System.out.println("Pickup Point : " + pickupPoint);
        System.out.println("Drop Point   : " + dropPoint);
        System.out.println("Pickup Time  : " + pickupTime);
        System.out.println("Drop-off Time: " + dropTime);
    }

    // Optionally add getters if needed
    public String getPickupPoint() {
        return pickupPoint;
    }

    public String getDropPoint() {
        return dropPoint;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public String getDropTime() {
        return dropTime;
    }
}

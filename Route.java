public class Route {
    private String pickupPoint;
    private String dropPoint;
    private String pickupTime;
    private String dropOffTime;

    public Route(String pickupPoint, String dropPoint, String pickupTime, String dropOffTime) {
        this.pickupPoint = pickupPoint;
        this.dropPoint = dropPoint;
        this.pickupTime = pickupTime;
        this.dropOffTime = dropOffTime;
    }

    public void displayRoute() {
        System.out.println("Route: " + pickupPoint + " ➝ " + dropPoint);
        System.out.println("Pickup Time: " + pickupTime + " | Drop-off Time: " + dropOffTime);
    }

    public String getPickUpPoint() {
        return pickupPoint;
    }

    public String getDropPoint() {
        return dropPoint;
    }
}

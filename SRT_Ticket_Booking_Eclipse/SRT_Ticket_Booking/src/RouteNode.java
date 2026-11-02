public class RouteNode {
    public String station;
    public String time;
    public RouteNode next;

    public RouteNode(String station, String time) {
        this.station = station;
        this.time = time;
        this.next = null;
    }
}

public class Train {
    public int trainNo;
    public String type;
    public RouteLinkedList route;
    public Carriage[] carriages;

    public Train(int trainNo, String type, int carriageCount, int rows, int cols) {
        this.trainNo = trainNo;
        this.type = type;
        this.route = new RouteLinkedList();
        this.carriages = new Carriage[carriageCount];
        for (int i = 0; i < carriageCount; i++) {
            carriages[i] = new Carriage(i + 1, rows, cols);
        }
    }

    public Carriage getCarriage(int carriageNo) {
        if (carriageNo < 1 || carriageNo > carriages.length) return null;
        return carriages[carriageNo - 1];
    }

    public String getRouteName() {
        return route.getFirstStation() + " -> " + route.getLastStation();
    }
}

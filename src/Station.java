public class Station {
    private int stationId;
    private boolean isAvailable;

    public static int totalStations = 7;

    public Station(int stationId) {
        this.stationId = stationId;
        this.isAvailable = true;
    }

    public int getStationId() {
        return stationId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void occupy() {
        isAvailable = false;
    }

    public void release() {
        isAvailable = true;
    }
}
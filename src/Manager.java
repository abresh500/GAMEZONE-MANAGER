import java.util.*;

public class Manager {
    private List<Station> stations = new ArrayList<>();
    private List<Session> sessions = new ArrayList<>();

    public Manager() {
        for (int i = 1; i <= Station.totalStations; i++) {
            stations.add(new Station(i));
        }
    }

    public void startSession(String name, int stationId) throws Exception {
        if (stationId < 1 || stationId > stations.size()) {
            throw new InvalidInputException("Invalid station ID");
        }

        Station station = stations.get(stationId - 1);

        if (!station.isAvailable()) {
            throw new StationUnavailableException("Station is occupied");
        }

        Customer customer = new RegularCustomer(name);

        Session session = new Session(customer, station);
        sessions.add(session);

        station.occupy();

        DatabaseHelper.insertSession(name, session.getPrice());

        System.out.println("Session started. Price: " + session.getPrice());
    }

    public void endSession(int stationId) {
        Station station = stations.get(stationId - 1);
        station.release();
    }

    public void generateReport() {
        ReportGenerator.generateReport(sessions.size(), Session.totalRevenue);
    }
}
import java.util.*;

public class Manager {
    private List<Station> stations = new ArrayList<>();
    private List<Session> sessions = new ArrayList<>();

    public Manager() {
        for (int i = 1; i <= Station.totalStations; i++) {
            stations.add(new Station(i));
        }
    }

    public void startSession(String name, int stationId, int type) throws Exception {
        if (stationId < 1 || stationId > stations.size()) {
            throw new InvalidInputException("Invalid station ID");
        }

        Station station = stations.get(stationId - 1);

        if (!station.isAvailable()) {
            throw new StationUnavailableException("Station is occupied");
        }

        Customer customer;
        if (type == 2) {
            customer = new DiscountCustomer(name);
        } else {
            customer = new RegularCustomer(name);
        }

        Session session = new Session(customer, station);
        sessions.add(session);
        station.occupy();

        System.out.println("Session started for " + name + " at Station " + stationId);
    }

    public void endSession(int stationId, int games) throws Exception {
        if (stationId < 1 || stationId > stations.size()) {
            throw new InvalidInputException("Invalid station ID");
        }

        Station station = stations.get(stationId - 1);

        if (station.isAvailable()) {
            throw new StationUnavailableException("Station " + stationId + " has no active session");
        }

        Session activeSession = null;
        for (Session s : sessions) {
            if (s.getStation() == station) {
                activeSession = s;
            }
        }

        double pricePerGame = activeSession.getCustomer().calculatePrice();
        double total = pricePerGame * games;
        activeSession.setPrice(total);

        System.out.println("--- Session Summary ---");
        System.out.println("Customer: " + activeSession.getCustomer().getName());
        System.out.println("Games played: " + games);
        System.out.println("Price per game: " + pricePerGame + " birr");
        System.out.println("Total: " + total + " birr");

        DatabaseHelper.insertSession(activeSession.getCustomer().getName(), total);

        station.release();
        sessions.remove(activeSession);
    }

    public void generateReport() {
        ReportGenerator.generateReport(sessions.size(), Session.totalRevenue);
    }
}
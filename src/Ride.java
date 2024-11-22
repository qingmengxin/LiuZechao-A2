import java.util.ArrayList;
import java.util.List;

public class Ride implements RideInterface {
    private String rideName;
    private int capacity;
    private Employee operator;
    private List<Visitor> waitingQueue;
    private List<Visitor> rideHistory;

    // Constructor
    public Ride(String rideName, int capacity, Employee operator) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
        this.waitingQueue = new ArrayList<>();
        this.rideHistory = new ArrayList<>();
    }

    // Getters and Setters
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    // Implement RideInterface methods
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        waitingQueue.add(visitor);
    }

    @Override
    public void removeVisitorFromQueue() {
        if (!waitingQueue.isEmpty()) {
            waitingQueue.remove(0);
        } else {
            System.out.println("No visitors in the queue to remove.");
        }
    }

    @Override
    public void printQueue() {
        System.out.println("Waiting Queue for " + rideName + ":");
        for (Visitor v : waitingQueue) {
            System.out.println("- " + v.getName());
        }
    }

    @Override
    public void runOneCycle() {
        System.out.println("Running one cycle of " + rideName + "...");
        for (int i = 0; i < capacity && !waitingQueue.isEmpty(); i++) {
            Visitor v = waitingQueue.remove(0);
            addVisitorToHistory(v);
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        System.out.println("Ride History for " + rideName + ":");
        for (Visitor v : rideHistory) {
            System.out.println("- " + v.getName());
        }
    }
}
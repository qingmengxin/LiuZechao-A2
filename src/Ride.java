import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Ride implements RideInterface {
    private String rideName;
    private int capacity;
    private Employee operator;
    private Queue<Visitor> waitingQueue;
    private List<Visitor> rideHistory;

    // Constructor
    public Ride(String rideName, int capacity, Employee operator) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
        this.waitingQueue = new LinkedList<>(); // Use LinkedList as a Queue
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

    // Implement RideInterface methods for Queue management
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        waitingQueue.offer(visitor);
        System.out.println(visitor.getName() + " has been added to the queue for " + rideName);
    }

    @Override
    public void removeVisitorFromQueue() {
        if (!waitingQueue.isEmpty()) {
            Visitor removedVisitor = waitingQueue.poll();
            System.out.println(removedVisitor.getName() + " has been removed from the queue for " + rideName);
        } else {
            System.out.println("The queue for " + rideName + " is empty. No visitors to remove.");
        }
    }

    @Override
    public void printQueue() {
        System.out.println("Visitors currently in the queue for " + rideName + ":");
        if (waitingQueue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            for (Visitor v : waitingQueue) {
                System.out.println("- " + v.getName() + ", Ticket ID: " + v.getTicketId());
            }
        }
    }

    // Implement RideInterface methods for ride operations
    @Override
    public void runOneCycle() {
        System.out.println("Running one cycle of " + rideName + "...");
        for (int i = 0; i < capacity && !waitingQueue.isEmpty(); i++) {
            Visitor v = waitingQueue.poll();
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
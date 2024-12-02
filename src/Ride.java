import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Comparator;
import java.util.Collections;

public class Ride implements RideInterface {
    private String rideName;
    private int capacity;
    private Employee operator;
    private Queue<Visitor> waitingQueue;  // Queue for visitors waiting
    private LinkedList<Visitor> rideHistory; // For visitors who took the ride

    // Constructor
    public Ride(String rideName, int capacity, Employee operator) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
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

    // RideInterface methods
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
        System.out.println(visitor.getName() + " has been added to the ride history for " + rideName);
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        boolean found = rideHistory.contains(visitor);
        System.out.println(visitor.getName() + (found ? " is " : " is not ") + "in the ride history for " + rideName);
        return found;
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        System.out.println("Ride History for " + rideName + ":");
        Iterator<Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            Visitor v = iterator.next();
            System.out.println("- " + v.getName() + ", Ticket ID: " + v.getTicketId());
        }
    }

    // Sort Ride History
    public void sortRideHistory(Comparator<Visitor> comparator) {
        Collections.sort(rideHistory, comparator);
        System.out.println("Ride history has been sorted for " + rideName);
    }
}
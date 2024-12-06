import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Comparator;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Ride implements RideInterface {
    private String rideName;
    private int capacity;
    private Employee operator;
    private Queue<Visitor> waitingQueue;  // Queue for visitors waiting
    private LinkedList<Visitor> rideHistory; // For visitors who took the ride
    private int maxRider;  // Maximum visitors the ride can accommodate in one cycle
    private int numOfCycles;  // Number of times the ride has been run

    // Constructor with default maxRider value
    public Ride(String rideName, int capacity, Employee operator) {
        this(rideName, capacity, operator, 4);  // Default maxRider is 4
    }

    // Constructor
    public Ride(String rideName, int capacity, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = maxRider;  // Set maxRider for the ride
        this.numOfCycles = 0; // Initially, no cycles have been run
    }

    // Export Ride History to a file
    public void exportRideHistory(String fileName) {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors in the ride history to export.");
            return;
        }
        // Try to write the ride history to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write the header
            writer.write("Ride History for " + rideName + "\n");
            writer.write("=======================================\n");

            // Iterate over rideHistory and write each visitor's details
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.getName() + ", Ticket ID: " + visitor.getTicketId() + "\n");
            }

            System.out.println("Ride history has been successfully exported to " + fileName);
        } catch (IOException e) {
            // Handle file-related exceptions
            System.err.println("Error exporting ride history to file: " + e.getMessage());
        }
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

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
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
        if (operator == null) {
            System.out.println("Cannot run the ride. No operator assigned.");
            return;
        }

        if (waitingQueue.isEmpty()) {
            System.out.println("Cannot run the ride. The queue is empty.");
            return;
        }

        System.out.println("Running one cycle of " + rideName + "...");
        int riders = Math.min(waitingQueue.size(), maxRider);  // Limit the number of riders to maxRider
        for (int i = 0; i < riders; i++) {
            Visitor v = waitingQueue.poll();  // Remove visitor from queue
            addVisitorToHistory(v);  // Add to ride history
        }

        numOfCycles++;  // Increment the number of cycles
        System.out.println("Cycle " + numOfCycles + " has completed.");
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

    // Getter for numOfCycles
    public int getNumOfCycles() {
        return numOfCycles;
    }
}
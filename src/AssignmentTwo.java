public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo program = new AssignmentTwo();
        program.partThree();
    }

    public void partThree() {
        // Create an operator for the ride
        Employee operator = new Employee("Alice", 30, "Park Lane", "E001", "Operator");

        // Create a new Ride object
        Ride ferrisWheel = new Ride("Ferris Wheel", 5, operator);

        // Create Visitors
        Visitor visitor1 = new Visitor("Jack", 20, "Green Street", "T001", "Regular");
        Visitor visitor2 = new Visitor("Sharon", 25, "Blue Avenue", "T002", "Regular");
        Visitor visitor3 = new Visitor("Benny", 22, "Yellow Road", "T003", "Regular");
        Visitor visitor4 = new Visitor("Leo", 30, "Orange Boulevard", "T004", "Regular");
        Visitor visitor5 = new Visitor("Sophia", 27, "Purple Street", "T005", "Regular");

        // Add Visitors to the Queue
        ferrisWheel.addVisitorToQueue(visitor1);
        ferrisWheel.addVisitorToQueue(visitor2);
        ferrisWheel.addVisitorToQueue(visitor3);
        ferrisWheel.addVisitorToQueue(visitor4);
        ferrisWheel.addVisitorToQueue(visitor5);

        // Remove a Visitor from the Queue
        ferrisWheel.removeVisitorFromQueue();

        // Print all Visitors in the Queue
        ferrisWheel.printQueue();
    }
}
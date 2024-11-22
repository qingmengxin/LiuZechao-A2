public class AssignmentTwo {
    public static void main(String[] args) {
        // Create employees
        Employee operator1 = new Employee("Alice", 30, "Park Lane", "E001", "Operator");
        Employee operator2 = new Employee("Bob", 35, "Sunset Boulevard", "E002", "Operator");

        // Create rides
        Ride rollerCoaster = new Ride("Roller Coaster", 2, operator1);
        Ride thunderstorm = new Ride("Thunderstorm", 4, operator2);

        // Create visitors
        Visitor v1 = new Visitor("Jack", 20, "Green Street", "T001", "Regular");
        Visitor v2 = new Visitor("Sharon", 25, "Blue Avenue", "T002", "Regular");
        Visitor v3 = new Visitor("Benny", 22, "Yellow Road", "T003", "Regular");
        Visitor v4 = new Visitor("Leo", 30, "Orange Boulevard", "T004", "Regular");
        Visitor v5 = new Visitor("Nehemia", 28, "Purple Street", "T005", "Regular");
        Visitor v6 = new Visitor("Jason", 27, "Red Avenue", "T006", "Regular");

        // Add visitors to roller coaster queue
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);

        // Simulate ride cycles
        rollerCoaster.runOneCycle();
        rollerCoaster.runOneCycle();

        // Print roller coaster queue and history
        rollerCoaster.printQueue();
        rollerCoaster.printRideHistory();

        // Add visitors to thunderstorm queue
        thunderstorm.addVisitorToQueue(v1);
        thunderstorm.addVisitorToQueue(v4);
        thunderstorm.addVisitorToQueue(v5);
        thunderstorm.addVisitorToQueue(v6);

        // Simulate thunderstorm ride cycle
        thunderstorm.runOneCycle();

        // Print thunderstorm queue and history
        thunderstorm.printQueue();
        thunderstorm.printRideHistory();
    }
}
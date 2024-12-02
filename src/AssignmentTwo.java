public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();

        // Uncomment these to run each part
        assignment.partThree();
        assignment.partFourA();
        assignment.partFourB();
    }

    public void partThree() {
        // Demonstration for Part 3
        Employee operator = new Employee("Alice", 30, "Park Lane", "E001", "Operator");
        Ride rollerCoaster = new Ride("Roller Coaster", 4, operator);

        // Create Visitors
        Visitor v1 = new Visitor("Jack", 20, "Green Street", "T001", "Regular");
        Visitor v2 = new Visitor("Sharon", 25, "Blue Avenue", "T002", "Regular");
        Visitor v3 = new Visitor("Benny", 22, "Yellow Road", "T003", "Regular");
        Visitor v4 = new Visitor("Leo", 30, "Orange Boulevard", "T004", "Regular");
        Visitor v5 = new Visitor("Sophia", 27, "Purple Street", "T005", "Regular");

        // Add Visitors to Queue
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);

        // Remove a Visitor
        rollerCoaster.removeVisitorFromQueue();

        // Print Queue
        rollerCoaster.printQueue();
    }

    public void partFourA() {
        // Demonstration for Part 4A
        Employee operator = new Employee("Alice", 30, "Park Lane", "E001", "Operator");
        Ride rollerCoaster = new Ride("Roller Coaster", 4, operator);

        // Create Visitors
        Visitor v1 = new Visitor("Jack", 20, "Green Street", "T001", "Regular");
        Visitor v2 = new Visitor("Sharon", 25, "Blue Avenue", "T002", "Regular");
        Visitor v3 = new Visitor("Benny", 22, "Yellow Road", "T003", "Regular");
        Visitor v4 = new Visitor("Leo", 30, "Orange Boulevard", "T004", "Regular");
        Visitor v5 = new Visitor("Sophia", 27, "Purple Street", "T005", "Regular");

        // Add Visitors to Ride History
        rollerCoaster.addVisitorToHistory(v1);
        rollerCoaster.addVisitorToHistory(v2);
        rollerCoaster.addVisitorToHistory(v3);
        rollerCoaster.addVisitorToHistory(v4);
        rollerCoaster.addVisitorToHistory(v5);

        // Check if a Visitor is in the history
        System.out.println("Is Sharon in the history? " + rollerCoaster.checkVisitorFromHistory(v2));

        // Print the number of Visitors
        System.out.println("Number of Visitors: " + rollerCoaster.numberOfVisitors());

        // Print all Visitors in the collection
        rollerCoaster.printRideHistory();
    }

    public void partFourB() {
        // Demonstration for Part 4B
        Employee operator = new Employee("Alice", 30, "Park Lane", "E001", "Operator");
        Ride thunderstorm = new Ride("Thunderstorm", 4, operator);

        // Create Visitors
        Visitor v1 = new Visitor("Jack", 20, "Green Street", "T001", "Regular");
        Visitor v2 = new Visitor("Sharon", 25, "Blue Avenue", "T002", "Regular");
        Visitor v3 = new Visitor("Benny", 22, "Yellow Road", "T003", "Regular");
        Visitor v4 = new Visitor("Leo", 30, "Orange Boulevard", "T004", "Regular");
        Visitor v5 = new Visitor("Sophia", 27, "Purple Street", "T005", "Regular");

        // Add Visitors to Ride History
        thunderstorm.addVisitorToHistory(v1);
        thunderstorm.addVisitorToHistory(v2);
        thunderstorm.addVisitorToHistory(v3);
        thunderstorm.addVisitorToHistory(v4);
        thunderstorm.addVisitorToHistory(v5);

        // Print unsorted history
        System.out.println("Unsorted Ride History:");
        thunderstorm.printRideHistory();

        // Sort the history
        VisitorComparator comparator = new VisitorComparator();
        thunderstorm.sortRideHistory(comparator);

        // Print sorted history
        System.out.println("Sorted Ride History:");
        thunderstorm.printRideHistory();
    }

    public void partFive() {
        // Implement additional requirements for Part 5 (if applicable)
    }

    public void partSix() {
        // Implement additional requirements for Part 6 (if applicable)
    }

    public void partSeven() {
        // Implement additional requirements for Part 7 (if applicable)
    }
}
public class Ride {
    private String rideName;
    private int capacity;
    private Employee operator;

    // Default Constructor
    public Ride() {
        this.rideName = "Unknown";
        this.capacity = 0;
        this.operator = null;
    }

    // Parameterized Constructor
    public Ride(String rideName, int capacity, Employee operator) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
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
}
Java 语言

复制代码

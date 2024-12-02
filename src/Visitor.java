public class Visitor extends Person {
    private String ticketId;
    private String membershipStatus;

    // Default Constructor
    public Visitor() {
        super();
        this.ticketId = "Unknown";
        this.membershipStatus = "Regular";
    }

    // Parameterized Constructor
    public Visitor(String name, int age, String address, String ticketId, String membershipStatus) {
        super(name, age, address);
        this.ticketId = ticketId;
        this.membershipStatus = membershipStatus;
    }

    // Getters and Setters
    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(String membershipStatus) {
        this.membershipStatus = membershipStatus;
    }
}

class Employee {
    private int id;
    private String name;

    // Default constructor
    public Employee() {
        this.id = 0;
        this.name = "Unknown";
    }

    // Parameterized constructor
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Setter methods
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Abstract method to calculate the monthly earnings
    public double calculateEarnings() {
        return 0.0;
    }
}
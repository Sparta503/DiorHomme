class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    // Default constructor
    public HourlyEmployee() {
        super();
        this.hourlyRate = 0.0;
        this.hoursWorked = 0;
    }

    // Parameterized constructor
    public HourlyEmployee(int id, String name, double hourlyRate, int hoursWorked) {
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    // Getter and setter methods for HourlyEmployee
    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    // Override the calculateEarnings method for HourlyEmployee
    @Override
    public double calculateEarnings() {
        return hourlyRate * hoursWorked;
    }
}

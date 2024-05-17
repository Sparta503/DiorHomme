class SalariedEmployee extends Employee {
    private double monthlySalary;

    // Default constructor
    public SalariedEmployee() {
        super();
        this.monthlySalary = 0.0;
    }

    // Parameterized constructor
    public SalariedEmployee(int id, String name, double monthlySalary) {
        super(id, name);
        this.monthlySalary = monthlySalary;
    }

    // Getter and setter methods for SalariedEmployee
    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    // Override the calculateEarnings method for SalariedEmployee
    @Override
    public double calculateEarnings() {
        return monthlySalary;
    }
}


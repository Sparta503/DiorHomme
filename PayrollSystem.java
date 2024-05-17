public class PayrollSystem {
    private Employee[] employees;

    // Parameterized constructor
    public PayrollSystem(Employee[] employees) {
        this.employees = employees;
    }

    // Calculate and return the total payroll for all employees
    public double calculateTotalPayroll() {
        double totalPayroll = 0.0;
        // Check if the array is not null and contains at least one employee
        if (employees != null && employees.length > 0 && employees[0] != null) {
            for (Employee employee : employees) {
                // Check if the employee object is not null
                if (employee != null) {
                    totalPayroll += employee.calculateEarnings();
                }
            }
        }

        return totalPayroll;
    }
}


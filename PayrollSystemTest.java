import java.util.InputMismatchException;
import java.util.Scanner;

public class PayrollSystemTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array to store employees
        Employee[] employees = new Employee[4];

        // Display a menu to the user
        int choice;
        do {
            System.out.println("\n===== Payroll System Menu =====");
            System.out.println("1. Add Hourly Employee");
            System.out.println("2. Add Salaried Employee");
            System.out.println("3. Display Total Payroll");
            System.out.println("4. Remove Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Hourly Employee
                    employees[0] = addHourlyEmployee(scanner);
                    break;
                case 2:
                    // Add Salaried Employee
                    employees[1] = addSalariedEmployee(scanner);
                    break;
                case 3:
                    // Display Total Payroll
                    displayTotalPayroll(employees);
                    break;
                case 4:
                    // Remove Employee
                    removeEmployee(scanner, employees);
                    break;
                case 5:
                    // Exit the program
                    System.out.println("Exiting Payroll System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Helper method to add an Hourly Employee
    private static HourlyEmployee addHourlyEmployee(Scanner scanner) {
        int id = getEmployeeId(scanner);
        scanner.nextLine(); // Consume the newline character

        String name = getEmployeeName(scanner);

        double hourlyRate = getHourlyRate(scanner);

        int hoursWorked = getHoursWorked(scanner);

        // Create the HourlyEmployee
        HourlyEmployee hourlyEmployee = new HourlyEmployee(id, name, hourlyRate, hoursWorked);

        // Display the entered details
        displayEmployeeDetails(hourlyEmployee);

        return hourlyEmployee;
    }

    // Helper method to add a Salaried Employee
    private static SalariedEmployee addSalariedEmployee(Scanner scanner) {
        int id = getEmployeeId(scanner);
        scanner.nextLine(); // Consume the newline character

        String name = getEmployeeName(scanner);

        double monthlySalary = getMonthlySalary(scanner);

        // Create the SalariedEmployee
        SalariedEmployee salariedEmployee = new SalariedEmployee(id, name, monthlySalary);

        // Display the entered details
        displayEmployeeDetails(salariedEmployee);

        return salariedEmployee;
    }

    // Helper method to get a valid employee ID
    private static int getEmployeeId(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter employee ID: ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid employee ID (integer).");
                scanner.next(); // Clear the buffer
            }
        }
    }

    // Helper method to get a valid employee name
    private static String getEmployeeName(Scanner scanner) {
        while (true) {
            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();

            if (!name.matches(".*\\d.*")) { // Check if the name contains any digit
                return name;
            } else {
                System.out.println("Invalid input. Please enter a valid employee name (non-integer).");
            }
        }
    }

    // Helper method to get a valid hourly rate
    private static double getHourlyRate(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter hourly rate: ");
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid hourly rate (numeric).");
                scanner.next(); // Clear the buffer
            }
        }
    }

    // Helper method to get valid hours worked
    private static int getHoursWorked(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter hours worked: ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid hours worked (integer).");
                scanner.next(); // Clear the buffer
            }
        }
    }

    // Helper method to get a valid monthly salary
    private static double getMonthlySalary(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter monthly salary: ");
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid monthly salary (numeric).");
                scanner.next(); // Clear the buffer
            }
        }
    }

    // Helper method to display total payroll
    private static void displayTotalPayroll(Employee[] employees) {
        // Check if the array is not null and contains at least one employee
        if (employees != null && employees.length > 0 && employees[0] != null) {
            // Create a payroll system with the array of employees
            PayrollSystem payrollSystem = new PayrollSystem(employees);

            // Calculate and display the total payroll
            double totalPayroll = payrollSystem.calculateTotalPayroll();
            System.out.println("\n===== Total Payroll =====");
            System.out.println("Total Payroll: $" + totalPayroll);

            for (Employee employee : employees) {
                // Check if the employee object is not null
                if (employee != null) {
                    displayEmployeeDetails(employee);
                    System.out.println("---------------------------");
                }
            }

        } else {
            System.out.println("No employees found to calculate payroll.");
        }
    }

    // Helper method to remove an employee from the array
    private static void removeEmployee(Scanner scanner, Employee[] employees) {
        System.out.print("Enter the ID of the employee to remove: ");
        int idToRemove = scanner.nextInt();

        boolean employeeRemoved = false;

        // Iterate through the array to find the employee with the specified ID
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == idToRemove) {
                System.out.println("Employee with ID " + idToRemove + " removed.");
                employees[i] = null; // Set the array element to null to remove the employee
                employeeRemoved = true;
                break;
            }
        }

        if (!employeeRemoved) {
            System.out.println("Employee with ID " + idToRemove + " not found.");
        }
    }

    // Helper method to display employee details
    private static void displayEmployeeDetails(Employee employee) {
        System.out.println("\nEmployee Added:");
        System.out.println("ID: " + employee.getId());
        System.out.println("Name: " + employee.getName());
        System.out.println("Monthly Earnings: $" + employee.calculateEarnings());
    }
}






public class EmployeeManagement {
    private Employee[] employees;
    private int size;

    // Constructor
    public EmployeeManagement(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add an employee
    public boolean addEmployee(Employee employee) {
        if (size == employees.length) {
            System.out.println("Employee list is full");
            return false;
        }
        employees[size++] = employee;
        return true;
    }

    // Search for an employee by employeeId
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null; // Employee not found
    }

    // Traverse and print all employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete an employee by employeeId
    public boolean deleteEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                // Shift elements to the left
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null; // Nullify the last element
                return true;
            }
        }
        return false; // Employee not found
    }

    public static void main(String[] args) {
        EmployeeManagement ems = new EmployeeManagement(10);

        // Add employees
        ems.addEmployee(new Employee("1", "Alice", "Manager", 70000));
        ems.addEmployee(new Employee("2", "Bob", "Developer", 60000));
        ems.addEmployee(new Employee("3", "Charlie", "Designer", 50000));

        // Traverse employees
        System.out.println("All Employees:");
        ems.traverseEmployees();

        // Search for an employee
        System.out.println("\nSearch for Employee with ID 2:");
        System.out.println(ems.searchEmployee("2"));

        // Delete an employee
        System.out.println("\nDelete Employee with ID 2:");
        ems.deleteEmployee("2");

        // Traverse employees again
        System.out.println("\nAll Employees After Deletion:");
        ems.traverseEmployees();
    }
}

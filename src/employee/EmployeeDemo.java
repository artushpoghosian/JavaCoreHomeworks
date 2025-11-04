package employee;

import employee.exception.CompanyNotFoundException;
import employee.exception.EmployeeNotFoundException;
import employee.exception.PositionLevelNotFoundException;

import java.util.Scanner;

public class EmployeeDemo implements Commands {

    private static Scanner sc = new Scanner(System.in);
    private static EmployeeStorage employeeStorage = new EmployeeStorage();

    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            Commands.printCommands();
            String command = sc.nextLine();

            switch (command) {
                case EXIT:
                    isRunning = false;
                    System.out.println("The program was terminated.");
                    break;
                case ADD_EMPLOYEE:
                    addEmployee();
                    break;
                case PRINT_ALL_EMPLOYEES:
                    employeeStorage.print();
                    break;
                case SEARCH_EMPLOYEE_BY_EMPLOYEEID:
                    searchEmployeeByEmployeeID();
                    break;
                case SEARCH_EMPLOYEE_BY_COMPANY_NAME:
                    searchEmployeeByCompany();
                    break;
                case SEARCH_EMPLOYEE_BY_POSITION_LEVEL:
                    searchEmployeeByPositionLevel();
                    break;
            }
        }
    }

    private static void searchEmployeeByPositionLevel() {
        System.out.println("Enter the Position Level Name to view all the employees at that Position Level");
        String positionLevel = sc.nextLine();
        try {
            employeeStorage.searchEmployeeByPositionLevel(positionLevel);
        } catch (PositionLevelNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Position Level Representation. Please choose from: JUNIOR, MIDDLE, SENIOR, LEAD");
        }
    }

    private static void searchEmployeeByCompany() {
        System.out.println("Enter the Company Name");
        String companyName = sc.nextLine();
        try {
            employeeStorage.searchEmployeeByCompany(companyName);
        } catch (CompanyNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void searchEmployeeByEmployeeID() {
        System.out.println("Enter the Employee ID");
        employeeStorage.print();
        String employeeID = sc.nextLine();
        try {
            employeeStorage.searchEmployeeByEmployeeID(employeeID);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    private static void addEmployee() {
        System.out.println("Enter Employee Name");
        String name = sc.nextLine();
        System.out.println("Enter Employee Surname");
        String surname = sc.nextLine();
        System.out.println("Enter Employee ID");
        String employeeID = sc.nextLine();
        System.out.println("Enter Employee's Salary");
        double salary = Double.parseDouble(sc.nextLine());
        System.out.println("Enter Employee's Company Name");
        String company = sc.nextLine();
        System.out.println("Enter Employee's Position");
        String position = sc.nextLine();
        Employee employee = new Employee(name, surname, employeeID, salary, company, position);
        employeeStorage.add(employee);
        System.out.println("The employee was added successfully.");
    }
}
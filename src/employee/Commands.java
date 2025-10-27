package employee;

public interface Commands {
    String EXIT = "0";
    String ADD_EMPLOYEE = "1";
    String PRINT_ALL_EMPLOYEES = "2";
    String SEARCH_EMPLOYEE_BY_EMPLOYEEID = "3";
    String SEARCH_EMPLOYEE_BY_COMPANY_NAME = "4";

    static void printCommands() {
        System.out.println("Please input " + EXIT + " to EXIT");
        System.out.println("Please input " + ADD_EMPLOYEE + " to ADD AN EMPLOYEE");
        System.out.println("Please input " + PRINT_ALL_EMPLOYEES + " to PRINT ALL THE EMPLOYEES");
        System.out.println("Please input " + SEARCH_EMPLOYEE_BY_EMPLOYEEID + " to SEARCH THE EMPLOYEE BY EMPLOYEE ID");
        System.out.println("Please input " + SEARCH_EMPLOYEE_BY_COMPANY_NAME + " to SEARCH THE EMPLOYEE BY COMPANY NAME");
    }
}
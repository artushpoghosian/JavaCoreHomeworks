package employee;

public class EmployeeStorage {

    private Employee[] employees = new Employee[20];
    private int size = 0;

    public void add(Employee employee){
        if(size == employees.length){
            extend();
        }
        employees[size++] = employee;
    }

    private void extend(){
        Employee[] temp = new Employee[size * 2];
        System.arraycopy(employees, 0, temp, 0, size);
        employees = temp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void searchEmployeeByEmployeeID(String employeeID) {
        for (int i = 0; i < size; i++) {
            if(employees[i].getEmployeeId().equals(employeeID))
                System.out.println(employees[i]);
        }
    }

    public void searchEmployeeByCompany(String Company) {
        for (int i = 0; i < size; i++) {
            if(employees[i].getCompany().equals(Company))
                System.out.println(employees[i]);
        }
    }
}
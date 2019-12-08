package Models;

import java.util.Scanner;
import java.util.Stack;

public class EmployeeRecord {
    private Stack<Employee> employeeStack = new Stack<>();
    public void addEmployee(String name, int age, String address){
        Employee employee= new Employee(name,age,address);
        this.employeeStack.add(employee);
    }
    public void addEmployee(Stack<Employee> record){
        while (!record.empty()){
            this.employeeStack.push(record.pop());
        }
    }
    public Employee searchEmployee(String str) {
        Stack<Employee> employeeStackTemp = new Stack<>();
        Employee employee = null,temp;
        do {
            temp=employeeStack.pop();
            employeeStackTemp.push(temp);
            if (temp.getFullNameEmployee().equals(str))
                employee=temp;
        } while (!employeeStack.empty());
        this.addEmployee(employeeStackTemp);
        return employee;
    }

    public static void main(String[] args) {
        EmployeeRecord employeeRecord=new EmployeeRecord();
        employeeRecord.addEmployee("A",21,"Da Nang");
        employeeRecord.addEmployee("B",21,"Da Nang");
        employeeRecord.addEmployee("C",21,"Da Nang");
        employeeRecord.addEmployee("D",21,"Da Nang");
        employeeRecord.addEmployee("E",21,"Da Nang");
        employeeRecord.addEmployee("F",21,"Da Nang");
        employeeRecord.addEmployee("G",21,"Da Nang");
        employeeRecord.addEmployee("H",21,"Da Nang");
        employeeRecord.addEmployee("I",21,"Da Nang");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name: ");
        Employee employee= employeeRecord.searchEmployee(input.nextLine());
        if(employee!=null){
            System.out.println(employee.toString());
        } else
            System.out.println("Employee not found");
    }
}

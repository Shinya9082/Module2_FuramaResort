package Models;

public class Employee {
    private String fullNameEmployee;
    private int age;
    private String addressEmployee;

    public Employee() {
    }

    public Employee(String fullNameEmployee, int age, String addressEmployee) {
        this.fullNameEmployee = fullNameEmployee;
        this.age = age;
        this.addressEmployee = addressEmployee;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullNameEmployee='" + fullNameEmployee + '\'' +
                ", age=" + age +
                ", addressEmployee='" + addressEmployee + '\'' +
                '}';
    }

    public String getFullNameEmployee() {
        return fullNameEmployee;
    }

    public void setFullNameEmployee(String fullNameEmployee) {
        this.fullNameEmployee = fullNameEmployee;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddressEmployee() {
        return addressEmployee;
    }

    public void setAddressEmployee(String addressEmployee) {
        this.addressEmployee = addressEmployee;
    }
}

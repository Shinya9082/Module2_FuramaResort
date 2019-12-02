package Commons;

import Models.Customer;

import java.util.Comparator;

public class CustomerNameComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getCustomerName().compareTo(o2.getCustomerName());
    }
    private int yearComparator(Customer o1, Customer o2){
        return o1.getDayOfBirth().substring(6).compareTo(o2.getDayOfBirth().substring(6));
    }
}

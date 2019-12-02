package Models;

public abstract class Service {
    private String id;
    private String serviceName;
    private double usableArea;
    private double rentFee;
    private int maxCapacity;
    private String typeOfRent;

    public Service() {
    }

    public Service(String id, String serviceName, double usableArea, double rentFee, int maxCapacity, String typeOfRent) {
        this.id = id;
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.rentFee = rentFee;
        this.maxCapacity = maxCapacity;
        this.typeOfRent = typeOfRent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getRentFee() {
        return rentFee;
    }

    public void setRentFee(double rentFee) {
        this.rentFee = rentFee;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getTypeOfRent() {
        return typeOfRent;
    }

    public void setTypeOfRent(String typeOfRent) {
        this.typeOfRent = typeOfRent;
    }

    public abstract String showInfor();
}

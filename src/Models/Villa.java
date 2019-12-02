package Models;

public class Villa extends Service{
    private String roomStandard;
    private String otherServices;
    private double poolArea;
    private int numberFloors;

    public Villa() {
    }

    public Villa(String id, String serviceName, double usableArea, double rentFee, int maxCapacity, String typeOfRent, String roomStandard, String otherServices, int poolArea, int numberFloors) {
        super(id, serviceName, usableArea, rentFee, maxCapacity, typeOfRent);
        this.roomStandard = roomStandard;
        this.otherServices = otherServices;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getOtherServices() {
        return otherServices;
    }

    public void setOtherServices(String otherServices) {
        this.otherServices = otherServices;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String showInfor(){
        return "Id: " + super.getId()+
                "\nArea: " +super.getUsableArea()+
                "\nFee: " +super.getRentFee()+
                "\nMaxPeople: " +super.getMaxCapacity()+
                "\nType of rent: " +super.getTypeOfRent()+
                "\nRoom standard: " +getRoomStandard()+
                "\nOther services: " +getOtherServices()+
                "\nPool area: " +getPoolArea()+
                "\nNumber of floors: " +getNumberFloors();
    }
}

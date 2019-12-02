package Models;

public class House extends Service {
    private String roomStandard;
    private String otherServices;
    private int numberFloors;

    public House() {
    }

    public House(String id, String serviceName, double usableArea, double rentFee, int maxCapacity, String typeOfRent, String roomStandard, String otherServices, int numberFloors) {
        super(id, serviceName, usableArea, rentFee, maxCapacity, typeOfRent);
        this.roomStandard = roomStandard;
        this.otherServices = otherServices;
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
                "\nNumber of floors: " +getNumberFloors();
    }
}

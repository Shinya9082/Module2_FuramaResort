package Models;

public class Room extends Service {
    private String freeServices;

    public Room(String id, String serviceName, double usableArea, double rentFee, int maxCapacity, String typeOfRent, String freeServices) {
        super(id, serviceName, usableArea, rentFee, maxCapacity, typeOfRent);
        this.freeServices = freeServices;
    }

    public Room() {
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    @Override
    public String showInfor(){
        return "Id: " + super.getId()+
                "\nArea: " +super.getUsableArea()+
                "\nFee: " +super.getRentFee()+
                "\nMaxPeople: " +super.getMaxCapacity()+
                "\nType of rent: " +super.getTypeOfRent()+
                "\nFree Services: "+getFreeServices();
    }
}

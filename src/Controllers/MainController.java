package Controllers;

import Commons.*;
import Models.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class MainController {
    private static Scanner input= new Scanner(System.in);
    public static void displayMainMenu(){
        System.out.print("\n1.Add New Services" +
                "\n2.Show Services" +
                "\n3.Add New Customer" +
                "\n4.Show Information Customer" +
                "\n5.Add New Booking Resort" +
                "\n6.Exit" +
                "\nEnter your choice: ");
        int choice=input.nextInt();
        switch (choice){
            case 1:
                addNewServices();
                break;
            case 2:
               showServices();
                break;
            case 3:
                addNewCustomer();
                break;
            case 4:
                input.nextLine();
                showInformationCustomers();
                break;
            case 5:
                addNewBookingResort();
                break;
            case 6:System.exit(0);

            default:
                System.out.println("\nError");
                backMainMenu();
        }
    }
    private static void addNewBookingResort(){
        ArrayList<Customer> customerList=FuncWriteAndReadFileCSV.getCustomerFromCSV();
        Customer customer=new Customer();
        System.out.println("*****Booking Resort*******");
        do {
            System.out.print(getCustomerList(customerList));
            System.out.print("Enter your choice:");
            customer = customerList.get(input.nextInt()-1);
        }while ((customer)==null);
        input.nextLine();
        System.out.print("*****Begin Booking for "+ customer.getCustomerName()+" *****" +
                "\n1.Booking Villa" +
                "\n2.Booking House" +
                "\n3.Boooking Room" +
                "\nEnter your choice: ");
        switch (input.nextInt()){
            case 1://Villa
                ArrayList<Villa> villaList = FuncWriteAndReadFileCSV.getVillaFromCSV();
                System.out.print(getVillaList(villaList));
                System.out.print("Enter your choie: ");
                customer.setService(villaList.get((input.nextInt()-1)));
                break;
            case 2://House
                ArrayList<House> houseList= FuncWriteAndReadFileCSV.getHouseFromCSV();
                System.out.print(getHouseList(houseList));
                System.out.print("Enter your choie: ");
                customer.setService(houseList.get((input.nextInt()-1)));
                break;
            case 3://Room
                ArrayList<Room> roomList= FuncWriteAndReadFileCSV.getRoomFromCSV();
                System.out.print(getRoomList(roomList));
                System.out.print("Enter your choie: ");
                customer.setService(roomList.get((input.nextInt()-1)));
                break;
            default:
                System.out.println("Error");
                backMainMenu();
        }
        ArrayList<Customer> listBooking = FuncWriteAndReadFileCSV.ReaderBookingCSV();
        listBooking.add(customer);
        FuncWriteAndReadFileCSV.writeBookingToFileCsv(listBooking);
        System.out.println("\nAdd Booking for : " + customer.getCustomerName() + " Successfully !!!");
        input.nextLine();
        backMainMenu();
    };
    private static void addNewCustomer(){
        Customer customer=new Customer();
        System.out.println("********Begin add new customer*********");
        //ID
        customer.setId(UUID.randomUUID().toString().replace("-",""));
        //Name
        while (true){
            input.nextLine();
            System.out.print("Enter name (Ex:Le Van A): ");
            try {
                customer.setCustomerName(NameException.validateCustomerName(input.nextLine()));
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        //BirthDay
        while (true){
            System.out.print("Enter day of birh dd/mm/yyyy: ");
            try {
                customer.setDayOfBirth(BirthdayException.validateBirthday(input.nextLine()));
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        //Gender
        while (true){
            System.out.print("Gender: ");
            try {
                customer.setGender(GenderException.validateGender(input.nextLine()));
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        //Id card
        while (true){
            System.out.print("Enter ID Card: ");
            try {
                customer.setIdCard(IdCardException.validateIDCard(input.nextLine()));
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        //Phone Number
        System.out.print("Enter Phone number");
        customer.setPhoneNumber(input.nextLine());
        //Email
        while (true){
            System.out.print("Enter Email(abc@abc.com): ");
            try {
                customer.setEmail(EmailException.validateEmail(input.nextLine()));
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        //Type Customer
        System.out.print("Customer type: ");
        customer.setTypeOfCustomer(input.nextLine());
        //Address
        System.out.print("Enter address: ");
        customer.setAddress(input.nextLine());
        //Write file
        ArrayList<Customer> listCustomer= FuncWriteAndReadFileCSV.getCustomerFromCSV();
        listCustomer.add(customer);
        FuncWriteAndReadFileCSV.writeCustomerToCSV(listCustomer);
        System.out.println("\n"+customer.getCustomerName()+" added");
        backMainMenu();
    }
    private static void showInformationCustomers(){
        ArrayList<Customer> listcustomer= FuncWriteAndReadFileCSV.getCustomerFromCSV();
        Collections.sort(listcustomer, new CustomerNameComparator());
        for (Customer customer:listcustomer) {
            System.out.println("********************************");
            System.out.println(customer.showInfor());
            System.out.println("********************************");
        }
        System.out.println("Back to menu");
        backMainMenu();
    }
    private static void backMainMenu(){
        System.out.println("Enter to continue...");
        input.nextLine();
        System.out.println("*********************");
        displayMainMenu();
    }
    private static void showAllVilla(){
        ArrayList<Villa> listvilla= FuncWriteAndReadFileCSV.getVillaFromCSV();
        for (Villa villa:listvilla) {
            System.out.println("********************************");
            System.out.println(villa.showInfor());
            System.out.println("********************************");
        }
        System.out.println("Back to menu");
        input.nextLine();
        backMainMenu();
    }
    private static void showAllHouse(){
        ArrayList<House> listvilla= FuncWriteAndReadFileCSV.getHouseFromCSV();
        for (House house:
                listvilla) {
            System.out.println("********************************");
            System.out.println(house.showInfor());
            System.out.println("********************************");
        }
        System.out.println("Back to menu");
        input.nextLine();
        backMainMenu();
    }
    private static void showAllRoom(){
        ArrayList<Room> listvilla= FuncWriteAndReadFileCSV.getRoomFromCSV();
        for (Room room:
                listvilla) {
            System.out.println("********************************");
            System.out.println(room.showInfor());
            System.out.println("********************************");
        }
        System.out.println("Back to menu");
        input.nextLine();
        backMainMenu();
    }
    private static void showServices(){
        System.out.println("*****************************************");
        System.out.print("\n1.Show all villas:" +
                "\n2.Show all house" +
                "\n3.Show all room" +
                "\n4.Show all villa not duplicate" +
                "\n5.Show all houses not duplicate" +
                "\n6.Show all rooms not duplicate" +
                "\n7.Back to menu" +
                "\n8.Exit" +
                "\nEnter your choice:");
        switch (input.nextInt()){
            case 1:
                //showAllVilla
                input.nextLine();
                showAllVilla();
                break;
            case 2:
                //showAllHouse
                input.nextLine();
                showAllHouse();
                break;
            case 3:
                //showAllRoom
                input.nextLine();
                showAllRoom();
                break;
            case 4:
                input.nextLine();
                showAllNameVilla();
                break;
            case 5:
                input.nextLine();
                showAllNameHouse();
                break;
            case 6:
                input.nextLine();
                showALLNameRoom();
                break;
            case 7:
                displayMainMenu();
            case 8:
                System.exit(0);
            default:
                System.out.println("Error");
                backMainMenu();
        }
    }

    private static void showAllNameVilla() {
        String pathVilla="src/Data/Villa.csv";
        Path path = Paths.get(pathVilla);
        if(!Files.exists(path)){
            System.out.println("File Villa is not exists!");
        }else {
            TreeSet<String> villaNameList =FuncWriteAndReadFileCSV.getAllNameService(pathVilla);
            System.out.println("\nList Name Service Villa Not Duplicate");
            for (String str: villaNameList){
                System.out.println("******************");
                System.out.println(str);
            }
            System.out.println("******************");
        }
        backMainMenu();
    }

    private static void showAllNameHouse() {
        String pathHouse="src/Data/House.csv";
        Path path = Paths.get(pathHouse);
        if(!Files.exists(path)){
            System.out.println("File House is not exists!");
        }else {
            TreeSet<String> houseNameList =FuncWriteAndReadFileCSV.getAllNameService(pathHouse);
            System.out.println("\nList Name Service House Not Duplicate");
            for (String str: houseNameList){
                System.out.println("******************");
                System.out.println(str);
            }
            System.out.println("******************");
        }
        backMainMenu();
    }

    private static void showALLNameRoom() {
        String pathRoom="src/Data/Room.csv";
        Path path = Paths.get(pathRoom);
        if(!Files.exists(path)){
            System.out.println("File Room is not exists!");
        }else {
            TreeSet<String> roomNameList =FuncWriteAndReadFileCSV.getAllNameService(pathRoom);
            System.out.println("\nList Name Service Room Not Duplicate");
            for (String str: roomNameList){
                System.out.println("******************");
                System.out.println(str);
            }
            System.out.println("******************");
        }
        backMainMenu();
    }

    public static void addNewServices(){
        System.out.println("*****************************************");
        System.out.println("1.Add New Villa:");
        System.out.println("2.Add New House:");
        System.out.println("3.Add New Room");
        System.out.println("4.Back to menu");
        System.out.println("5.Exit");
        System.out.print("Enter your choice: ");
        switch (input.nextInt()){
            case 1:
                System.out.println("********Begin add new Villa********");
                addNewVilla();
                break;
            case 2:
                System.out.println("********Begin add new House********");
                addNewHouse();
                break;
            case 3:
                System.out.println("********Begin add new Room********");
                addNewRoom();
                break;
            case 4:
                backMainMenu();
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("\nError");
                backMainMenu();
        }
    }
    private static Service addNewService(Service service){
        String message="";
        String errorMessage="";
        input.nextLine();
        ///////ID
        service.setId(UUID.randomUUID().toString().replace("-",""));
        ///////// Service name
        System.out.print("Enter Service name: ");
        service.setServiceName(input.nextLine());
        while (!FunValidate.checkNameService(service.getServiceName())){
            System.out.println("Invaid name input");
            System.out.print("Enter Service name: ");
            service.setServiceName(input.nextLine());
        }
        ////// Aera
        message="Enter usable area:";
        errorMessage="Enter a positive real number and over 30";
        service.setUsableArea(FunValidate.checkValidateDouble(message,errorMessage));
        while (service.getUsableArea()<30){
            System.out.println(errorMessage);
            service.setUsableArea(FunValidate.checkValidateDouble(message,errorMessage));
        }
        /////// RentFee
        message="Enter rent fee:";
        errorMessage="Enter a positive real number";
        service.setRentFee(FunValidate.checkValidateDouble(message,errorMessage));
        while (service.getRentFee()<0){
            System.out.println(errorMessage);
            service.setRentFee(FunValidate.checkValidateDouble(message,errorMessage));
        }
        //////Max People
        message="Enter max people: ";
        errorMessage="Enter a positive normal number between 0-20";
        service.setMaxCapacity(FunValidate.checkValidateInteger(message,errorMessage));
        while (service.getMaxCapacity()<0||service.getMaxCapacity()>20){
            System.out.println(errorMessage);
            service.setMaxCapacity(FunValidate.checkValidateInteger(message,errorMessage));
        };
        /////Type Rent
        System.out.print("Enter type of rent: ");
        service.setTypeOfRent(input.nextLine());
        while (!FunValidate.checkNameService(service.getTypeOfRent())){
            System.out.println("Invaid name input");
            System.out.print("Enter type of rent: ");
            service.setTypeOfRent(input.nextLine());
        }
        return service;
    }
    private static void addNewVilla(){
        String message="";
        String errorMessage="";
        Service villa=new Villa();
        addNewService(villa);
        /////Room Standard
        System.out.print("Enter room standard: ");
        ((Villa)villa).setRoomStandard(input.nextLine());
        while (!FunValidate.checkNameService(((Villa) villa).getRoomStandard())){
            System.out.println("Invalid Input");
            System.out.print("Enter room standard: ");
            ((Villa)villa).setRoomStandard(input.nextLine());
        }
        ////// Other services

        System.out.print("Enter other Services : ");
        ((Villa)villa).setOtherServices(input.nextLine());
        while (FunValidate.checkValidateOtherServices(((Villa) villa).getOtherServices())){
            System.out.println("Must be one of: massage, karaoke, food, drink, car");
            System.out.print("Enter other Services : ");
            ((Villa)villa).setOtherServices(input.nextLine());
        }
        ////// Pool Area
        message="Enter pool area:";
        errorMessage="Enter a real number and over 30";
        ((Villa)villa).setPoolArea(FunValidate.checkValidateDouble(message,errorMessage));
        while (((Villa)villa).getPoolArea()<30){
            System.out.println(errorMessage);
            ((Villa)villa).setPoolArea(FunValidate.checkValidateDouble(message,errorMessage));
        }
        ////// Number floors
        message="Enter numbers of floors:";
        errorMessage="Enter a positive number";
        ((Villa)villa).setNumberFloors(FunValidate.checkValidateInteger(message,errorMessage));
        while (((Villa)villa).getNumberFloors()<0){
            System.out.println(errorMessage);
            ((Villa)villa).setNumberFloors(FunValidate.checkValidateInteger(message,errorMessage));
        }

        //Write file
        ArrayList<Villa> listVilla = FuncWriteAndReadFileCSV.getVillaFromCSV();
        listVilla.add((Villa)villa);
        FuncWriteAndReadFileCSV.writeVillaToCsv(listVilla);
        System.out.println("\n"+villa.getServiceName()+" added");
        backMainMenu();
    }
    private static void addNewHouse(){
        String message="";
        String errorMessage="";
        Service house=new House();
        addNewService(house);
        /////Room Standard
        System.out.print("Enter room standard: ");
        ((House)house).setRoomStandard(input.nextLine());
        while (!FunValidate.checkNameService(((House) house).getRoomStandard())){
            System.out.println("Invalid Input");
            System.out.print("Enter room standard: ");
            ((House)house).setRoomStandard(input.nextLine());
        }
        ////// Other services

        System.out.print("Enter other Services : ");
        ((House)house).setOtherServices(input.nextLine());
        while (FunValidate.checkValidateOtherServices(((House) house).getOtherServices())){
            System.out.println("Must be one of: massage, karaoke, food, drink, car");
            System.out.print("Enter other Services : ");
            ((House)house).setOtherServices(input.nextLine());
        }
        ////// Number floors
        message="Enter numbers of floors:";
        errorMessage="Enter a positive number";
        ((House)house).setNumberFloors(FunValidate.checkValidateInteger(message,errorMessage));
        while (((House)house).getNumberFloors()<0){
            System.out.println(errorMessage);
            ((House)house).setNumberFloors(FunValidate.checkValidateInteger(message,errorMessage));
        }
        //Write file
        ArrayList<House> listHouse = FuncWriteAndReadFileCSV.getHouseFromCSV();
        listHouse.add((House)house);
        FuncWriteAndReadFileCSV.writeHouseToCsv(listHouse);
        System.out.println("\n"+house.getServiceName()+" added");
        backMainMenu();
    }
    private static void addNewRoom(){
        Service room=new Room();
        addNewService(room);
        ///// Freee services
        System.out.print("Enter free services: ");
        ((Room)room).setFreeServices(input.nextLine());
        while (FunValidate.checkValidateOtherServices(((Room) room).getFreeServices())){
            System.out.println("Must be one of: massage, karaoke, food, drink, car");
            System.out.print("Enter free services: ");
            ((Room)room).setFreeServices(input.nextLine());
        }
        //Write file
        ArrayList<Room> listRoom = FuncWriteAndReadFileCSV.getRoomFromCSV();
        listRoom.add((Room)room);
        FuncWriteAndReadFileCSV.writeRoomToCsv(listRoom);
        System.out.println("\n"+room.getServiceName()+" added");
        backMainMenu();
    }
    private static String getCustomerList(ArrayList<Customer> arrayList){
        String content="";
        int i=1;
        for (Customer customer: arrayList){
            content+= i++ +". "+customer.getCustomerName()+"\n";
        }
        return content;
    }
    private static String getVillaList(ArrayList<Villa> arrayList){
        String content="";
        int i=1;
        for (Villa villa: arrayList){
            content+= i++ +". "+villa.getServiceName()+"\n";
        }
        return content;
    }
    private static String getHouseList(ArrayList<House> arrayList){
        String content="";
        int i=1;
        for (House house: arrayList){
            content+= i++ +". "+house.getServiceName()+"\n";
        }
        return content;
    }
    private static String getRoomList(ArrayList<Room> arrayList){
        String content="";
        int i=1;
        for (Room room: arrayList){
            content+= i++ +". "+room.getServiceName()+"\n";
        }
        return content;
    }
}

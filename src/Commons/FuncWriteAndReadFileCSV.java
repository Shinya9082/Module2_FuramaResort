package Commons;


import Models.*;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.TreeSet;

public class FuncWriteAndReadFileCSV {
    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE='"';
    private static final int NUMBER_OF_LINE_SKIP =1;
    private static final String pathVilla="src/Data/Villa.csv";
    private static final String pathHouse="src/Data/House.csv";
    private static final String pathRoom="src/Data/Room.csv";
    private static final String pathCustomer="src/Data/Customer.csv";
    private static final String pathBooking="src/Data/Booking.csv";
    private static String[] headerRecordVilla = new String[]{"id","serviceName","usableArea","rentFee","maxCapacity","typeOfRent","roomStandard","otherServices","poolArea","numberFloors"};
    private static String[] headerRecordHouse = new String[]{"id","serviceName","usableArea","rentFee","maxCapacity","typeOfRent","roomStandard","otherServices","numberFloors"};
    private static String[] headerRecordRoom = new String[]{"id","serviceName","usableArea","rentFee","maxCapacity","typeOfRent","freeServices"};
    private static String[] headerRecordCustomer= new String[]{"id","customerName","dayOfBirth","gender","idCard","phoneNumber","email","typeOfCustomer","address"};
    private static String[] headerRecordBooking = new String[]{"id", "customerName", "dayOfBirth", "gender", "idCard", "phoneNumber", "email", "typeOfCustomer","address",
            "id", "serviceName", "usableArea", "rentFee", "maxCapacity", "typeOfRent"};
    ///Write Villa to CSV
    public static void writeVillaToCsv(ArrayList<Villa> arrayList){
        try (Writer writer=new FileWriter(pathVilla); CSVWriter csvWriter=new CSVWriter(writer,
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END))
        {
            csvWriter.writeNext(headerRecordVilla);
            for (Villa villa: arrayList){
                csvWriter.writeNext(new String[]{
                        villa.getId(),
                        villa.getServiceName(),
                        String.valueOf(villa.getUsableArea()),
                        String.valueOf(villa.getRentFee()),
                        String.valueOf(villa.getMaxCapacity()),
                        villa.getTypeOfRent(),
                        villa.getRoomStandard(),
                        villa.getOtherServices(),
                        String.valueOf(villa.getPoolArea()),
                        String.valueOf(villa.getNumberFloors())
                });
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    ///Write House to CSV
    public static void writeHouseToCsv(ArrayList<House> arrayList){
        try (Writer writer=new FileWriter(pathHouse); CSVWriter csvWriter=new CSVWriter(writer,
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END))
        {
            csvWriter.writeNext(headerRecordHouse);
            for (House house: arrayList){
                csvWriter.writeNext(new String[]{
                        house.getId(),
                        house.getServiceName(),
                        String.valueOf(house.getUsableArea()),
                        String.valueOf(house.getRentFee()),
                        String.valueOf(house.getMaxCapacity()),
                        house.getTypeOfRent(),
                        house.getRoomStandard(),
                        house.getOtherServices(),
                        String.valueOf(house.getNumberFloors())
                });
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    ///Write Room to CSV
    public static void writeRoomToCsv(ArrayList<Room> arrayList){
        try (Writer writer=new FileWriter(pathRoom); CSVWriter csvWriter=new CSVWriter(writer,
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END))
        {
            csvWriter.writeNext(headerRecordRoom);
            for (Room room: arrayList){
                csvWriter.writeNext(new String[]{
                        room.getId(),
                        room.getServiceName(),
                        String.valueOf(room.getUsableArea()),
                        String.valueOf(room.getRentFee()),
                        String.valueOf(room.getMaxCapacity()),
                        room.getTypeOfRent(),
                        room.getFreeServices()
                });
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    ///Write Customer to CSV
    public static void writeCustomerToCSV(ArrayList<Customer> arrayList){
        try (Writer writer=new FileWriter(pathCustomer); CSVWriter csvWriter=new CSVWriter(writer,
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END))
        {
            csvWriter.writeNext(headerRecordCustomer);
            for (Customer customer: arrayList){
                csvWriter.writeNext(new String[]{
                        customer.getId(),
                        customer.getCustomerName(),
                        customer.getDayOfBirth(),
                        customer.getGender(),
                        customer.getIdCard(),
                        customer.getPhoneNumber(),
                        customer.getEmail(),
                        customer.getTypeOfCustomer(),
                        customer.getAddress()
                });
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    ///Write Booking to CSV
    public static void writeBookingToFileCsv(ArrayList<Customer> arrayList) {
        try (Writer writer = new FileWriter(pathBooking);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END);) {

            //add Header of File
            csvWriter.writeNext(headerRecordBooking);
            for (Customer customer : arrayList) {
                csvWriter.writeNext(new String[]
                        //"id", "customerName", "dayOfBirth", "gender", "idCard", "phoneNumber", "email", "typeOfCustomer","address",
                        //            "id", "serviceName", "usableArea", "rentFee", "maxCapacity", "typeOfRent"
                        {customer.getId(), customer.getCustomerName(), customer.getDayOfBirth(), customer.getGender(),
                                customer.getIdCard(), customer.getPhoneNumber(), customer.getEmail(), customer.getTypeOfCustomer(), customer.getAddress(),
                                customer.getService().getId(), customer.getService().getServiceName(), String.valueOf(customer.getService().getUsableArea()),
                                String.valueOf(customer.getService().getRentFee()), String.valueOf(customer.getService().getMaxCapacity()),
                                customer.getService().getTypeOfRent()
                        });
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static ArrayList<Villa> getVillaFromCSV() {
        Path path = Paths.get(pathVilla);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(pathVilla);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        ColumnPositionMappingStrategy<Villa> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Villa.class);
        strategy.setColumnMapping(headerRecordVilla);
        CsvToBean<Villa> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<Villa>(new FileReader(pathVilla))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUMBER_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return (ArrayList<Villa>) csvToBean.parse();
    }
    //get list villa form CSV
    public static ArrayList<House> getHouseFromCSV(){
        Path path = Paths.get(pathHouse);
        if(!Files.exists(path)){
            try {
                Writer writer =new FileWriter(pathHouse);
            }catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        ColumnPositionMappingStrategy<House> strategy = new ColumnPositionMappingStrategy<House>();
        strategy.setType(House.class);
        strategy.setColumnMapping(headerRecordHouse);
        CsvToBean<House> csvToBean=null;
        try {
            csvToBean = new CsvToBeanBuilder<House>(new FileReader(pathHouse))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUMBER_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        }catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return (ArrayList<House>) csvToBean.parse();
    }
    //get list House form CSV
    public static ArrayList<Room> getRoomFromCSV(){
        Path path = Paths.get(pathRoom);
        if(!Files.exists(path)){
            try {
                Writer writer =new FileWriter(pathRoom);
            }catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        ColumnPositionMappingStrategy<Room> strategy = new ColumnPositionMappingStrategy<Room>();
        strategy.setType(Room.class);
        strategy.setColumnMapping(headerRecordRoom);
        CsvToBean<Room> csvToBean=null;
        try {
            csvToBean = new CsvToBeanBuilder<Room>(new FileReader(pathRoom))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUMBER_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        }catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return (ArrayList<Room>) csvToBean.parse();
    }
    //get list Customer form CSV
    public static ArrayList<Customer> getCustomerFromCSV(){
        Path path = Paths.get(pathCustomer);
        if(!Files.exists(path)){
            try {
                Writer writer =new FileWriter(pathCustomer);
            }catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        ColumnPositionMappingStrategy<Customer> strategy = new ColumnPositionMappingStrategy<Customer>();
        strategy.setType(Customer.class);
        strategy.setColumnMapping(headerRecordCustomer);
        CsvToBean<Customer> csvToBean=null;
        try {
            csvToBean = new CsvToBeanBuilder<Customer>(new FileReader(pathCustomer))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUMBER_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        }catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return (ArrayList<Customer>) csvToBean.parse();
    }
    //get list Booking from CSV
    public static ArrayList<Customer> getBookingFromCSV() {
        Path path = Paths.get(pathBooking);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(pathBooking);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        ColumnPositionMappingStrategy<Customer> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Customer.class);
        strategy.setColumnMapping(headerRecordBooking);
        CsvToBean<Customer> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<Customer>(new FileReader(pathBooking))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUMBER_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return (ArrayList<Customer>) csvToBean.parse();
    }
    //get list Booking form CSV withService
    public static ArrayList<Customer> ReaderBookingCSV() {
        ArrayList<Customer> listCustomer = new ArrayList<Customer>();
        try (Reader reader = new FileReader(pathBooking);
             CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] line;
            csvReader.skip(NUMBER_OF_LINE_SKIP);
            while ((line = csvReader.readNext()) != null) {
                Customer customer = new Customer();
                Service service = new Service() {
                    @Override
                    public String showInfor() {
                        return null;
                    }
                };
                customer.setId(line[0]);
                customer.setCustomerName(line[1]);
                customer.setDayOfBirth(line[2]);
                customer.setGender((line[3]));
                customer.setIdCard((line[4]));
                customer.setPhoneNumber(line[5]);
                customer.setEmail(line[6]);
                customer.setTypeOfCustomer(line[7]);
                customer.setAddress(line[8]);
                service.setId(line[9]);
                service.setServiceName(line[10]);
                service.setUsableArea(Float.parseFloat(line[11]));
                service.setRentFee(Float.parseFloat(line[12]));
                service.setMaxCapacity(Integer.parseInt(line[13]));
                service.setTypeOfRent(line[14]);
                customer.setService(service);
                listCustomer.add(customer);
            }
        } catch (
                IOException e) {
            System.out.println(e.getMessage());
        }
        return listCustomer;
    }
    //get nameService form file
    private static String getNameServiceFormFile(String line){
        String name="";
        if(line!=null){
            String []splitData= line.split(",");
            name=splitData[1];
        }
        return name;
    }
    //
    public static TreeSet<String> getAllNameService(String path){
        BufferedReader br= null;
        TreeSet<String> serviceTreeSet= new TreeSet<>();
        try{
            String line;
            br = new BufferedReader(new FileReader(path));
            while ((line=br.readLine())!=null){
                if(getNameServiceFormFile(line).equals("serviceName")){
                    continue;
                }
                serviceTreeSet.add(getNameServiceFormFile(line));
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return serviceTreeSet;
    }
}


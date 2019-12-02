package Commons;

import java.util.Scanner;

public class GenderException extends Exception {
    public GenderException(String mes){
        super(mes);
    }
    public static String validateGender(String  str) throws GenderException{
        String regex = "^(?:(?i)male|(?i)female|(?i)unkhow)$";
        if (str.matches(regex)) {
            return fixInput(str);
        } else {
            throw new GenderException("Invalid input");
        }
    }
    private static String fixInput(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1).toLowerCase();
    }

    public static void main(String[] args) {
        String str="";
        while (true){
            try {
                Scanner sc= new Scanner(System.in);
                System.out.print("Enter Gender: ");
                str=validateGender(sc.nextLine());
                break;
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        System.out.println(str);
    }
}

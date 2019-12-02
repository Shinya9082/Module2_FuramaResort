package Commons;

import java.util.Scanner;

public class FunValidate {
    public static String regex="";
    private static Scanner input;
    public static boolean checkNameService(String str){
        regex="^(?:\\p{Lu}\\p{Ll}*)(?: \\p{Lu}\\p{Ll}*)+$";
        return str.matches(regex);
    }
    public static double checkValidateDouble(String mes,String errMes){
        while (true){
            try {
                input=new Scanner(System.in);
                System.out.print(mes);
                return input.nextDouble();
            }catch (Exception ex){
                System.out.println(errMes);
            }
        }
    }
    public static int checkValidateInteger(String mes,String errMes){
        while (true){
            try {
                input=new Scanner(System.in);
                System.out.print(mes);
                return input.nextInt();
            }catch (Exception ex){
                System.out.println(errMes);
            }
        }
    }
    public static boolean checkValidateOtherServices(String str){
        regex="^(?:massage|karaoke|food|drink|car)$";
        return !str.matches(regex);
    }
//    public static String validateCustomerName (String str) throws NameException {
//        if(checkNameService(str)){
//            return str;
//        } else {
//            throw new NameException("Invalid name. Please enter again");
//        }
//    }

//    public static void main(String[] args) {
//        Scanner sc= new Scanner(System.in);
//        String str=null;
//        while (str==null){
//            try{
//                System.out.print("Enter a name:");
//                str=validateCustomerName(sc.nextLine());
//            }catch (Exception ex){
//                System.out.println(ex.getMessage());
//            }
//        }
//        System.out.println(str);
//
//    }
}

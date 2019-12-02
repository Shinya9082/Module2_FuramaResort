package Commons;

import java.time.LocalDate;


public class BirthdayException extends Exception{
    public BirthdayException(String mes){
        super(mes);
    }
    public static String validateBirthday(String str) throws BirthdayException{
        String regex= "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/(?=19|20[01]\\d)\\d{4}$";

        if(str.matches(regex)&&checkYear(str)){
            return str;
        }else {
            throw new BirthdayException("Invalid Birthday.Customer must be 18+. Please enter again");
        }
    }
    private static boolean checkYear(String str){
        LocalDate  curTime= LocalDate.now();
        int currentYear = Integer.parseInt(curTime.toString().substring(0,4)) ;
        int temp=Integer.parseInt(str.substring(6));
        return temp <= currentYear - 18;
    }
}

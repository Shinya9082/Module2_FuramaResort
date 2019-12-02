package Commons;

public class BirthdayException extends Exception{
    public BirthdayException(String mes){
        super(mes);
    }
    public static String validateBirthday(String str) throws BirthdayException{
        String regex= "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/(?=19|20[01]\\d)\\d{4}$";
        if(str.matches(regex)){
            return str;
        }else {
            throw new BirthdayException("Invalid Birthday. Please enter again");
        }
    }
}

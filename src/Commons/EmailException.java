package Commons;

public class EmailException extends Exception {
    public EmailException(String mes){
        super(mes);
    }
    public static String validateEmail(String str) throws EmailException {
        String regex = "^\\w+\\w*@\\w+(?:\\.\\w+){1,2}$";
        if (str.matches(regex)) {
            return str;
        } else {
            throw new EmailException("Invalid Email. Please enter again");
        }
    }
}

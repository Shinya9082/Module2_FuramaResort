package Commons;

public class NameException extends Exception {
    public NameException(String mes) {
        super(mes);
    }

    public static String validateCustomerName(String str) throws NameException {
        String regex = "^(?:\\p{Lu}\\p{Ll}*)(?: \\p{Lu}\\p{Ll}*)+$";
        if (str.matches(regex)) {
            return str;
        } else {
            throw new NameException("Invalid name. Please enter again");
        }
    }
}

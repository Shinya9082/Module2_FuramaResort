package Commons;

public class IdCardException extends Exception {
    public IdCardException(String mes){
        super(mes);
    }
    public static String validateIDCard(String str) throws IdCardException{
        String regex= "^(?:\\d{3} ){2}(?:\\d{3})$";
        if(str.matches(regex)){
            return str;
        }else {
            throw new IdCardException("Invalid Id card. Please enter again");
        }
    }
}

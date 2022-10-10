import java.util.Scanner;

public class PhoneCode {
    private static final Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args){
        int phoneNumber;
        String randomCode;
        do {
            System.out.println("Please enter your 305 phone number");
            phoneNumber = keyboard.nextInt();
        }while (phoneNumber<999999||phoneNumber>99999999);

        randomCode = encodeNumber(305);
        String codeWith305 = randomCode+encodeNumber(phoneNumber);
        System.out.print("The phone number 305"+phoneNumber+" can be encoded as "+codeWith305);


    }
    private static String encodeNumber(int phoneNumber){
        String finalCode = "";
        String tempCode= "";
        int[]intArray = {0,1,3,3,3,3,4,3,4};
        char[]charArray = {'0','1','A','D','G','J','M','P','T','W'};
        while (phoneNumber>0){
            int lastDigit = phoneNumber%10;
            int number = (int) Math.floor(Math.random()*intArray[lastDigit]);
            char character = (char) ((int)charArray[lastDigit]+number);
            finalCode =character+finalCode;
            phoneNumber=phoneNumber/10;
        }

        return finalCode;
    }




    }

